<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Management</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>

</html>








