package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.DBConnection;
import model.User;

public class AuthenticationService {

	private static Connection connection;
	private static Statement stmt;
	private static ResultSet rs;

	private static User currentUser;

	public static void setCurrentUser(User user, String username) {

		try {
			connection = DBConnection.getConnection();
			stmt = connection.createStatement();

			rs = stmt.executeQuery("select * from users where username = '" + username + "' ;");
			if (rs.next()) {
				user.setUsername(rs.getString("username"));

				currentUser = user;
			} else {
				System.out.println("User not found for username: " + username);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static User getCurrentUser() {
		return currentUser;
	}
}