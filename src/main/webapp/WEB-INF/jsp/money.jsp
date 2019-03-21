<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Raport: Money.pl</title>
    <jsp:include page="stylesheets.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container mainContainer">
    <h1>Raport - Money.pl</h1>
    <h3>Znaleziono wpisów: ${moneyPlOffers.size()}</h3>
    <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Data publikacji</th>
            <th>Stanowisko</th>
            <th>Pracodawca</th>
            <th>Miejsce pracy</th>
            <th>Portal</th>
            <th>Data przeszukania</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="moneyPlOffer" items="${moneyPlOffers}">
            <tr>
                <td>${moneyPlOffer.datePublished}</td>
                <td>${moneyPlOffer.position}</td>
                <td>${moneyPlOffer.employer}</td>
                <td>${moneyPlOffer.workplace}</td>
                <td>${moneyPlOffer.webPage}</td>
                <td>${moneyPlOffer.dataSearch}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> <!--  end of container-->
<jsp:include page="scriptLinks.jsp"></jsp:include>
</body>
</html>

