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
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<div class="container body-content">
		
		<div class="row">
			<div class="col-md-6">
				<h1>Find student:</h1>
				<hr>
				<div>
					<input type="text" id="userName">
					<button class="find" name="findUserButton">Find</button>
					
				</div>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>User Name</th>
								<th>Password</th>
								<th>Role</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>

									<td>${user.username}</td>
									<td>*********</td>
									<td>
										<ul>
											<c:forEach items="${user.roles}" var="role">

												<li>${role.name}</li>

											</c:forEach>
										</ul>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<script src="/static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript">
        $('.find').on('click', function () {
        	//alert('test');
            window.location.href = '/user/find/' + $('#userName').val();
            
        });
    </script>
</body>
</html>