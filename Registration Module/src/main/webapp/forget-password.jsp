<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Regenerate Password</title>

<!-- Styles -->
<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background: #f4f4f4;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.container {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

h2 {
	color: #333;
}

label {
	color: #555;
	display: block;
	text-align: left;
	margin-top: 10px;
}

input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button {
	background-color: #4caf50;
	color: #fff;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}
</style>
</head>

<body>
	<!-- RegeneratePassword Form Container -->
	<div class="container">
		<h2>Regenerate Password</h2>

		<!-- Regenerate Password Form -->
		<form action="regenerate-password" method="post">

			<!-- OTP Field -->
			<label for="otp">Enter OTP:</label> <input type="text" id="otp"
				name="otp" required>

			<!-- Submit Button -->
			<button type="submit">Regenerate Password</button>
		</form>
	</div>
</body>

</html>

    