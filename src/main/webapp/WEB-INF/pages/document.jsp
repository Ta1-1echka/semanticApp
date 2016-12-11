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
        <security:authorize access="hasRole('ROLE_USER')">
            <form action="/j_spring_security_logout" method="post">
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

<table class="menuTable">
    <tr>
        <td onclick="location.href='/profile'">My Account</td>
    </tr>
    <tr>
        <td onclick="location.href='/document/added'"> My added documents</td>
    </tr>
    <tr>
        <td onclick="location.href='/document/favorite'">My favorite documents</td>
    </tr>
    <tr>
        <td onclick="location.href='/document/new'">Add a document</td>
    </tr>
    <tr>
        <td onclick="location.href='/document'">All documents</td>
    </tr>
</table>
<security:authentication var="login" property="principal.username"/>
<c:if test="${not empty docs}">
    <form:form modellAtribute="user">
        <table class="docTable">
            <c:forEach var="doc" items="${docs}">
                <%--<thead>--%>
                <tr>
                    <c:set var="exist" value="false"/>
                    <td rowspan="2">
                        <c:forEach items="${user.docs}" var="fdoc">
                            <c:if test="${doc.idDocument==fdoc.idDocument}">
                                <c:set var="exist" value="true"/>
                            </c:if>
                        </c:forEach>
                        <c:if test="${exist==true}">
                            <img src="<c:url value="/resources/img/star.png"/>"
                                 onclick="location.href='/profile'"/>
                        </c:if>
                        <c:if test="${doc.user.login != login}">
                            <c:if test="${exist==false}">
                                <img src="<c:url value="/resources/img/emptystar.png"/>"
                                     onclick="location.href='/document/addToFavorite/${id}/${doc.idDocument}'"/>
                            </c:if>
                        </c:if>
                        <c:if test="${doc.user.login == login}">
                            <img src="<c:url value="/resources/img/mine.png"/>" class="mineImg"/>
                        </c:if>
                    </td>

                    <td class="file_name"><c:out value="${doc.name}"/></td>
                </tr>
                <tr>
                    <td><c:out value="Added by ${doc.user.login}"/></td>
                </tr>
                <%--</thead>--%>
            </c:forEach>
        </table>

        <table class="docTable">
            <tr>
                <c:forEach var="i" begin="${begin}" end="${end}">
                    <td class="pages">
                        <c:if test="${id == i}"><a href="/document/${i}" class="curHref"><c:out
                                value="${i}"/></a></c:if>
                        <c:if test="${id != i}"><a href="/document/${i}"><c:out value="${i}"/></a></c:if>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </form:form>
</c:if>
<c:if test="${not empty addedDocs}">
    <table class="docTable">
        <c:forEach var="doc" items="${addedDocs}">

            <tr>
                <td class="file_name"><c:out value="${doc.name}"/></td>
            </tr>
            <tr>
                <td><c:out value="Added by ${doc.user.login}"/></td>
            </tr>
        </c:forEach>
    </table>
    <table class="docTable">
        <tr>
            <c:forEach var="i" begin="${begin}" end="${end}">
                <td class="pages">
                    <c:if test="${id == i}"><a href="/document/added/${i}" class="curHref"><c:out
                            value="${i}"/></a></c:if>
                    <c:if test="${id != i}"><a href="/document/added/${i}"><c:out value="${i}"/></a></c:if>
                </td>
            </c:forEach>
        </tr>
    </table>
</c:if>

<c:if test="${not empty favDocs}">
    <table class="docTable">
        <c:forEach var="doc" items="${favDocs}">
            <tr>
                <td rowspan="2">
                    <img src="<c:url value="/resources/img/delete.png"/>" class="mineImg"
                         onclick="location.href='/document/deleteFromFavorite/${id}/${doc.idDocument}'"
                    />
                </td>

                <td class="file_name"><c:out value="${doc.name}"/></td>
            </tr>
            <tr>
                <td><c:out value="Added by ${doc.user.login}"/></td>
            </tr>
        </c:forEach>
    </table>
    <table class="docTable">
        <tr>
            <c:forEach var="i" begin="${begin}" end="${end}">
                <td class="pages">
                    <c:if test="${id == i}"><a href="/document/favorite/${i}" class="curHref"><c:out
                            value="${i}"/></a></c:if>
                    <c:if test="${id != i}"><a href="/document/favorite/${i}"><c:out value="${i}"/></a></c:if>
                </td>
            </c:forEach>
        </tr>
    </table>
</c:if>
<p>${message}</p>
</body>
</html>
