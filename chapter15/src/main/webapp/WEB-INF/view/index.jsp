<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="header2" value="Second level header" />

<!DOCTYPE html>
<html>
<head>
    <title>Home Controller</title>
</head>
<body>
<h1>Home Controller</h1>
<h2>${header2}</h2>
<hr/>

<a href="customer/showForm">Customer Form</a>

</body>
</html>
