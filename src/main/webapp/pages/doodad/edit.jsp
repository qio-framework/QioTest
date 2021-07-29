<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Doodad</title>
</head>
<body>
    <h1>Edit Doodad</h1>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <p><a href="${pageContext.request.contextPath}/doodads">Back to Doodads</a></p>

    <form action="${pageContext.request.contextPath}/doodads/update/${doodad.id}" method="post">
        <input type="text" name="name" value="${doodad.name}"/>
        <input type="submit" value="Update"/>
    </form>

</body>
</html>
