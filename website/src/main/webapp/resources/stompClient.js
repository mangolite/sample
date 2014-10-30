utils.define('stompClient', function(stompClient, _instance_) {
	var sClient = null;
	var userID,userQueue;
	var ready;
	var defaultBus;
	var cookies = utils.require('utils.cookies');
	stompClient.setChannel = function(name,resolver){
		if(this[name]) throw new Error('Cannot create bus with name"'+name + '"');
		this[name] = resolver;
		if(this[name].isDefault) defaultBus = name;
		resolver.busName = name;
		resolver.on = function(eName,listner){
			return stompClient.on(this.busName,eName,listner);
		}
	};
	function setConnected(connected) {
		document.getElementById('connect').innerHTML = connected ? "Connected" : "Not Connected";
	}
	function connect(user_id) {
		userID = user_id || 'nouser'
		userQueue = '/user/'+userID+'/notify/';
		var socket = new SockJS('/app/tunnel');
		//console.info('connecting with userid:',userID)
		sClient = Stomp.over(socket);
		sClient.noDebug = true;
		sClient.connect({},function(frame) {
			setConnected(true);
		    whoami = frame.headers['user-name'];
//		    console.log('Connected: ',frame,frame.headers,whoami);
		    ready = true;
		    stompClient.onconnected();
		});
	}

	function disconnect() {
		sClient.disconnect();
		setConnected(false);
		//console.log("Disconnected");
	}
	stompClient.onconnected = function(a,b,c,d,e){
		console.log('conneted');
	};

	var subscribe = function(bus,eName,listner){
		//console.info("subscribe",bus,eName,listner)
		if(stompClient[bus]){
			sClient.subscribe(stompClient[bus].path(bus,eName), function(msg){
				var data = JSON.parse(msg.body);
				return listner(data,msg);
			});
		} else {
			throw new Error('Bus with name "' + bus +'" does not exist');
		}
	};
	stompClient.subscribe = function(a,b,c){
		if(c !== undefined){
			return subscribe(a,b,c);
		} else if(b !== undefined && defaultBus) {
			return subscribe(defaultBus,a,b);
		} else throw new Error('specify bus')
	};
	stompClient.on = function(bus,eName,listner){
		//console.log(bus,eName,listner)
		if(ready){
			stompClient.subscribe(bus,eName,listner);
		} else {
			var _onconnected = stompClient.onconnected;
			stompClient.onconnected = function(){
				_onconnected();
				stompClient.subscribe(bus,eName,listner);
			};
		}
	};
	stompClient.send = function(handlerAction,data){
		//console.log(handlerAction,data,JSON.stringify(data))
		sClient.send("/action/wsr/"+handlerAction, {}, JSON.stringify({
			userToken : userID,
			data : JSON.stringify(data)
		}));
		
	};
	stompClient._ready_ = function(){
	    stompClient.setChannel('user',{
	    	path : function(bus,eName){
	    		return userQueue + eName;
	    	},
	    	isDefault : true
	    })
	    stompClient.setChannel('event',{
	    	path : function(bus,eName){
	    		return "/event/" + eName;
	    	}
	    });
		connect($('body').attr('data-user') || cookies.read('user'));
	}
})