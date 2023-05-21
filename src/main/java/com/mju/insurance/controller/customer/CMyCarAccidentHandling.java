package com.mju.insurance.controller.customer;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mju.insurance.common.exception.invalidInput.InvalidAccidentDateTimeException;
import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dto.customer.AccidentCarDTO;
import com.mju.insurance.dto.customer.AccidentPersonDTO;
import com.mju.insurance.dto.customer.MyCarAccidentHandlingDTO;
import com.mju.insurance.entity.carAccidentHandling.AccidentCar;
import com.mju.insurance.entity.carAccidentHandling.AccidentPerson;
import com.mju.insurance.entity.carAccidentHandling.CarAccidentHandling;
import com.mju.insurance.entity.carAccidentHandling.ECarAccidentHandlingState;
import com.mju.insurance.entity.contract.Contract;
import com.mju.insurance.service.customer.carAccidentHandling.SMyCarAccidentHandling;

@Controller
@RequestMapping(value = "/customer/car")
public class CMyCarAccidentHandling {	
	@Autowired SMyCarAccidentHandling sMyCarAccidentHandling;
	
	private String customerId;
	private String jspFolderName = "customer/myCarAccidentHandling/";

	@RequestMapping("")
	public String carAccidentHandlingHome(HttpServletRequest request) {
		this.customerId = (String) request.getSession().getAttribute("id");
		if(customerId == null) return "redirect:/auth/login";
		return jspFolderName + "myCarAccidentHandlingHome";
	}
	
	@RequestMapping("check")
	public String carAccidentHandlingCheck(HttpServletRequest request, Model model) {
		try {
			this.customerId = (String) request.getSession().getAttribute("id");
			if(customerId == null) return "redirect:/auth/login";
			
			ArrayList<MyCarAccidentHandlingDTO> dtos = new ArrayList<>();
			for(CarAccidentHandling carAccidentHandling : sMyCarAccidentHandling.getByCustomerId(customerId)) {
				MyCarAccidentHandlingDTO myCarAccidentHandlingDTO = new MyCarAccidentHandlingDTO();
				myCarAccidentHandlingDTO.setId(carAccidentHandling.getId());
				myCarAccidentHandlingDTO.setAccidentLocation(carAccidentHandling.getAccidentLocation());
				myCarAccidentHandlingDTO.setAccidentContent(carAccidentHandling.getAccidentContent());
				myCarAccidentHandlingDTO.setAccidentDate(carAccidentHandling.getAccidentDate());
				myCarAccidentHandlingDTO.setRequestDate(carAccidentHandling.getRequestDate());
				myCarAccidentHandlingDTO.setState(carAccidentHandling.getState());
				ArrayList<AccidentCarDTO> accidentCars = new ArrayList<>();
				for(AccidentCar accidentCar : carAccidentHandling.getAccidentCars()) {
					AccidentCarDTO dto = new AccidentCarDTO();
					dto.setCarNo(accidentCar.getCarNo());
					dto.setOwnerName(accidentCar.getOwnerName());
					dto.setOwnerPhoneNo(accidentCar.getOwnerPhoneNo());
					dto.setVisitedShopName(accidentCar.getVisitedShopName());
					accidentCars.add(dto);
				}
				myCarAccidentHandlingDTO.setAccidentCars(accidentCars);
				ArrayList<AccidentPersonDTO> accidentPeople = new ArrayList<>();
				for(AccidentPerson accidentPerson : carAccidentHandling.getAccidentPeople()) {
					AccidentPersonDTO dto = new AccidentPersonDTO();
					dto.setName(accidentPerson.getName());
					dto.setPhoneNo(accidentPerson.getPhoneNo());
					dto.setVisitedHospitalName(accidentPerson.getVisitedHospitalName());
					accidentPeople.add(dto);
				}
				myCarAccidentHandlingDTO.setAccidentPeople(accidentPeople);
				dtos.add(myCarAccidentHandlingDTO);
			}
			model.addAttribute("carAccidentHandlings", dtos);
		} catch (NullDataException e) {
			model.addAttribute("alert", e.getMessage());
		}
		return jspFolderName + "myCarAccidentHandlingList";
	}

	private ArrayList<AccidentCarDTO> carDtos;
	private ArrayList<AccidentPersonDTO> personDTOs;
	private Contract carContract;
	
	@RequestMapping("apply")
	public String carAccidentHandlingApply(HttpServletRequest request, RedirectAttributes re) {
		this.customerId = (String) request.getSession().getAttribute("id");
		if(customerId == null) return "redirect:/auth/login";
		try {
			this.carContract = sMyCarAccidentHandling.getCarContract(customerId);
			this.carDtos = new ArrayList<>();
			this.personDTOs = new ArrayList<>();
			return jspFolderName + "myCarAccidentHandlingApplication";
		} catch (NullDataException e) {
			re.addFlashAttribute("alert", e.getMessage());
			return "redirect:/customer";
		}
	}
	
	@RequestMapping(value = "apply", method = RequestMethod.POST)
	public String apply(HttpServletRequest request, RedirectAttributes re, Model model) {
		try {
			this.customerId = (String) request.getSession().getAttribute("id");
			if(customerId == null) return "redirect:/auth/login";
			MyCarAccidentHandlingDTO myCarAccidentHandlingDTO = new MyCarAccidentHandlingDTO();
			myCarAccidentHandlingDTO.setState(ECarAccidentHandlingState.ONREVIEW);
			myCarAccidentHandlingDTO.setRequestDate(LocalDateTime.now());
			LocalDateTime accidentDate = getLocalDateTime(request.getParameter("accidentDate"), request.getParameter("accidentTime"));
			checkInvalidDate(accidentDate);
			myCarAccidentHandlingDTO.setAccidentDate(accidentDate);			
			myCarAccidentHandlingDTO.setAccidentContent(request.getParameter("accidentContent"));
			myCarAccidentHandlingDTO.setAccidentLocation(request.getParameter("accidentLocation"));
			myCarAccidentHandlingDTO.setAccidentCars(this.carDtos);
			myCarAccidentHandlingDTO.setAccidentPeople(this.personDTOs);
			if(this.carDtos.size() == 0) {
				model.addAttribute("alert", "Need at least 1 car Info");
				return jspFolderName + "myCarAccidentHandlingApplication";
			} else if(this.personDTOs.size() == 0) {
				model.addAttribute("alert", "Need at least 1 person Info");
				return jspFolderName + "myCarAccidentHandlingApplication";
			}
			sMyCarAccidentHandling.applyCarAccidentHandling(myCarAccidentHandlingDTO, this.carContract.getId());
			return "redirect:/customer/car/check";
		} catch (InvalidAccidentDateTimeException e) {
			model.addAttribute("alert", e.getMessage());
		}
		return jspFolderName + "myCarAccidentHandlingApplication";
	}
	
	private void checkInvalidDate(LocalDateTime accidentDateTime) throws InvalidAccidentDateTimeException {
		if(accidentDateTime.isAfter(LocalDateTime.now())) {
			throw new InvalidAccidentDateTimeException();
		}
	}

	private LocalDateTime getLocalDateTime(String date, String time) {
		String[] dateArr = date.split("-");
		String[] timeArr = time.split(":");
		
		return LocalDateTime.of(
				Integer.parseInt(dateArr[0]),
				Integer.parseInt(dateArr[1]),
				Integer.parseInt(dateArr[2]),
				Integer.parseInt(timeArr[0]),
				Integer.parseInt(dateArr[1])
		);
	}

	@RequestMapping(value = "addCar", method = RequestMethod.POST)
	public String addCar(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		AccidentCarDTO carDto = new AccidentCarDTO();
		request.setCharacterEncoding("utf-8");
		carDto.setCarNo(request.getParameter("carNo"));
		carDto.setOwnerName(request.getParameter("ownerName"));
		carDto.setOwnerPhoneNo(request.getParameter("ownerPhoneNo"));
		carDto.setCost(Long.parseLong(request.getParameter("cost")));
		carDto.setVisitedShopName(request.getParameter("visitedShopName"));
		this.carDtos.add(carDto);
		model.addAttribute("accidentCars", carDtos);
		model.addAttribute("accidentPeople", personDTOs);
		return jspFolderName + "myCarAccidentHandlingApplication";
	}

	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	public String addPerson(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		AccidentPersonDTO personDto = new AccidentPersonDTO();
		request.setCharacterEncoding("utf-8");
		personDto.setName(request.getParameter("name"));
		personDto.setPhoneNo(request.getParameter("phoneNo"));
		personDto.setVisitedHospitalName(request.getParameter("visitedHospitalName"));
		this.personDTOs.add(personDto);
		model.addAttribute("accidentCars", carDtos);
		model.addAttribute("accidentPeople", personDTOs);
		return jspFolderName + "myCarAccidentHandlingApplication";
	}
}