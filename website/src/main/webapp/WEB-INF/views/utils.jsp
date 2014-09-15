<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Hello WebSocket</title>
<script type="text/javascript">
	window.BrowserDetect = new (function(){
		this.isBelowIE9 = false;
	});
</script>
<!--[if lte IE 9]>
<script type="text/javascript">
	window.BrowserDetect.isBelowIE9 = true;
</script>
<![endif]-->
<script src="/app/libs/jqgeeks/jquery/jquery.js"></script>
<script src="/app/libs/jqgeeks/utils/utils.js"></script>
<script src="/app/libs/jqgeeks/utils/tools/wiretap.js?no"></script>
<script src="/app/resources/static/sockjs-0.3.4.js"></script>
<script src="/app/resources/static/stomp.js"></script>
</head>
<body>
	<noscript>
		<h2 style="color: #ff0000">Seems your browser doesn't support
			Javascript! Websocket relies on Javascript being enabled. Please
			enable Javascript and reload this page!</h2>
	</noscript>
	<div id="myform">
		<div>
			<b id="connect"">Connected</b>
		</div>
		<div>
			<p>
				A.B <input class="tag" type="text" data-path="name.fname" formattype="date"
					id="name" />
			</p>
			<p>
				A.C <input class="tag" type="text" data-path="name.lname" formattype="date"
					id="name" />
			</p>
						<p>
				A.B <input class="tag" type="text" data-path="age" formattype="date"
					id="name" />
			</p>
		</div>
	</div>
</body>
<script src="/app/resources/utils.config.js"></script>
<script src="/app/resources/stompClient.js"></script>
<script src="/app/resources/dff/dff.init.js"></script>
</html>