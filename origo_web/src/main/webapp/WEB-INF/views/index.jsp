<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<link href="/app/dist/ox.app.css" rel="stylesheet"/>
<script src="/app/resources/weblibs/webmodules/jquery/jquery.js"></script>
<script src="/app/resources/weblibs/webmodules/foo/polyfills.js"></script>
<script src="/app/resources/weblibs/webmodules/foo/foo.js"></script>
<script src="/app/resources/weblibs/webmodules/foo/stacktrace.js"></script>
<script src="/app/resources/weblibs/jqgeeks/utils/utils.js"></script>
</head>
<body>

</body>
<script src="/app/resources/webroot/utils.config.js"></script>
<script src="/app/resources/webroot/ox.app.js"></script>
</html>