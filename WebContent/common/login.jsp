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
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css"><!-- LANつなげた状態じゃない場合localhostに変更 -->
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/login.css">
<%
		//out.println(login);
		/* 認証失敗から呼び出されたのかどうか */
		Object status = session.getAttribute("status");
	%>
</head>
<body>
	<DIV id="wrapper">
		<DIV id="main">
			<DIV id="check">
				<%
					/*最初のページではnullが設定されている*/
					if(status != null)
					{
						out.println("<p>認証に失敗しました</p>");
					    out.println("<p>再度会社名とパスワードを入力して下さい</p>");
						session.setAttribute("status", null);
					}
				%>
			</DIV>
			<DIV id="form">
		    	<p class="form-title">Login</p>
			    <FORM ACTION="http://localhost:8080/PosSystem/CommonLogin" method="post">
			        <p>Email</p>
			        <p class="mail"><input type="email"name="user" /></p>
			        <p>Password</p>
			        <p class="pass"><input type="password" name="pass" maxlength="8" /></p>
			        <p class="check"><input type="checkbox" name="checkbox" />パスワードを保存</p>
			        				<INPUT type="reset">
			        <p class="submit"><input type="submit" value="Login" /></p>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
</body>
</html>