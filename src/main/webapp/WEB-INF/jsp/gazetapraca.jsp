<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: Gazeta Praca</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - Gazeta Praca</h1>
                <h3>Znaleziono wpisów: ${gazetaPracaOffers.size()}</h3>
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
                    <c:forEach var="gazetaPracaOffer" items="${gazetaPracaOffers}">
                        <tr>
                            <td>${gazetaPracaOffer.jobOffer.dateAdded}</td>
                            <td>${gazetaPracaOffer.jobOffer.tittle}</td>
                            <td>${gazetaPracaOffer.jobOffer.position}</td>
                            <td>${gazetaPracaOffer.jobOffer.workplace}</td>
                            <td>${gazetaPracaOffer.jobOffer.province}</td>
                            <td>${gazetaPracaOffer.jobOffer.branch}</td>
                            <td>${gazetaPracaOffer.jobOffer.dataSearch}</td>
                            <td>${gazetaPracaOffer.jobOffer.description}</td>
                            <td>${gazetaPracaOffer.jobOffer.url}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>

