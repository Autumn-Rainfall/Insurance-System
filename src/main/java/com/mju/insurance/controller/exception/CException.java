package com.mju.insurance.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CException {
	
	@GetMapping("/error")
	public String error() {
		return "exception/error";
	}
}
