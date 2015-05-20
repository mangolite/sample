utils.define('tunnel.pipe', function(pipe,_instance_) {
	
	var counter = 0;
	var LISTENERS = {};
	
	pipe.localEvent = function LocalEvent(eventname,namespace){
		this.stopped = false;
		this.eventname = eventname;
		this.namespace = namespace;
		this.data = [];
	};
	
	pipe.localEvent.prototype.stop = function(){
		this.stopped  = true
	};
	
	pipe.on = function(eventname,cb){
		return this.instance().on(eventname,cb);
	};
	
	pipe.publish = function(eventInfo,data,data2,data3etc){
		var eventname = (typeof eventInfo === 'string') ? eventInfo : eventInfo.event;
		var namespace = eventInfo.namespace || this.namespace;
		var args = arguments;
		return $.Deferred(function(dff){
			var ev = new pipe.localEvent(eventname,namespace);
			if(typeof LISTENERS[eventname] != "undefined") {
				var numOfCallbacks = LISTENERS[eventname].length;
				for(var i=0; i<numOfCallbacks; i++) {
					var listener = LISTENERS[eventname][i];
					if(!listener.namespace || namespace == listener.namespace){
						ev.data.push(listener.callback.apply(ev,
								Array.prototype.slice.call(args,1)));
						if(ev.stopped) break;
					}
				}
			}
			dff.resolve(ev);
		}).promise();
	};
	
	pipe.off = function(eventname,cb){
		if(typeof LISTENERS[eventname] != "undefined") {
			var numOfCallbacks = LISTENERS[eventname].length;
			var newArray = [];
			if(cb!==undefined){
				var compKey = "id";
				if(typeof cb=='function'){
					compKey = "callback"
				}
				for(var i=0; i<numOfCallbacks; i++) {
					var listener = LISTENERS[eventname][i];
					if(listener[compKey] == cb) {
						delete listener[compKey]
					} else {
						newArray.push(listener);
					}
				}	
			}
			LISTENERS[eventname] = newArray;
		}
	};

	pipe._instance_ = function Pipe(namespace){
		this.namespace = namespace;
	};

	_instance_.on = function(eventname,cb,namespace){
		if(!this.lists) this.lists = [];
		if(eventname){
			counter++;
			this.lists.push(eventname+"#"+counter)
			if(!LISTENERS[eventname]) LISTENERS[eventname] = [];
			LISTENERS[eventname].push({
				name : eventname, callback : cb, id : counter, namespace : namespace
			});
		}
		return this;
	};
	_instance_.publish = function(){
		return pipe.publish.apply(this,arguments);
	};

	_instance_.off = function(){
		for(var i in this.lists){
			var einfo = this.lists[i].split('#');
			var newList = [];
			pipe.off.apply(pipe,einfo);
		}
		return this;
	};
	
});