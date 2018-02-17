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
      <li class="active"><a href="/csye6220/mylist">Todo</a></li>
      <li><a href="/csye6220/profile">Profile</a></li>
    </ul>
  </div>
</nav>


	<div class="container">
	<h1></h1>
		<div class="row">
			<div class="col-sm-6">
				<div class="page-header">
				<h3 style="color:white">Hi! ${user.fname}</h3>
				
					<h1>ADD YOUR TODOS'</h1>
				</div>

				<sf:form class="well form-horizontal" method="post"
					action="/csye6220/mylistadd" modelAttribute="User" onclick="myfunction()" >
					<fieldset>


						<div class="control-group">
							<label class="control-label" for="todo">Todo:</label>
							<div class="controls">
								<input type="text" id="todo" name="todo" class="input-medium"
									required="required" />
								<p class="help-block alert-error">
									<c:out value="${requestScope.errorPassword}" />
								</p>
							</div>
							                            
						</div>
					</fieldset>
				</sf:form>

			</div>

			<div class="col-sm-6">
<div class="row">
	</div>
	<h1></h1>
	<h1 style="color:white">check your messages</h1>
				<table class="table table-bordered table-striped">

					<thead>
						<tr>
							<th>Your Messages</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${msgs}" var="currentMsg">
							<tr>
								<td>${currentMsg.msg}
									<p>is done!</p>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
 
  <p style="color:red"><strong>${warn}</strong> ${alt}.</p>
  <p style="color:green"><strong>${suc}</strong> ${res}.</p>

  
		<center>
			<h2>Your Todos!</h2>
		</center>
		<table class="table table-bordered table-striped">

			<thead>
				<tr>
					<th>Your todo</th>
					<th>Are you Done?</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="currentTodo">
					<tr>
						<td>${currentTodo.todo}</td>
						<td><sf:form class="well form-horizontal" method="post"
								action="/csye6220/delete" modelAttribute="Update">
								<button id="todo" name="todo" type="submit"
									value="${currentTodo.todo}" onclick="myfunction()" class="btn btn-danger">Done</button>
							</sf:form></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
<script>
function myfunction()
{        
    document.getElementById("popup").style.display="block";
}
</script>
</body>
</html>