<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>About Me</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <style>
    body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding: 50px; }
    .container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px gray; display: inline-block; text-align: left; max-width: 600px; }
    .profile { background: #00a6ff; color: white; padding: 20px; border-radius: 10px 10px 0 0; text-align: center; }
    .profile img { width: 120px; height: 120px; border-radius: 50%; border: 4px solid #e9f52f; }
    .profile h2 { margin: 10px 0; }
    .social-icons a { margin: 0 10px; text-decoration: none; font-size: 20px; color: white; }
    .content { padding: 20px; }
    .button { display: block; margin: 20px auto; padding: 10px 20px; border: 2px solid #00a6ff; border-radius: 5px; text-decoration: none; color: #00a6ff; font-weight: bold; text-align: center; max-width: 200px; }
  </style>
</head>
<body>
<div class="container">
  <div class="profile">
    <img src="https://prod-printler-front-as.azurewebsites.net/media/photo/175862.jpg?mode=crop&width=638&height=900&rnd=0.0.1" alt="Avatar">
    <h2>HELLO, I'M ANH DUC NGUYEN</h2>
    <div class="social-icons">
      <a href="https://www.facebook.com/nguyen.duc.anh.36615" target="_blank"><i class="fab fa-facebook"></i></a>
      <a href="https://www.instagram.com/ducanh_0903?igsh=MTltcHRmaHg3Y285OA==" target="_blank"><i class="fab fa-instagram"></i></a>
      <a href="https://github.com/Ducanh-2003" target="_blank"><i class="fa-brands fa-github"></i></a>
    </div>
  </div>
  <div class="content">
    <h2>About Me</h2>
    <p>I am a third-year student at Nha Trang University, majoring in Information Technology. As part of my Web Application Development 2 course, I am studying on an assignment that involves learning and implementing the doPost and doGet methods in servlet.</p>
    <a href="mailto:anh.nd.64cntt@ntu.edu.vn" class="button">CONTACT ME</a>
  </div>
</div>
</body>
</html>
