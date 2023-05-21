<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mju.insurance.common.enums.*" %>
<%@ include file="../common/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>
</head>
<body>
	<div class="row ml-3 mr-3">
		<div class="col">
			<h4>Employee View</h4>
			<div class="list-group">
				<% for (EEmployeeMenu menu : EEmployeeMenu.values()) { %>
					<a href="<%="employee/" + menu.getUrl()%>"class="list-group-item list-group-item-action">
						<%=menu.getStr()%></a>
				<% } %>
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="../common/footer.jsp"%>
