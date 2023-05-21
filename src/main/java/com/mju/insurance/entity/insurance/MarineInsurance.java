package com.mju.insurance.entity.insurance;

import com.mju.insurance.entity.customer.Customer;

public class MarineInsurance extends Insurance {

	public MarineInsurance() {
		this.setInsuranceCategory(InsuranceCategory.MARINE);
	}
	
	public double calculateRatio(Customer customer) {
		long shipPrice = customer.getAdditionalInfo().getShipPrice();
		if(shipPrice < 700000000L) return 1.0;
		else if(shipPrice < 700000000L) return 1.2;
		else if(shipPrice < 1000000000L) return 1.3;
		else if(shipPrice < 5000000000L) return 1.5;
		else return 1.8;
	}
}
