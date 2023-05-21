package com.mju.insurance.controller.customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mju.insurance.common.exception.nullException.NullInputException;
import com.mju.insurance.dto.customer.ApplicationConsultationDTO;
import com.mju.insurance.dto.customer.ConsultationLookupDTO;
import com.mju.insurance.service.customer.consultApplication.SMyConsultApplication;

@Controller
@RequestMapping(value = "/customer/cons")
public class CApplicationConsultation {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	@Autowired
	SMyConsultApplication sMyConsultApplication;

	@RequestMapping("")
	public String applicationConsultationHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("id");
		if (customerId == null)
			return "redirect:/auth/login";
		return "customer/consultApplicationHome";
	}

	@RequestMapping("/apply")
	public String applyConsultation() {
		return "customer/applicationConsultation";
	}

	private String getInputAndCheckInvalid(HttpServletRequest request, String name) throws NullInputException {
		String input = request.getParameter(name);
		if (input.equals(""))
			throw new NullInputException(name);
		return input;
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String signUp(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		model.addAttribute("url", "/insurance/customer");
		try {
			String customerId = (String) session.getAttribute("id");
			String content = getInputAndCheckInvalid(request, "content");
			String cday = getInputAndCheckInvalid(request, "cday");
			String ctime = getInputAndCheckInvalid(request, "ctime");
			LocalDateTime consultationDate = LocalDateTime.parse(cday + "T" + ctime + ":00");
//			String nowDateTime = LocalDateTime.now().format(formatter);
//			LocalDateTime consultationDate = LocalDateTime.parse(nowDateTime);
//			LocalDateTime consultationDate = LocalDateTime.now();
			if (!sMyConsultApplication.applyConsultation(new ApplicationConsultationDTO(customerId, content, consultationDate)))
				model.addAttribute("mAlert", "Apply Failed");
			else model.addAttribute("mAlert", "Apply Success");
			return "common/alert";
//			return "redirect:/customer";
		} catch (NullInputException e) {
			model.addAttribute("mAlert", e.getMessage());
		}
		return "customer/applicationConsultation";
	}

	@RequestMapping(value = "/check")
	public String insuranceList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("id");
		ArrayList<ConsultationLookupDTO> consultationList = sMyConsultApplication.getByCustomerId(customerId);
//		ArrayList<ConsultationLookupDTO> dtos = new ArrayList<>();
//		for (ConsultApplication consultation : consultationList) {
//			ConsultationLookupDTO dto = new ConsultationLookupDTO();
//			dto.setContent(consultation.getContent());
//			dto.setApplicationDate(consultation.getApplicationDate());
//			dto.setConsultationDate(consultation.getConsultationDate());
//			dto.setState((ConsultApplicationState) consultation.getState());
//			dtos.add(dto);
//		}
		model.addAttribute("consultationList", consultationList);
		return "customer/consultationLookup";
	}
		
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deletePOST(HttpServletRequest request, Model model) throws Exception {
		try {
			String id = getInputAndCheckInvalid(request, "id");
			model.addAttribute("url", "/insurance/customer");
			if (!sMyConsultApplication.deleteMyConsultation(id))
				model.addAttribute("mAlert", "Delete Failed");
			else model.addAttribute("mAlert", "Delete Success");
			return "common/alert";
		} catch (NullInputException e) {
			model.addAttribute("mAlert", e.getMessage());
		}		return "customer/applicationConsultation";
	}
}
