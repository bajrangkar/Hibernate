package com.hibernate.association;

/**
 * Domain class attached to Student - One to Many - Unidirectional
 * @author bkar
 *
 */
public class Toy {
	private int toyid;
	private String toyName;
	private String toyColor;

	public Toy() {
		super();
	}

	public Toy(String toyName, String toyColor) {
		super();
		this.toyName = toyName;
		this.toyColor = toyColor;
	}
	
	public int getToyid() {
		return toyid;
	}

	public void setToyid(int toyid) {
		this.toyid = toyid;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public String getToyColor() {
		return toyColor;
	}

	public void setToyColor(String toyColor) {
		this.toyColor = toyColor;
	}

	@Override
	public String toString() {
		return "Toy("+toyid+")";
	}
	
}
