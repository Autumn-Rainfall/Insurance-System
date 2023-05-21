<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Result</title>
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
							<th>Customer Name</th>
							<th>Customer Age</th>
							<th>Customer Gender</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="customer" items="${customerInfo}">
							<tr>
								<td><c:out value="${customer.name}" /></td>
								<td><c:out value="${customer.age}" /></td>
								<td><c:out value="${customer.gender}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form class="was-validated" action="calculateResult" method="post">
					<div class="form-group">
						<label for="name">How many months do you want to pay in total? </label> <br />
						<input type="text" class="form-control"
							placeholder="Enter Total Payment Month" id="totalPaymentMonth"
							name="totalPaymentMonth" required /> <br />
							Insurance premium
						<button type="submit" class="btn btn-primary">Calculation</button>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
<%@ include file="../../common/footer.jsp"%>