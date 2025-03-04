package model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table( name = "user_info" ) public class UserInfo {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int			id;

	@Column( name = "name" , length = 20 , nullable = false )
	private String		name;

	@Column( name = "surname" , length = 50 , nullable = false )
	private String		surname;

	@Column( name = "phone" )
	private Integer		phone;

	@Column( name = "dni" , length = 9 , unique = true , nullable = false )
	private String		dni;

	@OneToOne( mappedBy = "user" )
	private LoginInfo	loginInfo;

	// Empty constructor (required by Hibernate)
	public UserInfo() {}

	// Constructor without ID or relationships
	public UserInfo(String name, String surname, Integer phone, String dni) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.dni = dni;
	}

	// Getters and Setters
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getSurname() { return surname; }

	public void setSurname(String surname) { this.surname = surname; }

	public Integer getPhone() { return phone; }

	public void setPhone(Integer phone) { this.phone = phone; }

	public String getDni() { return dni; }

	public void setDni(String dni) { this.dni = dni; }

	public LoginInfo getLoginInfo() { return loginInfo; }

	public void setLoginInfo(LoginInfo loginInfo) { this.loginInfo = loginInfo; }

	@Override
	public String toString() {
		return "UserInfo{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", phone=" + phone
				+ ", dni='" + dni + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserInfo userInfo = (UserInfo) o;
		return id == userInfo.id && Objects.equals(dni, userInfo.dni);
	}

	@Override
	public int hashCode() { return Objects.hash(id, dni); }
}