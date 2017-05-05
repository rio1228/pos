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
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/index.css">
</head>
<body>
<%
	String update = request.getRequestURI();
	session.setAttribute("updateuri", update);

	/* 認証失敗から呼び出されたのかどうか */
	Object exsist = session.getAttribute("exsist");
	/*最初のページではnullが設定されている*/
	if(exsist != null)
	{
		out.println("<p>そのユーザーIDは使われております</p>");
	    out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");
		session.setAttribute("exsist", null);
	}

%>
<H1>会員情報を変更します</H1>
<FORM ACTION="../UpdateDb" method="post">
<H3>ユーザーIDの変更</H3>
<INPUT type="text" name="user">
<H3>パスワードの変更</H3>
<INPUT type="password" name="password" maxlength="8">
<H3>電話番号の変更</H3>
<INPUT type="text" name="denwa">
<H3>メールアドレスの変更</H3>
<INPUT type="text" name="address">
<H3>職業の変更</H3>
	<select name="syokugyo">
		<option value="0">--</option>
		<option value="1">会社経営・自営</option>
		<option value="2">自営業</option>
		<option value="3">会社員（役員）</option>
		<option value="4">会社員（管理職）</option>
		<option value="5">会社員（一般社員）</option>
		<option value="6">契約社員・派遣社員</option>
		<option value="7">専門職（医師・弁護士など）</option>
		<option value="8">公務員</option>
		<option value="9">専業主婦・主夫・家事手伝い</option>
		<option value="10">学生</option>
		<option value="11">パート・アルバイト</option>
		<option value="12">その他</option>
	</select>
<INPUT type="submit">
<INPUT type="reset">
</FORM>
</body>
</html>