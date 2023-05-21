package com.mju.insurance.common.enums;

public enum EMyCarAccidentHandlingHome {
	applyCarAccidentHandling("Apply for a car accident handling", "apply"),
	checkCarAccidentHandling("Check my car accident handling list", "check"),
	deleteCarAccidentHandling("Delete my car accident handling", "cancel");
	
	private String str;
	private String url;
	
	private EMyCarAccidentHandlingHome(String str, String url) { this.str = str; this.url = url; }
	public String getStr() { return this.str; }
	public String getUrl() { return this.url; }
}
