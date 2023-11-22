<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro libro</title>
</head>
<body>
<h1 class="encabezado"> Registro libro</h1>
<form action="registroLibro" method="post">
    <div class="centrado">
        <label> Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">
        <label> Editorial:</label>
        <input name="editorial" type="text" class="campoTexto">
        <label> Categoria:</label>
        <input name="categoria" type="text" class="campoTexto">
        <label> Año:</label>
        <input name="año" type="number" class="campoTexto">
        <label> Tipo:</label>
        <input name="tipo" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="enviar" class="boton">
    </div>
</form>
</body>
</html>
