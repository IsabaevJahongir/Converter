<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>

<html>

<head>
    <meta charset="utf-8">
    <title>Log in</title>
</head>

<body>

<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/converter"); %>
</sec:authorize>

<div>

    <div>

        <form method="POST" action="/login">

            <div>
                <h2>Вход в систему</h2>
            </div>

            <div>
                <input name="username" type="text" placeholder="Имя" autofocus="true"/>
            </div>

            <div>
                <input name="password" type="password" placeholder="Пароль"/>
            </div>

            <div>
                <button type="submit">Log In</button>
            </div>

            <div>
                <h4><a href="/registration">Зарегистрироваться</a></h4>
            </div>

        </form>

    </div>

</div>

</body>

</html>
