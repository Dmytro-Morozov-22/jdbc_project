package com.ua.vin.jdbcMySQL;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "23qw1qW!";
	private static String URL = "jdbc:mysql://localhost/employee";

	public static Connection openConnection()
			throws SQLException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException {
		
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor()
				.newInstance();
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}

}
