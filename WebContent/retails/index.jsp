<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>総合ページ</title>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/jquery-3.1.1.min.js"></script>
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> バージョンを変更するとpjaxが使えない -->
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/jquery.particleground.min.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/drawer/3.2.1/css/drawer.min.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/header.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/footer.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/index.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/menu.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/example.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/analisis.css" >
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/marketing.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/table.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/js/remodal/remodal-default-theme.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/js/remodal/remodal.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/js/remodal/remodalUser.css">
<link href="https://fonts.googleapis.com/css?family=Droid+Sans:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Bitter|Droid+Sans:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Bitter|Droid+Sans:700|Gloria+Hallelujah" rel="stylesheet">
<%
	String login = request.getRequestURI();
	session.setAttribute("loginuri", login);
%>
</head>
<body class="drawer drawer--left">

<DIV id="wrapper">
	<DIV id="header"><!-- ヘッダー部分 -->
		<jsp:include page="/common/header.jsp" />
	</DIV>

	<DIV id="menu"><!-- メニュー部分 -->
			<jsp:include page="menu.jsp" />
	</DIV>

	<DIV id="main"><!-- 中身。動的に変わる -->
		<c:choose>
			<c:when test="${campany_form==null}">
				<jsp:include page="example.jsp" />
			</c:when>

		</c:choose>
	</DIV>

	<div id="footer"><!-- フッター部分 -->
		<jsp:include page="/common/footer.jsp" />
	</div>
</DIV>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/drawer/3.2.1/js/drawer.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/ungki/bootstrap.dropdown/3.3.5/dropdown.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/iScroll/5.1.3/iscroll.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/pjax/spica.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/pjax/localsocket.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/pjax/pjax-api.min.js"></script>
<!-- <script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/jquery.pjax.js"></script> -->
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/menuPjax.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/ccchart-min.js" charset="utf-8"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/analysisAjax.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/menu.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/color.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/remodal/remodal.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/analisisPjax.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/mainDiv.js"></script>
<!-- <script type="text/javascript" src="http://localhost:8080/PosSystem/js/ajaxzip2/prototype.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/ajaxzip2/ajaxzip2.js" charset="UTF-8"></script> -->
</body>
</html>