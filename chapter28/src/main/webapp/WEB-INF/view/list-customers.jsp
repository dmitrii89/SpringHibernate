<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
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
					<th>${customer.firstName}</th>
					<th>${customer.lastName}</th>
					<th>${customer.email}</th>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>

</html>









