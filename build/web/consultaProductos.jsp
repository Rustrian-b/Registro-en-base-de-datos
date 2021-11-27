<%-- 
    Document   : registroEntrada
    Created on : 11/11/2021, 08:15:16 PM
    Author     : H4HG
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.manejoBDD"%>
<%@page import="modelo.manejoBDD"%>
<%@page import="modelo.clsProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta y modificacion de inventario</title>
        <link rel="stylesheet" href="./css/styleConsultaProductos.css">
    </head>    
    <body>
        <table>
            <thead>
                <th>
                    Codigo
                </th>
                <th>
                    Nombre
                </th>
                <th>
                    Cantidad
                </th>
                <th>
                    Precio
                </th>
            </thead>
            <%
                ArrayList<clsProducto> aProducto = manejoBDD.productosRegistrados();
                Iterator<clsProducto> iter = aProducto.iterator();
                clsProducto per = null;
                
                while(iter.hasNext())
                {
                    per = iter.next();                
            %>
                    <tbody>
                        <tr>
                            <td><%=per.getvCodigo()%></td>
                            <td><%=per.getvNombre()%></td>
                            <td><%=per.getvCantidad()%></td>
                            <td>Q<%=per.getvPrecio()%></td>
                        </tr>
                    </tbody>
                <%}%>
        </table>   
        <div>
            <form action="entradaProducto" method="post">
                <h1>Entrada de productos </h1>
                <p>Ingrese codigo del producto al cual desea agregar productos: </p><input name="codigo" type="number" required="" placeholder="Codigo del producto" class="caja">
                <p>Ingrese la cantidad que desea agregar: </p><input name="cantidad" type="number" required="" placeholder="Cantidad a sumar" class="caja">
                <input type="submit" value="Agregar saldo" class="boton">
                <input type="reset" value="Reestablecer" class="boton">
            </form>
            <form action="salidaProducto" method="post">
                <h1>Salida de productos </h1>
                <p>Ingrese codigo del producto al cual desea restar productos: </p><input name="codigo1" type="number" required="" placeholder="Codigo del producto" class="caja">
                <p>Ingrese la cantidad que desea restar: </p><input name="cantidad1" type="number" required="" placeholder="Cantidad a restar" class="caja">
                <input type="submit" value="Restar saldo" class="boton">
                <input type="reset" value="Reestablecer" class="boton">
            </form>
        </div>
    </body>
</html>
