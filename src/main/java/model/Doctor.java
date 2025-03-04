package model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table( name = "doctor" ) public class Doctor {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int			id;

	@Column( name = "espcialization" , nullable = false )
	private String		specialization;

	@OneToOne
	@JoinColumn( name = "user_id" )
	private UserInfo	user;

	public Doctor() {}

	// Constructor without ID
	public Doctor(String specialization, UserInfo user) { this.specialization = specialization; this.user = user; }

	// Getters and Setters
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getSpecialization() { return specialization; }

	public void setSpecialization(String specialization) { this.specialization = specialization; }

	public UserInfo getUser() { return user; }

	public void setUser(UserInfo user) { this.user = user; }

	@Override
	public String toString() { return "Doctor{" + "id=" + id + ", specialization='" + specialization + '\'' + '}'; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Doctor doctor = (Doctor) o;
		return id == doctor.id && Objects.equals(specialization, doctor.specialization);
	}

	@Override
	public int hashCode() { return Objects.hash(id, specialization); }
}