package com.hibernate.association;

/**
 * Domain class attached with Student - One to One - Primary Key - Bidirectional
 * @author bkar
 *
 */
public class Nick {
	private int nid;
	private String nickName;
	// One To One - Primary Key - Bidirectional
	private Student student;
	
	public Nick() {
		super();
	}

	public Nick(String nickName) {
		super();
		this.nickName = nickName;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
