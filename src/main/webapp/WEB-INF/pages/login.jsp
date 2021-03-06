<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
    <link href="<c:url value="/resources/css/login.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<form:form  action="j_spring_security_check" method="post">
    <table class="login">

        <tr>
            <td colspan="2"><h1>Log-in</h1><br></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input type="text" name="j_username" placeholder="Username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="j_password" placeholder="Password"></td>
        </tr>

        <tr>
            <td colspan="2"> <input type="checkbox" id="rememberme"  name="remember-me-parameter"/>Запомнить меня</td>
        </tr>
        <tr>
            <td colspan="2" class="error"> <c:if test="${param.error==1}">Неверно введены данные</c:if></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="login" class="login-submit" value="Login"></td>
        </tr>
        <tr>
            <td colspan="2"><a href="/register">Register</a></td>
        </tr>

    </table>
    <%--<input type="hidden" name="${csrf.parameterName}"--%>
           <%--value="${csrf.token}"/>--%>
</form:form>

</body>
</html>
