/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

utils.define('tunnel.poll', function(poll) {

	poll.token = '-1';
	poll.counterEnd = 0;
	poll.counterStart = 0;
	poll.eventCounter = 0;
	poll.started = false;
    var eventMap = {};
    poll.open = function(){
    	if(poll.started) return false;
    	else poll.longPoll('utils.poll._onOpen_','handshake');
    };
    poll._onMessage_ = function(resp) {
    	try{
    		this.counterStart = this.counterEnd;
    		this.counter = resp.counter;
    		for(var i in resp.data){
    			this.counterEnd = Math.max(this.counterEnd,resp.data[i].id);
    			resp.data[i].data = utils.parse(resp.data[i].eData);
    			console.log('poll.onMessage',this.counterEnd,resp.data[i].data);
    		}
    		this.time = resp.time;
    	} catch(e){
    		console.error('error while processing lpoll response',e);
    	} finally {
    		poll.longPoll('utils.poll._onMessage_');    		
    	}
    };
    poll._onOpen_ = function(data) {
        console.log('poll is open',data);
        poll.longPoll('utils.poll._onMessage_');
    };
    poll._onSent_ = function(data) {
        console.log('poll is open',data);
        poll.longPoll('utils.poll._onMessage_');
    };
    poll.longPoll = function(_cb_,handler,data) {
        $.ajax({
            url : 'poll.php?do='+(handler || 'getLPollData'),
            type    : 'POST',
            dataType: 'jsonp',
            jsonpCallback: _cb_,
            data: 'token=' + this.token +  '&counterStart=' +  this.counterStart + 
            '&counterEnd=' +  this.counterEnd + 
            '&counter=' + this.counter + 
            '&data='+utils.stringify(data || {})
        });
    };
    
    poll.sendLazy = function(eName, eData){
    	 return poll.longPoll('utils.poll._onMessage_','sendData',eData);
    };
    poll.triggerListener = function(eName, eData){
    	eventMap[eName] = eventMap[eName] || [];
    	for(var i in eventMap[eName]){
        	eventMap[eName][i](listner);
    	}
    };
    poll.addListener = function(eName, listner){
    	poll.open();
    	eventMap[eName] = eventMap[eName] || [];
    	eventMap[eName].push({
    		id : poll.eventCounter ,fun : listner
    	});
    	return poll.eventCounter++;
    };
    poll.removeListener = function (eName,listener) {
    	eventMap[eName] = eventMap[eName] || [];
    	if(listener){
	    	eventMap[eName] = $.grep(eventMap[eName], function (value) {
	          return !(value.fun == listener ||  value.id==listener);
	        });
    	} else {
    		delete eventMap[eName];
    	}
    };
    poll._ready_ = function(){
    	poll.token = window.token || (document.location.search.split('token=')[1] || '-1').split('&')[0];
    	console.log('poll.starting...hmmmm');
    	//poll.open();
    };
    
    poll.sub = poll.addListener;
    poll.unsub =  poll.removeListener;

});