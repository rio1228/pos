<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更ページ</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
</head>
<body>

	<DIV id="wrapper">
		<DIV id="main">
			<H1>会員情報を変更します</H1>
			<FORM ACTION="../CampanyUpdate" method="post">
				<DIV id="check">
					<%
						String update = request.getRequestURI();
						session.setAttribute("updateuri", update);

						/* 認証失敗から呼び出されたのかどうか */
						Object exsist = session.getAttribute("exsist");
						/*最初のページではnullが設定されている*/
						if(exsist != null)
						{
							out.println("<p>その会社名は使われております</p>");
						    out.println("<p>再度会社名とパスワードを入力して下さい</p>");
							session.setAttribute("exsist", null);
						}
					%>
				</DIV>
				<H3>ユーザーネーム(ID)の変更</H3>
				<P><INPUT type="text" name="user"></P>
				<H3>パスワードの変更</H3>
				<P><INPUT type="password" name="password" maxlength="8"></P>
				<INPUT type="submit">
				<INPUT type="reset">
			</FORM>
		</DIV>
	</DIV>
</body>
</html>