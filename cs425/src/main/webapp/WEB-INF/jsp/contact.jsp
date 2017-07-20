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

    <title>Contact</title>

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

<h2>Contact</h2>
<h3>WATER team's contact.</h3>

<address>
    Maharishi University Of Management<br />
    1000 North Fourth St.<br />
    <abbr title="Phone">P:</abbr>
    (800) 369-6480
</address>

<address>
    <strong>Marketing:</strong>   <a href="mailto:info@orifjon.net">info@orifjon.net</a><br />
    <strong>Support:</strong> <br />
    
    <a href="mailto:orifjon.narkulov@hotmail.com">Orifjon Narkulov</a><br />
    <a href="mailto:minhhi227@gmail.com">Minh Hieu Nguyen</a><br />
    <a href="mailto:lwi25@yahoo.com">Lwam Abraham Hailu</a><br />
    <a href="mailto:raw.sharma1379@gmail.com">Ramesh Sharma</a><br />
    <a href="mailto:pagmaae@gmail.com">Dorjpagma Erdenebat</a><br />
</address>  

</div>
<script src="/static/js/jquery-1.11.1.min.js"></script>    
    <script src="/static/js/bootstrap.min.js"></script>
</body>
</html>
