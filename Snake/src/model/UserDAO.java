package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class UserDAO {

	private Connection connection;
	private PreparedStatement pStmt;
	private Statement stmt;
	private ResultSet rs;
	public static User user;

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	private void close() {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}

	}

	public boolean createUser(User user) {
		boolean created = false;
		connection = DBConnection.getConnection();

		try {
			pStmt = connection
					.prepareStatement("insert into users (username, password, email, gender) values (?, ?, ?, ?) ");

			pStmt.setString(1, user.getUsername());
			pStmt.setString(2, user.getPassword());
			pStmt.setString(3, user.getEmail());
			pStmt.setString(4, user.getGender());

			created = pStmt.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return created;

	}

	public void rememberMeToFile(String username, String password) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("userCredentials.txt"))) {
			writer.write(username + "," + password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getStoredCredentials() {
		try {
			String line = Files.readAllLines(Paths.get("userCredentials.txt")).get(0);
			return line.split(",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String[] {};

	}

	public boolean validate(String username, String password) {
		User user = getUserByUsername(username);
		if (user == null) {
			return false;
		}

		if (!user.getPassword().equals(password)) {
			return false;
		}
		return true;
	}

	public User getUserByUsername(String username) {
		User user = null;

		try {
			connection = DBConnection.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from users where username = '" + username + "' ;");

			while (rs.next()) {
				user = new User(rs.getLong("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

//	public boolean changePassword(String username, String oldPassword, String newPassword) {
//
//		boolean changed = false;
//		connection = DBConnection.getConnection();
//
//		try {
//			pStmt = connection.prepareStatement("select * from users where username = ? and password = ?");
//			pStmt.setString(1, username);
//			pStmt.setString(2, oldPassword);
//			rs = pStmt.executeQuery();
//
//			if (rs.next()) {
//				// Old password is correct, proceed with changing the password
//				pStmt = connection.prepareStatement("update users set password = ? where username = ?");
//				pStmt.setString(1, newPassword);
//				pStmt.setString(2, username);
//
//				changed = pStmt.executeUpdate() > 0 ? true : false;
//			} else {
//				System.out.println("Old password is incorrect!");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return changed;
//
//	}
//
//	public boolean deleteUser(String username) {
//		boolean deleted = false;
//		connection = DBConnection.getConnection();
//
//		User userToDelete = getUserByUsername(username);
//		if (userToDelete == null) {
//			System.out.println("User not found.");
//			return false;
//		}
//
//		try {
//			pStmt = connection.prepareStatement("delete from users where username =?");
//			pStmt.setString(1, username);
//
//			int rowsAffected = pStmt.executeUpdate();
//			deleted = rowsAffected > 0 ? true : false;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return deleted;
//
//	}

	public boolean changePassword(String username, String newPassword) {
		boolean changed = false;
		connection = DBConnection.getConnection();

		try {
			if (usernameExistsInDatabase(username)) {
				pStmt = connection.prepareStatement("update users set password = ? where username = ?");
				pStmt.setString(1, newPassword);
				pStmt.setString(2, username);

				int rowsAffected = pStmt.executeUpdate();
				changed = rowsAffected > 0;

				if (changed) {
					System.out.println("Password changed successfully!");
				} else {
					System.out.println("Failed to change password.");
				}
			} else {
				System.out.println("Username not found in the database.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return changed;
	}

	private boolean usernameExistsInDatabase(String username) {
		try {
			pStmt = connection.prepareStatement("select * from users where username = ?");
			pStmt.setString(1, username);
			rs = pStmt.executeQuery();

			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteAccount(String username) {
		boolean deleted = false;
		connection = DBConnection.getConnection();

		try {

			pStmt = connection
					.prepareStatement("delete from history where user_id in (select id from users where username = ?)");
			pStmt.setString(1, username);
			pStmt.executeUpdate();

			// Now, you can safely delete the user
			pStmt = connection.prepareStatement("delete from users where username = ?");
			pStmt.setString(1, username);

			int rowsAffected = pStmt.executeUpdate();
			deleted = rowsAffected > 0;

			if (deleted) {
				System.out.println("Account deleted successfully!");
			} else {
				System.out.println("Failed to delete account.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return deleted;

	}

	public User getUserById(Long user_id) {
		// TODO Auto-generated method stub
		User user = null;

		try {
			connection = DBConnection.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from users where username = '" + user_id + "' ;");

			while (rs.next()) {
				user = new User(rs.getLong("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
