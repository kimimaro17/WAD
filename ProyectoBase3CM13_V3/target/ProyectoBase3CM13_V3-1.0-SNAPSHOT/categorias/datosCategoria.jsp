<%-- 
    Document   : datosCategoria
    Created on : 14 oct 2021, 19:05:47
    Author     : Kimi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Categoria</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="./images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Proyecto Base V3
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Lista de Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ProductoServlet?accion=listaDeProductos">Lista de Productos</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="card-header">
                <h3 class="text-center">
                    Datos de la Categoria
                </h3>
            </div>
            <div class="card-body">
                <img>
                <ul class="list-group">
                    <li class="list-group-item">
                        <c:out value="${categoria.entidad.idCategoria}"/>
                    </li>
                    <li class="list-group-item">
                        <c:out value="${categoria.entidad.nombreCategoria}"/>
                    </li>
                    <li class="list-group-item">
                        <c:out value="${categoria.entidad.descripcionCategoria}"/>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
