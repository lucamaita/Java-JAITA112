package main;

import dao.DAOLibro;
import dao.IDAOTabelle;
import entities.*;

public class Main {

	public static void main(String[] args) {
		
				// LISTA LIBRI
		IDAOTabelle a = null;
		a = new DAOLibro("libreria");
		System.out.println(a.list());
		
		// 'Harry Potter e la Pietra Filosofale', 'Fantasy', 336, 'Salani Editore' ,20.50, 1
		//Entity e = new Libro(0, "Libro nuovo", "genere bello", 200, "Editore bello", 50.0, 1);
		//a.insert(e);
		//System.out.println(a.insert(e));
		//System.out.println(a.list());
	}

}
