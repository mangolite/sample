<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>RealTimeWebApp</title>
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
<script src="/app/resources/weblibs/webmodules/jquery/jquery.js"></script>
<script src="/app/resources/weblibs/jqgeeks/utils/polyfills.js"></script>
<script src="/app/resources/weblibs/jqgeeks/utils/utils.js"></script>
</head>
<body>
<div id="loginSection">
	<div id="loginContainer">
	</div>
</div>
<div id="chatSection">
	<div id="chatContainer">
	</div>
</div>


</body>
<script src="/app/resources/webroot/utils.config.js"></script>
<script src="/app/resources/webroot/ox.registration.js"></script>
</html>