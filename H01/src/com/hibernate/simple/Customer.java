package com.hibernate.simple;

/**
 * A Domain class, which demonstrates the Hibernate Core Simple Mapping
 * @author bkar
 *
 */
public class Customer {
	private String cname;
	private int cid;

	public Customer() {
		super();
	}

	public Customer(String cname) {
		super();
		this.cname = cname;
	}

	public Customer(String cname, int cid) {
		super();
		this.cname = cname;
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Customer[]" + "cid: " + cid + "cname: " + cname;
	}
}