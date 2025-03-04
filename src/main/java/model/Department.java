package model;
import jakarta.persistence.*;

@Entity
@Table(name = "departament")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@ManyToOne
	@JoinColumn(name = "hospital_id", nullable = false)
	private Location hospital;

	public Department() {
	}

	// Constructor without ID
	public Department(String name, String description, Location hospital) {
		this.name = name;
		this.description = description;
		this.hospital = hospital;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Location getHospital() {
		return hospital;
	}
	public void setHospital(Location hospital) {
		this.hospital = hospital;
	}
}