<%-- 
    Document   : listar
    Created on : 19/03/2020, 01:46:10 PM
    Author     : abarrime
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="resources/css/estilos.css">
        <script type="text/javascript" src="resources/js/formulario.js"></script>
        <title>Personas</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Personas</h1>
        </div>
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h5>Personas</h5>
                    <form action="./persona" method="post">
                        <input id="btnListar" type="submit" class="btn-primary" name="accion" value="Listar">
                        <input id="btnNuevo" type="submit" class="btn btn-success" name="accion" value="Agregar">
                    </form>
                    <hr/>
                    <a href="index.jsp" class="btn btn-info" style="margin-left: 10px;">Volver</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr class="text-center">
                                <th>ID</th>
                                <th>NOMBRES</th>
                                <th>APELLIDOS</th>
                                <th>CORREO</th>
                                <th>TELÉFONO</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="persona" items="${personas}">
                                <tr class="text-center">
                                    <td>${persona.getIdPersona()}</td>
                                    <td>${persona.getNombre()}</td>
                                    <td>${persona.getApellido()}</td>
                                    <td>${persona.getCorreo()}</td>
                                    <td>${persona.getTelefono()}</td>
                                    <td>
                                        <form action="./persona" method="post">
                                            <input id="filaSeleccionada" type="hidden" name="id" value="${persona.getIdPersona()}">
                                            <input id="btnEditar" type="submit" name="accion" class="btn btn-warning" value="Editar">
                                            <input id="btnEliminar" type="submit" name="accion" class="btn btn-danger" value="Eliminar" style="margin-left: 10px;">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

