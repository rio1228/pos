<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>総合インデックス</title>
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/basic.css">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/basic_css/footer.css">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/retail_css/index.css">
</head>
<body>
	<DIV ID="wrapper">
		<DIV id="main">
			<DIV id="box">
				<DIV id="box1">
					<DIV ><P><a href="http://localhost:8080/PosSystem/retails/register.jsp">レジ</a></P></DIV>
				</DIV>
				<DIV id="box2">
					<DIV ><P><a href="http://localhost:8080/PosSystem/retails/index.jsp">総合管理</a></P></DIV>
				</DIV>
			</DIV>
		</DIV>
		<DIV id="footer">
			<jsp:include page="/common/footer.jsp" />
		</DIV>
	</DIV>
</body>
</html>