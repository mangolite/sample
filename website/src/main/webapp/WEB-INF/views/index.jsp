<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Hello WebSocket</title>
<script src="/app/resources/static/sockjs-0.3.4.js"></script>
<script src="/app/resources/static/stomp.js"></script>
<script type="text/javascript">
	var stompClient = null;

	function setConnected(connected) {
		document.getElementById('connect').disabled = connected;
		document.getElementById('disconnect').disabled = !connected;
		document.getElementById('conversationDiv').style.visibility = connected ? 'visible'
				: 'hidden';
		document.getElementById('response').innerHTML = '';
	}

	function connect() {
		var socket = new SockJS('/app/tunnel');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			stompClient.subscribe('/event/greetings', function(greeting) {
				showGreeting(JSON.parse(greeting.body).content);
			});
		});
	}

	function disconnect() {
		stompClient.disconnect();
		setConnected(false);
		console.log("Disconnected");
	}

	function sendName() {
		var name = document.getElementById('name').value;
		stompClient.send("/action/hello", {}, JSON.stringify({
			'name' : name
		}));
	}
	function nosendName() {
		var name = document.getElementById('name').value;
		stompClient.send("/action/wsr/testinghandler/click", {}, JSON.stringify({
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
</script>
</head>
<body>
	<noscript>
		<h2 style="color: #ff0000">Seems your browser doesn't support
			Javascript! Websocket relies on Javascript being enabled. Please
			enable Javascript and reload this page!</h2>
	</noscript>
	<div>
		<div>
			<button id="connect" onclick="connect();">Connect</button>
			<button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
		</div>
		<div id="conversationDiv">
			<label>What is your name?</label><input type="text" id="name" />
			<button id="sendName" onclick="sendName();">Send</button>
			<button id="sendName" onclick="nosendName();">No Send</button>
			<p id="response"></p>
		</div>
	</div>
</body>
</html>