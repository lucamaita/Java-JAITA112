package main;

import java.io.FileNotFoundException;

import entities.Scuola;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scuola s = new Scuola("src/res/Dati.txt");
		
		//System.out.println(s.elenco());
		//System.out.println(s.elencoPendolari());
		//System.out.println(s.piuVecchio());
		//System.out.println(s.votoMedioComplessivo());
		//System.out.println(s.bonus());
	}

}
