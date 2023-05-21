<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../common/header.jsp"%>
<div class="container">
	<form class="mb-3" action="login" method="post">
		<div class="form-group">
			<label for="id">Email: </label>
			<input type="email" class="form-control" placeholder="Enter your email" id="email" name="email">
		</div>
		<div class="form-group">
			<label for="password">Password: </label>
			<input type="password" class="form-control" placeholder="Enter your password" id="password" name="password">
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
	<c:if test="${not empty alert}">
		<div class="alert alert-danger" role="alert">${alert}</div>
	</c:if>
</div>

<%@ include file="../common/footer.jsp"%>