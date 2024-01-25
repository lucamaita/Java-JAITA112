package main;

import java.io.FileNotFoundException;

import entities.Negozio;
import entities.INegozio;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		INegozio n = new Negozio("src/res/Dati.txt");
		
		//System.out.println(n.elenco());
		//System.out.println(n.elencoLaptop());
		//System.out.println(n.maxPrezzo());
		//System.out.println(n.prezzoMedio("tv"));
		//System.out.println(n.gaming()); 
		//System.out.println(n.prezzoMassimo());
		System.out.println(n.prezzoMinimo());
	}

}
