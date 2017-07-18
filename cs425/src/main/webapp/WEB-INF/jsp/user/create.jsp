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
				<h1>Create a new user</h1>
				<hr>
				     
			       <input type="text" id="username" class="form-control margin-bottom" placeholder="Username" autofocus="true"></input>
			       
			       <input type="text" id="userpassword" class="form-control margin-bottom" placeholder="Password" autofocus="true"></input>
			       
			       <input type="text" id="userpassportconf" class="form-control margin-bottom" placeholder="Confirm password" autofocus="true"></input>
			       
			       <select id="role" class="form-control margin-bottom">
			       		<option value="1">Administrator</option>
			       		<option value="2">Staff</option>
			       		<option value="3">Faculty</option>
			       		<option value="4">Student</option>
			       </select> 
			
				<input type="text" id="storeStudent" class="form-control margin-bottom hidden" placeholder="Enter StudentId" autofocus="true"></input>
				<input type="text" id="storeFaculty" class="form-control margin-bottom hidden" placeholder="Enter FacultyId" autofocus="true"></input>
				
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
			
			
			var storeStudent = $('#storeStudent').val().trim();
			var storeFaculty = $('#storeFaculty').val().trim();
			
			if(roleId == 3 && storeFaculty.length == 0){
				alert("FacultyId is required!");
			}else if(roleId == 4 && storeStudent.length == 0){
				alert("StudentID is required!");
			}
			
			/* $.ajax({
                type: 'POST',
                url: '/user/create',
                data: JSON.stringify({ username: username, password: password, roleId: roleId, storeStudent: storeStudent, storeFaculty: storeFaculty }),
                contentType: 'application/json; charset=utf-8',
                success: function (result) {
                    alter(result);
                },
                error: function (e) {
                    alert(e);
                }
            }); */
            
			$.post("/user/create", { 
					username: username, 
					password: password, 
					roleId: roleId, 
					storeStudent: storeStudent, 
					storeFaculty: storeFaculty 
					},
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
		
		$('#role').change( function() {
			var id = $('#role').val();
			
			    $('#storeStudent').removeClass('hidden').addClass('hidden');
		        $('#storeFaculty').removeClass('hidden').addClass('hidden');
		      if(id == 3){
		    	  $('#storeFaculty').removeClass('hidden');
		      } else if(id == 4){
		    	  $('#storeStudent').removeClass('hidden');
		      }
		});
	
	</script>
</body>
</html>