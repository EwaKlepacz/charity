
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="user" method="post">
    <form:label path="username">Nazwa: </form:label>
    <form:input path="username"/>

    <form:label path="password">Hasło: </form:label>
    <form:input path="password"/>

    <form:label path="enable">Aktywny:</form:label>
    <form:checkbox path="enable"/>

    <form:hidden path="id"/>

    <input type="submit" value="Zapisz"/>

</form:form>
</body>
</html>
