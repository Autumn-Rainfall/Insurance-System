<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<h4>Sales Activity</h4>
		<form class="was-validated" action="insuranceResult" method="get">
			<div class="form-group">
				<label for="name">Insurance Name: </label> <input type="text"
					class="form-control" placeholder="Enter Insurance name"
					id="insName" name="insName" required> <br />
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</form>
	</div>
</body>
</html>

<%@ include file="../../common/footer.jsp"%>