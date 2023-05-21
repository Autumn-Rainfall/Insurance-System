<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mju.insurance.common.enums.*" %>
<%@ include file="../../common/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sales Management</title>
</head>
<body>
   <div class="list-group">
      <% for (ESalesManagement menu : ESalesManagement.values()) { %>
         <a href="<%="salesManagement/" + menu.getUrl()%>" class="list-group-item list-group-item-action">
            <%=menu.getStr()%>
         </a>
      <% } %>
   </div>
</body>
</html>
<%@ include file="../../common/footer.jsp"%>