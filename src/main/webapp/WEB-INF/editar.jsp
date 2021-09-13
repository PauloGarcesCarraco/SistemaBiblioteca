<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cl.edutecno.modelo.Libro"%>
<%@page import="cl.edutecno.VO.LibroVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#">Biblioteca CRUD</a>
		<div class="navbar">
			<div class="navbar-nav"></div>
		</div>
	</nav>

	<h1>Editar Libro</h1>
	<c:if test="${mensaje != null ? true : false}">
		<div class="alert alert-secondary  alert-dismissible fade show"
			role="alert">${mensaje}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<form action="editar" method="post">
		<input type="hidden" name="idLibro" value="${LibroVO.getIdLibro()}" />
		<table>

			<tr>
				<td class="p-2"><label for="titulo">Titulo:</label></td>
				<td><input class="form-control" type="text" name="titulo"
					placeholder="Titulo" value="${LibroVO.getTitulo()}" /></td>
			</tr>
			<tr>
				<td class="p-2"><label for="ano">Año:</label></td>
				<td><input class="form-control" type="number" min="0" placeholder="Año"
					name="ano" value="${LibroVO.getAno()}" /></td>
			</tr>
			<tr>
				<td class="p-2"><label for="autor">Autor:</label></td>
				<td><input class="form-control" type="text" placeholder="Autor"
					name="autor" value="${LibroVO.getAutor()}" /></td>

				<td class="p-2"><label for="imprenta">Imprenta:</label></td>
				<td><input class="form-control" type="text"
					placeholder="Imprenta" name="imprenta"
					value="${LibroVO.getImprenta()}" /></td>

				<td class="p-2">
					<form action="/action_page.php">
						<label for="cars">Disponibilidad:</label> </td>
						<td><select id="disponible"
							name="disponible" >
							<option value=1>Disponible</option>
							<option value=0>No disponible</option>
						</select>
					</form> </td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit"
					class="btn m-2 btn-success" value="Guardar" /></td>
			</tr>
		</table>
	</form>




	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>