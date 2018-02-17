<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MYLIST!</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/csye6220/logout"><span class="glyphicon glyphicon-user"></span> Log Out</a></li>
    </ul>
    <ul class="nav navbar-nav">
      <li><a href="/csye6220/mylist">Todo</a></li>
      <li class="active"><a href="/csye6220/profile">Profile</a></li>
    </ul>
  </div>
</nav>


<div class="container">

		<div class="row">
		<h1 style="color:white">xyz</h1>
					<div class="span6 offset3">
			<div class="panel panel-success">
      <div class="panel-heading">Your Details!</div>
      <div class="panel-body">
      <h4><b style="color:blue">Family Name :</b> ${user.fname}</h4>
      <h4><b style="color:blue">Email :</b> ${user.email}</h4>
      </div>
    </div>		
					
		</div>
			<div class="span6 offset3 well">
				<div class="page-header">
					<h1></h1>
				</div>

				<sf:form class="form-group form-horizontal" method="get"
					action="/csye6220/update" modelAttribute="user">
					<fieldset>

						<div class="control-group">
							<label class="control-label" for="fname">Family Name:</label>
							<div class="controls">
								<sf:input path="fname" id="fname" type="text"
									value="${user.fname}" class="input-medium" placeholder="Family name"
									required="required" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="email">Email:</label>
							<div class="controls">
								<sf:input path="email" id="email" type="email"
									value="${user.email}" class="input-medium" placeholder="your@email.com"
									required="required" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="password">Password:</label>
							<div class="controls">
								<sf:input type="password" path="password" id="password"
									value="${user.password}" class="input-medium" placeholder="min 6 characters"
									required="required" />
							</div>
						</div>

						<div class="form-actions">
							<button type="submit" class="btn btn-primary">
								<i class="icon-lock icon-white"></i> Update
							</button>
						</div>

					</fieldset>
				</sf:form>
			</div>
		</div>
	</div>


</body>
</html>