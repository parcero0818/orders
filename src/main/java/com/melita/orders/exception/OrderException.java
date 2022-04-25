package com.melita.orders.exception;

public class OrderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9151753590405750739L;
	private final String userMessage;
	private final int status;
	private final String errorCode;

	public OrderException(String developerMessage, String userMessage, int status, String errorCode, Throwable e) {
		super(developerMessage, e);
		this.userMessage = userMessage;
		this.status = status;
		this.errorCode = errorCode;
	}

	public OrderException(String developerMessage, String userMessage, int status, String errorCode) {
		super(developerMessage);
		this.userMessage = userMessage;
		this.status = status;
		this.errorCode = errorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public int getStatus() {
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
