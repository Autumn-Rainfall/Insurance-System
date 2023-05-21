<%@ include file="../common/header.jsp"%>
<%@ page import="com.mju.insurance.common.enums.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<div class="container">
			<table class="table table-dark">
				<thead>
					<tr>
						<th>Content</th>
						<th>Application Date</th>
						<th>Consultation Date</th>
						<th>State</th>
						<th>Cancel</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="consultation" items="${consultationList}">
						<tr>
							<td><c:out value="${consultation.content}" /></td>
							<td><c:out value="${consultation.applicationDate}" /></td>
							<td><c:out value="${consultation.consultationDate}" /></td>
							<td><c:out value="${consultation.state}" /></td>
							<td><button class="btn btn-danger pull-right" type="button" 
							onclick = "cancelConfirm(${consultation.id})">Cancel</button>
							<script>
								function cancelConfirm(id) {
									if (confirm("Do you want to cancel it?") == true) {
										location.href = "delete?id=" + id;
									} else return;
								}
							</script></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
<%@ include file="../common/footer.jsp"%>