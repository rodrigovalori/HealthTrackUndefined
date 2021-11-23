<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/dashboard-profile.css" />
    <title>Dashboard | HealthTrack</title>
</head>

<body>
    <div class="container">
        <div class="forms-container">
            <div class="forms-1" id="dashboard">
                <div class="forms-2">
                    <form action="">
                        <h2 class="title">HealthTrack</h2>
                    </form>
                    <form action="cadastrarAtividadeFisica" method="get">
                        <input type="submit" value="Exercícios" class="btn solid" />
                    </form>
                    <form action="cadastrarAlimento" method="get">
                        <input type="submit" value="Alimentação" class="btn solid" />
                    </form>
                    <form action="cadastrarPeso" method="get">
                        <input type="submit" value="Peso" class="btn solid" />
                    </form>
                    <form action="cadastrarPressaoArterial" method="get">
                        <input type="submit" value="Pressão Arterial" class="btn solid" />
                    </form>
                    <form action="login">
                        <input id="voltar" type="submit" value="Sair" class="btn solid" />
                    </form>
                </div>
            </div>
        </div>

        <div class="panels-container">
            <div class="panel left-panel">
                <div class="content">
                </div>
                <img src="images/avatar.svg" class="image" />
            </div>
        </div>
    </div>
</body>

</html>