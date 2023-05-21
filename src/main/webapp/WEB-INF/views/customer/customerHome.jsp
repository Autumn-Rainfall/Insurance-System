<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mju.insurance.common.enums.*" %>
<%@ include file="../common/header.jsp"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<h4>Look Up Insurance Products</h4>
			<div class="list-group">
				<% for (EInsuranceListMenu menu : EInsuranceListMenu.values()) { %>
					<a href="customer/ins?category=<%=menu.getUrl()%>" class="list-group-item list-group-item-action">
						<%=menu.getStr()%>
					</a>
				<% } %>
			</div>
		</div>
		<div class="col">
			<h4>Manage My Insurance</h4>
			<div class="list-group">
				<% for (ECustomerMenu menu : ECustomerMenu.values()) { %>
					<a href="<%="customer/" + menu.getUrl()%>" class="list-group-item list-group-item-action">
						<%=menu.getStr()%>
					</a>
				<% } %>
			</div>
		</div>
	</div>
	<c:if test="${not empty alert}">
		<script>alert('${alert}')</script>
	</c:if>
</div>
</body>
</html>
<%@ include file="../common/footer.jsp"%>
