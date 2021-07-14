<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>LMS</title>
        </head>

        <body>
            <h1>Profile</h1><br><br>
           
            User Details: <br>
                ID : ${user.username}<br>
                First Name : ${user.firstname}<br>
                Last Name : ${user.lastname}<br>
                Username : ${user.username}<br>
                EnrollmentYear : ${user.enrollmentYear}<br>
                EnrollmentMonth : ${user.enrollmentMonth}<br>
                ProgramId : ${user.programId}<br>
                Email : ${user.email}<br>
                Mobile : ${user.mobile}<br>
                Acad Session : ${user.acadSession}<br>
                Campus Id : ${user.campusId}<br>
                Campus Name : ${user.campusName}<br>
                Role : ${user.role}<br>      
                <br>      
            <a href="/faculty/page2">Page 2</a>
            <br>
            <a href="/faculty/logout">Sign Out</a>
        </body>

        </html>