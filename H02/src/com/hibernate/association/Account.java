package com.hibernate.association;

/**
 * Domain class attached to Student - Many to Many - Join Table - Unidirectional 
 * @author bkar
 *
 */
public class Account {

	private int acctId;
	private String acctType;
	private int contacts;

	public Account() {
		super();
	}

	public Account(String acctType, int contacts) {
		super();
		this.acctType = acctType;
		this.contacts = contacts;
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public int getContacts() {
		return contacts;
	}

	public void setContacts(int contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Account("+acctId+")";
	}
	
}
