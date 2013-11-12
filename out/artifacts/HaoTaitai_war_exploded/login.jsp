<%--
  Created by IntelliJ IDEA.
  User: Nathanchen
  Date: 12/09/13
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title></title>
</head>
<body>
    <s:form name="loginform">
        <s:textfield name="user.name" key="user" />
        <s:textfield name="user.password" key="pass" />
        <input type="submit" value="Register" onclick="register();">
        <input type="submit" value="Login" onclick="login();">
    </s:form>

    <script type="text/javascript">
        var targetForm = document.loginform;
        function register()
        {
            targetForm.action = "/register/register";
        }

        function login()
        {
            targetForm.action = "/login/login";
        }
    </script>
</body>
</html>