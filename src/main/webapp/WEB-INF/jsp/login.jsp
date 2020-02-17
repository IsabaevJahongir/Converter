<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>

<html>

<head>
    <style>
        #footer {
            position: fixed; /* Фиксированное положение */
            left: 0; bottom: 0; /* Левый нижний угол */
            padding: 10px; /* Поля вокруг текста */
            background: #39b54a; /* Цвет фона */
            color: #fff; /* Цвет текста */
            width: 100%; /* Ширина слоя */
        }
    </style>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta charset="utf-8">
    <title>Log in</title>
</head>

<body class="w3-light-grey">

<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/converter"); %>
</sec:authorize>


<div class="w3-container w3-green w3-opacity w3-left-align">
    <h3>Вход в систему</h3>
</div>

<div class="w3-card-4" >

    <form method="POST" action="/login" modelAttribute="userForm" class="w3-selection  w3-light-grey w3-padding">

        <div>
            <input name="username" type="text" placeholder="Имя" autofocus="true" class="w3-input  w3-border w3-round-large" style="width: 25%"/>
        </div>

        <div>
            <input name="password" type="password" placeholder="Пароль"           class="w3-input  w3-border w3-round-large" style="width: 25%"/>
        </div>

        <div>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Log In</button>
        </div>

    </form>


    <div class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/'">Главная</button>
        <button class="w3-btn w3-round-large" onclick="location.href='/registration'">Регистрация</button>
    </div>


</div>

</body>

</html>
