<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="css/basic.css">
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