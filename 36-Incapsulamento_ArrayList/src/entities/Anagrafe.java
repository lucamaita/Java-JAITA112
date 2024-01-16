package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anagrafe
{
	// Creare dati in scaffolding, cioe mettere dati di prova fittizzi direttamenti nel codice
	// private Persona[] persone = {new Persona("Alice","Bensanelli",26,"Milano"), new Persona("Pino","Pane",35,"Como")};
	
	// DEFINIZIONE
	// ArrayList e un insieme ORDINATO di elementi dello stesso tipo , di dimensione variabile
	
	// Il tipo da inserire nelle parentesi uncinate (<>) deve sempre essere un tipo BOXATO
	// I tipi si dividono in PRIMITIVI(int, double, boolean, float, char...) 
	// e in BOXATI o classi WRAPPER (o classi) (String, Integer, Double, Boolean, Persona...)
	
	// 	DICHIARAZIONE + INIZIALIZZAZIONE
	// ArrayList<TipoDiDato> nomeArray = new ArrayList<TipoDiDato>();
	// private ArrayList<Persona> persone = new ArrayList<Persona>();
	private ArrayList<Persona> persone;

	public Anagrafe(String path) throws FileNotFoundException
	{
		// ATTENZIONE!!
		// Ricordarsi sempre di inizializzare l'AL, perche JAVA non ve lo ricordera.
		persone = new ArrayList<Persona>();
		
		Scanner file = new Scanner(new File(path));
		
		while(file.hasNextLine())
		{
			String[] info = file.nextLine().split(",");
			
			Persona p = new Persona(info[0], info[1], Integer.parseInt(info[2]), info[3]);
		
			// .add() aggiunge all'ArrayList l'elemento tra le sue tonde
			persone.add(p);
		}
		
		file.close();
	}// Fine costruttore
	
	public String cerca(String residenza)
	{
		String ris = "";
		
		for(Persona p : persone)
			if(p.getResidenza().equalsIgnoreCase(residenza))
				ris += p.scheda();
		
		return ris;
	}
}
