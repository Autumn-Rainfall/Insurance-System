package com.mju.insurance.entity.benefitPayment;

public enum EBenefitPaymentState {
		ONREVIEW("泥섇뜝�룞�삕 �뜝�룞�삕"), READY("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占� �뜝�룞�삕"), REFUSED("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕"), PAID("�뜝�룞�삕�뜝�뙣�셿琉꾩삕");
		//DB�뜝�룞�삕�뜝�룞�삕�뜝�듅�눦�삕�뜝�뙓琉꾩삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
	
	private String title;
	private EBenefitPaymentState(String title){
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
