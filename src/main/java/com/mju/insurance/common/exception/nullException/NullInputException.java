package com.mju.insurance.common.exception.nullException;

public class NullInputException extends Exception {
	private static final long serialVersionUID = 1L;
	private static String message = "Please write down your ";

	/**
	 * 
	 * @param name null input column name
	 */
	public NullInputException(String name) {
		super(message + name);
	}
}
