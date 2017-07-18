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

    <title>Faculty courses | Home</title>
    
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="/static/js/html5shiv.min.js"></script>
		<script src="/static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	
	<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

	<div class="container">
		<h1>Courses For The Past Six Months</h1><hr>
		
	<c:choose>
			<c:when test="${listOfAll.size()!=0}">
				<table>
					<tr>
						<th>Course-Number</th>
						<th>Course-Name</th>
						<th>Course-StartDate</th>
						<th>Enrolled</th>
						<th>Capacity</th>
						<th>Active</th>
						<th>Attendance</th>




					</tr>
					<c:forEach items="${listOfAll}" var="course">
						<tr>
							<td><c:out value="${course.course.number}" /></td>
							<td><c:out value="${course.course.name}" /></td>
							<td><c:out value="${course.startDate}" /></td>
							<td><c:out value="${course.enrolled}" /></td>
							<td><c:out value="${course.capacity}" /></td>
							<td><c:out value="${course.active}" /></td>
							<td><a href="/attendance/course/${course.id}">View</a></td>
							

						</tr>
					</c:forEach>

				</table>
			</c:when>
			<c:otherwise>


				<b>No Record is found for the past six Months!</b>


			</c:otherwise>

		</c:choose>
		
	<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>
	</div>
	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>