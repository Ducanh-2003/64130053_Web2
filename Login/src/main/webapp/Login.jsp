<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if("ABC".equals(username) && "MNK".equals(password)){
            response.sendRedirect("UserProfile.html");
        } else {
            out.print("Invalid username or password. Try again!<br/>");
            out.print("<a href = 'Login.html'>Back to login</a>");
        }

    %>
</body>
</html>
