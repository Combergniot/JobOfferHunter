<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="stylesheets.jsp"></jsp:include>
        <title>JobOfferHunter</title>
</head>

<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">


<a href="/login">Wróć do logowania</a>

<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</div>
    <jsp:include page="scriptLinks.jsp"></jsp:include>
</body>


</html>