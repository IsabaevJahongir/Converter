<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>

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
    <title>Converter</title>
</head>

<body class="w3-light-grey">


<div class="w3-container w3-green w3-opacity w3-left-align">
    <h3>Конвертер</h3>
</div>

<div class="w3-card-4">

    <form action="/converter" method="POST">

        <div>

            <p>
                <select name="fromValute" size="1" class="w3-half">
                    <c:forEach items="${allValutes}" var="fromValute">
                        <option value="${fromValute.id}" ${fromValute.id == conversion.fromValute.id ? 'selected' : ' '}>${fromValute.name} ${fromValute.charCode}</option>
                    </c:forEach>
                </select>

                <select name="toValute" size="1" class="w3-half">
                    <c:forEach items="${allValutes}" var="toValute">
                        <option value="${toValute.id}" ${toValute.id == conversion.toValute.id ? 'selected' : ' '}>${toValute.name} ${toValute.charCode}</option>
                    </c:forEach>
                </select>
            </p>

        </div>

        <div>
            <p>
                <input path="amount" name="fromAmount" type="text" placeholder="Исходная сумма"
                       value="${conversion.amount == 0 ? '': conversion.amount}" class="w3-half"/>

                <input name="toAmount" type="text" placeholder="Целевая сумма"
                       value="${conversion.resultOfConversion() == 0 ? '' : conversion.resultOfConversion()}" class="w3-half" readonly/>

                <form:errors path="fromDate"></form:errors>
                ${doubleError}
            </p>
        </div>

        <div>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Конвертировать</button>
        </div>

    </form>

    <div class="w3-container w3-grey w3-opacity w3-left-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/history'">История конвертаций пользавателя
        </button>
        <button class="w3-btn w3-round-large" onclick="location.href='/'">Главная</button>
    </div>


</div>

</body>

</html>