<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Sign up</title>
    <link href="<c:url value="/resources/css/login.css"/>" type="text/css" rel="stylesheet">
</head>
<body>
<%--<spring:message code="login.exist" var="messageloginexist"/>--%>
<form:form action="/register/user" method="post" modelAttribute="userDTO">
    <table class="signup">

        <tr>
            <td colspan="2"><h1>Sign up</h1><br></td>
        </tr>
        <tr>
            <td>Login *</td>
            <td><form:input path="login" placeholder="Username"/></td>
        </tr>
        <tr>
            <td>Password *</td>
            <td><form:password path="password" placeholder="Password"/></td>
        </tr>
        <tr>
            <td>Firstname</td>
            <td><form:input path="firstname" placeholder="Firstname"/></td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td><form:input path="lastname" placeholder="Lastname"/></td>
        </tr>
        <tr>
            <td>Birth day</td>
            <td><form:input path="birth" type="date" placeholder="Birth day"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email" type="email" name="email" placeholder="Email"/></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td>
                <form:select path="sex">
                    <form:option value=""></form:option>
                    <form:option value="male">Male</form:option>
                    <form:option value="female">Female</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" class="signup-submit" value="Register"></td>
        </tr>
        <tr>
            <td colspan="2" class="error"><form:errors path="*"/></td>
        </tr>
        <tr>
            <td colspan="2"><a href="/login">Login</a></td>
        </tr>
    </table>
</form:form>

</body>
</html>