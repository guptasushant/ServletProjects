package com.servlet;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GenerateOTP")
public class GenerateOTPServlet extends HttpServlet {
	String toEmail;
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
         String email = request.getParameter("email");
        String otp = generateOTP();

        // Save OTP to the database
//        saveOTPToDatabase(email, otp);

        // Send OTP to the email
        sendOTPByEmail(email, otp,request );
        response.sendRedirect("forget-password.jsp"); // Redirect to OTP verification page
        

        // Store email in session for validation in VerifyOTPServlet
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("otp", otp);

       }

    private String generateOTP() {
        // Generate a 6-digit random OTP
        Random rand = new Random();
        int otpNumber = rand.nextInt(900000) + 100000;
        return String.valueOf(otpNumber);
    }

//    private void saveOTPToDatabase(String email, String otp) 
//    {
//        // Database connection details (replace with your actual database details)
//        String url = "jdbc:mysql://localhost:3306/sushant";
//        String username = "root";
//        String password = "root";
//
//        try {
//            // Load the JDBC driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Establish the database connection
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            // Insert OTP into the database
//            String query = "INSERT INTO otp_table (email, otp) VALUES (?, ?)";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, email);
//                preparedStatement.setString(2, otp);
//                preparedStatement.executeUpdate();
//            }
//
//            // Close the connection
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void sendOTPByEmail(String toEmail, String otp,HttpServletRequest req) 
    {
        // Replace these values with your actual email configuration
        String fromEmail = "guptasushant560@gmail.com";
        String emailPassword = "nuicwdgblrwlvapx";
       toEmail=req.getParameter("email");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(fromEmail, emailPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your OTP for Verification");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
