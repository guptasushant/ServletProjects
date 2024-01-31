<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User Bank Account</title>

    <style>
        /* Style to make the link look like a button */
        .button-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px; /* Adjust the margin as needed */
        }

        /* Additional styles for form layout */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Update User Bank Account</h2>

    <form action="updateServlet" method="post">
    
        <label for="idToUpdate">Enter ID to Update :</label>
        <input type="text" name="id" required>
        <input type="hidden" name="work" value="update">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required>
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required>
        <input type="submit" value="Update" class="button-link">
        <input type="reset" value="Reset" class="button-link">
    </form>
</body>
</html>
