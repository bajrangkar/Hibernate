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
	private String DEFAULT_TABLE_NAME = "MY_JUZZY_MANGO";
	public int gap=1;
	public int startAt=1;
	
	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public int getStartAt() {
		return startAt;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		System.out.println("startAt parameter passed to GenNow with value : "+params.getProperty("startAt"));
		System.out.println("gap parameter passed to GenNow with value : "+params.getProperty("gap"));
		startAt = Integer.parseInt(params.getProperty("startAt"));
		gap = Integer.parseInt(params.getProperty("gap"));
	}
	
	@Override
	public Serializable generate(SessionImplementor sessionImpl, Object data) throws HibernateException {
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			String prefix = "CUST";
			String suffix = "";
			connection = sessionImpl.connection();
			statement = connection.createStatement();
			try {
				resultSet = statement.executeQuery("SHOW TABLES LIKE '"+DEFAULT_TABLE_NAME+"'");
				if(resultSet.next()) {
					resultSet = statement.executeQuery("SELECT NEXT_VAL FROM "+DEFAULT_TABLE_NAME);
					if (resultSet.next()) {
						int nextValue = resultSet.getInt(1);
						statement.execute("UPDATE "+DEFAULT_TABLE_NAME+" SET NEXT_VAL="+(nextValue+gap));
						suffix = String.format("%05d", (nextValue+gap));
					}
				} else {	
					statement.execute("CREATE TABLE "+DEFAULT_TABLE_NAME+" (NEXT_VAL INT)");
					statement.execute("INSERT INTO "+DEFAULT_TABLE_NAME+" VALUES("+startAt+")");
					suffix = String.format("%05d", startAt);
				}
				result = prefix.concat(suffix);
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