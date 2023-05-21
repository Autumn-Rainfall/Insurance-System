<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../common/header.jsp"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="insurance" items="${insuranceInfo}">
		<tr>
			<td><c:out value="${insurance.id}" /></td>
			<td><c:out value="${insurance.name}" /></td>
			<td><c:out value="${insurance.category}" /></td>
			<td><c:out value="${insurance.state}" /></td>
		</tr>
	</c:forEach>
	<c:forEach var="clauses" items="${clauses}">
		<tr>
			<td><c:out value="${clauses.id}" /></td>
			<td><c:out value="${clauses.name}" /></td>
			<td><c:out value="${clauses.clauseCategory}" /></td>
			<td><c:out value="${clauses.insuredAmount}" /></td>
			<td><c:out value="${clauses.premium}" /></td>
		</tr>
	</c:forEach>
	<form class="was-validated" action="result" method="get">
		<label for="name">Customer Email: </label>
		<input type="text" class="form-control" placeholder="Enter Insurance name" id="insName" name="insName" required> <br />
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
	
</body>
</html>
<%@ include file="../../common/footer.jsp"%>