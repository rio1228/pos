<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認ページ</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/">
<%
	String campanyname = request.getParameter("campany");
	String userid = request.getParameter("username");
	String pass = request.getParameter("pass");
	String username1 = request.getParameter("name1");
	String username2 = request.getParameter("name2");
	String zipcode1 = request.getParameter("postcode1");
	String zipcode2 = request.getParameter("postcode2");
	String prefecture = request.getParameter("prefecture");
	String city = request.getParameter("citytown");
	String lastaddress = request.getParameter("lastaddress");
	String ocupation = request.getParameter("syokusyu");
	String email = request.getParameter("address");
	String phone = request.getParameter("denwa");
	String zipcode = zipcode1+"-"+zipcode2;
	String citytown = city+"\t"+lastaddress;

	session.setAttribute("campany", campanyname);
	session.setAttribute("username", userid);
	session.setAttribute("pass", pass);
	session.setAttribute("name1", username1);
	session.setAttribute("name2", username2);
	session.setAttribute("zipcode", zipcode);
	session.setAttribute("prefecture", prefecture);
	session.setAttribute("citytown", city);
	session.setAttribute("lastaddress", lastaddress);
	session.setAttribute("syokusyu", ocupation);
	session.setAttribute("address", email);
	session.setAttribute("denwa", phone);

%>
</head>
<body>
	<DIV ID="wrapper">
		<H1>下記の内容でよろしいですか？</H1>
		<P>貴社名：<%= campanyname %></P>
		<P>パスワード：<%= pass %></P>
		<P>担当者名：<%= username1 %></P>
		<P>担当者名(フリガナ)：<%= username2 %></P>
		<P>ジップコード：<%= zipcode %></P>
		<P>都道府県名：<%= prefecture %></P>
		<P>以下住所：<%= citytown %></P>
		<P>メールアドレス：<%= email %></P>
		<P>電話番号：<%= phone %></P>
		<FORM ACTION="http://localhost:8080/PosSystem/CampanyInsert" method="post">
			<INPUT type="submit" value="登録">
		</FORM>
		<A href="campany_insert.jsp"><INPUT type="button" value="修正する"></A>
	</DIV>
</body>
</html>