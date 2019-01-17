<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Your info" />

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>
<p>First name: ${person.firstName}</p>
<p>Last name: ${person.lastName}</p>
<p>Country: ${person.country}</p>
<p>Favourite language: ${person.favouriteLanguage}</p>
<ul>
    <c:forEach items="${person.operatingSystems}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>
