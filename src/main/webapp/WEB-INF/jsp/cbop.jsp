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
    <h3>Znaleziono wpisów: ${cbopOffers.size()}</h3>
    <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Data dodania</th>
            <th>Tytuł ogłoszenia</th>
            <th>Stanowisko</th>
            <th>Miejsce pracy</th>
            <th>Województwo</th>
            <th>Branża</th>
            <th>Data pobrania</th>
            <th>Treść oferty</th>
            <th>URL</th>
        </tr>
        </thead>


        <tbody>
        <c:forEach var="cbopOffer" items="${cbopOffers}">
            <tr>
                <td>${moneyPlOffer.jobOffer.dateAdded}</td>
                <td>${moneyPlOffer.jobOffer.tittle}</td>
                <td>${moneyPlOffer.jobOffer.position}</td>
                <td>${moneyPlOffer.jobOffer.workplace}</td>
                <td>${moneyPlOffer.jobOffer.province}</td>
                <td>${moneyPlOffer.jobOffer.branch}</td>
                <td>${moneyPlOffer.jobOffer.dataSearch}</td>
                <td>${moneyPlOffer.jobOffer.description}</td>
                <td>${moneyPlOffer.jobOffer.url}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> <!--  end of container-->
<jsp:include page="scriptLinks.jsp"></jsp:include>
</body>
</html>

