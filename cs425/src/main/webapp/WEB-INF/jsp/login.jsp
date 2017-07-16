<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in the Attendance Report System</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/common.css" rel="stylesheet">
    <link href="static/css/myfile.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container centered">
<div class="row">
	<div class="col-sm-4" align="center">
    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in the system</h2>
		<hr>
        <div class="form-group ${error != null ? 'has-error' : ''}">
           
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
           
        </div>
        </form>
	</div>
</div>
    

</div>
<!-- /container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>
