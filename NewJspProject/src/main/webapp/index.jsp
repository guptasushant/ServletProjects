<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add module home page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
 <div class="container">
  
  <div class="col-md-6 offset-md-3">
  	<form action="op.jsp">
  	<div class="card">
  	
  	<div class="card-header bg-dark text-white">
  	<h3>Provide me two number </h3>
  	
  	</div>
  	<div class="card-body bg-secondary"> 
  		<div class="form-group">
  		<input name="n1" class="form-control" placeholder="Enter n1"/>
  		</div>
  		<br>
  		<div class="form-group">
  		<input name="n2" type="number" class="form-control" placeholder="Enter n2"/>
  		</div>
  	
  	</div>
  	<div class="card-footer bg-dark text-white text-center">
  	
  	<button class="btn btn-outline-success">Divide</button>
  	</div>
  	
  	
  	</div>
  </form>
  
  </div>
 
 </div>
</body>
</html>