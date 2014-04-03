package com.model;

public class Restaurant {

	private String name;
	private String price;
	private int ratting;
	private boolean visible;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getRatting() {
		return ratting;
	}

	public void setRatting(int ratting) {
		this.ratting = ratting;
	}

	public Restaurant(String name, String price, int ratting) {

		this.setName(name);
		this.setPrice(price);
		this.setRatting(ratting);
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public Restaurant(String name, String price, int ratting,boolean visible) {

		this.setName(name);
		this.setPrice(price);
		this.setRatting(ratting);
		this.setVisible(visible);
	}

}
