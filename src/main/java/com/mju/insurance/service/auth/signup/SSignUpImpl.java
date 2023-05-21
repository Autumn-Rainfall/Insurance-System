package com.mju.insurance.service.auth.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.insurance.common.enums.ECustomerColumn;
import com.mju.insurance.dao.customer.CustomerDao;
import com.mju.insurance.dto.auth.SignUpDTO;
import com.mju.insurance.entity.customer.AdditionalInfo;
import com.mju.insurance.entity.customer.Customer;

@Service
public class SSignUpImpl implements SSignUp {
    
	@Autowired private CustomerDao customerDao;

	@Override
	public boolean signUp(SignUpDTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setPassword(dto.getPassword());
		customer.setAge(dto.getAge());
		customer.setGender(dto.getGender());
		customer.setRegistrationNo(dto.getRegistrationNo());
		customer.setPhoneNo(dto.getPhoneNo());
		customer.setAccountNo(dto.getAccountNo());
		AdditionalInfo additionalInfo = new AdditionalInfo();
		additionalInfo.setCarPrice(dto.getCarPrice());
		additionalInfo.setHousePrice(dto.getHousePrice());
		additionalInfo.setDrivingCareer(dto.getDrivingCareer());
		additionalInfo.setShipPrice(dto.getShipPrice());
		customer.setAdditionalInfo(additionalInfo);
		return customerDao.createCustomer(customer);
	}
	
	@Override
	public boolean isEmailDuplicated(String email) {
		return (customerDao.getCustomerByColumnName(ECustomerColumn.email.getStr(), email) != null);
	}
	
	@Override
	public boolean isRegistrationNoDuplicated(String registrationNo) {
		return (customerDao.getCustomerByColumnName(ECustomerColumn.registrationNo.getStr(), registrationNo) != null);
	}
	
	@Override
	public boolean isPhoneNoDuplicated(String phoneNo) {
		return (customerDao.getCustomerByColumnName(ECustomerColumn.phoneNo.getStr(), phoneNo) != null);
	}
}
