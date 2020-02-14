<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <title>Сonversion result</title>
</head>

<body>

<div>
    <table>

        <thead>
        <th>Исходная валюта</th>
        <th>Целевая валюта</th>
        <th>Исходная сумма</th>
        <th>Получаемая сумма</th>
        </thead>

        <td>${conversion.fromValute.name}</td>
        <td>${conversion.toValute.name}</td>
        <td>${conversion.amount} ${conversion.fromValute.charCode} </td>
        <td>${result} ${conversion.toValute.charCode}</td>
    </table>

    <div>
        <a href="/converter">В конвертер</a>
    </div>

    <div>
        <a href="/">Главная</a>
    </div>

</div>


</body>

</html>