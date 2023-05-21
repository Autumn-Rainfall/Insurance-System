package com.mju.insurance.service.customer.carAccidentHandling;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dao.carAccidentHandling.CarAccidentHandlingDao;
import com.mju.insurance.dao.contract.ContractDao;
import com.mju.insurance.dao.insurance.InsuranceDao;
import com.mju.insurance.dto.customer.AccidentCarDTO;
import com.mju.insurance.dto.customer.AccidentPersonDTO;
import com.mju.insurance.dto.customer.MyCarAccidentHandlingDTO;
import com.mju.insurance.entity.carAccidentHandling.AccidentCar;
import com.mju.insurance.entity.carAccidentHandling.AccidentPerson;
import com.mju.insurance.entity.carAccidentHandling.CarAccidentHandling;
import com.mju.insurance.entity.contract.Contract;
import com.mju.insurance.entity.insurance.Insurance;
import com.mju.insurance.entity.insurance.InsuranceCategory;

@Service
public class SMyCarAccidentHandlingImpl implements SMyCarAccidentHandling {
	@Autowired InsuranceDao insuranceDao;
	@Autowired CarAccidentHandlingDao carAccidentHandlingDao;
	@Autowired ContractDao contractDao;
	

    @Override
    public void applyCarAccidentHandling(MyCarAccidentHandlingDTO dto, String contractId) {
    	CarAccidentHandling carAccidentHandling = new CarAccidentHandling();
    	carAccidentHandling.setContractId(contractId);
    	carAccidentHandling.setRequestDate(dto.getRequestDate());
    	carAccidentHandling.setAccidentDate(dto.getAccidentDate());
    	carAccidentHandling.setAccidentContent(dto.getAccidentContent());
    	carAccidentHandling.setAccidentLocation(dto.getAccidentLocation());
    	ArrayList<AccidentCar> accidentCars = new ArrayList<>();
    	for(AccidentCarDTO accidentCarDto : dto.getAccidentCars()) {
    		AccidentCar accidentCar = new AccidentCar();
    		accidentCar.setCarNo(accidentCarDto.getCarNo());
    		accidentCar.setCost(accidentCarDto.getCost());
    		accidentCar.setOwnerName(accidentCarDto.getOwnerName());
    		accidentCar.setOwnerPhoneNo(accidentCarDto.getOwnerPhoneNo());
    		accidentCar.setVisitedShopName(accidentCarDto.getVisitedShopName());
    		accidentCars.add(accidentCar);
    	}
    	carAccidentHandling.setAccidentCars(accidentCars);    	
    	ArrayList<AccidentPerson> accidentPeople = new ArrayList<>();
    	for(AccidentPersonDTO accidentPersonDTO : dto.getAccidentPeople()) {
    		AccidentPerson accidentPerson = new AccidentPerson();
    		accidentPerson.setName(accidentPersonDTO.getName());
    		accidentPerson.setPhoneNo(accidentPersonDTO.getPhoneNo());
    		accidentPerson.setVisitedHospitalName(accidentPersonDTO.getVisitedHospitalName());
    		accidentPeople.add(accidentPerson);
    	}
    	carAccidentHandling.setAccidentPeople(accidentPeople);
    	carAccidentHandling.setState(dto.getState());
        carAccidentHandlingDao.create(carAccidentHandling);
    }
    
	@Override
	public ArrayList<CarAccidentHandling> getByCustomerId(String customerId) throws NullDataException {
		ArrayList<CarAccidentHandling> carAccidentHandlings = new ArrayList<>();
		for(CarAccidentHandling c : carAccidentHandlingDao.getCarAccidentHandlings()) {
			Contract contract = contractDao.getContractById(c.getContractId());
			if(contract.getCustomerId().equals(customerId)) {
				carAccidentHandlings.add(c);
			}
		}
		if(carAccidentHandlings.size() == 0) throw new NullDataException("Car Accident Handling");
		return carAccidentHandlings;
	}
	
	@Override
	public Contract getCarContract(String customerId) throws NullDataException {
		ArrayList<Contract> customerContracts = contractDao.getByCustomerId(customerId);
		for(Contract contract : customerContracts) {
			Insurance insurance = insuranceDao.getById(contract.getInsuranceId());
			if(insurance.getInsuranceCategory() == InsuranceCategory.CAR) {
				if(!isMatured(contract)) return contract;
			}
		} throw new NullDataException("Car Contract");
	}
	
	private boolean isMatured(Contract contract) {
		return contract.getExpirationDateTime().isBefore(LocalDateTime.now());
	}
}
