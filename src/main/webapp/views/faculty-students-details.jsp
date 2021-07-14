<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LMS</title>
</head>
<body>
	<h2>Faculty Details</h2>
	<%-- Faculty Name : ${user.firstname} ${user.lastname}<br> --%>
	Faculty Username : ${userrole.user.username}<br>
	Program Name : ${programName}<br>
	Acad Session : ${acadSession}<br><br>
	<h3>Course Details</h3>
	<c:forEach var="courseDetails" items="${courseDetails}">
		<p><c:out value="${courseDetails.courseName}	" /><c:out value="${courseDetails.moduleAbbr}" /></p>
	</c:forEach>
	<h3>Student Details</h3>
	<c:forEach var="studentDetails" items="${studentsDetails}">
		<p><c:out value="${studentDetails.username}		" /><c:out value="${studentDetails.firstname} ${studentDetails.lastname}	" /><c:out value="${studentDetails.rollNo}" /></p>
	</c:forEach>
<%-- 	Student Username : ${studentsDetails.username}<br>
	Student Name : ${studentsDetails.firstname} ${studentsDetails.lastname}<br>
	Student Email : ${studentsDetails.email}<br> --%>
</body>
</html>