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

    <div>
        <form action="/converter" method="post" name="drop_down_box">

            <div>
                <select name="menu" size="1">
                    <option value="first">Первая позиция</option>
                    <option selected="selected" value="second">Вторая позиция</option>
                    <option value="third">Третья позиция</option>
                    <option value="fourth">Четвертая позиция</option>
                </select>

                <div>
                    <input name="text" type="text" placeholder="Сумма"/>
                </div>

            </div>

            <div>
                <select name="menu" size="1">
                    <option value="first">1</option>
                    <option selected="selected" value="second">2</option>
                    <option value="third">3</option>
                    <option value="fourth">4</option>
                </select>

                <div>
                    <input name="text" type="text" placeholder="Сумма"/>
                </div>
            </div>

            <div>
                <button type="submit">Посчитать</button>
            </div>
    </div>
</div>

    <div>
        <a href="/">Главная</a>
    </div>

</div>

</body>

</html>