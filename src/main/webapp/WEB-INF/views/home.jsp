<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>MyList!</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MYLIST!</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/csye6220/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/csye6220/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<h1></h1>
<center>
<img src="http://2.bp.blogspot.com/-zBqbicJB3n4/Tcv9uL0CvPI/AAAAAAAAA4Q/KIMya9WGC7E/s1600/JC_Little_FUNNYanimation_todoLIST.jpg" class="img-rounded" width="500" height="500">
</center>

<h1>${msg}</h1>
</body>
</html>
