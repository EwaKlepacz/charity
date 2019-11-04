<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Admin</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <form action="<c:url value="/logout"/>" method="post">
                <input type="submit" class="btn btn--small btn--without-border" value="Wyloguj">
            </form>
        </ul>
        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#institutions" class="btn btn--without-border">Zaufane instytucje</a></li>
            <li><a href="#admins" class="btn btn--without-border">Administratorzy</a></li>
            <li><a href="#users" class="btn btn--without-border">Użytkownicy</a></li>
            <li><a href="" class="btn btn--without-border">Edytuj Konto </a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <sec:authorize access="hasRole('ADMIN')">
        Jestem adminem
    </sec:authorize>
    <h2>Dla Admina</h2>

</section>
<section class="steps" id="institutions">
    <div class="steps--container">
        <table>
            <c:forEach items="${institutions}" var="institution">
                <tr>
                    <td><h3>${institution.name}</h3></td>
                    <td>
                        <c:url value="/admin/institution/edit" var="editURL">
                            <c:param name="id" value="${institution.id}"/>
                        </c:url>
                        <a href="${editURL}" class="btn btn--small btn--highlighted">Edytuj</a>
                        <c:url value="/admin/institution/remove" var="removeURL">
                            <c:param name="id" value="${institution.id}"/>
                        </c:url>
                        <a href="${removeURL}" class="btn btn--small btn--highlighted">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <a href="<c:url value="/admin/institution/add"/>" class="btn btn--small btn--highlighted">Dodaj</a>
        </div>
    </div>

</section>
<section class="steps" id="admins">
    <div class="steps--container">
        <table>
            <c:forEach items="${admins}" var="admin">
                <tr>
                    <td><h3>${admin.username}</h3></td>
                    <td>
                        <c:url value="/admin/edit" var="editAdminURL">
                            <c:param name="id" value="${admin.id}"/>
                        </c:url>
                        <a href="${editAdminURL}" class="btn btn--small btn--highlighted">Edytuj</a>
                        <c:url value="/admin/remove" var="removeAdminURL">
                            <c:param name="id" value="${admin.id}"/>
                        </c:url>
                        <a href="${removeAdminURL}" class="btn btn--small btn--highlighted">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
<section class="steps" id="users">
    <div class="steps--container">
        <table>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><h3>${user.username}</h3></td>
                    <td>
                        <c:url value="/admin/edit" var="editUserURL">
                            <c:param name="id" value="${user.id}"/>
                        </c:url>
                        <a href="${editUserURL}" class="btn btn--small btn--highlighted">Edytuj</a>
                        <c:url value="/admin/remove" var="removeUserURL">
                            <c:param name="id" value="${user.id}"/>
                        </c:url>
                        <a href="${removeUserURL}" class="btn btn--small btn--highlighted">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
