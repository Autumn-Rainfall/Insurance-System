package com.mju.insurance.common.exception.invalidInput;

public class InvalidAccidentDateTimeException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String message = "Invalid Date Time";

	public InvalidAccidentDateTimeException() {
		super(message);
	}
}
