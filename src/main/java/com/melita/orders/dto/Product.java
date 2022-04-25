package com.melita.orders.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8214121242417631870L;
	@NotNull(message = "product name required" + "," + "required")
	private String name;
	private String detail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
