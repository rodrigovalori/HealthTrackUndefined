<%@page import="br.com.fiap.healthtrack.model.AtividadeFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="Peso"
	class="br.com.fiap.healthtrack.model.Peso" scope="request" />

<!doctype html>
<html lang="pt-BR">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Editar - Peso</title>
</head>
<body>

	<div class="container">
		<h1 class="mt-5 mb-4">Editar - Peso</h1>
		<form action="editarPeso" method="post">
			<div class="d-flex flex-column bd-highlight mb-3 col-sm-7">
				<label for="id-peso" class="mt-3">Peso</label> <input class="form-control form-control-sm mt-2"
					type="text" value="${peso.peso}"
					name="peso" id="peso"
					width="400px">
			</div>
			<div class="col-sm-3">
				<label class="mb-2" for="id-data-pesagem">Quantidade (gramas)</label> <input class="form-control form-control-sm mb-3" type="text"
					value="${peso.dataHoraString}"
					name="data-pesagem" id="data-pesagem">
			</div>
			<div class="mt-3">
				<input type="submit" class="btn btn-success" value="Salvar">
				<a href="historicoPeso" class="btn btn-danger">Cancelar</a>
			</div>
		</form>
	</div>
</body>
</html>