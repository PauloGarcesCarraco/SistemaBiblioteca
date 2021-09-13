<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<style type="text/css">
.navbar {
	padding-left: 2%
}

.boton {
	padding-left: 2%;
	margin-bottom: 0rem
}

.tabla {
	margin-top: 0rem;
	padding-right: 2%;
	padding-left: 2%;
}

.filtro {
	padding-left: 2%;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#">Biblioteca CRUD</a>
		<div class="navbar">
			<div class="navbar-nav"></div>
		</div>
	</nav>
	<!-- Botón agregar usuario -->
	<div class="boton">
		<a href="agregarForm" class="btn m-2 btn-success">Agregar libro</a>
	</div>

	<!-- ---------------------------------------------------- -->
	<div class="filtro">

		<h3>Buscador de libro</h3>
		<form action="buscar" method="get">
			<table>
				<tr>
					<td class="p-2"><label for="autor">Autor:</label></td>
					<td><input class="form-control" type="text"
						placeholder="Autor" name="autor" value="${LibroVO.setAutor()}" /></td>

					<td class="p-2"><label for="titulo">Titulo:</label></td>
					<td><input class="form-control" type="text" name="titulo"
						placeholder="Titulo" value="${LibroVO.setTitulo()}" /></td>

				</tr>

				<tr>
					<td colspan="2"><input type="submit"
						class="btn m-2 btn-success" value="Buscar" />
				</tr>
			</table>
		</form>


	</div>

	<!-- ---------------------------------------------------- -->
	<div class="tabla">
		<table border="1" class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Titulo</th>
					<th scope="col">Autor</th>
					<th scope="col">Año</th>
					<th scope="col">Imprenta</th>
					<th scope="col">Disponible</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${libroVO.getLibros()}" var="libros">

					<tr>
						<td>${libros.getIdLibro()}</td>
						<td>${libros.getTitulo()}</td>
						<td>${libros.getAutor()}</td>
						<td>${libros.getAno()}</td>
						<td>${libros.getImprenta()}</td>
						<td><script>
							var dispo = ${libros.getDisponible()}
							var dispoInt = parseInt(dispo)
							if (dispoInt == 1) {
								document.write("Disponible")
							} else {
								document.write("No disponible")
							}
						</script></td>
						<td><a href="editarForm?idLibro=${libros.getIdLibro()}"
							class="btn btn-primary btn-sm">Editar</a> <a
							href="eliminar?idLibro=${libros.getIdLibro()}"
							class="btn btn-danger btn-sm">Eliminar</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>


	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>

</body>
</html>