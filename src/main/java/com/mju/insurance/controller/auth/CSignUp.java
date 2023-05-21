package com.mju.insurance.controller.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mju.insurance.common.exception.duplicatedInput.DuplicatedInfoException;
import com.mju.insurance.common.exception.invalidInput.InvalidConfirmException;
import com.mju.insurance.dto.auth.SignUpDTO;
import com.mju.insurance.service.auth.signup.SSignUp;

@Controller
@RequestMapping(value = "/auth")
public class CSignUp {
	
	@Autowired SSignUp sSignUp;
	
	@RequestMapping("/signup") public String signupForm() { return "auth/signUp"; }
	
	private final String mAlert = "alert";
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(HttpServletRequest request, Model model) {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			if(sSignUp.isEmailDuplicated(email)) throw new DuplicatedInfoException("email", email);
			String password = request.getParameter("password");
			String confirm = request.getParameter("confirm");
			if(!password.equals(confirm)) throw new InvalidConfirmException();
			int age = Integer.parseInt(request.getParameter("age"));
			boolean gender = request.getParameter("gender").equals("male") ? true : false;
			String registrationNo = request.getParameter("registrationNo");
	        if(sSignUp.isRegistrationNoDuplicated(registrationNo)) throw new DuplicatedInfoException("registrationNo", registrationNo);
			String phoneNo = request.getParameter("phoneNo");
	        if(sSignUp.isPhoneNoDuplicated(phoneNo)) throw new DuplicatedInfoException("phoneNo", phoneNo);
			String bank = request.getParameter("bank");
			String accountNo = bank + " " + request.getParameter("accountNo");
			long carPrice = Long.parseLong(request.getParameter("carPrice"));
			long housePrice = Long.parseLong(request.getParameter("housePrice"));
			int drivingCareer = Integer.parseInt(request.getParameter("drivingCareer"));
			long shipPrice = Long.parseLong(request.getParameter("shipPrice"));
			if(!sSignUp.signUp(new SignUpDTO(name, email, password, age, gender, registrationNo, phoneNo, accountNo, carPrice, housePrice, drivingCareer, shipPrice)))
				model.addAttribute(mAlert, "Sign Up Failed");
			return "redirect:/auth/login";
		} catch (InvalidConfirmException e) { model.addAttribute(mAlert, e.getMessage()); }
		catch (DuplicatedInfoException e) { model.addAttribute(mAlert, e.getMessage()); }
		return "auth/signUp";
	}
}
