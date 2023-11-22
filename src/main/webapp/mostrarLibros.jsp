<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mostrar libros</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1 class="encabezado">Libros ingresados</h1>
<div class="centrado">
    <table>
        <tr>
            <th>Nombre </th>
            <th>Categoria </th>
            <th>Año </th>
        </tr>
        <c:forEach items="${libros}" var="libro">
            <tr>
                <td><c:out value="${libro.getNombre()}"></c:out> </td>
                <td> <c:out value="${libro.getCategoria()}"></c:out> </td>
                <td> <c:out value="${libro.getAño()}"></c:out> </td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>