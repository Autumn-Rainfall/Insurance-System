package com.mju.insurance.common.enums;

public enum ESalesManagement {
	salesActivity("Sales Activity", "salesActivity"),
	contractCompletion("Contract Completion", "contractCompletion"),
	consultApplicationList("Consult Application List", "consultApplicationList");

	private String str;
	private String url;

	private ESalesManagement(String str, String url) { this.str = str; this.url = url; }
	public String getStr() { return this.str; }
	public String getUrl() { return this.url; }
}
