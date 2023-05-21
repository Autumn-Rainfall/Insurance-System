package com.mju.insurance.common.exception.invalidInput;

public class InvalidConfirmException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String message = "Confirm and Password do not match";

	public InvalidConfirmException() {
		super(message);
	}
}
