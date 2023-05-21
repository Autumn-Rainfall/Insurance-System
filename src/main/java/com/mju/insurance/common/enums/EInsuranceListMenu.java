package com.mju.insurance.common.enums;

public enum EInsuranceListMenu {
	marine("Marine Insurance", "marine"),
	car("Automobile Insurance", "car"),
	driver("Driver Insurance", "driver"),
	fire("Fire Insurance", "fire"),
	all("All Insurance", "all");
	
	private String str;
	private String url;
	
	private EInsuranceListMenu(String str, String url) { this.str = str; this.url = url; }
	public String getStr() { return this.str; }
	public String getUrl() { return this.url; }
}
