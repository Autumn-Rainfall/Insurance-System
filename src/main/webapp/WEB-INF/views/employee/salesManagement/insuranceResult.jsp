<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../common/header.jsp"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insurance Information</title>
<style>
table {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

th {
	padding-right: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty alert}">
				<h4>${alert}</h4>
				<a href="/insurance" class="btn btn-primary">home</a>
			</c:when>
			<c:otherwise>
				<table class="table table-dark">
					<thead>
						<tr>
							<th>Insurance ID</th>
							<th>Insurance Name</th>
							<th>Insurance Category</th>
							<th>Insurance State</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${insuranceInfo}" var="insurance">
							<tr>
								<td><c:out value="${insurance.id}" /></td>
								<td><c:out value="${insurance.name}" /></td>
								<td><c:out value="${insurance.category}" /></td>
								<td><c:out value="${insurance.state}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="table table-dark">
					<thead>
						<tr>
							<th>Clause ID</th>
							<th>Clause Name</th>
							<th>Clause Category</th>
							<th>Clause Insured Amount</th>
							<th>Clause Premium</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="clauses" items="${clauses}">
							<tr>
								<td><c:out value="${clauses.id}" /></td>
								<td><c:out value="${clauses.name}" /></td>
								<td><c:out value="${clauses.clauseCategory}" /></td>
								<td><c:out value="${clauses.insuredAmount}" /> won</td>
								<td><c:out value="${clauses.premium}" /> won</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form class="was-validated" action="customerResult" method="post">
					<div class="form-group">
						<label for="name">Customer Email: </label> <input type="text"
							class="form-control" placeholder="Enter Customer Email"
							id="customerEmail" name="customerEmail" required> <br />
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
<%@ include file="../../common/footer.jsp"%>