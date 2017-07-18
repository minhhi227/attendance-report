<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    
    <title>Create a student | Attendance Report System</title>
    
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
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="row">
			<div class="col-md-6">
				<h1>Update user password</h1>
				<hr>
				     <input type="hidden" id="username" value="${user.username}"/>
				     
			       <label class="form-control margin-bottom">${user.username}</label>
			       <input type="text" id="userpassword" class="form-control margin-bottom" placeholder="Password" autofocus="true"></input>
			       <input type="text" id="userpassportconf" class="form-control margin-bottom" placeholder="Confirm password" autofocus="true"></input>
			       
        			<button class="btn btn-lg btn-primary btn-block">Submit</button>
    		
    
			</div>
		</div>
	</div>
	
	<script src="/static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="/static/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$('.btn-block').on('click', function(){
			
			var roleId = $('#role').val();
		
			var username = $('#username').val().trim();
			if(username.length == 0) {
				alert("User name is required!");
				return;
			}
			
			var password = $('#userpassword').val().trim();
			var passportconf = $('#userpassportconf').val().trim();
			
			if(password.length == 0 || passportconf.length == 0) {
				alert("Password is required!");
				return;
			}else if(password != passportconf) {
				alert("Confirm password is not same!");
				return;
			}
			
            
			$.post("/user/update", { 
					username: username, 
					password: password},
					function(data) {

				if(data == 'success'){
					window.location.href = '/user/find'
				}
				else {
					alert(data);
				}

				}).done(function() {
				}).fail(function(xhr, textStatus, errorThrown) {
				}).complete(function() {
			});

			
		});
		
		
	</script>
</body>
</html>