package com.mju.insurance.controller.customer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mju.insurance.common.enums.EInsuranceListMenu;
import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dto.customer.InsuranceLookupDTO;
import com.mju.insurance.entity.insurance.Insurance;
import com.mju.insurance.entity.insurance.InsuranceCategory;
import com.mju.insurance.service.customer.insuranceLookup.SInsuranceLookup;

@Controller
@RequestMapping(value = "/customer/ins")
public class CInsuranceLookup {
	
	@Autowired SInsuranceLookup sInsuranceLookup;
	
	@RequestMapping("")
	public String insuranceList(@RequestParam(value = "category") String categoryStr, Model model) {
		try {
			model.addAttribute("category", categoryStr);
			InsuranceCategory category = null;
			if(categoryStr.equals(EInsuranceListMenu.marine.getUrl())) category = InsuranceCategory.MARINE;
			if(categoryStr.equals(EInsuranceListMenu.car.getUrl())) category = InsuranceCategory.CAR;
			if(categoryStr.equals(EInsuranceListMenu.driver.getUrl())) category = InsuranceCategory.DRIVER;
			if(categoryStr.equals(EInsuranceListMenu.fire.getUrl())) category = InsuranceCategory.FIRE;
			ArrayList<Insurance> insurances = sInsuranceLookup.getOnSaleInsuranceByCategory(category);
			
			ArrayList<InsuranceLookupDTO> dtos = new ArrayList<>();
			for(Insurance insurance : insurances) {
				InsuranceLookupDTO dto = new InsuranceLookupDTO();
				dto.setName(insurance.getName());
				dto.setInsuredAmountSum(sInsuranceLookup.getInsuredAmountSum(insurance));
				dto.setPremiumSum(sInsuranceLookup.getPremiumSum(insurance));
				dtos.add(dto);
			}
			
			model.addAttribute("insurances", dtos);
		} catch(NullDataException e) {
			model.addAttribute("alert", e.getMessage());
		}
		return "customer/insuranceLookup";
	}
}
