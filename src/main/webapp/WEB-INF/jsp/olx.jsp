<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: OLX</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - OLX</h1>
                <h3>Znaleziono wpisów: ${beers.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data dodania</th>
                        <th>Stanowisko</th>
                        <th>Miejsce pracy</th>
                        <th>Branża</th>
                        <th>Forma zatrudnienia</th>
                        <th>Typ kontraktu</th>
                        <th>Wynagrodzenie</th>
                        <th>Wymagania</th>
                        <th>Data pobrania</th>
                        <th>Treść oferty</th>
                        <th>URL</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="olxOffer" items="${olxOffers}">
                        <tr>
                            <td>${olxOffer.datePublished}</td>
                            <td>${olxOffer.position}</td>
                            <td>${olxOffer.workplace}</td>
                            <td>${olxOffer.branch}</td>
                            <td>${olxOffer.formOfEmployment}</td>
                            <td>${olxOffer.contractType}</td>
                            <td>${olxOffer.salary}</td>
                            <td>${olxOffer.required}</td>
                            <td>${olxOffer.dataSearch}</td>
                            <td>${olxOffer.description}</td>
                            <td>${olxOffer.url}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

