<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Something went Wrong </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

</head>
<body>
<div class="container-p-3 text-center">
<img src="img/error.jpg" class="img-fluid"/>
<h1>Sorry! something Went Wrong....</h1>
<p><%= exception %></p>
<a class="btn btn-outline-primary" href="index.jsp">Home page</a>
</div>
</body>
</html>