package com.adapter;

public class recommandations {
	private String name = "";
	private String title = "";
	private String Image = "";
	private String conttent = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}

	public void setconttent(String conttent) {
		this.conttent = conttent;
	}

	public String gettitle() {
		return this.title;
	}

	public String getImage() {
		return this.Image;
	}

	public String getconttent() {
		return this.conttent;
	}
}
