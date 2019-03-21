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
                <h1>Raport - https://pl.linkedin.com</h1>
                <h3>Znaleziono wpisów: ${linkedinOffers.size()}</h3>
            <table class="table table-striped table-bordered" id="example" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>Data publikacji</th>
                        <th>Stanowisko</th>
                        <th>Pracodawca</th>
                        <th>Lokalizacja</th>
                        <th>Branża</th>
                        <th>Forma zatrudnienia</th>
                        <th>Doświadczenie</th>
                        <th>Obowiązki służbowe</th>
                        <th>Data przeszukania</th>
                    </tr>
                </thead>

                <%--todo--%>

                <tbody>
                    <c:forEach var="linkedinOffer" items="${linkedinOffers}">
                        <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!--  end of container-->
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>
</html>

