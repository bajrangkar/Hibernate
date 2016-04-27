package com.hibernate.association;

import java.util.Set;																									

/**
 * Domain class attached to Student - Many to Many - Join Table - Bidirectional 
 * @author bkar
 *
 */
public class Account {

	private int acctId;
	private String acctType;
	private int contacts;
	// Many To Many - Bidirectional
	private Set<Student> students;
	
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
