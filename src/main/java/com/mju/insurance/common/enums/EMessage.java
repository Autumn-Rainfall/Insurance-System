package com.mju.insurance.common.enums;

public enum EMessage {
	loginFailed("Login Failed! Try Again");
	
	private String str;
	
	private EMessage(String str) { this.str = str; }
	public String getStr() { return this.str; }
}
