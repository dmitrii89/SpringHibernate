<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

<h1>Login page</h1>

<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
    <c:if test="${param.error != null}">
        <i class="failed">Sorry! You entered invalid username/password.</i>
    </c:if>

    <p>
        User name: <input type="text" name="username">
    </p>
    <p>
        User password: <input type="text" name="password">
    </p>
    <input type="submit" value="Login" />

</form:form>

</body>
</html>
