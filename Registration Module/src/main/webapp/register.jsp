<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>

    <!-- Styles -->
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: url('https://images.pexels.com/photos/1591447/pexels-photo-1591447.jpeg?cs=srgb&dl=pexels-guillaume-meurice-1591447.jpg&fm=jpg') center/cover fixed no-repeat;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            flex-direction: column-reverse;
            color:white;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9);
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
            color: black;
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

        /* Loading animation styles */
        #loadingContainer {
            display: none;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }

        .loading-spinner {
            border: 4px solid rgba(0, 0, 0, 0.1);
            border-radius: 50%;
            border-top: 4px solid #3498db;
            width: 20px;
            height: 20px;
            animation: spin 1s linear infinite;
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
</head>

<body>
    <!-- Registration Form Container -->
    <div class="container">
        <h2>User Registration</h2>

        <!-- Registration Form -->
        <form action="register" onsubmit="showLoading()" method="post">

            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required><br>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required><br>

            <!-- Email Field -->
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <!-- Password Field -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <!-- Submit Button -->
            <button type="submit">Register</button>
            <button type="button" onclick="location.href='login.html';" id="loginButton">Login</button>
        </form>

        <!-- Loading animation -->
        <div id="loadingContainer">
            <div class="loading-spinner"></div>
            <p>Loading...</p>
        </div>
    </div>

    <script>
        function showLoading() {
            // Hide the form
            document.querySelector('.container form').style.display = 'none';
            
            // Show the loading animation
            document.getElementById('loadingContainer').style.display = 'flex';
            
            // Simulate registration process (replace this with your actual registration logic)
            setTimeout(() => {
                // After some delay, you may want to redirect or show a success message
               // alert('Registration successful!');
                
                // For this example, let's just reset the form and hide the loading animation
                document.querySelector('.container form').style.display = 'block';
                document.getElementById('loadingContainer').style.display = 'none';
            }, 3000); // Simulating a 3-second registration process
        }
    </script>
</body>

</html>
