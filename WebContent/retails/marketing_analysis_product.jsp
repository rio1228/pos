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
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/drawer/3.2.1/css/drawer.min.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/header.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/footer.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/index.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/menu.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/example.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/analisis.css" >
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/marketing.css">
</head>
<title>売上分析ページ</title>
<body class="drawer drawer--left">
	<DIV id="header"><!-- ヘッダー部分 -->
		<jsp:include page="/common/header.jsp" />
	</DIV>

	<DIV id="menu"><!-- メニュー部分 -->
			<jsp:include page="menu.jsp" />
	</DIV>
<DIV id="wrapper">
	<DIV id="main"><!-- 中身。動的に変わる -->
		<DIV id="contents">
			<H1>販売分析ページ</H1>
			<DIV id="analysis">
				<DIV id="kind-button">
					<INPUT id="sex" class="button5" type="button" value="性別"></INPUT>
					<INPUT id="age" class="button5" type="button" value="年代別"></INPUT>
					<INPUT id="price" class="button5" type="button" value="単価別"></INPUT>
					<INPUT id="wine" class="button5" type="button" value="ワイン色別"></INPUT>
				</DIV>
				<DIV id="analysis-chart">
					<canvas id="chart_rod"></canvas>
					<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script><!-- バージョンを変更するとpjaxが使えない -->
					<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/ccchart-min.js" charset="utf-8"></script>
					<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/analysisAjax.js"></script>
					<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/rod.js"></script>
				</DIV>
			</DIV>
		</DIV>
		</DIV>

	<div id="footer"><!-- フッター部分 -->
		<jsp:include page="/common/footer.jsp" />
	</div>
</DIV>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/drawer/3.2.1/js/drawer.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/ungki/bootstrap.dropdown/3.3.5/dropdown.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/iScroll/5.1.3/iscroll.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/jquery.pjax.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/menuPjax.js"></script>

<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/menu.js"></script>
</body>
</html>