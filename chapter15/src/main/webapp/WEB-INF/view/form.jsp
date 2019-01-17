<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="title" value="Customer Form" />

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <style>
        .error {color: red}
    </style>
</head>
<body>
<h1>${title}</h1>

<h3>Form</h3>
<i>Asterisk (*) means required</i>
<br/><br/>
<form:form action="processForm" modelAttribute="customer">
    <p>
        First name: <form:input path="firstName" />
        <form:errors path="firstName" cssClass="error" />
    </p>
    <p>
        Last name (*): <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
    </p>
    <p>
        Free passes (*): <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error" />
    </p>
    <p>
        Postal code (*): <form:input path="postalCode" />
        <form:errors path="postalCode" cssClass="error" />
    </p>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
