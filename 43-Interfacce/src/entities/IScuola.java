package entities;

import java.util.ArrayList;

// Per convenzione la mia azienda usa scrivere il nome delle interfacce con una I e poi il nome
// delle classi che sfruttano questa inferfaccia.
// Non tutti seguono queste regole, in generale l'importante e seguire le stesse convenzioni che si seguono
// per la nomencalatura delle classi.


// INTERFACCIA: e un contratto.
// In particolare, le interfacce stipulano dei contratti tra loro stesse e delle classi.
// L'accordo tra le due parti si regge su questi presupposti: L'interfaccia fornisce alla classe protezione,
// e la classe fornisce all'interfaccia l'implementazione dei suoi metodi.

public interface IScuola {
	
	// Le interfacce nel corso delle versioni sono cambiate molto.
	// Uno scaglione grosso c'e stato tra le versioni precedenti alla 1.8 e le versioni 1.8 e successive.
	// Nelle versioni piu recenti c'e stato un altro grosso passo in avanti che ha cambiato nuovamente 
	// le possibilita di questo strumento.
	
	// Le versioni precendenti alla 1.8 permettevano alle interfacce di possedere 
	//  unicamente le firme dei metodi.
	public String elenco();
	public String elencoPendolari();
	public ArrayList<Entity> getPersone();
	
	// Dalla versione 1.8 in poi e stata implementata la possibilita di dare un corpo ai metodi
	default String anziano() {
		
		String ris = "";
		int max = 0;
		
		for(Entity e : getPersone()) {
			if(((Persona)e).eta() > max) {
				max = ((Persona)e).eta();
				ris = e.toString();
			}else if(((Persona)e).eta() == max)
				ris += e.toString();
		}
		
		return ris;
	}
	
	// Nelle versioni piu recenti e stata introdotta la possibilita di avere delle proprieta STATICHE
	
	// Le interfacce recenti assomiglieranno tantissimo a una classe astratta.
	// La differenza e che le interfacce non possono avere lo stato dell'oggetto, la classe astratta si.
	
}
