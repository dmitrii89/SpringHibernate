<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Customer info" />

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>
<p>First name: ${customer.firstName}</p>
<p>Last name: ${customer.lastName}</p>
<p>Free passes: ${customer.freePasses}</p>
<p>Postal code: ${customer.postalCode}</p>
<p>Postal code: ${customer.courseCode}</p>
</body>
</html>
