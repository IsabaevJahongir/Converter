<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>

<html>

<head>
    <meta charset="utf-8">
    <title>Registration</title>
</head>

<body>

<div>

    <div>
        <form:form method="POST" modelAttribute="userForm">

            <div>
                <h2>Регистрация</h2>
            </div>

            <div>
                <form:input type="text" path="username" placeholder="Username" autofocus="true"></form:input>

                <form:errors path="username"></form:errors>
                    ${usernameError}
            </div>

            <div>
                <form:input type="password" path="password" placeholder="Password"></form:input>
            </div>

            <div>
                <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"></form:input>

                <form:errors path="password"></form:errors>
                    ${passwordError}
            </div>

            <div>
                <button type="submit">Зарегистрироваться</button>
            </div>

        </form:form>

    </div>

    <div>
        <a href="/">Главная</a>
    </div>

</div>

</body>

</html>