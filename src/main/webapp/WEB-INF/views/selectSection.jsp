<%-- 
    Document   : selectSection
    Created on : 31-ago-2020, 9:30:21
    Author     : JoseAndrade
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>        
        <title>Proccontrol</title>
    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-6">  
                    <nav>
                        <ul class="nav nav-pills">
                            <li role="presentation" class="active">
                                <a href="<spring:url value= '/'/>">
                                    Inici
                                </a>
                            </li>
                        </ul>    
                    </nav>
                </div>
            </div>
        </div>

        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>A quina secció anirà l'instal·lació?</h1>                  
                </div>
            </div>
        </section>

        <section class="text-center"><a href="<spring:url value= '/seccio/new'/>">
                <button type="button" class="btn btn-success">Crear nova secció</button> 
            </a>
        </section><hr>

        <section class="container">
            <div class="row">
                <c:forEach items="${seccions}" var="seccions">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                      

                            <div class="thumbnail">
                                <div class="caption"><a href=" <spring:url value= '/seccio/seccio?seccioId=${seccions.idSeccio}' /> ">
                                    <h3>#${seccions.nom}</h3>                              
                                    <p>${seccions.tipusProduccio}</p>  </a>                          
                                </div>
                            </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </body>
</html>
