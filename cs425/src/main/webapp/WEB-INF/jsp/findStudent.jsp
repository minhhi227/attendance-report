
<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Student Manager | Home</title>
    
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<%@ include file="/WEB-INF/jsp/layout/header.jsp"%>

	<form action="/student/findStudentById" method="GET">
		<div class="divFindStudent">
           Enter StudentId:<Span id="spanId"> * </Span><input type="text"
				name="studentId" id="studentId" required placeholder="student Id">
			<input type="submit" value="Find" id="requestButton">
		</div>
	</form>

	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<%@ include file="/WEB-INF/jsp/layout/footer.jsp"%>
</body>
</html>