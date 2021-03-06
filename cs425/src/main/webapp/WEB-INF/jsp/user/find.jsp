<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    
    <title>Find a student | Attendance Report System</title>
    
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
			<div class="col-md-8">
				<h1>Find user:</h1>
				<hr>
				<div class="margin-bottom">
					<input type="text" id="userName" class="form-control" style="width: 300px; display: contents;">
					<button class="find btn btn-primary" name="findUserButton">Find</button>
					<a href="/user/create">Create user</a>
					
				</div>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>User Name</th>
								<th>Password</th>
								<th>Role</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${!empty user}">
							<tr>
									<td>${user.username}</td>
									<td>*********</td>
									<td>
										<ul>
											<c:forEach items="${user.roles}" var="role">
												<li class="role">${role.name}</li>
											</c:forEach>
										</ul>
									</td>
										<td><a href="/user/update/${user.username}">edit</a></td>
										<td><a href="/user/delete/${user.username}">delete</a></td>
								</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="user" items="${users}">
								<tr>
									<td>${user.username}</td>
									<td>*********</td>
									<td>
										<ul>
											<c:forEach items="${user.roles}" var="role">

												<li class="role">${role.name}</li>

											</c:forEach>
										</ul>
										
										<td><a href="/user/update/${user.username}">edit</a></td>
										<td><a href="/user/delete/${user.username}">delete</a></td>
									</td>
								</tr>
							</c:forEach>
							</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<script src="/static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('.role').each(function() {
				
				var text = $(this).text();
				text = text.replace('ROLE_','');
				$(this).text(text);
			});
		});
	
        $('.find').on('click', function () {
        	//alert('test');
        	var username=$('#userName').val();
        	
        	if(username)        		
	            window.location.href = '/user/find/' + username;
            else
            	window.location.href = '/user/find';
            
        });
    </script>
</body>
</html>