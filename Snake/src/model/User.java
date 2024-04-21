package model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

	private LongProperty id;
	private StringProperty username;
	private StringProperty password;
	private StringProperty email;
	private StringProperty gender;

	public User() {
	}

	public User(String username, String password, String email, String gender) {
		super();
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.email = new SimpleStringProperty(email);
		this.gender = new SimpleStringProperty(gender);
	}

	public User(Long id, String username, String password, String email, String gender) {
		super();
		this.id = new SimpleLongProperty(id);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.email = new SimpleStringProperty(email);
		this.gender = new SimpleStringProperty(gender);
	}

	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id = new SimpleLongProperty(id);
	}

	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username = new SimpleStringProperty(username);
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password = new SimpleStringProperty(password);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email = new SimpleStringProperty(email);
	}

	public String getGender() {
		return gender.get();
	}

	public void setGender(String gender) {
		this.gender = new SimpleStringProperty(gender);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", gender="
				+ gender + "]";
	}

}
