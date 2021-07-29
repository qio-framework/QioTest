<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Doodads</title>
</head>
<body>

    <h1>Doodads</h1>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>

    <a href="${pageContext.request.contextPath}/doodads/create">New Doodad</a>

    <c:if test="${doodads.size() > 0}">
        <table>
            <c:forEach items="${doodads}" var="doodad">
                <tr>
                    <td>${doodad.id}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/doodads/edit/${doodad.id}">${doodad.name}</a>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/doodads/delete/${doodad.id}" method="post">
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${doodads.size() == 0}">
        <p>No doodads created yet...</p>
    </c:if>

</body>
</html>
