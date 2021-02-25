<%-- 
    Document   : seccio
    Created on : 24-ago-2020, 12:38:48
    Author     : JoseAndrade
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>        
        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <!-- javaScript -->
        <script type="text/javascript" src="../resources/js/user.js"></script>

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
                            <li role="presentation" class="active">
                                <a href="<spring:url value= '/edicio'/>">
                                    Edició i creació
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <section class="container">
            <form:form modelAttribute="formseccio" class="form-horizontal" action="${act}">
                <fieldset>
                    <legend>Afegir o canviar secció</legend>
                    
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="seccioId">
                            Id secció:
                        </label>
                        <div class="col-lg-10">
                            <form:input id="seccioId" path="idSeccio" type="text" class="form:input-large" readonly="true" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="name">
                            Nom:
                        </label>
                        <div class="col-lg-10">
                            <form:input id="name" path="nom" type="text" class="form:input-large" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="tipus">
                            Tipus:
                        </label>
                        <div class="col-lg-10">
                            <form:input id="tipus" path="tipusProduccio" type="text" class="form:input-large" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary"
                                   value ="Desar"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>

