<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>

<html>

<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta charset="utf-8">
    <title>Main</title>
</head>

<body class="w3-light-grey">

<div>

    <div class="w3-container w3-center w3-green w3-opacity w3-left-align">
        <h3>Добро пожаловать в конвертер валют!</h3>
    </div>


    <div>
        <sec:authorize access="!isAuthenticated()">
            <h4><a href="/login">Войти</a></h4>
            <h4><a href="/registration">Зарегистрироваться</a></h4>
        </sec:authorize>
    </div>

    <div>
        <sec:authorize access="isAuthenticated()">
            <h4><a href="/converter">В конвертер</a></h4>
        </sec:authorize>
    </div>

    <div>
        <sec:authorize access="isAuthenticated()">
            <h4><a href="/exchange">Курсы валют</a></h4>
        </sec:authorize>
    </div>

    <div>
        <sec:authorize access="isAuthenticated()">
            <h4><a href="/logout">Выйти</a></h4>
        </sec:authorize>
    </div>


</div>

</body>

</html>