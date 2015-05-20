utils.define('tunnel.stomp').as(function(stomp, _instance_) {
	
	utils.require(":jqgeeks/sockjs");
	
	var sClient = null;
	var userID,userQueue;
	var ready;
	var defaultBus,broadCastBus;
	var TIMEOUT_SPAN = 10000,CLEAR_TIME = 1000;
	var nowTime,clearTimer; 
	var cookies = utils.module('utils.cookies');
	var tunnel = utils.module('tunnel');
	stomp.debugMode = false;
	stomp.setChannel = function(name,resolver){
		if(this[name]) throw new Error('Cannot create bus with name"'+name + '"');
		this[name] = resolver;
		console.info("this[name]",name,this[name])
		if(this[name].isDefault) defaultBus = name;
		if(this[name].isBroadCast) broadCastBus = name;
		resolver.busName = name;
		resolver.on = function(eName,listner){
			return stomp.on(this.busName,eName,listner);
		}
	};
	function setConnected(connected) {
		//document.getElementById('connect').innerHTML = connected ? "Connected" : "Not Connected";
	}
	function connect(user_id,passcode,nodata) {
		userID = user_id || 'nouser'
		userQueue = '/user/'+userID+'/notify/';
		var socket = new SockJS('/app/tunnel');
		//console.info('connecting with userid:',userID)
		sClient = Stomp.over(socket);
		sClient.noDebug = false;
		sClient.connect({},function(frame) {
			setConnected(true);
		    whoami = frame.headers['user-name'];
		    if(stomp.debugMode){
		    	console.debug('Connected: ',frame,frame.headers,whoami);
		    }
		    ready = true;
		    stomp.onconnected();
		});
		sClient.debug = function(){
			
		};
	}

	function disconnect() {
		sClient.disconnect();	
		setConnected(false);
		//console.log("Disconnected");
	}
	stomp.callback_namespace = "";
	stomp.onconnected = function(a,b,c,d,e){
		if(stomp.debugMode){
			console.log('conneted');
		}
		this.callback_namespace = tunnel.getUniqueId();
	    sClient.subscribe('/callbacks/'+this.callback_namespace, function(frame) {
	    	var callbackId = frame.headers.callback_id;
	    	var callbackDone = frame.headers.callbackDone;
	    	var resp = JSON.parse(frame.body);
	    	var reqObj = stomp.ALL_REQ[callbackId];
	    	if(reqObj){
		    	if(callbackDone === "true" || callbackDone === true){
		    		if(resp.success === true){
			    		reqObj.resolve(resp.data,resp);
		    		} else {
		    			reqObj.reject(resp.data,resp);
		    		}
		    	} else {
		    		reqObj.notify(resp);
		    	}
	    	}
	    });
	    sClient.subscribe('/user/queue/messages', function(message) {
	        if(stomp.debugMode){
	        	console.info("messageQ",JSON.parse(message.body));
	        }
	    });
	    stomp.clearExpired();
	    stomp.$ON_CONNECT_DEFERRED.resolve();
	};
	stomp.getTimeoutResponse = function(){
		return { data : {}, success : false };
	};

	stomp.clearExpired = function(){
		window.clearTimeout(stomp.clearTimer);
		nowTime = (new Date()).getTime(); 
		for(var callbackId in stomp.ALL_REQ){
			var reqObj = stomp.ALL_REQ[callbackId];
			if(reqObj === undefined || reqObj.state() === 'resolved' || reqObj.state() === 'resolved'){
				delete stomp.ALL_REQ[callbackId]
			} else if(reqObj.expiryTime < nowTime){
				var resp = stomp.getTimeoutResponse();
				reqObj.reject(resp.data,resp);
			}
		}
		clearTimer = window.setTimeout(stomp.clearExpired,TIMEOUT_SPAN);
	};
	
	var subscribe = function(bus,eName,listnerFunction){
		//console.info("subscribe",bus,eName,listner)
		if(stomp[bus]){
			return sClient.subscribe(stomp[bus].path(bus,eName), listnerFunction);
		} else {
			throw new Error('Bus with name "' + bus +'" does not exist');
		}
	};
	
	stomp._instance_ = function(bus){
		this.bus = bus;
		this.subs = [];
	};
	
	_instance_.publish = function(api,data){
		return stomp.send({api : api, data : data });
	};
	
	_instance_.on = function(eName,listner){
		var self = this;
		stomp.$ON_CONNECT_PROMISE = stomp.$ON_CONNECT_PROMISE.done(function(){
			var listnerFunction = function(msg){
				var data = JSON.parse(msg.body);
				return listner(data,msg);
			};
			self.subs.push({ 
				sub : subscribe(self.bus || defaultBus ,eName,listnerFunction), 
				eName : eName
			});
			self.subs.push({ 
				sub : subscribe(broadCastBus,eName,listnerFunction), 
				eName : eName
			});
		});
		return self;
	};
	
	_instance_.off = function(eName){
		for(var i in this.subs){
			if(eName === undefined || this.subs[i].eName === eName){
				this.subs[i].sub.unsubscribe()
			}
		}
	};
	
	stomp.on = function(eName,listner){
		return stomp.instance().on(eName,listner);
	};
	stomp.publish = function(api,data){
		return stomp.instance(defaultBus).publish(api,data);
	};
	stomp.send_old = function(handlerAction,webRequest, header){
		//console.log(handlerAction,data,JSON.stringify(data))
		return sClient.send("/action/wsr/"+handlerAction, header || {}, JSON.stringify(webRequest));
		
	};
	stomp.ALL_REQ = {};

	stomp.send = function(OBJ){
		return tunnel.getRequestObject(OBJ,function(reqObj){
			if(stomp.debugMode){
				console.debug("---",OBJ,reqObj)
			}
			var _id_ = tunnel.getUniqueId();
			reqObj.expiryTime = (new Date()).getTime() + TIMEOUT_SPAN;
			stomp.$ON_CONNECT_PROMISE  = stomp.$ON_CONNECT_PROMISE.done(function(){
				if(stomp.send_old(OBJ.api,{
					data : JSON.stringify(OBJ.data),
					callbackId : _id_, 
					namesapce : stomp.callback_namespace
				}, {})){
					if(stomp.debugMode){
						console.debug("sent---",reqObj);
					}
					stomp.ALL_REQ[_id_] = reqObj;
				};
			});
		});
	};
	
	stomp._execute_ = function(){
		stomp.$ON_CONNECT_DEFERRED = $.Deferred();
		stomp.$ON_CONNECT_PROMISE = stomp.$ON_CONNECT_DEFERRED.promise();
	};
	
	stomp._define_ = function(){
		stomp.setChannel('user',{
	    	path : function(bus,eName){
	    		return userQueue + eName;
	    	},
	    	isDefault : true
	    })
	    stomp.setChannel('event',{
	    	path : function(bus,eName){
	    		return "/event/" + eName;
	    	},
	    	isBroadCast : true
	    });
		//connect($('body').attr('data-user') || cookies.read('user'));
	};
	stomp.connect = function(user_id,passcode,nodata){
		connect($('body').attr('data-user') || cookies.read('user'));
	};
})