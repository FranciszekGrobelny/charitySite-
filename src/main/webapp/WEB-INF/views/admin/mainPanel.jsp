<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Admin Panel</title>
</head>
<body>

    <h2>Kategorie</h2>
    <button id="getAll" type="submit" data-ajax="GET">Pokaż aktualną listę kategorii</button>
    <div>
        <table id="nextCategories">

        </table>
    </div>

    <div id="getCategoryById"></div>

    <div>
        <h4>Dodaj nową kategorię</h4>
        <form>
            <input type="text" name="categoryName">
            <button type="submit" data-ajax="POST">Dodaj</button>
        </form>
    </div>
    <div>
        <h4>Edytuj kategorię o podanym id</h4>
        <form>
            <input type="number" name="categoryId">
            <input type="text" name="updateCategoryName"/>
            <button type="submit" data-ajax="UPDATE">Edytuj</button>
        </form>
    </div>
    <div id="deleteById">

    </div>
    <script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/adminPanel.js"/>"></script>
</body>
</html>
