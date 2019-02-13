<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <h1>Welcome to Home page</h1>
    <hr />
    <p>User: <security:authentication property="principal.username" /></p>
    <p>Role(s): <security:authentication property="principal.authorities" /></p>

    <hr />

<form:form action="${pageContext.request.contextPath}/logout" method="post" >
    <input type="submit" value="Logout" />
</form:form>

</body>
</html>
