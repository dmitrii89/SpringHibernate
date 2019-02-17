<%--
  Created by IntelliJ IDEA.
  User: Dmitrii
  Date: 17.02.2019
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>
<h1>Welcome page!</h1>
<h2>Project Rest demo</h2>
<hr />
<p><a href="${pageContext.request.contextPath}/test/hello">Hello</a></p>
<p><a href="${pageContext.request.contextPath}/api/students">Students list</a></p>
</body>
</html>
