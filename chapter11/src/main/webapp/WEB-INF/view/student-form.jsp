<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Student Form" />
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>

<h3>Actual name</h3>
<form action="processForm" method=""GET>
    <input type="text" name="studentName" placeholder="What's your name?">
    <input type="submit">
</form>

<h3>Uppercase name</h3>
<form action="uppercaseName" method=""GET>
    <input type="text" name="studentName" placeholder="What's your name?">
    <input type="submit">
</form>

<h3>Version 3</h3>
<form action="/versionThree" method=""GET>
    <input type="text" name="studentName" placeholder="What's your name?">
    <input type="submit">
</form>

</body>
</html>
