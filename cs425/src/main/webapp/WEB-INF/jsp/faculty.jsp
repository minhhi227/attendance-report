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
    
    <title>Admin Manager | Home</title>
    
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
			<a href="/" class="navbar-brand">Faculty</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					 <c:choose>
						<c:when test="${mode == 'MODE_COURSE'}">
						</c:when>
					</c:choose>
					
				</ul>
			</div>
		</div>
	</div>
	
	<h3 id="facultyPage">Welcome Back</h3>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2 id="rigthLogout"> <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>
	<form >
	<ul id="facultyList">
  <li class="list"><a href="/faculty-Courses">Courses</a></li>
  <li class="list"><a href="#input">input</a></li>
  <li class="list"><a href="#input">input</a></li>
  <li class="list"><a href="#input">input</a></li>
</ul>
	</form>>
	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>