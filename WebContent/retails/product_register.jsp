<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録ページ</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem-proto/basic_css/basic.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem-proto/basic_css/header.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem-proto/basic_css/footer.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem-proto/retail_css/product_register.css">
</head>
<body>
<DIV id="wrapper">
	<DIV id="header">
		<%@include file="/common/header.jsp"%>
	</DIV>
	<DIV id="productregister">
		<H1>会員登録フォーム</H1>
		<FORM ACTION="../ProductRegister" method="post">
			<P>JANコード</P>
			<P><INPUT type="text" name="productid"></P>
			<P>商品名</P>
			<P><INPUT type="text" name="productname"></P>
			<P>単価</P>
			<P><INPUT type="text" name="price">円</P>
			<P>商品分類</P>
			<P><select name="liquor">
				<option value="">--</option>
				<option value="1">赤ワイン</option>
				<option value="2">白ワイン</option>
				<option value="3">ロゼワイン</option>
				<option value="4">スパークリング白</option>
				<option value="5">スパークリング赤</option>
				<option value="6">その他ワイン</option>
				<option value="7">日本酒</option>
				<option value="8">焼酎</option>
				<option value="9">ブランデー</option>
				<option value="10">ウィスキー</option>
				<option value="11">ウォッカ</option>
				<option value="12">ジン</option>
				<option value="13">テキーラ</option>
				<option value="14">その他リキュール</option>
			</select></P>
			<INPUT type="submit">
			<INPUT type="reset">
		</FORM>
	</DIV>

	<DIV id="footer">
		<%@include file="/common/footer.jsp"%>
	</DIV>
</DIV>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/PosSystem-proto/js/header.js"></script>
</body>
</html>