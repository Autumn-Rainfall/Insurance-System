package com.mju.insurance.service.employee.salesManagement;

import com.mju.insurance.common.exception.invalidInput.InvalidException;
import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.entity.contract.Contract;
import com.mju.insurance.entity.customer.Customer;
import com.mju.insurance.entity.insurance.Insurance;

public interface SSalesManagement {

//	ArrayList<Contract> getAllContract();
	Insurance getInsuranceByName(String name) throws NullDataException;
	Customer getCustomerByEmail(String email) throws InvalidException;
	long getInsurancePremium(Insurance insurance, Customer customer, int totalPaymentMonth);
	long getInsuredAmount(Insurance insurance, Customer customer);
	boolean joinInsurance(Contract contract);
//	Insurance getInsurance(String id);
//	boolean requestUW(Contract contract, ArrayList<UWDocument> documents);
//	ArrayList<ConsultApplication> getAllConsultApplication();
//	boolean updateConsultApplication(ConsultApplication consultApplication);
//	boolean updateContract(Contract contract);
//	Customer getCustomer(String id);
//	ConsultApplication getConsultApplication(String id);
//	ArrayList<Contract> getAllContractRegister();
//	Contract getContract(String id);
//	UW getUW(Contract contract);
}
