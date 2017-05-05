<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ここにタイトル</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/js/remodal/remodal-default-theme.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/PosSystem/js/remodal/remodal.css">
</head>
<body>
	<DIV ID="wrapper">
		<a data-remodal-target="modal">「data-remodal-target」でポップアップ！</a>

	  	<div class="remodal" data-remodal-id="modal" data-remodal-options="hashTracking:false">
	      <h1>タイトル</h1>
	      <p>
	        Hello, world!
	      </p>
	      <br />
	      <a class="remodal-cancel" href="#">Cancel</a>
	      <a class="remodal-confirm" href="#">OK</a>
	  	</div>
	</DIV>

<script type="text/javascript" src="http://localhost:8080/PosSystem/js/remodal/remodal.min.js"></script>
</body>
</html>