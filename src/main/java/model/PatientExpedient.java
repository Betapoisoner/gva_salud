package model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table( name = "patient_expedient" ) public class PatientExpedient {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int			id;

	@ManyToOne
	@JoinColumn( name = "user_id" , nullable = false )
	private UserInfo	user;

	@ManyToOne
	@JoinColumn( name = "histor_id" , nullable = false )
	private History		history;

	public PatientExpedient() {}

	// Constructor without ID
	public PatientExpedient(UserInfo user, History history) { this.user = user; this.history = history; }

	// Getters and Setters
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public UserInfo getUser() { return user; }

	public void setUser(UserInfo user) { this.user = user; }

	public History getHistory() { return history; }

	public void setHistory(History history) { this.history = history; }

	@Override
	public String toString() {
		return "PatientExpedient{" + "id=" + id + ", user=" + user + ", history=" + history + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PatientExpedient that = (PatientExpedient) o;
		return id == that.id && Objects.equals(user, that.user);
	}

	@Override
	public int hashCode() { return Objects.hash(id, user); }
}