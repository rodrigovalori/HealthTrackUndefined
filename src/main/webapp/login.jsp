<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="usuario" class="br.com.fiap.healthtrack.model.Usuario" scope="request" />

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script src="https://kit.fontawesome.com/64d58efce2.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/login-signUp.css">
<title>Login | HealthTrack</title>
</head>

<body>
	<div class="container">
		<div class="forms-container">
			<div class="forms-1">
				<div class="forms-2">
					<form action="logon" method="get">
						<h2 class="title">Fazer login</h2>
						<div class="input-field">
							<i class="fas fa-envelope"></i>
							<input type="email" name="email" placeholder="Email" />
						</div>
						<div class="input-field">
							<i class="fas fa-lock"></i>
								<input type="password" name="senha" placeholder="Senha" />
						</div>
						<input type="submit" value="Entrar" class="btn solid" />
					</form>

					<form action="signUp" method="get">
						<input type="submit" value="Criar conta" class="btn solid" />
					</form>

				</div>
			</div>
		</div>

		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content">
					<h3>Bem vindo ao HealthTrack!</h3>
					<p>Já possui uma conta? Entre e viva uma vida muito mais
						saudável.</p>
				</div>
				<img src="images/correndo.svg" class="image" />
			</div>
		</div>
	</div>
</body>

</html>