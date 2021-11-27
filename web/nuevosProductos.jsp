<%-- 
    Document   : nuevosProductos
    Created on : 10/11/2021, 09:09:15 PM
    Author     : H4HG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Registro</title>
        <link rel="stylesheet" href="./css/styleNuevosProductos.css">
    </head>
    <body>
        <img src="./img/logo.png" class="imagen">
        <h1>Registro de nuevo producto</h1>
        <form action="registroProducto" method="post">
            <p>Ingrese codigo del producto: </p><input name="codigo" type="number" required="" placeholder="Codigo del producto" class="caja">
            <p>Ingrese nombre del producto: </p><input name="nombre" type="text" required="" placeholder="Nombre del producto" class="caja">
            <p>Cantidades a ingresar: </p><input name="cantidad" type="number" required="" placeholder="Cantidad inicial" class="caja">
            <p>Precio del producto(en Quetzales): </p> <input name="precio" type="text" required="" placeholder="Precio" class="caja">
            <input type="submit" value="Ingresar producto" class="boton">
            <input type="reset" value="Reestablecer" class="boton">
        </form>
    </body>
</html>
