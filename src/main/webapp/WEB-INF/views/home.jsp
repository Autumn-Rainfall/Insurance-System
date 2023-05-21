<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mju.insurance.common.enums.*" %>

<%@ include file="common/header.jsp"%>

<div class="container">
	<div class="row">
	<% for(EHomeMenu menu: EHomeMenu.values()){ %>
			<div class="card" style="width: 350px; margin: 0 3px">
				<div class="card-body">
					<h4 class="card-title"><%=menu.getStr()%></h4>
						<p class="card-text"><%=menu.getInfo()%></p>
						<a href="<%=menu.getUrl()%>" class="btn btn-primary">Go for <%=menu.getStr()%></a>
				</div>
			</div>
	<% } %>
	</div>
</div>

<%@ include file="common/footer.jsp"%>