package com.mju.insurance.service.customer.benefitPayment;

import org.springframework.stereotype.Service;

@Service
public class SMyBenefitPaymentImpl implements SMyBenefitPayment {
//    private static final BenefitPaymentRepository benefitPaymentRepository = BenefitPaymentRepository.getInstance();
//    private static final ContractRepository contractRepository = ContractRepository.getInstance();
//	
//	@Override
//	public boolean applyBenefitPayment(BenefitPayment benefitPayment) {
//		return benefitPaymentRepository.create(benefitPayment);
//	}
//
//	@Override
//	public boolean revokeMyBenefitPayment(String id, String customerId) {
//		BenefitPayment benefitPayment = benefitPaymentRepository.getById(id);
//		if(benefitPayment == null) return false;
//		Contract contract = contractRepository.get(benefitPayment.getContractId());
//		if(contract.getCustomerId().equals(customerId)) return benefitPaymentRepository.delete(id);
//		return false;
//	}
//	
//	@Override
//	public ArrayList<BenefitPayment> getByCustomerId(String customerId) {
//		ArrayList<BenefitPayment> benefitPayments = new ArrayList<>();
//		for(BenefitPayment b : benefitPaymentRepository.getAll()) {
//			Contract contract = contractRepository.get(b.getContractId());
//			if(contract.getCustomerId().equals(customerId)) {
//				benefitPayments.add(b);
//			}
//		}
//		return benefitPayments;
//	}
}
