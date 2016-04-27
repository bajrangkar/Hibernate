package com.hibernate.association;

/**
 * Domain class attached with Student - One to One - Primary Key - Unidirectional
 * @author bkar
 *
 */
public class Nick {
	private int sid;
	private String petName;
	private String natureOf;
	private boolean naughty;

	public Nick() {
		super();
	}

	public Nick(String petName, String natureOf, boolean naughty) {
		super();
		this.petName = petName;
		this.natureOf = natureOf;
		this.naughty = naughty;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getNatureOf() {
		return natureOf;
	}

	public void setNatureOf(String natureOf) {
		this.natureOf = natureOf;
	}

	public boolean isNaughty() {
		return naughty;
	}

	public void setNaughty(boolean naughty) {
		this.naughty = naughty;
	}

}
