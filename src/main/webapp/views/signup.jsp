<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<h3 class="text-center">Sign Up</h3>
<div class="container-fluid">
<form method="POST" action="signup">
  <div class="row">
    <div class="col-sm-3">
    	<div class="form-group">
    		<input type="text" class="form-control" placeholder="Username" name="username" id="username">
  		</div>
  		<div class="form-group">
    		<input type="text" class="form-control" placeholder="Enrollment Month" name="enrollmentMonth" id="enrollmentMonth">
  		</div>
  		<div class="form-group">
    		<input type="text" class="form-control" placeholder="Father`s Name" name="fatherName" id="fatherName">
  		</div>
  		<div class="form-group">
    		<input type="text" class="form-control" placeholder="Program Id" name="programId" id="programId">
  		</div>	
  		<div class="form-group">
    		<input type="text" class="form-control" placeholder="Mobile No." name="mobile" id="mobile">
  		</div>	
    </div>
    <div class="col-sm-3">
  		<div class="form-group">
    		<input type="text" class="form-control" placeholder="First Name" name="firstname" id="pwd">
  		</div>
		<div class="form-group">
    		<input type="text" class="form-control" placeholder="Mother`s Name" name="motherName" id="motherName">
  		</div>
  		<div class="form-group">
    		<input type="text" class="form-control" placeholder="Academic Session" name="acadSession" id="acadSession">
  		</div>
  		
    </div>
    <div class="col-sm-3">
    	<div class="form-group">
    		<input type="text" class="form-control" placeholder="Last Name" name="lastname" id="pwd">
  		</div>
  		<div class="form-group">
    		<input type="text" class="form-control" placeholder="Roll No." name="rollNo" id="rollNo">
  		</div>
    </div>
    <div class="col-sm-3">
    	<div class="form-group">
    		<input type="password" class="form-control" placeholder="Password" name="password" id="pwd">
  		</div>
  		<div class="form-group">
    		<input type="email" class="form-control" placeholder="Email" name="email" id="email">
  		</div>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>