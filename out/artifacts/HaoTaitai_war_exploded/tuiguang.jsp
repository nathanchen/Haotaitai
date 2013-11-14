<%--
  Created by IntelliJ IDEA.
  User: Nathanchen
  Date: 17/09/13
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    this is tuiguang page
<%
    Cookie cookie = new Cookie("promotion","tuiguang.jsp");
    response.addCookie(cookie);
    response.sendRedirect("huodong.jsp");
%>
</body>
</html>