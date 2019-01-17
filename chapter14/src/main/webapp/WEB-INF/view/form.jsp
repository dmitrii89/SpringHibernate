<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="title" value="Person Form" />

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>

<h3>Form</h3>
<form:form action="processForm" modelAttribute="person">
    <p>
        First name: <form:input path="firstName" />
    </p>
    <p>
        Last name: <form:input path="lastName" />
    </p>
    <p>Country:
        <form:select path="country" >
            <form:options items="${countryOptions}" />
        </form:select>
    </p>
    <p>Favourite language:
        Java <form:radiobutton path="favouriteLanguage" value="Java" />
        C# <form:radiobutton path="favouriteLanguage" value="C#" />
        Python <form:radiobutton path="favouriteLanguage" value="Python" />
        Ruby <form:radiobutton path="favouriteLanguage" value="Ruby" />
        Php <form:radiobutton path="favouriteLanguage" value="Php" />
    </p>
    <p>Operating systems:
        Windows <form:checkbox path="operatingSystems" value="Windows" />
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        Linux <form:checkbox path="operatingSystems" value="Linux" />
    </p>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
