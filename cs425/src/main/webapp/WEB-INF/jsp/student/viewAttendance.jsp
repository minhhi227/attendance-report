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
				<h3>My Attendance</h3>
				<h1>${msg}</h1>
				<hr>
				<div class="table-responsive">
					<table class="text-left">
					  <tr>
					    <td>Percentage of attendance: ${meditaionPercentage} %</td>
					  </tr>
					  <tr>
					    <td>Number of sessions attended: ${meditationCount}</td>
					  </tr>
					  <tr>
					    <td>Total number of sessions in this block: ${numberOfRequiredSessions}</td>
					  </tr>
					  <tr>
					    <td>Total extra grade: ${extraGrade}</td>
					  </tr>
					</table>
		
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Date</th>
								<th>Attendance</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="map" items="${map}">
								<tr>
									<td>${map.key}</td>
									
									<c:choose>
									    <c:when test="${map.value == true}">
									        <td><span class="glyphicon glyphicon-ok"></span></td> 
									    </c:when>    
									    <c:otherwise>
									         <td><span class="glyphicon glyphicon-minus"></span></td> 
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