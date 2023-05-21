package com.mju.insurance.dto.customer;

public class InsuranceLookupDTO {
	String name;
	long insuredAmountSum;
	long premiumSum;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public long getInsuredAmountSum() { return insuredAmountSum; }
	public void setInsuredAmountSum(long insuredAmountSum) { this.insuredAmountSum = insuredAmountSum; }
	public long getPremiumSum() { return premiumSum; }
	public void setPremiumSum(long premiumSum) { this.premiumSum = premiumSum; }
}
