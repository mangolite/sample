<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Hello WebSocket</title>

<!-- <link type="text/css" rel="stylesheet"
	href="/app/resources/css/compiled/bootstrap/bootstrap.css" />
 -->
<link type="text/css" rel="stylesheet"
	href="/app/resources/css/compiled/skin/black/theme.css" />

<script type="text/javascript">
	window.BrowserDetect = new (function() {
		this.isBelowIE9 = false;
	});
</script>
<!--[if lte IE 9]>
<script type="text/javascript">
	window.BrowserDetect.isBelowIE9 = true;
</script>
<![endif]-->
<script src="/app/resources/jquery/jquery.js"></script>
<script src="/app/resources/utils/utils.js"></script>
<script src="/app/resources/static/sockjs-0.3.4.js"></script>
<script src="/app/resources/static/stomp.js"></script>
</head>
<body data-user="${user}">
	<noscript>
		<h2 style="color: #ff0000">Seems your browser doesn't support
			Javascript! Websocket relies on Javascript being enabled. Please
			enable Javascript and reload this page!</h2>
	</noscript>
	<div>
		<b id="connect"">Connected</b>
	</div>
	<div id="myform"></div>
	<div id="market_price" style="position: absolute; right: 0; top:0;"></div>
</body>
<script src="/app/resources/utils.config.js"></script>
<script src="/app/resources/stompClient.js"></script>
<script src="/app/resources/dff/dff.init.js"></script>
</html>