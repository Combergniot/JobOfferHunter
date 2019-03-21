<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="stylesheets.jsp"></jsp:include>
            <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">
            <title>Zaloguj się</title>
            
        </head>
        <body>
        <%--<jsp:include page="navbar.jsp"></jsp:include>--%>
        <div class="container-fluid" id="loginBgWrapper">

        
            <div class="container mainContainer">
                <div class="loginContainer text-center">
                    <div class="row">
                        <h2>Zaloguj się</h2>
                    </div>
                  
                <c:if test="${param.error ne null}">
                    <div>Nieprawidłowe hasło</div>
                </c:if>
                    <div class="row text-center">
                        <div class="form-wrapper col-lg-12 col-md-12 col-sm-12">
                            
                        
                       <form c:action="{@/login}" method="post" class="form-horizontal text-center">
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope-o"></i></span>
                        <input class="form-control input-lg" type="text" id="username" name="username" placeholder="Login"/>
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <input class="form-control input-lg" type="password" name="password" placeholder="Hasło"  />
                    </div>
                    <span class="help-block">Wpisz swój login i hasło</span>
                    <br/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div><button class="btn btn-secondary" type="submit">Zaloguj się</button></div>
                </form>  
                       </div> 
                    </div>
               
            </div>

        </div>
                <h4>wersja: ${applicationVersion}</h4>
                </div>  <!--end of background wrapper-->
               
        <jsp:include page="scriptLinks.jsp"></jsp:include>
    </body>

</html>