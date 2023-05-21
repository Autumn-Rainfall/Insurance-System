package com.mju.insurance.common.exception.invalidInput;

public class InvalidTotalPaymentMonthException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String message = "유효하지 않은 총납입월수 입니다.";

	public InvalidTotalPaymentMonthException() {
		super(message);
	}
}
