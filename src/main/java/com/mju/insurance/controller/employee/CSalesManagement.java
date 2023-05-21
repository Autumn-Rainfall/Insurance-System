package com.mju.insurance.controller.employee;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mju.insurance.common.exception.invalidInput.InvalidException;
import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dto.employee.SalesCustomerDTO;
import com.mju.insurance.dto.employee.SalesInsuranceDTO;
import com.mju.insurance.entity.contract.Contract;
import com.mju.insurance.entity.customer.Customer;
import com.mju.insurance.entity.insurance.Clause;
import com.mju.insurance.entity.insurance.Insurance;
import com.mju.insurance.service.employee.salesManagement.SSalesManagement;

@Controller
public class CSalesManagement {
	Insurance insurance;
	Customer customer;
	int totalPaymentMonth;
	Contract contract;
	
	@Autowired SSalesManagement sSalesManagement;

	@RequestMapping(value = "/employee/salesManagement")
	public String salesManagement() {
		return "/employee/salesManagement/salesManagementHome";
	}

	@RequestMapping(value = "/employee/salesManagement/salesActivity")
	public String salesActivity() {
		return "/employee/salesManagement/salesActivity";
	}

	@GetMapping(value = "/employee/salesManagement/insuranceResult")
	public String salesActivity(Model model, HttpServletRequest request) {
		String insName = request.getParameter("insName");
		try {
			this.insurance = sSalesManagement.getInsuranceByName(insName);
			ArrayList<Clause> clauses = insurance.getClauses();
			ArrayList<SalesInsuranceDTO> dtos = new ArrayList<>();
			SalesInsuranceDTO salesInsuranceDTO = new SalesInsuranceDTO();
			salesInsuranceDTO.setId(insurance.getId());
			salesInsuranceDTO.setName(insurance.getName());
			salesInsuranceDTO.setCategory(insurance.getInsuranceCategory());
			salesInsuranceDTO.setState(insurance.getInsuranceState());
			dtos.add(salesInsuranceDTO);
			model.addAttribute("clauses", clauses);
			model.addAttribute("insuranceInfo", dtos);
			return "/employee/salesManagement/insuranceResult";
		} catch (NullDataException e) {
			model.addAttribute("alert", e.getMessage());
			return "/employee/salesManagement/insuranceResult";
		}
	}

	@PostMapping(value = "/employee/salesManagement/customerResult")
	public String customerResult(Model model, HttpServletRequest request) {
		String customerEmail = request.getParameter("customerEmail");
		try {
			this.customer = sSalesManagement.getCustomerByEmail(customerEmail);
			ArrayList<SalesCustomerDTO> dtos = new ArrayList<>();
			SalesCustomerDTO salesCustomerDTO = new SalesCustomerDTO();
			salesCustomerDTO.setName(customer.getName());
			salesCustomerDTO.setAge(customer.getAge());
			salesCustomerDTO.setGender(customer.getGender() ? "남성" : "여성");
			dtos.add(salesCustomerDTO);
			model.addAttribute("customerInfo", dtos);
			return "/employee/salesManagement/customerResult";
		} catch (InvalidException e) {
			model.addAttribute("alert", e.getMessage());
			return "/employee/salesManagement/customerResult";
		}
	}

	@PostMapping(value = "/employee/salesManagement/calculateResult")
	public String calculateResult(Model model, HttpServletRequest request) {
		totalPaymentMonth = Integer.parseInt(request.getParameter("totalPaymentMonth"));
		long insurancePremium = sSalesManagement.getInsurancePremium(this.insurance, this.customer, totalPaymentMonth);
		long insuredAmount = sSalesManagement.getInsuredAmount(this.insurance, this.customer);
		model.addAttribute("insuranceName", this.insurance.getName());
		model.addAttribute("insurancePremium", insurancePremium);
		model.addAttribute("insuredAmount", insuredAmount);
		return "/employee/salesManagement/calculateResult";
	}

	@GetMapping(value = "/employee/salesManagement/yes")
	public String join() {
		this.contract = new Contract();
		String insuranceId = this.insurance.getId();
		String customerId = this.customer.getId();
		LocalDateTime contractDateTime = LocalDateTime.now();
		LocalDateTime expirationDateTime = LocalDateTime.now().plusMonths(this.totalPaymentMonth);
		this.contract.setInsuranceId(insuranceId);
		this.contract.setCustomerId(customerId);
		this.contract.setContractDateTime(contractDateTime);
		this.contract.setExpirationDateTime(expirationDateTime);
		sSalesManagement.joinInsurance(this.contract);
		return "redirect:/";
	}

	@GetMapping(value = "/employee/salesManagement/no")
	public String cancel() {
		return "redirect:/";
	}
}