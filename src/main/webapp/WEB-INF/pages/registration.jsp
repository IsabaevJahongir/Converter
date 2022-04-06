<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Registration</title>
</head>

<body class="w3-light-grey">

<div>

    <div class="w3-container w3-green w3-opacity w3-left-align">
        <h3>Регистрация</h3>
    </div>

    <div class="w3-card-4">
        <form:form method="POST" modelAttribute="userForm" class="w3-selection w3-light-grey w3-padding">


            <div>
                <form:input type="text" path="username" placeholder="Username" autofocus="true"
                            class="w3-input  w3-border w3-round-large" style="width: 25%"></form:input>

                <form:errors path="username"></form:errors>
                    ${usernameError}
            </div>

            <div>
                <form:input type="password" path="password" placeholder="Password"
                            class="w3-input  w3-border w3-round-large" style="width: 25%"></form:input>
                <form:errors path="password"></form:errors>
                    ${passwordError}
            </div>

            <div>
                <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"
                            class="w3-input  w3-border w3-round-large" style="width: 25%"></form:input>

            </div>

            <div>
                <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Зарегистрироваться
                </button>
            </div>

        </form:form>

        <div class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='..'">Главная</button>
            <button class="w3-btn w3-round-large" onclick="location.href='/login'">Войти</button>
        </div>


    </div>


</div>

</body>

</html>