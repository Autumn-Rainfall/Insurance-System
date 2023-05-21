<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Insurance System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="/insurance">Private 1st Class Insurance</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <%
      String id = (String)session.getAttribute("id");
      if(id == null) { %>
      <li class="nav-item">
        <a class="nav-link" href="/insurance/auth/login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/insurance/auth/signup">Sign Up</a>
      </li>
      <% } else { %>
      <li class="nav-item">
        <a class="nav-link" href="/insurance/auth/logout">Logout</a>
      </li>
      <% } %>
    </ul>
  </div>  
</nav>
<br/>
