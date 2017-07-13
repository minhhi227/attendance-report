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
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	 <div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Users</a>
		</div>
	</div> 

	<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>User Name</th>
								<th>Password</th>
								<th>Role</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									
									<td>${user.username}</td>
									<td>******</td>
									<td>${user.roles}</td>
								</tr>
							</c:forEach> 
						</tbody>
					</table>
				</div>
				
</body>
</html>