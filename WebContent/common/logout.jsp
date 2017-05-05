<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト確認ページ</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/logout.css">

</head>
<body>
	<DIV id="wrapper">
		<DIV id="logout">
			<H1>本当にログアウトしますか？</H1>
			<FORM ACTION="../CommonLogout">
				<INPUT type="submit" value="はい">
			</FORM>
			<A href="http://localhost:8080/PosSystem/retails/index.jsp"><INPUT type="button" value="戻る"></A>
		</DIV>
	</DIV>
</body>
</html>