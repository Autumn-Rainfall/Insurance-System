package com.mju.insurance.service.customer.insuranceLookup;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.dao.insurance.InsuranceDao;
import com.mju.insurance.entity.insurance.Clause;
import com.mju.insurance.entity.insurance.Insurance;
import com.mju.insurance.entity.insurance.InsuranceCategory;
import com.mju.insurance.entity.insurance.InsuranceState;

@Service
public class SInsuranceLookupImpl implements SInsuranceLookup {
	
	@Autowired
	private InsuranceDao insuranceDao;

	@Override
	public ArrayList<Insurance> getInsurancesOnSale() throws NullDataException {
		ArrayList<Insurance> insurances = (ArrayList<Insurance>) insuranceDao.getInsurances();
		ArrayList<Insurance> filtered = (ArrayList<Insurance>) insurances.stream()
				.filter(insurance -> insurance.getInsuranceState().equals(InsuranceState.ON_SALE))
				.collect(Collectors.toList());
		return filtered;
	}
	
	@Override
	public ArrayList<Insurance> getOnSaleInsuranceByCategory(InsuranceCategory insuranceCategory) throws NullDataException {
		ArrayList<Insurance> insurances = getInsurancesOnSale();
		if(insuranceCategory == null) return insurances;
		ArrayList<Insurance> filtered = (ArrayList<Insurance>) insurances.stream()
				.filter(insurance -> insurance.getInsuranceCategory().equals(insuranceCategory))
				.collect(Collectors.toList());
		if(filtered.size() == 0) throw new NullDataException("Insurance");
		return filtered;
	}
	
	@Override
	public long getInsuredAmountSum(Insurance insurance) {
		ArrayList<Clause> clauses = insurance.getClauses();
		long sum = 0;
        for(Clause clause : clauses) {
            sum += clause.getInsuredAmount();
        }
        return sum;
	}
	
	@Override
	public long getPremiumSum(Insurance insurance) {
		ArrayList<Clause> clauses = insurance.getClauses();
		long sum = 0;
        for(Clause clause : clauses) {
            sum += clause.getPremium();
        }
        return sum;
	}
}
