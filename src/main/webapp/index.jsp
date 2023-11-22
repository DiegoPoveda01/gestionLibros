<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Menu</title>
</head>
<body>
<h1 class="encabezado"> Menú principal libros </h1>
<br>
<form action="registroLibro" method="get">
    <div class="centrado">
        <input type="submit" value="Registrar libro" class="boton">
    </div>
</form>
<br>
<form action="mostrarLibros" method="get">
    <div class="centrado">
        <input type="submit" value="Mostrar libros" class="boton">
    </div>
</form>
<br>
<form action="eliminarLibro" method="get">
    <div class="centrado">
        <input type="submit" value="Eliminar libro" class="boton">
    </div>
</form>
</body>
</html>