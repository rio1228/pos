<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確定</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/logout.css">
</head>
<body>
	<DIV id="wrapper">
		<DIV id="main">
			<P>ご登録ありがとうございました</P>
			<FORM ACTION="retails/index.jsp">
				トップページに戻る
				<INPUT type="submit">
			</FORM>
		</DIV>
	</DIV>
</body>
</html>