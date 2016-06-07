<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
                    <%--! removing T from dateTime --%>
                <td><fmt:parseDate value="${meal.dateTime}" pattern="y-M-dd'T'H:m" var="parsedDate"/>
                    <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd'T' HH:mm"/> </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit/${meal.id}">Edit</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/delete/${meal.id}">Delete</a>
                    </td>


            </tr>
        </c:forEach>
        </tbody>

    </table>


<h2><a href="index.html">Home</a></h2>
<h2><a href ="addMeal.jsp">Add meal</a></h2>
<h2><a href = "users">User List</a></h2>

</body>
</html>
