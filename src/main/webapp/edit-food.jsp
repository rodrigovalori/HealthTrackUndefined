<%@page import="br.com.fiap.healthtrack.model.AtividadeFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="alimento"
	class="br.com.fiap.healthtrack.model.Alimento" scope="request" />

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

<title>Editar - Alimento</title>
</head>
<body>

	<div class="container">
		<h1 class="mt-5 mb-4">Editar - Alimento</h1>
		<form action="editarAlimento" method="post">
			<div class="d-flex flex-column bd-highlight mb-3 col-sm-7">
				<label for="id-nome-alimento" class="mt-3">Alimento</label> <input class="form-control form-control-sm mt-2"
					type="text" value="${alimento.nomeAlimento}"
					name="nome-alimento" id="nome-alimento"
					width="400px">
			</div>
			<div class="col-sm-3">
				<label class="mb-2" for="id-quantidade-alimento">Quantidade (gramas)</label> <input class="form-control form-control-sm mb-3" type="text"
					value="${alimento.quantidadeAlimento}"
					name="quantidade-alimento" id="quantidade-alimento">
			</div>
			<div>
				<div class="col-sm-3">
					<label class="mb-2" for="calorias-alimento">Calorias ingeridas</label> <input class="form-control form-control-sm mb-3"
						type="text" value="${alimento.energiaKcalAlimento}"
						name="calorias-alimento" id="calorias-alimento">
				</div>
			</div>
			<div>
				<div class="col-sm-3">
					<label class="mb-2" for="hora-alimento">Data e Hora</label> <input class="form-control form-control-sm mb-3"
						type="text" value="${alimento.dataHoraString}"
						name="hora-alimento"
						id="hora-alimento">
				</div>
			</div>
			<div class="mt-3">
				<input type="submit" class="btn btn-success" value="Salvar">
				<a href="historicoAlimento" class="btn btn-danger">Cancelar</a>
			</div>
		</form>
	</div>
</body>
</html>