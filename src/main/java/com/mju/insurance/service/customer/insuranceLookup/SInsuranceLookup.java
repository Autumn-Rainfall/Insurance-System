package com.mju.insurance.service.customer.insuranceLookup;

import java.util.ArrayList;

import com.mju.insurance.common.exception.nullException.NullDataException;
import com.mju.insurance.entity.insurance.Insurance;
import com.mju.insurance.entity.insurance.InsuranceCategory;

public interface SInsuranceLookup {
    ArrayList<Insurance> getInsurancesOnSale() throws NullDataException;
    ArrayList<Insurance> getOnSaleInsuranceByCategory(InsuranceCategory insuranceCategory) throws NullDataException;
	long getInsuredAmountSum(Insurance insurance);
	long getPremiumSum(Insurance insurance);
}
