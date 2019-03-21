
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Aplikacja</title>

</head>

<body>
<h1>Hello </h1>

<a href="/login">Przejdź do logowania</a>

<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>

</html>