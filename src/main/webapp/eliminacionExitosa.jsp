<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Eliminar libro</title>
</head>
<body>
<h1 class="encabezado"> Eliminar libro</h1>
<div class="centrado">
    <p class="subtitulo">Eliminacion exitosa</p> <br>
    <label class="campoTexto"> Nombre : <c:out value="${libro.getNombre()}"></c:out> </label>
    <br>
    <label class="campoTexto"> Editorial : <c:out value="${libro.getEditorial()}"></c:out></label>
    <br>
    <label class="campoTexto"> Categoria : <c:out value="${libro.getCategoria()}"></c:out></label>
    <br>
    <label class="campoTexto"> Año : <c:out value="${libro.getAño()}"></c:out></label>
    <br>
    <label class="campoTexto"> Tipo : <c:out value="${libro.getTipo()}"></c:out></label>
    <br>
    <a class="boton" href="index.jsp">Volver</a>
</div>

</body>
</html>