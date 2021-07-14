<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>LMS</title>
    </head>
    <body>
    	<div class="jumbotron text-center">
  			<h1>Welcome to the World of Online Learning</h1>
  			<p>Learning Made Easy</p> 
		</div>
  
		<div class="container">
  			<div class="row">
    			<div class="col-sm-4">
    			</div>
    			<div class="col-sm-4">
    				<h3 class="text-center">Change Password</h3>
					<form method="POST" action="/changeUserPassword">
  					<div class="form-group">
    					<input type="text" class="form-control" placeholder="Username/SAP ID" name="username" id="username">
  					</div>
 					<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
					</form>
    			</div>
    			<div class="col-sm-4">
    		</div>
  			</div>
		</div>
    
        <%-- <h1>Sign In</h1>
         <%
            	request.getAttribute("rerror"); 
            %>
            <h4>serror is ${serror}</h4>
            <h4>rerror is ${rerror}</h4>
        <form method="POST" action="login">
            <input type="text" name="username" placeholder="Username/SAP ID"><br><br>
            <input type="password" name="password" placeholder="Password">
            <input type="submit" value="Submit" /></form>
        </form><br> --%>
    </body>
</html>