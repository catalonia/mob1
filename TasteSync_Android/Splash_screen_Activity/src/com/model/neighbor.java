/**
 * 
 */
package com.model;
public class neighbor {

	private String text;
	private boolean visible;

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public neighbor(String name) {
		// TODO Auto-generated constructor stub
		this.setName(name);
	}

	public String getName() {
		return text;
	}

	public void setName(String name) {
		this.text = name;
	}

}
