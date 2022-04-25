package com.melita.orders.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1540006709045621971L;
	@NotNull(message = "personal info required" + "," + "required")
	private PersonalInformation personalInformation;
	@NotNull(message = "products required" + "," + "required")
	@NotEmpty(message = "products required" + "," + "required")
	private List<Product> products;
	@NotNull(message = "date required" + "," + "required")
	private LocalDate installationDate;
	@NotNull(message = "time slot required" + "," + "required")
	private String timeSlot;

	public PersonalInformation getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public LocalDate getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(LocalDate installationDate) {
		this.installationDate = installationDate;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

}
