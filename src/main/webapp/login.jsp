<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de sesión</title>
    <!-- Agregar enlace al CSS de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="mb-4">Formulario de Login</h1>
    <form action="/carro-compras/login" method="post">
        <div class="form-group">
            <label for="username">Nombre de usuario</label>
            <input type="text" name="username" id="username" class="form-control" placeholder="Ingresa tu nombre de usuario">
        </div>
        <div class="form-group">
            <label for="password">Contraseña</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="Ingresa tu contraseña">
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>

<!-- Agregar scripts de Bootstrap y dependencias -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

