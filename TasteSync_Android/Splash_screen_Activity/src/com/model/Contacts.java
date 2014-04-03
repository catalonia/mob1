package com.model;

public class Contacts {
	private String name;
	private String Email;
	private Boolean visible;
	private String phone;

	public Contacts(String name, String email, String checkphone,
			Boolean visible) {
		super();
		this.name = name;
		Email = email;
		this.phone = checkphone;
		this.visible = visible;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

}
