package com.annotation.simple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * A Domain class, which demonstrates the Hibernate Annotation Simple Mapping
 * @author bkar
 */
@Entity
@Table(name = "seller")
public class Seller {
	@Column(name = "sname")
	private String sname;
	@Id
	@GenericGenerator(name = "sellerGen", strategy = "com.annotation.util.GenNow",
	parameters={
			@Parameter(name="startAt", value="11"),
			@Parameter(name="gap", value="10"),
			@Parameter(name="tablename", value="SELLER_JUZZY_MANGO"),
			@Parameter(name="prefix", value="SELL"),
			@Parameter(name="suffix", value="@")
		}
	)
	@GeneratedValue(generator = "sellerGen")
	
//	@GenericGenerator(name = "ss", strategy="increment")
//	@GeneratedValue(generator = "ss")
	@Column(name = "sid")
	private String sid;

	public Seller() {
		super();
	}
	
	public Seller(String sname) {
		super();
		this.sname = sname;
	}

	public Seller(String sname, String sid) {
		super();
		this.sname = sname;
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Seller[]" + "sid: " + sid + "sname: " + sname;
	}
}