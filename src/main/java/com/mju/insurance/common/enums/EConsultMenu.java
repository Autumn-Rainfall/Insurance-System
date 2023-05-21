package com.mju.insurance.common.enums;

public enum EConsultMenu {
	applyConsultation("Apply for an insurance consultation", "apply"),
	checkMyConsultation("Check my consultation list", "check"),
	deleteMyConsultation("Cancel my consultation", "cancel"),
	goBack("Go Customer Menu", "../../customer");
	
	private String str;
	private String url;
	
	private EConsultMenu(String str, String url) { this.str = str; this.url = url; }
	public String getStr() { return this.str; }
	public String getUrl() { return this.url; }
}
