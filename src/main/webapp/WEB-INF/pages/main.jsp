<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Main</title>
    <link href="<c:url value="/resources/css/main.css"/>" type="text/css" rel="stylesheet">

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
            <form action="<c:url value='j_spring_security_logout' />" method="post">
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
            <td>My Account</td>
        </tr>
        <tr>
            <td onclick="location.href='/addedDocs'"> My added documents</td>
        </tr>
        <tr>
            <td>My favorite documents</td>
        </tr>
        <tr>
            <td onclick="location.href='/doc'">Add a document</td>
        </tr>
        <tr>
            <td onclick="location.href='/'">All documents</td>
        </tr>
    </table>
</security:authorize>

<c:if test="${not empty docs}">
    <table class="docTable">
        <c:forEach var="doc" items="${docs}">
            <thead>
            <tr>
                <td rowspan="2" class="tr_border"><img src="<c:url value="/resources/img/search.png"/>"/></td>
                <td class="file_name"><c:out value="${doc.name}"/></td>
            </tr>
            <tr>
                <td class="tr_border"><c:out value="Added by ${doc.user.login}"/></td>
            </tr>
            </thead>
        </c:forEach>
    </table>
</c:if>
<c:if test="${not empty profile}">
    <table class="docTable">

        <tr>
            <td class="file_name">Firstname</td>
            <td class="file_name"><c:out value="${profile.firstname}"/></td>
        </tr>
        <tr>
            <td class="file_name">Lastname</td>
            <td class="file_name"><c:out value="${profile.lastname}"/></td>
        </tr>
        <tr>
            <td class="file_name">Birth</td>
            <td class="file_name"><c:out value="${profile.birth}"/></td>
        </tr>
        <tr>
            <td class="file_name">Email</td>
            <td class="file_name"><c:out value="${profile.email}"/></td>
        </tr>
        <tr>
            <td class="file_name">Sex</td>
            <td class="file_name"><c:out value="${profile.sex}"/></td>
        </tr>
    </table>
</c:if>
<%--<security:authorize access="isRememberMe()">--%>
<%--<p>--%>
<%--<h3> login with "remember me" cookies</h3>--%>
<%--</security:authorize>--%>
<%--<security:authorize access="hasRole('ROLE_USER')">--%>
<%--<p>--%>
<%--<h3> login with hasRole('ROLE_USER')</h3>--%>
<%--</security:authorize>--%>


</body>
</html>
