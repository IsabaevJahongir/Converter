<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>Id</th>
        <th>Name</th>
        <th>Nominal</th>
        <th>Value</th>
        <th>Date</th>
        <th>Char code</th>

        </thead>

        <c:forEach items="${allValutes}" var="fromValute">
            <tr>
                <td>${fromValute.id}</td>
                <td>${fromValute.name}</td>
                <td>${fromValute.nominal}</td>
                <td>${fromValute.value}</td>
                <td>${fromValute.actualDate}</td>
                <td>${fromValute.charCode}</td>


            </tr>
        </c:forEach>
    </table>

    <a href="/">Главная</a>

</div>
</body>
</html>