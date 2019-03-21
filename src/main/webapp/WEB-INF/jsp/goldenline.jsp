<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Raport: GoldenLine</title>
        <jsp:include page="stylesheets.jsp"></jsp:include>
        <%--<jsp:include page="favicon.jsp"></jsp:include>  --%>
        </head>
        <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="container mainContainer">
                <h1>Raport - GoldenLine</h1>
                <h3>Znaleziono wpisów: ${goldenLineOffers.size()}</h3>
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
                    <c:forEach var="goldenLineOffer" items="${goldenLineOffers}">
                        <tr>
                            <td>${goldenLineOffer.jobOffer.dateAdded}</td>
                            <td>${goldenLineOffer.jobOffer.tittle}</td>
                            <td>${goldenLineOffer.jobOffer.position}</td>
                            <td>${goldenLineOffer.jobOffer.workplace}</td>
                            <td>${goldenLineOffer.jobOffer.province}</td>
                            <td>${goldenLineOffer.jobOffer.branch}</td>
                            <td>${goldenLineOffer.jobOffer.dataSearch}</td>
                            <td>${goldenLineOffer.jobOffer.description}</td>
                            <td>${goldenLineOffer.jobOffer.url}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>

    </body>

</html>

