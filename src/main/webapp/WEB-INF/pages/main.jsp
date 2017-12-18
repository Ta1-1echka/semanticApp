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
            <c:redirect url="/document"/>
        </security:authorize>
    </div>

    <div class="wrap">
        <form class="search" action="">
            <input type="search" placeholder="Search here..." required>
            <button type="submit">Search</button>
        </form>
    </div>
</header>

<c:if test="${not empty docs}">
    <table class="docTable">
        <c:forEach var="doc" items="${docs}">
            <thead>
            <tr>
                <td class="file_name"><c:out value="${doc.name}"/></td>
            </tr>
            <tr>
                <td><c:out value="Added by ${doc.user.login}"/></td>
            </tr>
            </thead>
        </c:forEach>
    </table>
    <table class="docTable">
        <tr>

            <%--<c:forEach var="i" begin="${begin}" end="${end}">--%>
                <%--<td class="pages">--%>
                    <%--<c:if test="${id == i}"><a href="/page/${i}" class="curHref"><c:out value="${i}"/></a></c:if>--%>
                    <%--<c:if test="${id != i}"><a href="/page/${i}"><c:out value="${i}"/></a></c:if>--%>
                <%--</td>--%>
            <%--</c:forEach>--%>
        </tr>
    </table>
</c:if>
</body>
</html>
