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
	<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<h4>Student ~ ${student.firstName}  ${student.lastName}  </h4><hr>
<div>
<table>
         <tr>
								
							  <th>StudentId</th>
								<th>EntryDate</th>
								<th>Status</th>
								<th>EmailAddress</th>
								<th>VisaStatus</th>
								
								 
							      
							</tr>
    <%-- <c:forEach items="${student}" var="stu">--%>
        <tr>
                   
                    <td><c:out value="${student.studentId}" /></td>
                    <td><c:out value="${student.entryDate}" /></td>
                     <td><c:out value="${student.status}" /></td>
                    <td><c:out value="${student.emailaddress}" /></td>
                    <td><c:out value="${student.visaStatus}" /></td>
                    
                   
       
       
                          </tr>
<%--  </c:forEach>--%>

</table>
</div>

</body>
</html>