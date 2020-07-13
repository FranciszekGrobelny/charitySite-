<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Admin Panel</title>
</head>
<body>

    <h3>Kategorie</h3>
    <h4>Dodaj nową kategorię</h4>
    <div>
        <form method="post" action="/admin/panel/create/category">
            <input type="text" name="categoryName">
            <input type="submit">
        </form>
    </div>
    <h4>Edytuj kategorię o podanym id</h4>
    <div>
        <form method="post" action="/admin/panel/update/category">
            <input type="number" name="categoryId">
            <input type="submit">
        </form>
    </div>

</body>
</html>
