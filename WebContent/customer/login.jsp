<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/header.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/footer.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/index.css">
</head>
<body>
<%
	String login = request.getRequestURI();
	session.setAttribute("loginuri", login);
	//out.println(login);
	/* 認証失敗から呼び出されたのかどうか */
	Object status = session.getAttribute("status");
	/*最初のページではnullが設定されている*/
	if(status != null)
	{
		out.println("<p>認証に失敗しました</p>");
	    out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");
		session.setAttribute("status", null);
	}
%>
<FORM ACTION="../LoginDb" method="post">
	<P>ユーザーID</P>
	<INPUT type="text" name="user">
	<P>パスワード</P>
	<INPUT type="password" name="pass" maxlength="8">
	<INPUT type="submit">
<INPUT type="reset">
</FORM>
</body>
</html>