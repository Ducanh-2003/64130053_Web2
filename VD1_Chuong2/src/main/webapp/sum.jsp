<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Tinh Toan gia tri lay tu URL</title>
</head>
<body>
<h1>Hom nay la ngay: </h1>
<%= new Date().toString()%>
<br/>

<%
  String strA = request.getParameter("a");
  int valueA = Integer.parseInt(strA);

  String strB = request.getParameter("b");
  int valueB = Integer.parseInt(strB);

  out.print("Tong cua ");
  out.print(valueA);
  out.print(" va ");
  out.print(valueB);
  out.print(" la: ");
  out.print(valueA+valueB);

%>
</body>
</html>
