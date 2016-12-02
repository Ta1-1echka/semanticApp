<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
    <link href="<c:url value="/resources/css/main.css"/>" type="text/css" rel="stylesheet">

</head>
<body>
<header>
    <div class="buts">
        <a href="/login">
            <button type="button" class="reg_ent_but">Log in</button>
        </a>
        <a href="/register">
            <button type="button" class="reg_ent_but">Sign up</button>
        </a>
    </div>

    <div class="wrap">
        <form class="search" action="">
            <input type="search" placeholder="Search here..." required>
            <button type="submit">Search</button>
        </form>
    </div>
</header>
<table>
    <thead>
    <tr>
        <td rowspan="2" class="tr_border"><img src="<c:url value="/resources/img/search.png"/>"/></td>
        <td>Name of file</td>
    </tr>
    <tr>
        <td class="tr_border">Add by user</td>
    </tr>
    </thead>
    <thead>
    <tr>
        <td rowspan="2" class="tr_border"><img src="<c:url value="/resources/img/search.png"/>"/></td>
        <td class="file_name">Name of file</td>
    </tr>
    <tr>
        <td class="tr_border">Add by user</td>
    </tr>
    </thead>

</table>
</body>
</html>
