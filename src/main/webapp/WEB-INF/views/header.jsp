<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
<nav class="container container--70">
    <sec:authorize access="isAuthenticated()">
    <ul class="nav--actions">

        <li><a href="<c:url value="/admin"/>" class="btn btn--small btn--without-border">Moje Konto</a></li>
        <li><form action="<c:url value="/logout"/>" method="post">
            <input  type="submit" class="btn btn--small btn--without-border" value="Wyloguj">
        </form>
        </li>
    </ul>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <ul class="nav--actions">
            <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="<c:url value="/registration"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>
    </sec:authorize>
    <ul>
        <li><a href="/#start" class="btn btn--without-border active">Start</a></li>
        <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="/#fundation" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="/#footer" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Zacznij pomagać!<br/>
            Oddaj niechciane rzeczy w zaufane ręce
        </h1>
    </div>
</div>
</header>
</body>
</html>