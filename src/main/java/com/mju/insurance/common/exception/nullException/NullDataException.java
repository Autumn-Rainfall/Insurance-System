package com.mju.insurance.common.exception.nullException;

public class NullDataException extends Exception {
	private static final long serialVersionUID = 1L;
	private static String message = " is not found";

	public NullDataException(String name) {
		super(name + message);
	}
}
