package com.mju.insurance.entity.carAccidentHandling;

public enum ECarAccidentHandlingState {
	ONREVIEW("ó�� ��"), HANDLED("ó�� �Ϸ�"), REFUSED("������");

	private String title;
	private ECarAccidentHandlingState(String title){
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
