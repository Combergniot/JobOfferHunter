<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: Pracuj.pl</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - Pracuj.pl</h1>
                <h3>Znaleziono wpisów: ${pracujPlOffers.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data dodania</th>
                        <th>Stanowisko</th>
                        <th>Rodzaj pracy</th>
                        <th>Miejsce pracy</th>
                        <th>Pracodawca</th>
                        <th>Branża</th>
                        <th>Oferta ważna do:</th>
                        <th>Data pobrania</th>
                        <th>URL</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pracujPlOffer" items="${pracujPlOffers}">
                        <tr>
                            <td>${pracujPlOffer.datePublished}</td>
                            <td>${pracujPlOffer.position}</td>
                            <td>${pracujPlOffer.employmentType}</td>
                            <td>${pracujPlOffer.workplace}</td>
                            <td>${pracujPlOffer.employer}</td>
                            <td>${pracujPlOffer.branch}</td>
                            <td>${pracujPlOffer.validThrough}</td>
                            <td>${pracujPlOffer.dataSearch}</td>
                            <td>${pracujPlOffer.url}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

