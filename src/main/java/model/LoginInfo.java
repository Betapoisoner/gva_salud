package model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table( name = "login_info" ) public class LoginInfo {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int			id;

	@Column( name = "email" , nullable = false )
	private String		email;

	@Column( name = "password" , nullable = false )
	private String		password;

	@OneToOne
	@JoinColumn( name = "user_id" , unique = true )
	private UserInfo	user;

	public LoginInfo() {}

	// Constructor without ID
	public LoginInfo(String email, String password, UserInfo user) {
		this.email = email;
		this.password = password;
		this.user = user;
	}

	// Getters and Setters
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public UserInfo getUser() { return user; }

	public void setUser(UserInfo user) { this.user = user; }

	@Override
	public String toString() { return "LoginInfo{" + "id=" + id + ", email='" + email + '\'' + '}'; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoginInfo loginInfo = (LoginInfo) o;
		return id == loginInfo.id && Objects.equals(email, loginInfo.email);
	}

	@Override
	public int hashCode() { return Objects.hash(id, email); }
}