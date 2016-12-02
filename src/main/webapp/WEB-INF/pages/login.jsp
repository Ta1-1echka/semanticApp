<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<head>
    <title>Login</title>
    <link href="<c:url value="/resources/css/login.css"/>" type="text/css" rel="stylesheet">
</head>
<body>

<%--<form name='form_login' action="j_spring_security_check" method="post">--%>
<form>
    <table class="login">

        <tr>
            <td colspan="2"><h1>Log-in</h1><br></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="j_username" placeholder="Username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="j_password" placeholder="Password"></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="checkbox" id="rememberme"  name="_spring_security_remember_me"/>Запомнить меня</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="login" class="login-submit" value="Login"></td>
        </tr>
        <tr>
            <td colspan="2"><a href="/register">Register</a></td>
        </tr>

    </table>
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

</body>
</html>
