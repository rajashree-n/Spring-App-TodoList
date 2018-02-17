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

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">MYLIST!</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/csye6220/register"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="/csye6220/login"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">

		<div class="row">
			<div class="span6 offset3">
				<div class="page-header">
					<h1></h1>
				</div>

				<c:if test="${error != null}">
				<div class="alert alert-error"> <strong>${error}</strong>
			</div>
			</c:if>

			<sf:form class="well form-horizontal" method="post"
				action="/csye6220/loggingParent" modelAttribute="user">
				<fieldset>

					<div class="control-group">
						<label class="control-label" for="email">Email:</label>
						<div class="controls">
							<sf:input path="email" id="email" type="email"
								class="input-medium" placeholder="your@email.com"
								required="required" />
								<p class="help-block alert-error">
								<sf:errors path="email" cssClass="error"/>
								</p>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="password">Password:</label>
						<div class="controls">
							<sf:input type="password" path="password" id="password"
								class="input-medium" placeholder="min 6 characters"
								required="required" />
								<p class="help-block alert-error">
								<sf:errors path="password" cssClass="error"/>
								</p>
						</div>
					</div>

					<div class="form-actions">
						<button type="submit" class="btn btn-primary">
							<i class="icon-lock icon-white"></i> Sign in
						</button>
					</div>

					<div align="center">
						You don't have an account yet? <a href="/csye6220/register">Register
							here for free!</a>
					</div>
					<h3>${error}</h3>
				</fieldset>
			</sf:form>
		</div>
	</div>
	</div>
</body>
</html>