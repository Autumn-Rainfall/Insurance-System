<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../../common/header.jsp"%>
<div class="container">
	<h1>My Car Accident Handling Application</h1>

	<c:if test="${not empty alert}">
		<div class="alert alert-danger mt-3">${alert}</div>
	</c:if>
	<form class="was-validated" method="post" action="addCar">
		<div class="border my-3 p-3">
			<h5>Accident Related Car Info.</h5>
			<div class="form-group">
				<label for="carNo">Car no. : </label>
				<input type="text" class="form-control" placeholder="Please write down the car number here" id="carNo" name="carNo" required>
			</div>
			<div class="form-group">
				<label for="ownerName">Car owner name : </label>
				<input type="text" class="form-control" placeholder="Please write down the car owners'name here" id="ownerName" name="ownerName" required>
			</div>
			<div class="form-group">
				<label for="ownerPhoneNo">Car owner phone no. : </label>
				<input type="text" class="form-control" placeholder="Please write down the car owners' phone number here" id="ownerPhoneNo" name="ownerPhoneNo" required>
			</div>
			<div class="form-group">
				<label for="cost">Cost : </label>
				<input type="number" class="form-control" placeholder="Please write down the car's cost here" id="cost" name="cost" required>
			</div>
			<div class="form-group">
				<label for="visitedShopName">Visited car shop name : </label>
				<input type="text" class="form-control" placeholder="Please write down the car shop you visited here" id="visitedShopName" name="visitedShopName" required>
			</div>
			<button id="submit" class="btn btn-dark">Add Car</button>
			<h6 class="mt-3">Added Cars' Info</h6>
			<c:if test="${empty accidentCars}">
				<div>No Accident Car was added.</div>
			</c:if>
			<c:forEach var="accidentCar" items="${accidentCars}">
				<c:set var="i" value="${i+1}"/>
				<div>
					<span>#${i}</span>
					<span>carNo: <c:out value="${accidentCar.carNo}"/>, </span>
					<span>ownerName: <c:out value="${accidentCar.ownerName}"/>, </span>
					<span>phoneNo: <c:out value="${accidentCar.ownerPhoneNo}"/>, </span>
					<span>visitedShopName: <c:out value="${accidentCar.visitedShopName}"/></span>
				</div>
			</c:forEach>
		</div>
	</form>
	<form class="was-validated" method="post" action="addPerson">
		<div class="border my-3 p-3">
			<h5>Accident Related Person Info.</h5>
			<div class="form-group">
				<label for="name">Name : </label>
				<input type="text" class="form-control" placeholder="Please write down the person's name location here" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="phoneNo">Phone no. : </label>
				<input type="text" class="form-control" placeholder="Please write down person's phone number here" id="phoneNo" name="phoneNo" required>
			</div>
			<div class="form-group">
				<label for="visitedHospitalName">Visited hospital : </label>
				<input type="text" class="form-control" placeholder="Please write down the hospital person visited here" id="visitedHospitalName" name="visitedHospitalName" required>
			</div>
			<button id="submit" class="btn btn-dark">Add Person</button>
			<h6 class="mt-3">Added People's Info</h6>
			<c:if test="${empty accidentPeople}">
				<div>No Accident Person was added.</div>
			</c:if>
			<c:forEach var="accidentPerson" items="${accidentPeople}">
				<c:set var="j" value="${j+1}"/>
				<div>
					<span>#${j}</span>
					<span>name: <c:out value="${accidentPerson.name}"/>, </span>
					<span>phoneNo: <c:out value="${accidentPerson.phoneNo}"/>, </span>
					<span>visitedHospitalName: <c:out value="${accidentPerson.visitedHospitalName}"/></span>
				</div>
			</c:forEach>
		</div>
	</form>
	<form class="was-validated" method="post" action="apply">
		<div class="form-group">
			<label for="accidentDate"> Choose your car accident date / time :
				<input type="date" name="accidentDate" required pattern="\d{4}-\d{2}-\d{2}">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please Choose your car accident date.</div>
				<span class="validity"></span>
			</label>
			<label for="accidentTime">
				<input type="time" name="accidentTime" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please Choose your car accident time.</div>
				<span class="validity"></span>
			</label>
		</div>
		<div class="form-group">
			<label for="accidentContent">Car accident contents : </label>
			<input type="text" class="form-control" placeholder="Please write down the details of the car accident contents here" id="accidentContent" name="accidentContent" required>
		</div>
		<div class="form-group">
			<label for="accidentLocation">Car accident location : </label>
			<input type="text" class="form-control" placeholder="Please write down the car accident location here" id="accidentLocation" name="accidentLocation" required>
		</div>
		<button id="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<%@ include file="../../common/footer.jsp"%>