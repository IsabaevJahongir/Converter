<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Exchange</title>
</head>

<body class="w3-light-grey">

<div class="w3-container w3-green w3-opacity w3-left-align">
    <h3>Курсы валют</h3>
</div>

<div>
    <table>
        <thead>
        <th>Название валюты</th>
        <th>Номинал</th>
        <th>Цена (руб.)</th>
        <th>Сокращение</th>
        </thead>

        <c:forEach items="${allValutes}" var="fromValute">
            <tr>
                <td>${fromValute.name}</td>
                <td>${fromValute.nominal}</td>
                <td>${fromValute.value}</td>
                <td>${fromValute.charCode}</td>
            </tr>
        </c:forEach>

    </table>
</div>


<div class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Главная</button>
</div>


</body>
</html>