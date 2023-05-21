package com.mju.insurance.common.exception.duplicatedInput;

public class DuplicatedInfoException extends Exception {
	private static final long serialVersionUID = 1L;
	private static String message = "already exists";
	
	/**
	 * 
	 * @param name column name
	 * @param value column value
	 */
	public DuplicatedInfoException(String name, String value) {
		super(name + " '" + value + "' " + message);
	}
}