package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Autore;
import entities.Entity;
import factory.Factory;
import factory.IFactory;

public class DAOAutore extends DAO implements IDAOTabelle {

	public DAOAutore(String nomeDB) {
		super(nomeDB);
	}
	
	public boolean delete(int id) {
		return super.update("DELETE FROM autori WHERE id = " + id);
	}
	
	public boolean insert(Entity e) {
		return super.update("INSERT INTO autori (nome, cognome, dob, nazionalita, biografia) VALUES " +
							"(\"" + ((Autore)e).getNome() 	 	+ "\", " +
							"\""  + ((Autore)e).getCognome() 	+ "\", " +
							"\""  + ((Autore)e).getDob()	 	+ "\", " +
							"\""  + ((Autore)e).getNazionalita()+ "\", " +
							""	  + ((Autore)e).getBiografia() 	+ ")" 	 );
	}
	
	public boolean update(Entity e) {
		return super.update(
							"UPDATE Autori SET " 											+
							"nome = \"" 		+ ((Autore)e).getNome() 	  	+ "\", " 	+
							"cognome = \"" 		+ ((Autore)e).getCognome() 	  	+ "\", " 	+
							"dob = \"" 			+ ((Autore)e).getDob() 		  	+ "\", " 	+
							"nazionalita = \"" 	+ ((Autore)e).getNazionalita() 	+ "\", " 	+
							"biografia = " 		+ ((Autore)e).getBiografia() 	+ " " 		+
							"WHERE id = " 		+ e.getId()
							);
				
	}
	
	public List<Entity> list()
	{
		List<Entity> ris = new ArrayList<Entity>();
		
		List<Map<String,String>> righe = super.read("SELECT * FROM Autori");
		
		for(Map<String,String> riga : righe)
		{
			IFactory a = Factory.createObject("Autore");
			a.create(riga);
			ris.add((Autore)a);
		}
		
		return ris;
	}
	
	public Entity find(int id)
	{
		Map<String,String> riga = super.read("SELECT * FROM Autori WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Autori");
		a.create(riga);
		
		return (Autore)a;
	}

}
