package main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		//	MAPPE
		
		// Definizione
		// Una mappa e un insieme di coppie chiave-valore
		
		// Le mappe per loro natura tendono al disordine, cioe non esiste un indice che tenga ordinato
		// l'insieme di dati che salviamo nella variabile.
		
		// Al posto dell'indice numerico classico, le mappe hanno le CHIAVI.
		// Una chiave puo essere del tipo che volete voi (int, double, String, entity, persona, array...)
		// L'unica cosa a cui dovete prestare attenzione e non far ripetere mai la chiave.
		
		// Ogni chiave mi permettera di identificare con assulta certezza il valore a lei associato.
		// Il valore puo essere del tipo che volete voi (int, double, String, Entity...)
		
		// Il tipo della chiave e il valore non devono essere per forza uguali.
		
		// Le mappe sono principalmente di due tipi: 
		// - Ordinate: significa che mantiene l'ordine di inserimento
		// - Disordinate: significa che restituiscono un ordine diverso da quello di inserimento
		
		// DICHIARAZIONE
		// 		Map e un interfaccia che ci permettere di scegliere dopo se usare una 
		// 		mappa ordinata o disordinata. 
		// 		Ricordatevi di importare Map da java.util
		// SINTASSI: Map<tipoChiave, tipoValore> nomeMappa
		Map<String,Integer> merciOrdinata;
		Map<String,Integer> merciDisordinata;
		
		// INIZIALIZZAZIONE
		// Mapa ordinata
		merciOrdinata = new LinkedHashMap<String, Integer>();
		// Mappa disordinata
		merciDisordinata = new HashMap<String, Integer>();
		
		// VALORIZZAZIONE
		merciOrdinata.put("Pane",5);
		merciOrdinata.put("Tergicristallo", 1);
		merciOrdinata.put("Latte", 6);
		merciOrdinata.put("Cereali", 1);
		merciOrdinata.put("Pane",10);
		// ATTENZIONE: Se la chiave si ripete, il valore vecchio si sovrascrive con quello nuovo!!
		
		merciDisordinata.put("Sugo", 1);
		merciDisordinata.put("Succo d'arancia", 2);
		merciDisordinata.put("Pasta", 2);
		merciDisordinata.put("Yogurt", 2);
		
		// STAMPA in console
		System.out.println(merciOrdinata);
		System.out.println("\n\n" + merciDisordinata + "\n\n");
		
		// CICLARE
			// Il ciclo for indicizzato con le mappe non funziona
			// L'unico ciclo che si usa con le mappe e il foreach
		// Le mappe si possono ciclare sia per le chiavi che per i valori
		
			// CICLO per CHIAVI: 
			//	posso ottenere sia le informazioni delle chiavi che i valori collegati alle chiavi
		for(String key : merciOrdinata.keySet()) {
			System.out.println("Chiave " + key + " Valore: " + merciOrdinata.get(key));
		}
		// .keySet() -> Restituisce una lista delle chiavi della mappa
		// mappa.get(key) -> Restituisce il valore associato alla chiave key
		
			// CICLO per VALORI:
			// posso ottenere solo le informazioni legate ai singoli valori (non so nulla delle chiavi)
		for(Integer value : merciOrdinata.values()) {
			System.out.println("Valore: " + value);
		}
		
		// CANCELLARE un valore della mappa
		
		// Per chiave:
		merciOrdinata.remove("Pane");
		//Per coppia chiave valore:
		merciOrdinata.remove("Pane", 10);
	}
}
