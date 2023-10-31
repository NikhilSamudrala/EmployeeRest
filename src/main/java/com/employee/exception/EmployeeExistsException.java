package com.employee.exception;

public class EmployeeExistsException extends RuntimeException {

	private static final long serialVersionUID = -6145641841915295577L;
	private final String message;
	private final String errorCode;

	public EmployeeExistsException(String message, String errorCode) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}

	public EmployeeExistsException(Throwable original, String errorCode) {
		super(original);
		this.message = original.getMessage();
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
	
}
