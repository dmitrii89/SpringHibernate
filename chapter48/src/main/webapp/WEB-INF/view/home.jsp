<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <h1>Welcome to Home page</h1>
    <p>Spring security is coming</p>

<form:form action="${pageContext.request.contextPath}/logout" method="post" >
    <input type="submit" value="Logout" />
</form:form>

</body>
</html>
