package com.mju.insurance.common.enums;

public enum EHomeMenu {
	customer("CUSTOMER", "customer", "For customers who want to join, modify, or inquire insurance, click this button"),
	employee("EMPLOYEE", "employee", "For employees who want to join, modify, or inquire insurance, click this button");
	
	private String str;
	private String url;
	private String info;
	
	private EHomeMenu(String str, String url, String info) { this.str = str; this.url = url; this.info = info; }
	public String getStr() { return this.str; }
	public String getUrl() { return this.url; }
	public String getInfo() { return this.info; }
}
