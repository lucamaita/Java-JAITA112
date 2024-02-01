package entities;

public class Entity {

	// PROPRIETA
	private int id;
	
	// COSTRUTTORE
	public Entity() {}
	
	public Entity(int id) {
		super();
		this.id = id;
	}
	

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	// METODI
	@Override
	public String toString() {
		return "\n\tID: " + id;
	}
}
