package com.mju.insurance.controller.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mju.insurance.common.enums.EMessage;
import com.mju.insurance.common.exception.nullException.NullInputException;
import com.mju.insurance.dto.auth.LoginDTO;
import com.mju.insurance.entity.customer.Customer;
import com.mju.insurance.service.auth.login.SLogin;

@Controller
@RequestMapping(value = "/auth")
public class CLogin {
	
	@Autowired SLogin sLogin;
	
	@RequestMapping("/login") public String loginForm() { return "auth/login"; }

    // Get Input and Check whether null or not
	private String getInputAndCheckInvalid(HttpServletRequest request, String name) throws NullInputException {
		String input = request.getParameter(name);
		if(input.equals("")) throw new NullInputException(name);
		return input;
	}
	
	private final String mAlert = "alert";	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, RedirectAttributes re) {
		try {
			String email = getInputAndCheckInvalid(request, "email");
			String password = getInputAndCheckInvalid(request, "password");
			Customer customer = sLogin.login(new LoginDTO(email, password));
			if(customer == null) re.addFlashAttribute(mAlert, EMessage.loginFailed.getStr());
			else {
				request.getSession().setAttribute("id", customer.getId());
				return "redirect:/";
			}
		} catch (NullInputException e) { re.addFlashAttribute(e.getMessage()); }
		return "redirect:/auth/login";
	}
}
