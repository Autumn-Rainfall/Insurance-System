<%@ include file="../../common/header.jsp"%>
<%@ page import="com.mju.insurance.common.enums.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<div class="container">
			<h2>Car Accident Handling</h2>
			<p>Click and manage your car accident handling.</p>
			<table class="table table-dark table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Location</th>
						<th>Content</th>
						<th>Accident Date</th>
						<th>Request Date</th>
						<th>State</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty alert}">
						<tr>
							<td colspan="6">${alert}</td>
						<tr>
					</c:if>
					<c:forEach var="carAccidentHandling" items="${carAccidentHandlings}">
						<tr>
							<td><c:out value="${carAccidentHandling.id}"/></td>
							<td><c:out value="${carAccidentHandling.accidentLocation}"/></td>
							<td><c:out value="${carAccidentHandling.accidentContent}"/></td>
							<td><c:out value="${carAccidentHandling.accidentDate}"/></td>
							<td><c:out value="${carAccidentHandling.requestDate}"/></td>
							<td><c:out value="${carAccidentHandling.state}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
<%@ include file="../../common/footer.jsp"%>