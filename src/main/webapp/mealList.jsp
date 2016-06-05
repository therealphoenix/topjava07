<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Meal list</title>
</head>
<body>

<h2>Meal list</h2><br>



    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>dateTime</th>
            <th>description</th>
            <th>calories</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>

                <c:forEach var="meal" items="${mealList}">
            <tr>
                    <tr style="color:
                <c:if test="${meal.exceed}">darkred</c:if>
                <c:if test="${!meal.exceed}">darkgreen</c:if>">
                <td>${meal.id}</td>
                <td>${meal.dateTime}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>


            </tr>
        </c:forEach>
        </tbody>

    </table>


<h2><a href="index.html">Home</a></h2>
<h2><a href = "users">User List</a></h2>

</body>
</html>
