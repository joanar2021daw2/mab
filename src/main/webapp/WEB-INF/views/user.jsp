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
                                <a href="<spring:url value= '#'/>">
                                    Edició i creació
                                </a>
                            </li>
                        </ul>
                        </li>
                        </ul>    
                    </nav>
                </div>
            </div>
        </div>

        <section class="container">
            <form:form modelAttribute="formuser" class="form-horizontal" action="${act}">
                <fieldset>
                    <legend>Afegir o canviar usuari</legend>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="userId">
                            Id usuari:
                        </label>
                        <div class="col-lg-10">
                            <form:input id="userId" path="userId" type="text" class="form:input-large" readonly="true" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="numop">
                            Núm operari(valor numèric):
                        </label>
                        <div class="col-lg-10">
                            <form:input id="numop" path="numOperari" type="number" class="form:input-large" required="true" pattern="[0-9]+"/>
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
                        <label class="control-label col-lg-2 col-lg-2" for="cognom1">
                            Primer cognom:
                        </label>
                        <div class="col-lg-10">
                            <form:input id="cognom1" path="cognom1" type="text" class="form:input-large" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="cognom2">
                            Segon cognom:
                        </label>
                        <div class="col-lg-10">
                            <form:input id="cognom2" path="cognom2" type="text" class="form:input-large" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="password">
                            Password:
                        </label>
                        <div class="col-lg-10">
                            <form:input id="password" path="password" type="text" class="form:input-large" required="true"  minlength="2" maxlength="30"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="actiu">
                            Alta/Baixa:
                        </label>
                        <div class="col-lg-10">
                            <form:select id="actiu" path="active" class="form:input-large">
                                <form:option value="true" label="Alta" />
                                <form:option value="false" label="Baixa" />
                            </form:select>
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
