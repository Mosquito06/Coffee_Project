package kr.or.dgit.Coffee_Project.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public static DBCon getInstance() {
		return instance;
	}

	private DBCon() {
		Properties properties = getProperties("conf.properties");
				
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("pwd"));
			
		} catch (SQLException e) {
			/*System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();*/
			if(e.getErrorCode() == 1049){
				JOptionPane.showMessageDialog(null, "데이터베이스를 먼저 추가하세요");
			}
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
