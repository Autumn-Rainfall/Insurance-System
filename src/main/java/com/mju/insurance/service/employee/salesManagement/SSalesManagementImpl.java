package com.mju.insurance.service.employee.salesManagement;
//import java.util.ArrayList;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.insurance.common.exception.invalidInput.InvalidException;
import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dao.contract.ContractDao;
import com.mju.insurance.dao.customer.CustomerDao;
import com.mju.insurance.dao.insurance.InsuranceDao;
import com.mju.insurance.entity.contract.Contract;
import com.mju.insurance.entity.customer.Customer;
import com.mju.insurance.entity.insurance.Clause;
import com.mju.insurance.entity.insurance.Insurance;

//import com.mju.insurance.entity.consultApplication.ConsultApplication;
//import com.mju.insurance.entity.contract.Contract;
//import com.mju.insurance.entity.contract.ContractState;
//import com.mju.insurance.entity.customer.Customer;
//import com.mju.insurance.entity.insurance.Clause;
//import com.mju.insurance.entity.insurance.Insurance;
//import com.mju.insurance.entity.uw.UW;
//import com.mju.insurance.entity.uw.UWDocument;
//import com.mju.insurance.entity.uw.UWState;

@Service
public class SSalesManagementImpl implements SSalesManagement {
//	 private static final ContractRepository contractRepository = ContractRepository.getInstance();
//	 private static final ConsultApplicationRepository consultApplicationRepository = ConsultApplicationRepository.getInstance();
//	 private static final CustomerRepository customerRepository = CustomerRepository.getInstance();
//	 private static final UWRepository uwRepository = UWRepository.getInstance();
	@Autowired
	InsuranceDao insuranceDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ContractDao contractDao;

	@Override
	public Insurance getInsuranceByName(String name) throws NullDataException {
		return insuranceDao.getByName(name);
	}

	@Override
	public Customer getCustomerByEmail(String email) throws InvalidException {
		return customerDao.getByEmail(email);
	}
	
	@Override
	public boolean joinInsurance(Contract contract) { return ContractDao.add(contract); }
//	 @Override
//	 public ArrayList<Contract> getAllContract() {
//		 return contractRepository.getAll();
//	 }

//	 @Override
//	 public Insurance getInsurance(String id) {
//		 return insuranceRepository.get(id);
//	 }
//	 
//	 @Override
//	 public boolean requestUW(Contract contract, ArrayList<UWDocument> documents) {
//		 contract.setState(ContractState.UNDER_UW);
//		 String contractId = this.addContractAndGetId(contract);
//		 
//		 UW uw = new UW();
//		 uw.setDocuments(documents);
//		 uw.setUwState(UWState.UNDER_AUDIT);
//		 uw.setContractId(contractId);
//		 return uwRepository.add(uw);
//	 }
//	 
//	 @Override
//	 public ArrayList<ConsultApplication> getAllConsultApplication() {
//		 return consultApplicationRepository.getAll();
//	 }
//	 @Override
//	 public boolean updateConsultApplication(ConsultApplication consultApplication) {
//		 return consultApplicationRepository.update(consultApplication);
//	 }
//	 @Override
//	 public boolean updateContract(Contract contract) {
//		 return contractRepository.update(contract);
//	 }
//	 @Override
//	 public Customer getCustomer(String id) {
//		 return customerRepository.get(id);
//	 }
//	 
	@Override
	public long getInsuredAmount(Insurance insurance, Customer customer) {
		ArrayList<Clause> clauses = insurance.getClauses();
		long insuredAmount = 0;
		for (Clause clause : clauses) insuredAmount += clause.getInsuredAmount();
		return insuredAmount;
	}

	@Override
	public long getInsurancePremium(Insurance insurance, Customer customer, int totalPaymentMonth) {
		ArrayList<Clause> clauses = insurance.getClauses();
		long premium = 0;
		for (Clause clause : clauses) premium += clause.getPremium();
		double ratio = insurance.calculateRatio(customer);
		return (long) (premium * ratio) / totalPaymentMonth;
	}
//	 @Override
//	 public ConsultApplication getConsultApplication(String id) {
//		 return consultApplicationRepository.get(id);
//	 }
//	public String addContractAndGetId(Contract contract) {
//		return contractRepository.addAndGetId(contract);
//	}
//	@Override
//	public ArrayList<Contract> getAllContractRegister() {
//		ArrayList<Contract> contracts = contractRepository.getAll();
//		ArrayList<Contract> contractRegisters = new ArrayList<Contract>();
//		for(Contract contract: contracts) {
//			if(contract.getState() == ContractState.UNDER_UW) contractRegisters.add(contract);
//		}
//		return contractRegisters;
//	}
//	@Override
//	public Contract getContract(String id) {
//		return contractRepository.get(id);
//	}
//	@Override
//	public UW getUW(Contract contract) {
//		ArrayList<UW> UWs = uwRepository.getAll();
//		for(UW uw: UWs) {
//			if(uw.getContractId().equals(contract.getId())) {
//				return uw;
//			}
//		}
//		return null;
//	}

}
