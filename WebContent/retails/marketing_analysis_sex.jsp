<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
</head>
<title>性別分析</title>
<body class="drawer drawer--left">
<DIV id="wrapper">
	<DIV id="header"><!-- ヘッダー部分 -->
		<jsp:include page="/common/header.jsp" />
	</DIV>

	<DIV id="menu"><!-- メニュー部分 -->
			<jsp:include page="menu.jsp" />
	</DIV>
	<DIV id="main"><!-- 中身。動的に変わる -->
		<DIV id="contents">
			<DIV id="pie-contents">
				<DIV id="analysis">
					<DIV id="analisis_nav">
						<DIV id="home_pie" title="総合分析"><a href="http://localhost:8080/PosSystem/retails/marketing_analysis.jsp"><IMG ALT="総合別分析へ移動します" SRC="../img/home.png"></a></DIV>
						<DIV id="sex_pie" title="性別分析へ移動します"><a href="http://localhost:8080/PosSystem/retails/marketing_analysis_sex.jsp"><IMG ALT="性別分析" SRC="../img/sex.png"></a><span></span></DIV>
						<DIV id="weather_pie" title="天候別分析"><a href="http://localhost:8080/PosSystem/retails/marketing_analysis_weather.jsp"><IMG ALT="天候別分析へ移動します" SRC="../img/sun.png" ></a></DIV>
						<DIV id="temp_pie" title="気温別分析"><a href="http://localhost:8080/PosSystem/retails/marketing_analysis_temp.jsp"><IMG ALT="気温別分析へ移動します" SRC="../img/temp.png" ></a></DIV>
						<DIV id="human_pie" title="年代別分析"><a href="http://localhost:8080/PosSystem/retails/marketing_analysis_human.jsp"><IMG ALT="年代別分析へ移動します" SRC="../img/human.png" ></a></DIV>
					</DIV>
					<DIV id="analysis-chart">
						<canvas id="chart_pie"></canvas>
						<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/jquery-3.1.1.min.js"></script>
						<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/ccchart-min.js" charset="utf-8"></script>
						<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/analysisAjax.js"></script>
						<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/pie_sex.js" charset="utf-8"></script>
						<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/analisisPjax.js"></script>
					</DIV>
					<DIV id="recommend">
						<H2>売れ筋商品に似た商品はこちらです</H2>
						<TABLE border="1" id="popularTable">
						<TR>
							<TH>イメージ</TH>
							<TH width="200px">商品名</TH>
							<TH>詳細を見る</TH>
						</TR>
					</TABLE>
					</DIV>
					<DIV id="orderDiv">
						<H2>発注予定</H2>
						<FORM ACTION="../Order" method="post" id="orderAction">
							<TABLE border="1" id="orderTable">
								<TR>
									<TH width="100px">商品名</TH>
									<TH width="100px">卸売業者名</TH>
									<TH width="60px">単価</TH>
									<TH width="50px">数量</TH>
									<TH width="55px">小計</TH>
									<TH width="35px">削除</TH>
								</TR>
							</TABLE>
							<DIV id="orderSubmit">
								<INPUT type="reset" value="全て取り消す">
								<INPUT type="submit" value="発注する">
							</DIV>
						</FORM>
					</DIV>
					<DIV id="modalDiv"></DIV>
				</DIV>
			</DIV>
		</DIV>
		<div id="footer"><!-- フッター部分 -->
		<jsp:include page="/common/footer.jsp" />
		</div>
	</DIV>

</DIV>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/drawer/3.2.1/js/drawer.min.js"></script>
<script type="text/javascript" src="https://cdn.rawgit.com/ungki/bootstrap.dropdown/3.3.5/dropdown.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/iScroll/5.1.3/iscroll.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/pjax/spica.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/pjax/localsocket.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/vendor/pjax/pjax-api.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/menuPjax.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/common/menu.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/analysis/color.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem/js/remodal/remodal.min.js"></script>
</body>
</html>