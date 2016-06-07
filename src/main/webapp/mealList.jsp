<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>Title</title>
</head>
<body background="Meal.jpg">


<c:choose>
    <c:when test="${empty id}">
        <h2 style="background: #a0fffc">Add meal form:</h2>
    </c:when>
    <c:otherwise>
        <h2 style="background: lightblue">Edit meal form:</h2>
    </c:otherwise>
</c:choose>

<form method="POST" action="./meals">
    <table>

        <tr>
            <td style="background: lightblue">ID</td>
            <td><input type="text" name="id" value="${id}"/></td>
        </tr>

        <tr>
            <td style="background: lightblue">Description</td>
            <td><input type="text" name="description" value="${description}"/></td>
        </tr>

               <tr>
            <td style="background: lightblue" >Calories</td>
            <td><input type="text" name="calories" value="${calories}"/>

        </tr>



    </table>

    <input type="submit" value="Add/Update"
           style="background: #ffe627"/>

</form>

<hr>
<h2 style="background: #a0fffc">Meals list</h2>

<table style="border: 3px solid; width: 500px; text-align:center">
    <thead style="background: lightblue">
    <tr>
        <th>Meal ID</th>
        <th>Date and time</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="meal" items="${meals}">

        <c:url var="editUrl" value="./meals?do=edit&id=${meal.id}" />
        <c:url var="deleteUrl" value="./meals?do=delete&id=${meal.id}" />
        <tr <c:if test="${meal.exceed}">bgcolor= #ffb6c1 </c:if>
            <c:if test="${!meal.exceed}">bgcolor= #adff2f</c:if>">

            <td><c:out value="${meal.id}" /> </td>
            <td><c:out value="${meal.dateTime.format(formatter)}" /> </td>
            <td><c:out value="${meal.description}" /></td>
            <td><c:out value="${meal.calories}" /></td>

            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${empty meals}">
    There are currently no meals in the list.
</c:if>

</body>
</html>