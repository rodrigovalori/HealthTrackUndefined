<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="usuario" class="br.com.fiap.healthtrack.model.Usuario" scope="request" />

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/login-signUp.css">
    <title>Criar conta | HealthTrack</title>
</head>

<body>
    <div class="container">
        <div class="forms-container">
            <div class="forms-1" id="signup">
                <div class="forms-2">
                    <form action="cadastrarUsuario" method="post">
                        <h2 class="title">Criar conta</h2>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" name="nome-usuario" placeholder="Nome e Sobrenome" />
                        </div>
                        <div class="input-field">
                            <i class="far fa-calendar"></i>
                            <input type="text" name="data-nascimento" placeholder="dd/mm/aaaa" />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="email" name="email" placeholder="Email" />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="senha" placeholder="Senha" />
                        </div>
                        <input type="submit" value="Confirmar" class="btn solid" />
                    </form>
                    <form action="login">
                        <input id="voltar" type="submit" value="Já tenho uma conta" class="btn solid" />
                    </form>
                </div>
            </div>
        </div>

        <div class="panels-container">
            <div class="panel left-panel">
                <div class="content">
                    <h3>Bem vindo ao HealthTrack!</h3>
                    <p>
                        Novo por aqui? Faça uma conta e viva uma vida muito mais saudável.
                    </p>
                </div>
                <img src="images/fitness.svg" class="image" alt="" />
            </div>
        </div>
    </div>
</body>

</html>