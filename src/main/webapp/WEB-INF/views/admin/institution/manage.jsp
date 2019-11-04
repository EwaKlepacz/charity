<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie instytucjami</title>
</head>
<body>
<form:form modelAttribute="institution" method="post">
    <form:label path="name">Nazwa: </form:label>
    <form:input path="name"/>

    <form:label path="description">Cel: </form:label>
    <form:input path="description"/>

    <form:hidden path="id"/>

    <input type="submit" value="Zapisz"/>

</form:form>
</body>
</html>
