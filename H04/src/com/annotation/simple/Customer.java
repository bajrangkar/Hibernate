package com.annotation.simple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

//import org.hibernate.annotations.GenericGenerator;
/**
 * A Domain class, which demonstrates the Hibernate Annotation Simple Mapping
 * @author bkar
 */
@Entity
@Table(name = "customer")
public class Customer {
	@Column(name = "cname")
	private String cname;
	@Id
//	@SequenceGenerator(name = "sg", sequenceName = "Juzzy_Mango", initialValue = 100, allocationSize = 5)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
	
	@GenericGenerator(name = "ss", strategy = "com.annotation.util.GenNow",
	parameters={
			@Parameter(name="startAt", value="1001"),
			@Parameter(name="gap", value="100"),
			@Parameter(name="tablename", value="CUSTOMER_JUZZY_MANGO"),
			@Parameter(name="prefix", value="CUST"),
			@Parameter(name="suffix", value="!")
		}
	)
	@GeneratedValue(generator = "ss")
	
//	@GenericGenerator(name = "ss", strategy="increment")
//	@GeneratedValue(generator = "ss")
	@Column(name = "cid")
	private String cid;

	public Customer() {
		super();
	}

	public Customer(String cname) {
		super();
		this.cname = cname;
	}

	public Customer(String cname, String cid) {
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Customer[]" + "cid: " + cid + "cname: " + cname;
	}
}