<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    
    <title>View attendance by course | Attendance Report System</title>
    
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<div class="container body-content">
<div class="row">

	<div class="col-sx-12"> 
	<h1>View all Attendance</h1>
	<form name="showCourse" action="/showCourse" method="POST">
	Enter Student ID :<input type=text name="studentId"> 
	<button type="submit">Search</button>
	</form>
	
	
	<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>
</div>
</div>

	<script src="/static/js/jquery-1.11.1.min.js"></script>    
</body>
</html>