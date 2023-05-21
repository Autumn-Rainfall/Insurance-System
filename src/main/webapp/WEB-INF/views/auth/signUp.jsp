<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../common/header.jsp"%>

<div class="container">
	<c:if test="${not empty alert}">
		<div class="alert alert-danger" role="alert">${alert}</div>
	</c:if>
	<form class="was-validated" action="signup" method="post">
		<div class="form-group">
			<label for="name">Name: </label>
			<input type="text" class="form-control" placeholder="Enter your name" id="name" name="name" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="email">Email: </label>
			<input type="email" class="form-control" placeholder="Enter your email" id="email" name="email" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="password">Password: </label>
			<input type="password" class="form-control" placeholder="Enter your password" id="password" name="password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="confirm">Confirm: </label>
			<input type="password" class="form-control" placeholder="Enter your password one more time" id="confirm" name="confirm" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="age">Age: </label>
			<input type="number" class="form-control" placeholder="Enter your age" id="age" name="age" min="1" max="150" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="gender">Gender: </label>
			<div>
				<input type="radio" id="male" name="gender" value="male">
				<label for="male">Male</label><br>
				<input type="radio" id="female" name="gender" value="female">
				<label for="female">Female</label><br>
			</div>
		</div>
		<div class="form-group">
			<label for="registrationNo">Registration No. (ex.011230-4444444): </label>
			<input type="text" class="form-control" placeholder="Enter your registration number" id="registrationNo" name="registrationNo" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="phoneNo">Phone No.: </label>
			<input type="tel" class="form-control" placeholder="Enter your phone number" id="phoneNo" name="phoneNo" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="bank">Bank: </label>
			<input type="text" class="form-control" placeholder="Enter your bank" id="bank" name="bank" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="accountNo">Account No.: </label>
			<input type="number" class="form-control" placeholder="Enter your account number" id="accountNo" name="accountNo" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="carPrice">Car Price: </label>
			<input type="number" class="form-control" placeholder="Enter your car price" id="carPrice" name="carPrice" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="housePrice">House Price: </label>
			<input type="number" class="form-control" placeholder="Enter your house price" id="housePrice" name="housePrice" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="drivingCareer">Driving Career: </label>
			<input type="number" class="form-control" placeholder="Enter your driving career" id="drivingCareer" name="drivingCareer" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group">
			<label for="shipPrice">Ship Price: </label>
			<input type="number" class="form-control" placeholder="Enter your ship price" id="shipPrice" name="shipPrice" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>
		<div class="form-group form-check">
      		<label class="form-check-label">
       			<input class="form-check-input" type="checkbox" name="remember" required> I agree to the collection of personal information
      			<div class="valid-feedback">Valid.</div>
      			<div class="invalid-feedback">Check this checkbox to continue.</div>
     		</label>
   		</div>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
</div>


<%@ include file="../common/footer.jsp"%>