package entities;

public abstract class Entity
{
	private int id;
	
	public Entity(int id)
	{
		setId(id);
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String toString()
	{
		return "\n\tID " + id;
	}
	
}//Fine Classe Entity