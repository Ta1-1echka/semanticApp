<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign up</title>
    <link href="<c:url value="/resources/css/login.css"/>" type="text/css" rel="stylesheet">
</head>
<body>

<form>
    <table class="signup">

        <tr>
            <td colspan="2"><h1>Sign up</h1><br></td>
        </tr>
        <tr>
            <td>Username *</td>
            <td><input type="text" name="user" placeholder="Username"></td>
        </tr>
        <tr>
            <td>Password *</td>
            <td><input type="password" name="pass" placeholder="Password"></td>
        </tr>
        <tr>
            <td>Firstname</td>
            <td><input type="text" name="firstname" placeholder="Firstname"></td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td><input type="text" name="lastname" placeholder="Lastname"></td>
        </tr>
        <tr>
            <td>Birth day</td>
            <td><input type="date" name="birth" placeholder="Birth day"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" placeholder="Email"></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td>
                <select>
                    <option></option>
                    <option>Male</option>
                    <option>Female</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="login" class="signup-submit" value="Register"></td>
        </tr>
        <tr>
            <td colspan="2"><a href="/login">Login</a></td>
        </tr>
    </table>
</form>

</body>
</html>