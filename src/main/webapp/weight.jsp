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
<title>Peso | HealthTrack</title>
</head>

<body>
	<div class="container">
		<div class="forms-container">
			<div class="forms-1" id="weight">
				<div class="forms-2">
					<form action="cadastrarPeso" method="post">
						<h2 class="title">Peso</h2>
						<div class="input-field">
							<i class="fas fa-weight"></i> <input type="text" name="peso"
								placeholder="Peso atual" />
						</div>
						<div class="input-field">
							<i class="far fa-calendar"></i> <input type="text"
								name="data-pesagem" placeholder="Data" />
						</div>
						<input id="iniciar" type="submit" value="Registrar"
							class="btn solid" />
					</form>
					<form action="historicoPeso" method="get">
						<input type="submit" value="Histórico" class="btn solid" />
					</form>
					<form action="dashboard">
						<input id="voltar" type="submit" value="Voltar ao menu"
							class="btn solid" />
					</form>
				</div>
			</div>
		</div>

		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content"></div>
				<img src="images/peso.svg" class="image" />
			</div>
		</div>
	</div>
</body>

</html>