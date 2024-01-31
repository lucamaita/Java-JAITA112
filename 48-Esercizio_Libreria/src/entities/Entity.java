package entities;

public abstract class Entity {
	
	// Proprieta
	private int id;

	// Costruttore
	public Entity(int id) {
		setId(id);
	}
	public Entity() {}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Metodi
	@Override
	public String toString() {
		return "\n\tID: " + id;
	}
	
}
