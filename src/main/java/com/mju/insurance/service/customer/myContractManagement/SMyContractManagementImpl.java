package com.mju.insurance.service.customer.myContractManagement;

import org.springframework.stereotype.Service;

@Service
public class SMyContractManagementImpl implements SMyContractManagement {
//	private static final ContractRepository contractRepository = ContractRepository.getInstance();
//    private static final InsuranceRepository insuranceRepository = InsuranceRepository.getInstance();
//	
//	@Override
//	public ArrayList<Contract> getCustomerContracts(String customerId) {
//		return contractRepository.getByCustomerId(customerId);
//	}
//
//	@Override
//	public long getMonthlyPremium(Contract contract, Insurance insurance, Customer customer) {
//		ArrayList<Clause> clauses = insurance.getClauses();
//		long premiumSum = 0;
//		for(Clause clause: clauses) premiumSum += clause.getPremium();
//		double ratio = insurance.calculateRatio(customer);
//		LocalDateTime contractDateTime = contract.getContractDateTime();
//		LocalDateTime expirationDateTime = contract.getExpirationDateTime();
//		long month = ChronoUnit.MONTHS.between(contractDateTime, expirationDateTime);
//		
//		return (long) ((premiumSum * ratio) / month);
//	}
//	
//	@Override
//	public Contract getUnmaturedContractByCategory(String customerId, InsuranceCategory insuranceCategory) {
//		ArrayList<Contract> customerContracts = contractRepository.getByCustomerId(customerId);
//		for(Contract contract : customerContracts) {
//			Insurance insurance = insuranceRepository.get(contract.getInsuranceId());
//			if(insurance.getInsuranceCategory() == insuranceCategory) {
//				if(!isMatured(contract)) return contract;
//			}
//		}
//		return null;
//	}
//	
//	private boolean isMatured(Contract contract) {
//		return contract.getExpirationDateTime().isBefore(LocalDateTime.now());
//	}
}
