package com.melita.orders.dto;

public class Response<T> {
	private int status;
	private String userMessage;
	private String developerMessage;
	private Object data;

	public Response(int status, String userMessage, String developerMessage, Object data) {
		super();
		this.status = status;
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
