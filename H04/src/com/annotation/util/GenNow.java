package com.annotation.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class GenNow implements IdentifierGenerator, Configurable {
	
	private int startAt=1;
	private int gap=1;
	private String DEFAULT_TABLE_NAME = "MY_JUZZY_MANGO";
	private String prefix = "";
	private String suffix = "";
	
	public int getStartAt() {
		return startAt;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public String getDEFAULT_TABLE_NAME() {
		return DEFAULT_TABLE_NAME;
	}

	public void setDEFAULT_TABLE_NAME(String dEFAULT_TABLE_NAME) {
		DEFAULT_TABLE_NAME = dEFAULT_TABLE_NAME;
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		System.out.println("startAt parameter passed to GenNow with value : "+params.getProperty("startAt"));
		System.out.println("gap parameter passed to GenNow with value : "+params.getProperty("gap"));
		startAt = Integer.parseInt(params.getProperty("startAt"));
		gap = Integer.parseInt(params.getProperty("gap"));
		DEFAULT_TABLE_NAME = params.getProperty("tablename");
		prefix = params.getProperty("prefix");
		suffix = params.getProperty("suffix");
	}
	
	@Override
	public Serializable generate(SessionImplementor sessionImpl, Object data) throws HibernateException {
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			String generatedId = "";
			connection = sessionImpl.connection();
			statement = connection.createStatement();
			try {
				resultSet = statement.executeQuery("SHOW TABLES LIKE '"+DEFAULT_TABLE_NAME+"'");
				if(resultSet.next()) {
					resultSet = statement.executeQuery("SELECT NEXT_VAL FROM "+DEFAULT_TABLE_NAME);
					if (resultSet.next()) {
						int nextValue = resultSet.getInt(1);
						statement.execute("UPDATE "+DEFAULT_TABLE_NAME+" SET NEXT_VAL="+(nextValue+gap));
						generatedId = String.format("%05d", (nextValue+gap));
					}
				} else {	
					statement.execute("CREATE TABLE "+DEFAULT_TABLE_NAME+" (NEXT_VAL INT)");
					statement.execute("INSERT INTO "+DEFAULT_TABLE_NAME+" VALUES("+startAt+")");
					generatedId = String.format("%05d", startAt);
				}
				result = prefix.concat(generatedId).concat(suffix);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				statement.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("\t {RESULT :: "+result+"} ");
		return result;
	}
}