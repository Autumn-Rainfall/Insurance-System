<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mju.insurance.common.enums.*" %>
<%@ include file="../common/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consult Application</title>
</head>
<body>
	<div class="row ml-3 mr-3">
		<div class="col">
			<h4>Management of consultation applications</h4>
			<div class="list-group">
				<% for (EConsultMenu menu : EConsultMenu.values()) { %>
					<a href="<%="cons/" + menu.getUrl()%>" class="list-group-item list-group-item-action">
						<%=menu.getStr()%>
					</a>
				<% } %>
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="../common/footer.jsp"%>
