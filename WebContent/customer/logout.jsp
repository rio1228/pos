<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト確認ページ</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/header.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/footer.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/index.css">
</head>
<body>

<H1>本当にログアウトしますか？</H1>
<FORM ACTION="../LogOut">
	<INPUT type="submit">
</FORM>

</body>
</html>