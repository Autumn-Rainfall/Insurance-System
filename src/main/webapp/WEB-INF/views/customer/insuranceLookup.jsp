<%@ include file="../common/header.jsp"%>
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
			<h2>${category} Insurances</h2>
			<p>The details of this insurance are as follows</p>
			<table class="table table-dark">
				<thead>
					<tr>
						<th>Insurance Name</th>
						<th>Maximum Accession Amount</th>
						<th>Total Premium</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty alert}">
						<tr>
							<td colspan="3">${alert}</td>
						<tr>
					</c:if>
					<c:forEach var="insurance" items="${insurances}">
						<tr>
							<td><c:out value="${insurance.name}" /></td>
							<td><c:out value="${insurance.insuredAmountSum}" /> won</td>
							<td><c:out value="${insurance.premiumSum}" /> won</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
<%@ include file="../common/footer.jsp"%>