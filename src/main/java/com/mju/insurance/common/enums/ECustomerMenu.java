package com.mju.insurance.common.enums;

public enum ECustomerMenu {
	consultApplicationManagement("Management of consultation applications", "cons"),
	contractsManagement("Management my insurance / Termination Contract", "cont"),
	carAccidentHandlingManagement("Management of Accident handling", "car"),
	benefitPaymentManagement("Management of insurance claim", "ben");
	
	private String str;
	private String url;
	
	private ECustomerMenu(String str, String url) { this.str = str; this.url = url; }
	public String getStr() { return this.str; }
	public String getUrl() { return this.url; }
}
