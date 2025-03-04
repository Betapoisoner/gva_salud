package model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table( name = "appointment" ) public class Appointment {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int				id;

	@Column( name = "summary" , length = 100 , nullable = false )
	private String			summary;

	@Column( name = "motives" , nullable = false )
	private String			motives;

	@Column( name = "date" , nullable = false )
	private LocalDateTime	date;

	@ManyToOne
	@JoinColumn( name = "patient_id" , nullable = false )
	private UserInfo		patient;

	@ManyToOne
	@JoinColumn( name = "doctor_id" , nullable = false )
	private Doctor			doctor;

	@ManyToOne
	@JoinColumn( name = "location_id" , nullable = false )
	private Location		location;

	@ManyToOne
	@JoinColumn( name = "department_id" )
	private Department		department;

	public Appointment() {}

	// Constructor without ID
	public Appointment(String summary, String motives, LocalDateTime date, UserInfo patient, Doctor doctor,
			Location location, Department department) {
		this.summary = summary;
		this.motives = motives;
		this.date = date;
		this.patient = patient;
		this.doctor = doctor;
		this.location = location;
		this.department = department;
	}

	// Getters and Setters
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getSummary() { return summary; }

	public void setSummary(String summary) { this.summary = summary; }

	public String getMotives() { return motives; }

	public void setMotives(String motives) { this.motives = motives; }

	public LocalDateTime getDate() { return date; }

	public void setDate(LocalDateTime date) { this.date = date; }

	public UserInfo getPatient() { return patient; }

	public void setPatient(UserInfo patient) { this.patient = patient; }

	public Doctor getDoctor() { return doctor; }

	public void setDoctor(Doctor doctor) { this.doctor = doctor; }

	public Location getLocation() { return location; }

	public void setLocation(Location location) { this.location = location; }

	public Department getDepartment() { return department; }

	public void setDepartment(Department department) { this.department = department; }

	@Override
	public String toString() {
		return "Appointment{"	+ "id=" + id + ", summary='" + summary + '\'' + ", motives='" + motives + '\'' + ", date="
				+ date + ", patient=" + patient + ", doctor=" + doctor + ", location=" + location + ", department="
				+ department + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Appointment that = (Appointment) o;
		return id == that.id && Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() { return Objects.hash(id, date); }
}