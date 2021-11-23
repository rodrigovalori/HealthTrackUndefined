<%@page import="br.com.fiap.healthtrack.model.PressaoArterial"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="PressaoArterial"
	class="br.com.fiap.healthtrack.model.PressaoArterial"
	scope="request" />

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

<title>Editar - Pressão Arterial</title>
</head>
<body>

	<div class="container">
		<h1 class="mt-5 mb-4">Editar - Pressão Arterial</h1>
		<form action="editarPressaoArterial" method="post">
			<div class="d-flex flex-column bd-highlight mb-3 col-sm-7">
				<label for="id-pressao-sistolica" class="mt-3">Pressão
					Sistólica:</label> <input class="form-control form-control-sm mt-2"
					type="text" value="${pressao.pressaoSistolica}"
					name="pressao-sistolica" id="pressao-sistolica" width="400px">
			</div>
			<div class="col-sm-3">
				<label class="mb-2" for="id-pressao-diastolica">Pressão
					Diastólica:</label> <input class="form-control form-control-sm mb-3"
					type="text" value="${pressao.pressaoDiastolica}"
					name="pressao-diastolica" id="pressao-diastolica">
			</div>
			<div class="col-sm-3">
				<label class="mb-2" for="id-data-hora-medicao">Data e hora:</label> <input
					class="form-control form-control-sm mb-3" type="text"
					value="${pressao.dataHoraMedicao}" name="data-hora-medicao"
					id="data-hora-medicao">
			</div>
			<div class="mt-3">
				<input type="submit" class="btn btn-success" value="Salvar">
				<a href="historicoPressaoArterial" class="btn btn-danger">Cancelar</a>
			</div>
		</form>
	</div>
</body>
</html>