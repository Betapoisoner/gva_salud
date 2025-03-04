package model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table( name = "history" ) public class History {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int			id;

	@Column( name = "event" , length = 100 , nullable = false )
	private String		event;

	@Column( name = "description" , nullable = false )
	private String		description;

	@Column( name = "date" , nullable = false )
	private LocalDate	date;

	public History() {}

	// Constructor without ID
	public History(String event, String description, LocalDate date) {
		this.event = event;
		this.description = description;
		this.date = date;
	}

	// Getters and Setters
	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getEvent() { return event; }

	public void setEvent(String event) { this.event = event; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public LocalDate getDate() { return date; }

	public void setDate(LocalDate date) { this.date = date; }

	@Override
	public String toString() {
		return "History{"	+ "id=" + id + ", event='" + event + '\'' + ", description='" + description + '\'' + ", date="
				+ date + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		History history = (History) o;
		return id == history.id && Objects.equals(date, history.date);
	}

	@Override
	public int hashCode() { return Objects.hash(id, date); }
}