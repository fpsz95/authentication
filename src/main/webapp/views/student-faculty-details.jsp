<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<h2>Student Details</h2>
	<%-- Student Name : ${user.firstname} ${user.lastname}<br> --%>
	Student Username : ${userRole.user.username}<br>
	Program Name : ${programName}<br>
	Acad Session : ${acadSession}<br><br>
	<h3>Course Details</h3>
	<c:forEach var="courseDetails" items="${courseDetails}">
		<p><c:out value="${courseDetails.courseName}	" /><c:out value="${courseDetails.moduleAbbr}" /></p>
	</c:forEach>
	<h3>Faculty Details</h3>
	<c:forEach var="facultyDetails" items="${facultyDetails}">
		<p><c:out value="${facultyDetails.username}		" /><c:out value="${facultyDetails.firstname} ${facultyDetails.lastname}	" /><c:out value="${facultyDetails.email}" /></p>
	</c:forEach>
</body>
</html>