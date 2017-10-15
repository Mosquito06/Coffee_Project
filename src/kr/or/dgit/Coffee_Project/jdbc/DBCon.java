package kr.or.dgit.Coffee_Project.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static final DBCon instance = new DBCon();

	public static DBCon getInstance() {
		return instance;
	}

	private DBCon() {
		Properties properties = getProperties("conf.properties");

		try {
			Connection con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("pwd"));
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}

	}

	private Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);

		try {
			properties.load(is);
		} catch (IOException e) {
			System.err.printf("%s%n", e.getMessage());
			e.printStackTrace();
		}
		return properties;
	}

}
