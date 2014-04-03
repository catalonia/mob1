package com.model;

import android.graphics.Bitmap;

public class photo {
	Bitmap image;

	public photo(Bitmap image) {
		super();
		this.image = image;
	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

}
