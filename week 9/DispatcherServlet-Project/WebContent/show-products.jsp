<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styletable.css">
</head>
<body>
	<div class="container">
		<table>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
			</tr>
			  
			<c:forEach var="i" items="${PRODUCTS}">
				<tr>
					<td>${i.prodId}</td>
					<td>${i.name}</td>
				</tr>
			</c:forEach>
		
		</table>
		<!--  <a href="index.jsp">Go to Home Page</a>-->
	</div>

</body>
</html>