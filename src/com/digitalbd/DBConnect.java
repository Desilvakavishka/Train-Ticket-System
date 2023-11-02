// Dias D.D.K.S.
// IT21220760
// SE/OOP_MLB_WD_2022_S2_183

package com.digitalbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	
	// declaring database requirements and assigning values
	private String hostName = "jdbc:mysql://localhost:3306/ticketing_system";
	private String userName = "root";
	private String userPassword = "root";
	public Statement statement;
	private Connection con;

	// using singleton pattern
	
	private static DBConnect dbCon;
	
	private DBConnect() {
		this.con = null;
		this.statement = null;
		
		// exception handling for database connectivity
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(hostName,userName,userPassword);
			this.statement = this.con.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnect getInstance() {
		// check for duplicate object creation
		if (dbCon == null) {
			dbCon = new DBConnect();
		}
		return dbCon;
		
	}

}
