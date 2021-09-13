<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<style type="text/css">

.navbar{
padding-left: 2%
}
.tablas {
	margin-top: 0rem;
	padding-left: 2%;
	padding-right: 2%;
}
.titulo {
	margin-top: 0rem;
	padding-left: 2%;
	padding-right: 2%;
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

<div class="titulo">
	<h3>Buscar Libro</h3>
	<c:if test="${mensaje != null ? true : false}">
		<div class="alert alert-secondary  alert-dismissible fade show"
			role="alert">${mensaje}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	</div>

	<div class="tablas">

		<table border="1" class="table table-striped">
			<thead class="thead-dark">
				<th scope="col">ID</th>
				<th scope="col">Titulo</th>
				<th scope="col">Autor</th>
				<th scope="col">Año</th>
				<th scope="col">Imprenta</th>
				<th scope="col">Disponible</th>
				</tr>
				<td>${LibroVO.getIdLibro()}</td>
				<td>${LibroVO.getTitulo()}</td>
				<td>${LibroVO.getAutor()}</td>
				<td>${LibroVO.getAno()}</td>
				<td>${LibroVO.getImprenta()}</td>
				<td><script>
				var dispo=${LibroVO.getDisponible()}
				var dispoInt=parseInt(dispo)
				if(dispoInt==1){
				document.write("Disponible")
				}else{
					document.write("No disponible")
				}
				</script></td>

			</thead>
		</table>
	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>