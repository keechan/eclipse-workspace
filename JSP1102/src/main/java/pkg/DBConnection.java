package pkg;

import java.sql.Connection;

public class DBConnection {
	static String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	static String UID = "system";
	static String PWD = "1234";
	
	public static Connection getConnection() {
		
		return null;
	}
}
