package com.adapter;

public class restaurant {

	private String name;
	private String price;
	private int ratting;

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

	public restaurant( String name, String price, int ratting) {

		this.setName(name);
		this.setPrice(price);
		this.setRatting(ratting);
	}

}
