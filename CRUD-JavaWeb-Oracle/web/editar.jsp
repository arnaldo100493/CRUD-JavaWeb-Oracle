<%-- 
    Document   : editar
    Created on : 19/03/2020, 09:48:44 PM
    Author     : abarrime
--%>

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
        <title>Editar Personas</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Editar Personas</h1>
        </div>
        <div class="container col-md-6">
            <div class="card">
                <div class="card-header">
                    <h5>Editar Persona</h5>
                </div>
                <hr/>
                <div class="card-body">
                    <form action="./persona" method="post">
                        <div class="form-group">
                            <label for="">Id Persona:</label>
                            <input id="txtIdPersona" type="text" name="idPersona" value="${persona.getIdPersona()}" class="form-control" readonly="true">
                        </div>
                        <div class="form-group">
                            <label for="">Nombres:</label>
                            <input id="txtNombre" type="text" name="nombre" value="${persona.getNombre()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Apellidos:</label>
                            <input id="txtApellido" type="text" name="apellido" value="${persona.getApellido()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Correo:</label>
                            <input id="txtCorreo" type="text" name="correo" value="${persona.getCorreo()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Teléfono:</label>
                            <input id="txtTelefono" type="text" name="telefono" value="${persona.getTelefono()}" class="form-control">
                        </div>
                        <input id="btnActualizar" type="submit" name="accion" class="btn btn-danger" value="Actualizar">
                        <a href="index.jsp" class="btn btn-info" style="margin-left: 10px;">Volver</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
