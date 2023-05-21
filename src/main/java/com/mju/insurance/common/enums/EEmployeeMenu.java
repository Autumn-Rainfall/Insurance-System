package com.mju.insurance.common.enums;

public enum EEmployeeMenu {
	insuranceManagement("Insurance Management", "insuranceManagement"),
	contractManagement("Contract Management", "contractManagement"),
	uWManagement("UW", "uWManagement"),
	salesManagement("Sales Management", "salesManagement"),
	benefitPaymentManagement("Benefit Payment Management", "benefitPaymentManagement"),
	carAccidentHandlingManagement("CarAccidentHandling Management", "carAccidentHandlingManagement");
	
	private String str;
	private String url;
	
	private EEmployeeMenu(String str, String url) { this.str = str; this.url = url; }
	public String getStr() { return this.str; }
	public String getUrl() { return this.url; }
}