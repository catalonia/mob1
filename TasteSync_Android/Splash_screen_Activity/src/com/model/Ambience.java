package com.model;

public class Ambience {
	private String CompanyName = "";
	private String Image = "";
	private boolean visible;

	/*********** Set Methods ******************/
	public void setCompanyName(String CompanyName) {
		this.CompanyName = CompanyName;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}

	/*********** Get Methods ****************/
	public String getCompanyName() {
		return this.CompanyName;
	}

	public String getImage() {
		return this.Image;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
