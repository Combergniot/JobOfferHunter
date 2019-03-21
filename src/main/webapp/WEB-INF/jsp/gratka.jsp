<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: gratka.praca.pl</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - gratka.praca.pl</h1>
                <h3>Znaleziono wpisów: ${gratkaOffers.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data ogłoszenia</th>
                        <th>Stanowisko</th>
                        <th>Kraj</th>
                        <th>Region</th>
                        <th>Lokalizacja</th>
                        <th>Pracodawca</th>
                        <th>Branża</th>
                        <th>Typ stanowiska</th>
                        <th>Rodzaj pracy</th>
                        <th>Forma zatrudnienia</th>
                        <th>Minimalne wykształcenie</th>
                        <th>Dodatkowe opcje</th>
                        <th>Wynagrodzenie</th>
                        <th>Gazeta</th>
                        <th>Data przeszukania</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="gratkaOffer" items="${gratkaOffers}">
                        <tr>

                            <td>${gratkaOffer.dateAdded}</td>
                            <td>${gratkaOffer.position}</td>
                            <td>${gratkaOffer.country}</td>
                            <td>${gratkaOffer.workplace}</td>
                            <td>${gratkaOffer.province}</td>
                            <td>${gratkaOffer.employer}</td>
                            <td>${gratkaOffer.branch}</td>
                            <td>${gratkaOffer.jobType}</td>
                            <td>${gratkaOffer.typeOfWork}</td>
                            <td>${gratkaOffer.formOfEmployment}</td>
                            <td>${gratkaOffer.requiredEducation}</td>
                            <td>${gratkaOffer.additionalOptions}</td>
                            <td>${gratkaOffer.salary}</td>
                            <td>${gratkaOffer.offerFromNewspapper}</td>
                            <td>${gratkaOffer.dataSearch}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>
</html>

