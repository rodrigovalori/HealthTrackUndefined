<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="listaAtividadeFisica" class="java.util.ArrayList"
	scope="request"></jsp:useBean>
	
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/64d58efce2.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/tables.css">
<title>Exercícios - Histórico | HealthTrack</title>
</head>

<body>
<div class="container">

		<h1 class="mt-5 mb-4">Histórico de Exercícios</h1>

		<table class="table table-hover align-middle">
			<thead>
				<tr>
					<th>Exercício</th>
					<th>Calorias queimadas</th>
					<th>Data e Hora (Início)</th>
					<th>Data e Hora (Término)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaAtividadeFisica}" var="atividadeFisica">
					<div class="d-flex justify-content-between">
						<tr>
							<td>${atividadeFisica.descricaoAtividadeFisica}</td>
							<td>${atividadeFisica.energiaKcalAtividadeFisica}</td>
							<td>${atividadeFisica.dataHoraStringInicio}</td>
							<td>${atividadeFisica.dataHoraStringTermino}</td>
							<td class="d-flex justify-content-end"><a
								href="editarAtividadeFisica?id=${atividadeFisica.codAtividadeFisica}"
								class="btn btn-primary me-2">Editar</a> <a
								href="excluirAtividadeFisica?id=${atividadeFisica.codAtividadeFisica}"
								class="btn btn-danger me-2">Excluir</a></td>
						</tr>
					</div>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>

</html>