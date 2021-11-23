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
<title>Pressão Arterial | HealthTrack</title>
</head>

<body>
	<div class="container">
		<div class="forms-container">
			<div class="forms-1" id="pressure">
				<div class="forms-2">
					<form action="cadastrarPressaoArterial" method="post">
						<h2 class="title">Pressão Arterial</h2>
						<div class="input-field">
							<i class="fas fa-heartbeat"></i> <input type="text"
								name="pressao-sistolica" placeholder="Pressão Sistólica" />
						</div>
						<div class="input-field">
							<i class="fas fa-heartbeat"></i> <input type="text"
								name="pressao-diastolica" placeholder="Pressão Diastólica" />
						</div>
						<div class="input-field">
							<i class="far fa-calendar"></i> <input type="text"
								name="data-hora-medicao" placeholder="Data e horário" />
						</div>
						<input id="iniciar" type="submit" value="Registrar"
							class="btn solid" />
					</form>
					<form action="historicoPressaoArterial" method="get">
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
				<img src="images/pressão.svg" class="image" />
			</div>
		</div>
	</div>
</body>

</html>