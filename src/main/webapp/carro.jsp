<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="models.*" %>
<%
    Carro carro = (Carro) session.getAttribute("carro");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Carro de Compras</title>
    <!-- Meta etiqueta para diseño responsive -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Enlace al CSS de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Carro de Compras</h1>
    <%
        if (carro == null || carro.getItems().isEmpty()) {
    %>
    <div class="alert alert-warning" role="alert">
        Lo sentimos, no hay productos en el carro de compras.
    </div>
    <% } else { %>
    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID PRODUCTO</th>
            <th>NOMBRE</th>
            <th>PRECIO</th>
            <th>CANTIDAD</th>
            <th>TOTAL</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (ItemCarro item : carro.getItems()) {
        %>
        <tr>
            <td><%= item.getProductos().getIdProducto() %></td>
            <td><%= item.getProductos().getNombre() %></td>
            <td><%= item.getProductos().getPrecio() %></td>
            <td><%= item.getCantidad() %></td>
            <td><%= item.getSbtotal() %></td>
        </tr>
        <% } %>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4" class="text-right"><strong>Total</strong></td>
            <td><strong><%= carro.getTotal() %></strong></td>
        </tr>
        </tfoot>
    </table>
    <% } %>
    <div class="mt-4">
        <a href="<%= request.getContextPath() %>/productos" class="btn btn-primary">Seguir comprando</a>
        <a href="<%= request.getContextPath() %>/index.html" class="btn btn-secondary">Ir al inicio</a>
    </div>
</div>

<!-- Scripts de Bootstrap y dependencias -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

