<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xuat du lieu</title>
</head>
<body>
    <%!
        int x = 99;
        int y;
        int z;
    %>
    <%
        y = 999;
        z = x + y;
        out.append("Ket qua: ");
        out.append(String.valueOf(z));
    %>
    <br>
    <h2>Hoac ket qua la:</h2>
    <%= z %>
</body>
</html>
