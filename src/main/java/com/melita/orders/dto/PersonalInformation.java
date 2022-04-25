package com.melita.orders.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class PersonalInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6545511119759600115L;
	@NotNull(message = "name required" + "," + "required")
	private String name;
	@NotNull(message = "last name required" + "," + "required")
	private String lastName;
	@NotNull(message = "id required" + "," + "required")
	private String identification;
	@NotNull(message = "address required" + "," + "required")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
