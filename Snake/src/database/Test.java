package database;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			System.out.println("Connected to Database successfully!");

		} else {
			System.out.println("Fail to connect to Database");

		}

	}
}