<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../common/header.jsp"%>

<div class="container">
	<form class="was-validated" method="post">
		<div class="form-group">
			<label for="content">Consultation contents : </label>
			<input type="text" class="form-control" placeholder="Please write down the details of the consultation here" id="content" name="content" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="cday"> Choose your preferred consultation date (required, at least one day ago) :
				<input type="date" id=cday name="cday" required pattern="\d{4}-\d{2}-\d{2}">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please Choose your preferred consultation date.</div>
				<span class="validity"></span>
			</label>
		</div>
		<div class="form-group">
			<label for="cday"> Choose your preferred consultation time :
		    	<input type="time" id=ctime name="ctime" required pattern="hh:mm:ss" >
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please Choose your preferred consultation time.</div>
			</label>
		</div>
		<div class="form-group form-check">
      		<label class="form-check-label">
       			<input class="form-check-input" type="checkbox" name="remember" required> I checked the details and date of the consultation
      			<div class="valid-feedback">Valid.</div>
      			<div class="invalid-feedback">Check this checkbox to continue.</div>
     		</label>
   		</div>
		<%--
		<button id="submit" class="btn btn-primary" onclick = "alert('Submit Success!!')" >Submit</button>
		 --%>
		<button id="submit" class="btn btn-primary" >Submit</button>
	</form>
	<c:if test="${not empty alert}">
		<div class="alert alert-danger" role="alert">${alert}</div>
	</c:if>
</div>

<%@ include file="../common/footer.jsp"%>