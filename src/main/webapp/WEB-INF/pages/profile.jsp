<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <td onclick="location.href='/profile'">My Account</td>
        </tr>
        <tr>
            <td onclick="location.href='/document/added'"> My added documents</td>
        </tr>
        <tr>
            <td>My favorite documents</td>
        </tr>
        <tr>
            <td onclick="location.href='/document'">Add a document</td>
        </tr>
        <tr>
            <td onclick="location.href='/'">All documents</td>
        </tr>
    </table>

    <form:form modelAttribute="profile" action="/profile/edit" method="post">
        <c:if test="${not empty profile}">
            <table class="profileTable">
                <tr>
                    <td>Firstname</td>
                    <td>
                            ${profile.firstname}
                    </td>
                </tr>
                <tr>
                    <td>Lastname</td>
                    <td>
                            ${profile.lastname}
                    </td>
                </tr>
                <tr>
                    <td>Birth</td>
                    <td>${profile.birth}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${profile.email}</td>
                </tr>
                <tr>
                    <td>Sex</td>
                    <td>
                            ${profile.sex}
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="file_name"><input type="submit" value="Edit"></td>
                </tr>
            </table>
        </c:if>
    </form:form>

    <form:form modelAttribute="profileEdit" action="/profile/edit/update" method="post">
        <c:if test="${not empty profileEdit}">
            <form:hidden path="idUser"/>
            <table class="profileTable">
                <tr>
                    <td>Firstname</td>
                    <td>
                        <form:input path="firstname"/>
                    </td>
                </tr>
                <tr>
                    <td>Lastname</td>
                    <td>
                        <form:input path="lastname"/>
                    </td>
                </tr>
                <tr>
                    <td>Birth</td>
                    <td><form:input path="birth" type="date"/>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><form:input path="email" type="email"/></td>
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
                    <td colspan="2" class="file_name"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </c:if>
    </form:form>
</security:authorize>

</body>
</html>
