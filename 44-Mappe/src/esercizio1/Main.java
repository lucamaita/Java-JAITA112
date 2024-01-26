package esercizio1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Chiedete all'utente una serie di informazioni legate alla sua anagrafica.
		// Salvate le informazioni in una mappa.
		// Stampate poi la scheda riassuntiva ordinata delle informazioni prese da console.
		
		Scanner tastiera;
		tastiera = new Scanner(System.in);
		Map<String, String> anagrafica;
		anagrafica = new LinkedHashMap<String, String>();
		
		System.out.println("Digita il tuo nome, poi premi INVIO");
		anagrafica.put("Nome", tastiera.nextLine());
		System.out.println("Digita il tuo cognome, poi premi INVIO");
		anagrafica.put("Cognome", tastiera.nextLine());
		System.out.println("Digita la tua eta, poi premi INVIO");
		anagrafica.put("Eta", tastiera.nextLine());
		System.out.println("Digita la tua citta di residenza, poi premi INVIO");
		anagrafica.put("Residenza", tastiera.nextLine());
		
		tastiera.close();
		
		for(String key : anagrafica.keySet())
			System.out.println( key + ": " + anagrafica.get(key));
		
	}

}// Fine Classe Main
