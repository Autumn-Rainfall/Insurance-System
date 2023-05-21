package com.mju.insurance.common.exception.invalidInput;

public class InvalidException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String message = " is not valid.";

	public InvalidException(String name) {
		super(name + message);
	}
}