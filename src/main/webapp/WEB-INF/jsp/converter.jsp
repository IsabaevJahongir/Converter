<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Новости</title>
</head>

<body>

<div>

    <div>
        <h2>Конвертер</h2>
    </div>

    <form action="/converter" method="POST">


        <div>
            <select name="fromValute" size="1">
                <c:forEach items="${allValutes}" var="fromValute">
                    <option value="${fromValute.id}"> ${fromValute.charCode} ${" ("} ${fromValute.name} ${")"}</option>
                </c:forEach>
            </select>

            <select name="toValute" size="1">
                <c:forEach items="${allValutes}" var="toValute">
                    <option value="${toValute.id}"> ${toValute.charCode} ${" ("} ${toValute.name} ${")"}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <input name="fromAmount" type="text" placeholder="Исходная валюта"/>

            <input name="toAmount" type="text" placeholder="Целевая валюта"/>
        </div>

        <div>
            <button type="submit">Конвертировать</button>
        </div>

        <div>
            <a href="/">Главная</a>
        </div>


    </form>


</div>

</body>

</html>