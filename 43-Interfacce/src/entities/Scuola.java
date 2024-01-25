package entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Scuola {

	private ArrayList<Entity> persone;
	
	public Scuola(String path) throws FileNotFoundException {
		
		persone = new ArrayList<Entity>();
		
		Scanner file = new Scanner(new File(path));
		
		Entity e;
		
		while(file.hasNextLine()) {
			
			String[] info = file.nextLine().split(";");
			
			e = null;
			
			if(info[0].equalsIgnoreCase("s")) {
				
				e = new Studente(Integer.parseInt(info[1]), 
								info[2], 
								info[3], 
								info[4], 
								info[5], 
								info[6], 
								info[7], 
								trasforma(info[8]));
			}
			else if (info[0].equalsIgnoreCase("d")) {
				
				e = new Dipendente(Integer.parseInt(info[1]), 
									info[2], 
									info[3], 
									info[4], 
									info[5], 
									info[6], 
									Double.parseDouble(info[7]), 
									info[8],
									Integer.parseInt(info[9]));
			}
			
			if(e != null)
				persone.add(e);
		}
		file.close();
		
	}
	
	// Metodi
	private double[] trasforma(String info) {
		String[] vettore = info.split("-");
		double[] ris = new double[vettore.length];
		
		for(int i = 0; i < vettore.length; i++)
			ris[i] = Double.parseDouble(vettore[i]);
		
		return ris;
	}
	
	public String elenco() {
		
		String ris = "";
		
		for(Entity e : persone)
			ris += e.toString();
		
		return ris;
	}
	
	// Voglio vedere l'elenco dai dipendenti pendolari
	
	public String elencoPendolari() {
		
		String ris = "";
		
		for(Entity e : persone) {
			if(e instanceof Dipendente) {
				if(((Dipendente) e).pendolare()) {
					ris += e.toString();
				}
			}
		}
		
		return ris;
		
	}
	
	// Voglio vedere la persona piu vecchia traa tutti
	
	public String piuVecchio() {
		
		String ris = "";
		int max = 0;
		
		for(Entity e : persone) {
			if(((Persona) e).eta() > max) {
				max = ((Persona) e).eta();
				ris = e.toString();
			}else if(((Persona) e).eta() == max) {
				ris += e.toString();
			}
		}
		return ris;
	}
	
	// Voglio vedere il voto medio complessivo della scuola
	
	public Double votoMedioComplessivo() {
		
		Double ris = 0.0;
		int conta = 0;
		Double somma = 0.0;
		
		for(Entity e : persone) {
			if(e instanceof Studente) {
				somma += ((Studente) e).media();
				conta++;
			}
		}
		
		ris = somma/conta;

		return ris;	
	}
	
	// Voglio vedere per ogni persona il valore del bonus che prende
	
	public String bonus() {
		
		String ris = "";
		
		for(Entity e : persone) {
			ris += e instanceof Studente ? "\nStudente " : "\nDipendente ";
			ris += 	" " + ((Persona) e).getNome() + 
					" " + ((Persona) e).getCognome() + 
					" " +  ((Persona) e).bonus() + "$";
		}
		
		return ris;
	}
	
	
	
	
	
	
	
	
	
	
	
}// Fine classe
