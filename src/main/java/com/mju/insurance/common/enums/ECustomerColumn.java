package com.mju.insurance.common.enums;

public enum ECustomerColumn {
	id("id"),
	email("email"),
	registrationNo("registration_no"),
	phoneNo("phone_no"),
	name("name");
	
	private String str;
	
	private ECustomerColumn(String str) { this.str = str; }
	public String getStr() { return this.str; }
}
