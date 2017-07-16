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

	<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

			<div class="container text-center" id="tasksDiv">
				<h3>My Courses</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th class="number">Course Number</th>
								<th class="name">Name</th>
								<th class="date">Start Date</th>
								<th class="period">Period</th>
								<th class="faculty">Faculty</th>
								<th class="attend">View Attendance</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="enrolled" items="${enrolled}">
								<tr>
									<td>${enrolled.offering.course.number}</td>
									<td>${enrolled.offering.course.name}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${enrolled.offering.startDate}"/></td>
									<td>${enrolled.offering.period}</td>
									<td>${enrolled.offering.faculty.firstName}</td>
									<c:choose>
									    <c:when test="${enrolled.offering.startDate <= today}">
									        <td><a href="/student/attendance/${enrolled.offering.id}">View</a></td> 
									    </c:when>    
									    <c:otherwise>
									        <td>Pending</td>
									    </c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>
			</div>
		

	<script src="/static/js/jquery-1.11.1.min.js"></script>    
    <script src="/static/js/bootstrap.min.js"></script>
</body>
</html>