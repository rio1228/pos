<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>設定ページ</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/retails_css/settei.css">
</head>
<body>
	<div id="particles">
		<div style="position: absolute;top:10px;left:10px;">
			<h1>Particleground</h1>
			<p>A JavaScript plugin for snazzy background particle systems. Includes an optional parallax effect controlled by the mouse on desktop devices and gyroscope on mobile devices. Works in any browser that supports HTML5 canvas.</p>
		</div>
	</div>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script><!-- バージョンを変更するとpjaxが使えない -->
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/jquery.particleground.min.js" charset="utf-8"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/mainDiv.js"></script>
</body>
</html>