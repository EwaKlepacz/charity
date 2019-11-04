<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie instytucji</title>
</head>
<body>
<h3>Instytucja: ${institutionToRemove.name}</h3>
<form:form method="post" modelAttribute="institutionToRemove">
    <form:hidden path="id"/>
    Czy chcesz usunąć tą Instytucję?
    <input class="btn btn--small btn--highlighted" type="submit" value="Tak"/>
</form:form>
<a class="btn btn--small btn--highlighted" href='<c:url value="/admin"/>'>Nie</a>
</body>
</html>
