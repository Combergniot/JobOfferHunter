<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Wygeneruj raport</title>

    <jsp:include page="stylesheets.jsp"></jsp:include>
    <link rel="stylesheet" href="resources/css/chosen.css">
     <script src="resources/js/chosen.js"></script>
    <script src="resources/js/chosen.jquery.js"></script>
    <script src="resources/js/datapicker.js"></script>
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container mainContainer">
    <h1>Wygeneruj raport</h1>


    <legend id="anch1" class="">Kryteria</legend>
    <div class="form-horizontal">

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Portale pracy</label>
            <div class="col-md-4">
                <select name="jobPortals" class="chosen-select form-control" id="jobPortals" data-placeholder="Wybierz...">
                    <option value="0"></option>
                    <option value="1">GoldenLine</option>
                    <option value="2">Pracuj.pl</option>
                    <option value="3">OLX</option>
                    <option value="4">gratka.praca.pl</option>
                    <option value="5">Gazeta praca</option>
                    <option value="6">Money.pl</option>
                </select>
            </div>
        </div>

        <div class="col-md-12 well">
            <legend id="anch2">Data</legend>

            <!-- dataPikcer-->

            <div class="form-group dates">
                <label class="col-md-1 control-label"> Od:</label>
                <div class="col-md-5">
                    <input id="startDate" name="startDate" class="form-control input-md" type="date" required>
                </div>
                <label class="col-md-1 control-label"> Do:</label>
                <div class="col-md-5">
                    <input id="endDate" name="endDate" class="form-control input-md" type="date" required>
                </div>
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Wygeneruj raport</button>

    </div>
</div>

<jsp:include page="scriptLinks.jsp"></jsp:include>

</body>

</html>

