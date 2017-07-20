<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <title>Home</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<div class="container">

    <div class="jumbotron">
    <h1>TM Attendance Report System</h1>
    <p class="lead">The purpose of this website is to collect, analyze, and define high-level needs and features of the MUM faculty to easily look up at students’ meditation attendance</p>
    <p><a href="https:www.mum.edu" class="btn btn-primary btn-lg">Learn more &raquo;</a></p>
</div>

<div class="row">

    <div class="col-md-4">
        <h2>Transcendental Meditation<sup>®</sup></h2>
        <p>
            You'll learn this absolutely effortless technique to <strong>boost your learning ability</strong> and reduce stress
        </p>
        <p><a class="btn btn-default" href="https://www.mum.edu/about-mum/transcendental-meditation-technique">Learn more &raquo;</a></p>
    </div>
    
    <div class="col-md-4">
        <h2>What is TM?</h2>
        <p>It’s a <strong>simple, natural, effortless technique practiced</strong> 20 minutes twice each day while sitting comfortably with the eyes closed.</p>
        <p><a class="btn btn-default" href="http://www.tm.org/transcendental-meditation">Learn more &raquo;</a></p>
    </div>
    <div class="col-md-4">
        <h2>What is the TM technique?</h2>
        <p>It's an effortless technique for "recharging your mind and body" — and <strong>creating a brighter, more positive state of mind</strong>.</p>
        <p><a class="btn btn-default" href="http://www.tm.org/">Learn more &raquo;</a></p>
    </div>
</div>

</div>
<script src="/static/js/jquery-1.11.1.min.js"></script>    
    <script src="/static/js/bootstrap.min.js"></script>
</body>
</html>
