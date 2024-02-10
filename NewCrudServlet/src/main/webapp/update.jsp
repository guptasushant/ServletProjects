<%@page import="com.newservlet.dao.UserDaoImpl"%>
<%@page import="com.newservlet.bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Data</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        form {
            margin-top: 20px;
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="email"],
        input[type="tel"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #4caf50;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%
  int id =  Integer.parseInt(request.getParameter("userId"));
request.setAttribute("id", id);
%>
    <div class="container">
        <h2>User Update Form</h2>
        <form action="UpdateUser" method="get">
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="updateemail" required><br>
            
            <label for="phone">Phone Number:</label><br>
            <input type="tel" id="phone" name="updatephone_no" required><br>
            
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="updatepassword" required><br>
            
            <!-- Use JSP expression to set the value of userId in hidden field -->
            <input type="hidden" name="userId" value="${id}"><br> 
            
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
