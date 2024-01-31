<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SubmitForm</title>
<style>
	.container
	{
		width: 30%;
		border: 1px solid black;
		margin: auto;
		padding: 20px;
		#Myform table tr td input{
			font-size: 20px;
		}
	}
</style>
</head>
<body>
	<div class="container">
		<h1>My form</h1>
		<form action="MyServlet" method="post">
			<table>
				<tr>
					<td>Enter your name :</td>				
					<td> <input type="text" name="Username" placeholder="Enter here"></td>
					</tr>
					<tr>
					<td>Enter your password :</td>				
					<td> <input type="text" name="Password" placeholder="Enter here"></td>
					</tr>	
					<tr>
					<td>Enter your Email :</td>				
					<td> <input type="text" name="Email" placeholder="Enter here"></td>
					</tr>			
						<tr>
						<td>Select Gender :</t>				
						<td> 
						<input type="radio" name="Gender" value="male"> Male   
						<input type="radio" name="Gender" value="female"> Female 
						</td>
						</tr>
	<tr>
		<td> Select Your Course</td>
		<td>
			<select name="course">
				<option value="java">Java</option>
				<option value="python">Python</option>
				<option value="javaScript">js</option>
				<option value="c++">C++</option>
				<option value="android">Android</option>
			</select>
		</td>
	</tr>	
	<tr>
		<td style ="text-align: center;">
			<input type="checkbox" value="Checked" name="condition"/>
		</td>
		<td>
			Agree terms & conditions
		</td>
	</tr>
	<tr>
		<td style ="text-align: center;">
			<button type="submit">Register</button>
			<button type="reset">Reset</button>
		</td>
	</tr>		
			