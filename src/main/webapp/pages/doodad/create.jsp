<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Doodad</title>
</head>
<body>

    <h1>New Doodad</h1>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <p><a href="${pageContext.request.contextPath}/doodads">Back to Doodads</a></p>

    <form action="${pageContext.request.contextPath}/doodads/save" method="post">
        <input type="text" name="name" value=""/>
        <input type="submit" value="Save"/>
    </form>
</body>
</html>
