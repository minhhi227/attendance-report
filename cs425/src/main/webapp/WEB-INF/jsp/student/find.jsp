
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

	
	<div class="container body-content">
		<div class="row">
				<div class="col-sx-12">
					<div>
			           <br>
			           <input type="text" name="studentId" id="studentId"  placeholder="Student Id">
					   <input type="submit" value="Find" id="requestButton">
					</div>
					<hr>
					
					
					<table>
					         <tr>
													
								<th>StudentId</th>
								<th>Full Name</th>
								<th>EntryDate</th>
								<th>Status</th>
								<th>EmailAddress</th>
								<th>VisaStatus</th>
								<th>Attendance</th>
							</tr>
						<c:choose>
						    <c:when test="${!empty student}">
	        				<tr>
	                   
			                    <td><c:out value="${student.studentId}" /></td>
			                    <td><c:out value="${student.firstName}  ${student.lastName} " /></td>
			                    
			                    <td><c:out value="${student.entryDate}" /></td>
			                    <td><c:out value="${student.status}" /></td>
			                    <td><c:out value="${student.emailaddress}" /></td>
			                    <td><c:out value="${student.visaStatus}" /></td>
			                    <td><a href="/attendance/student/${student.studentId}">View</a></td>
			                 </tr>
	                  		</c:when>
                  		</c:choose>
					</table>
					
					<hr>
					<h2>Courses list by current student</h2>
					<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th class="number">Course Number</th>
								<th class="name">Name</th>
								<th class="date">Start Date</th>
								<th class="period">Period</th>
								<th class="faculty">Faculty</th>
								<th class="attend">Manage attendance</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="enrolled" items="${enrolled}">
								<tr>
									<td>${enrolled.offering.course.number}</td>
									<td>${enrolled.offering.course.name}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd" value="${enrolled.offering.startDate}"/></td>
									<td>${enrolled.offering.period}</td>
									<td>${enrolled.offering.faculty.firstName}</td>
									<c:choose>
									    <c:when test="${enrolled.offering.startDate <= today}">
									        <td><a href="/staff/attendance/${enrolled.offering.id}/${student.studentId}">View</a></td> 
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
					
					
				</div>
				<%@ include file="/WEB-INF/jsp/layout/footer.jsp"%>
			</div>
	</div>

	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
        $('#requestButton').on('click', function () {
        	//alert('test');
        	var username=$('#studentId').val();
        	//console.log("123"+username);
        	
        	if(username)        		
	            window.location.href = '/student/find/' + username;
            else
            	{
            		alert('StudentId is required!');
            	}
            
        });
    </script>
</body>
</html>