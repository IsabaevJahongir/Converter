<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        #footer {
            position: fixed; /* Фиксированное положение */
            left: 0;
            bottom: 0; /* Левый нижний угол */
            padding: 10px; /* Поля вокруг текста */
            background: #39b54a; /* Цвет фона */
            color: #fff; /* Цвет текста */
            width: 100%; /* Ширина слоя */
        }
    </style>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <script src="resources/js/calendar_ru.js" type="text/javascript"></script>
    <title>History</title>
</head>

<body class="w3-light-grey">

<div class="w3-container w3-green w3-opacity w3-left-align">
    <h3>История конвертаций</h3>
</div>


<div class="w3-card-4">
    <form method="post" action="/history">
        <p>Выбор даты:<br>
            <input type="text" value="dd-mm-yyyy" placeholder="dd-mm-yyyy" ${x} onfocus="this.select();lcs(this)"
                   onclick="event.cancelBubble=true;this.select();lcs(this)"
                   name="fromDate" class="w3-input  w3-border w3-round-large" style="width: 25%">

            <form:errors path="fromDate"></form:errors>
            ${dateError}

        <div>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Смотреть по дате</button>
        </div>
        </p>

    </form>
</div>


<div>
    <table>
        <thead>
        <th>Исходная валюта</th>
        <th>Целевая валюта</th>
        <th>Исходная сумма</th>
        <th>Получаемая сумма</th>
        <th>Дата выполнения операции</th>
        </thead>

        <c:forEach items="${allConversions}" var="conversion">
            <tr>
                <td>${conversion.fromValute.name}</td>
                <td>${conversion.toValute.name}</td>
                <td>${conversion.amount} ${conversion.fromValute.charCode} </td>
                <td>${conversion.resultOfConversion()} ${conversion.fromValute.charCode} </td>
                <td>${conversion.date}</td>
            </tr>
        </c:forEach>

    </table>

</div>


<div id = footer class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/history'">Вся история</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/converter'">В конвертер</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Главная</button>
</div>

</body>

</html>