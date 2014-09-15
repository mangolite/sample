utils.define('stompClient', function(stompClient, _instance_) {
	var sClient = null;
	function setConnected(connected) {
		document.getElementById('connect').innerHTML = connected ? "Connected" : "Not Connected";
	}

	function connect() {
		var socket = new SockJS('/app/tunnel');
		sClient = Stomp.over(socket);
		sClient.connect({}, function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			sClient.subscribe('/event/greetings', function(greeting) {
				showGreeting(JSON.parse(greeting.body).content);
			});
		});
	}

	function disconnect() {
		sClient.disconnect();
		setConnected(false);
		console.log("Disconnected");
	}

	stompClient.send = function(handlerAction,data){
		sClient.send("/action/wsr/"+handlerAction, {}, JSON.stringify({
			data : JSON.stringify(data)
		}));
		
	};
	
	function sendName() {
		var name = document.getElementById('name').value;
		sClient.send("/action/hello", {}, JSON.stringify({
			'name' : name
		}));
	}
	function nosendName() {
		var name = document.getElementById('name').value;
		sClient.send("/action/wsr/testinghandler/click", {}, JSON.stringify({
			data : JSON.stringify({
				'name' : name
			})
		}));
	}
	function showGreeting(message) {
		var response = document.getElementById('response');
		var p = document.createElement('p');
		p.style.wordWrap = 'break-word';
		p.appendChild(document.createTextNode(message));
		response.appendChild(p);
	}
	stompClient._ready_ = function(){
		connect();
	}
})