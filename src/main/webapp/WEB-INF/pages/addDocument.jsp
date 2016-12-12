<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Main</title>
    <link href="<c:url value="/resources/css/main.css"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/css/file.css"/>" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/file.js"/>"></script>

</head>
<body>
<header>
    <div class="buts">
        <security:authorize access="not hasRole('ROLE_USER')">
            <a href="/login">
                <button type="button" class="reg_ent_but">Log in</button>
            </a>
            <a href="/register">
                <button type="button" class="reg_ent_but">Sign up</button>
            </a>
        </security:authorize>

        <security:authorize access="hasRole('ROLE_USER')">
            <form action="<c:url value="/j_spring_security_logout"/>" method="post">
                <button type="submit" class="reg_ent_but">Logout</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </security:authorize>
    </div>

    <div class="wrap">
        <form class="search" action="">
            <input type="search" placeholder="Search here..." required>
            <button type="submit">Search</button>
        </form>
    </div>
</header>
<security:authorize access="hasRole('ROLE_USER')">
    <table class="menuTable">
        <tr>
            <td onclick="location.href='/profile'">My Account</td>
        </tr>
        <tr>
            <td onclick="location.href='/document/added'"> My added documents</td>
        </tr>
        <tr>
            <td onclick="location.href='/'">My favorite documents</td>
        </tr>
        <tr>
            <td onclick="location.href='/document/new/add'">Add a document</td>
        </tr>
        <tr>
            <td onclick="location.href='/document'">All documents</td>
        </tr>
    </table>
</security:authorize>
<form:form method="post" enctype="multipart/form-data" action="/document/new/add" modelAttribute="user">
    <form:hidden path="idUser"/>
    <form:hidden path="login"/>
    <form:hidden path="password"/>
    <label for="f01">Name</label>
    <input id="f01" class="inputDocName" type="text" name="name"/>
    <br/>
    <input id="f02" class="chooseFileBut" type="file" name="file"
           placeholder="Choose file"/>

    <%--accept="application/msword"--%>

    <label for="f02">Choose file</label>
    <br/>
    <input type="submit" id="f03" class="addFileBut"/>
    <label for="f03">Save file</label>

</form:form>

</body>
</html>
