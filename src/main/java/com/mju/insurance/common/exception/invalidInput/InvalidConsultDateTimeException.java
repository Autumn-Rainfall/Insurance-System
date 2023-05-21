package com.mju.insurance.common.exception.invalidInput;

public class InvalidConsultDateTimeException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String message = "신청할 수 없는 날짜입니다.";

	public InvalidConsultDateTimeException() {
		super(message);
	}
}
