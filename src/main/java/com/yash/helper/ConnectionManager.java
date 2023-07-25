package com.yash.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionManager {

	@Autowired@Qualifier("embedded")
	private javax.sql.DataSource dataSource;
	
	@Value("${authUser}")
	private String username;
	
	@Value("${authPassword}")
	private String password;
	private Connection connection=null;
	
	public Connection openConnection() {
		try {
			connection= dataSource.getConnection(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
