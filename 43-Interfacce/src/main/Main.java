package main;

import java.io.FileNotFoundException;

import entities.Scuola;
import entities.IScuola;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		IScuola s = new Scuola("src/res/Dati.txt");
		
		//System.out.println(s.elenco());
		//System.out.println(s.elencoPendolari());
		//System.out.println(s.piuVecchio());
		//System.out.println(s.votoMedioComplessivo());
		//System.out.println(s.bonus());
		
		// ATTENZIONE!
		//  Dato che sfrutto il polimorfismo alla riga 12, l'oggetto creato avra
		//  accesso solo ai metodi presenti dentro l'interfaccia 
		//  (che sia solo la firma o l'intero corpo, poco importa).
		// Se volete usare un metodo presente solo nell'aggregatrice dovrete castare l'oggetto s
	}

}