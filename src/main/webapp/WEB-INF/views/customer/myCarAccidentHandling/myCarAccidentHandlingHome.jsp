<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mju.insurance.common.enums.*" %>
<%@ include file="../../common/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Accident Handling</title>
</head>
<body>
	<div class="row ml-3 mr-3">
		<div class="col">
			<h4>Management of car accident handling</h4>
			<div class="list-group">
				<% for (EMyCarAccidentHandlingHome menu : EMyCarAccidentHandlingHome.values()) { %>
					<a href="<%="car/" + menu.getUrl()%>" class="list-group-item list-group-item-action">
						<%=menu.getStr()%>
					</a>
				<% } %>
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="../../common/footer.jsp"%>