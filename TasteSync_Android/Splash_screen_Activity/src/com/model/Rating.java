/**
 * 
 */
package com.model;

import android.widget.ImageView;

public class Rating {
	private String Name = "";
	private String img;
	private boolean visible;

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return this.Name;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getImage() {
		return img;
	}

	public void setImage(String img) {
		this.img = img;
	}

}
