package com.mju.insurance.service.employee.contractManagement;

import org.springframework.stereotype.Service;

@Service
public class SContractManagementImpl implements SContractManagement{
//	 private static final ContractRepository contractRepository = ContractRepository.getInstance();
//	 private static final CancelApplicationRepository cancelApplicationRepository = CancelApplicationRepository.getInstance();
//	 
//	@Autowired
//	private CustomerDao customerDao;
//	 
//	 public ArrayList<Contract> getAllContracts() {
//		 ArrayList<Contract> contracts = contractRepository.getAll();
//	     return contracts;
//	 }
//	
//	 public ArrayList<Contract> getAllMatureContracts() {
//		 ArrayList<Contract> matureContracts = new ArrayList<>();
//		 ArrayList<Contract> contracts = contractRepository.getAll();
//		 for (Contract contract: contracts) { 
//			 long difference = ChronoUnit.MONTHS.between(LocalDateTime.now(), contract.getExpirationDateTime());
//			 if (difference <= 1) {
//				 matureContracts.add(contract);
//			 }
//		 }
//		 return matureContracts;
//	 }
//	 
//	 public boolean deleteContract(String id) {
//		 return contractRepository.delete(id);
//	 }
//	 
//	 public ArrayList<CancelApplication> getAllCancelApplications(){
//		 return cancelApplicationRepository.getAll();
//	 }
//	 
//	@Override
//	public Contract getContract(String id) {
//		return contractRepository.get(id);
//	}
//	
//	@Override
//	public Insurance getInsurance(String id) {
//		InsuranceRepository insuranceRepository = InsuranceRepository.getInstance(); 
//		return insuranceRepository.get(id);
//	}
//	
//	@Override
//	public Customer getCustomer(String id) {
//		return customerDao.getCustomerByColumnName(ECustomerColumn.id.getStr(), id);
//	}
//	
//	@Override
//	public CancelApplication getCancelApplication(String id) {
//		return cancelApplicationRepository.get(id);
//	}
//	
//	@Override
//	public boolean updateCancelApplication(CancelApplication cancelApplication) {
//		return cancelApplicationRepository.update(cancelApplication);
//	}
}
