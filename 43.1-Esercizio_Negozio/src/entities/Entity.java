package entities;

public abstract class Entity {
	
	// Proprieta
	private int id;

	// Costruttore
	public Entity(int id) {
		super();
		setId(id);
	}

	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// Metodi
	@Override
	public String toString() {
		return "\nID: " + id;
	}

}
