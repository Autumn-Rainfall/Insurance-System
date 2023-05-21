<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Total Payment</title>
</head>
<body>
	<div class="container">
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Insurance Name</th>
					<th>Insurance Premium</th>
					<th>Insured Amount</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${insuranceName}</td>
					<td>${insurancePremium}won</td>
					<td>${insuredAmount}won</td>
				</tr>
			</tbody>
		</table>
		<h4>Would you like to join?</h4>
		<a href="yes" class="btn btn-primary">YES</a>
		<a href="no" class="btn btn-primary">NO</a>
	</div>
</body>
</html>
<%@ include file="../../common/footer.jsp"%>