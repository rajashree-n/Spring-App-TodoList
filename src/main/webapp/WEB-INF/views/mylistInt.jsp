<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
  </div>
</nav>

	<div class="container">
<h1 style="color:white">Choose your Category</h1>
<h1>Choose your Category</h1>
<h5>Hi! ${user.fname}</h5>
<center>


<a href="/csye6220/mylist"><button value="${user}" id="user" name="user" type="submit" class="btn btn-success">LOGIN AS PARENT</button></a>

<a href="/csye6220/mylistchild"><button value="${user}" type="submit" class="btn btn-info">LOGIN AS CHILD</button></a>
</center>
	</div>
</body>
</html>
