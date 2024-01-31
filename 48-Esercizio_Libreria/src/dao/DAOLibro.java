package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Entity;
import entities.Libro;
import factory.Factory;
import factory.IFactory;

public class DAOLibro extends DAO implements IDAOTabelle {
	
	public DAOLibro(String nomeDB) {
		super(nomeDB);
	}
	
	public boolean update (Entity e) {
		
		return super.update(
				"UPDATE Libri SET " 	+
				"titolo = \"" 			+ ((Libro)e).getTitolo() 		+ "\", " +
				"genere = \"" 			+ ((Libro)e).getGenere()		+ "\", " +
				"numero_pagine = \""	+ ((Libro)e).getNumero_pagine()	+ "\", " +
				"casa_editrice = \""	+ ((Libro)e).getCasa_editrice()	+ "\", " +
				"prezzo = "				+ ((Libro)e).getPrezzo()		+ ", "	 +
				"idAutore = "			+ ((Libro)e).getAutore()		+ " "	 +
				"WHERE id = "			+ e.getId()
				);
	}
	
	public boolean insert(Entity e)
	{
		return super.update(
							"INSERT INTO libri (titolo, genere, numero_pagine, casa_editrice, prezzo, idAutore) VALUES " +
							"(\"" + ((Libro)e).getTitolo() 			+ "\", " +
							"\""  + ((Libro)e).getGenere() 			+ "\", " +
							""    + ((Libro)e).getNumero_pagine()	+ ", " +
							"\""  + ((Libro)e).getCasa_editrice()	+ "\", " +
							""    + ((Libro)e).getPrezzo()			+ ", "	 +
							""	  + ((Libro)e).getAutore() 			+ ")"
							);
	}
	
	public boolean delete(int id)
	{
		return super.update("DELETE FROM Libri WHERE id = " + id);
	}
	
	public List<Entity> list()
	{
		List<Entity> ris = new ArrayList<Entity>();
		
		List<Map<String,String>> righe = super.read("SELECT * FROM Libri INNER JOIN autori on libri.idAutore = autori.id");
		
		for(Map<String,String> riga : righe)
		{
			IFactory a = Factory.createObject("Libro");

			a.create(riga);

			ris.add((Libro)a);
		}
		
		return ris;
	}
	
	public Entity find(int id)
	{
		Map<String,String> riga = super.read("SELECT * FROM Libri WHERE id = " + id).get(0);
		
		IFactory a = Factory.createObject("Libro");
		a.create(riga);
		
		return (Libro)a;
	}
	
	public List<Libro> findBooks(int idAutore)
	{
		List<Libro> ris = new ArrayList<>();
		
		List<Map<String,String>> righe = super.read("SELECT	Libri.* " 					   + 
													"FROM	Autori INNER JOIN Libri "    +
													"ON libri.idAutore = autori.id " + 
													"WHERE	autori.id = " + idAutore   );
		
		for(Map<String,String> riga : righe)
		{
			IFactory a = Factory.createObject("Libro");
			a.create(riga);

			ris.add((Libro)a);
		}
		
		return ris;
	}
	
}
