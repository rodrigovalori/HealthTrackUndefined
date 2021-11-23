<%@page import="br.com.fiap.healthtrack.model.AtividadeFisica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="atividadeFisica"
	class="br.com.fiap.healthtrack.model.AtividadeFisica" scope="request" />

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

<title>Editar - Atividade Física</title>
</head>
<body>

	<div class="container">
		<h1 class="mt-5 mb-4">Editar - Atividade Física</h1>
		<form action="editarAtividadeFisica" method="post">
			<div class="d-flex flex-column bd-highlight mb-3 col-sm-7">
				<label for="id-descricao-atividade" class="mt-3">Descrição
					da atividade</label> <input class="form-control form-control-sm mt-2"
					type="text" value="${atividadeFisica.descricaoAtividadeFisica}"
					name="descricao-atividade" id="id-descricao-atividade"
					width="400px">
			</div>
			<div class="col-sm-3">
				<label class="mb-2" for="id-calorias-gastas">Calorias gastas
					(kcal)</label> <input class="form-control form-control-sm mb-3" type="text"
					value="${atividadeFisica.energiaKcalAtividadeFisica}"
					name="calorias-gastas" id="id-calorias-gastas">
			</div>
			<div>
				<div class="col-sm-3">
					<label class="mb-2" for="id-dd/mm/aaaa hh:mm (Inecio)">dd/mm/aaaa
						hh:mm (Início)</label> <input class="form-control form-control-sm mb-3"
						type="text" value="${atividadeFisica.dataHoraStringInicio}"
						name="hora-inicio" id="hora-inicio">
				</div>
			</div>
			<div>
				<div class="col-sm-3">
					<label class="mb-2" for="id-dd/mm/aaaa hh:mm (Termino)">dd/mm/aaaa
						hh:mm (Término)</label> <input class="form-control form-control-sm mb-3"
						type="text" value="${atividadeFisica.dataHoraStringTermino}"
						name="hora-termino"
						id="hora-termino">
				</div>
			</div>
			<div class="mt-3">
				<input type="submit" class="btn btn-success" value="Salvar">
				<a href="historicoAtividadeFisica" class="btn btn-danger">Cancelar</a>
			</div>
		</form>
	</div>
</body>
</html>