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
		<script src="/static/js/html5shiv.min.js"></script>
		<script src="/static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<div class="container body-content">
<div class="row">

	<div class="col-sx-12"> 
	<h1>View attendance by course</h1>
	<hr>
	
	<c:choose>
			<c:when test="${studentattendances.size()!=0}">
				<table>
					<tr>
						<th>Course</th>
						<th>Student</th>
						<th>Full name</th>
						<th>Max attendance</th>
						<th>Participated</th>
						<th>Percentage</th>
						<th>Grade</th>


					</tr>
					<c:forEach items="${studentattendances}" var="studentattendance">
						<tr>
							<td><c:out value="${studentattendance.courseOffering.course.number}" /></td>
							<td><c:out value="${studentattendance.student.studentId}" /></td>
							<td><c:out value="${studentattendance.student.firstName} ${studentattendance.student.lastName}" /></td> 
							<td><c:out value="${studentattendance.getMaxAttendance()}" /></td>
							<td><c:out value="${studentattendance.getMeditationCount()}" /></td>
							<td><c:out value="${studentattendance.getMeditaionPercentageString()}%" /></td>
							<td><c:out value="${studentattendance.getMeditationExtraGrade()}" /></td>
						</tr>
					</c:forEach>

				</table>
			</c:when>
			<c:otherwise>
				<b>There are no record!</b>
			</c:otherwise>
	</c:choose>
	</div>
	
	<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>
</div>
</div>

	<script src="/static/js/jquery-1.11.1.min.js"></script>   
	<script src="/static/js/bootstrap.min.js"></script> 
</body>
</html>