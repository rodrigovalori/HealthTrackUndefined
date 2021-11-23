<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="https://kit.fontawesome.com/64d58efce2.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/topics.css">
<title>Exercícios | HealthTrack</title>
</head>

<body>
	<div class="container">
		<div class="forms-container">
			<div class="forms-1">
				<div class="forms-2">
					<form action="cadastrarAtividadeFisica" method="post">
						<h2 class="title">Exercícios</h2>
						<div class="input-field">
							<i class="far fa-file"></i> <input type="text"
								placeholder="Descrição da atividade" name="descricao-atividade" />
						</div>
						<div class="input-field">
							<i class="fas fa-weight"></i> <input type="number"
								placeholder="Calorias gastas (kcal)" name="calorias-gastas" />
						</div>
						<div class="input-field">
							<i class="fas fa-stopwatch"></i> <input type="text"
								name="hora-inicial" placeholder="dd/mm/aaaa hh:mm (Início)" />
						</div>
						<div class="input-field">
							<i class="fas fa-stopwatch"></i> <input type="text"
								name="hora-final" placeholder="dd/mm/aaaa hh:mm (Término)" />
						</div>
						<input id="iniciar" type="submit" value="Registrar"
							class="btn solid" />
					</form>
					<form action="historicoAtividadeFisica" method="get">
						<input type="submit" value="Histórico" class="btn solid" />
					</form>
					<form action="dashboard" method="get">
						<input id="voltar" type="submit" value="Voltar ao menu"
							class="btn solid" />
					</form>
				</div>
			</div>
		</div>

		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content"></div>
				<img src="images/exercícios.svg" class="image" />
			</div>
		</div>
	</div>


</body>

</html>