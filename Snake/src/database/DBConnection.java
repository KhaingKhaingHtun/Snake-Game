package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

	private DBConnection() {
	}

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/snakegame?useSSL=false";
		String user = "root";
		String password = "Admin*123";

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}