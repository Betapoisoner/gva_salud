package model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table( name = "location" ) public class Location {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int				id;

	@Enumerated( EnumType.STRING ) // Maps the enum to a string in the database
	@Column( name = "type" , nullable = false )
	private LocationType	type;

	@Column( name = "name" , nullable = false )
	private String			name;

	@Column( name = "description" , nullable = false )
	private String			description;

	// Empty constructor (required by Hibernate)
	public Location() {}

	// Constructor without ID
	public Location(LocationType type, String name, String description) {
		this.type = type;
		this.name = name;
		this.description = description;
	}

	// Getters and Setters
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public LocationType getType() { return type; }

	public void setType(LocationType type) { this.type = type; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	@Override
	public String toString() {
		return "Location{"	+ "id=" + id + ", type=" + type + ", name='" + name + '\'' + ", description='" + description
				+ '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Location location = (Location) o;
		return id == location.id && Objects.equals(name, location.name);
	}

	@Override
	public int hashCode() { return Objects.hash(id, name); }
}