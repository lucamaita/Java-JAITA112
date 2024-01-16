package main;

import java.io.FileNotFoundException;

import entities.Anagrafe;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE A OGGETTI
		// > Incapsulamento: Significa proteggere dei pezzi di codice
		//						si puo fare tramite un discorso di "permessi" o 	
		//						tramite un discorso di "mascherare" pezzi di codice.
		
		// Quando parliamo di permessi parliamo di "livelli di visibilita" che sono 4 (dal piu al meno permissivo):
		
		// PUBLIC -----------------> Rende visibile l'elemento in tutto il programma 
		// PROTECTED --------------> Rende visibile l'elemento in tutte le parti imparentate tra loro, anche se stanno in 
		//								package diversi
		// PACKAGE ( o default) ---> Rende visibile l'elemento solo ai componenti del suo stesso package di appartenenza
		// PRIVATE ----------------> Rende visibile l'elemento solo nella sua classe di appartenenza
		
		//Esempio di come reagisce il codice ai livelli di visibilita dei commenti dentro Persona
//		Persona p = new Persona();
//		
//		p.nome = "Alice";
//		p.cognome = "Bensanelli";
//		p.eta = 26;
//		p.residenza = "Milano";
		
		Anagrafe a = new Anagrafe("src/res/Dati.txt");
		
		System.out.println(a.cerca("Brescia"));
		
	}
}
