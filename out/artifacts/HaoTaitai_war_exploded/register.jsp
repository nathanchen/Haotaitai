<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Nathanchen
  Date: 13/09/13
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <s:form action="register/register">
        <s:textfield name="username" label="user name"/>
        <s:textfield name="passowrd" label="user passowrd"/>
        <s:textfield name="age" label="age"/>
        <s:textfield name="birthday" label="birthday"/>
        <s:submit value="submit"/>
    </s:form>
</body>
</html>