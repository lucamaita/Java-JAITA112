package esercizio2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Leggete da un file dei dati le informazioni relative a dei film
        // Il file sarà un CSV formattato così:
        // id,titolo,genere,durataMinuti

        // Usate solo le mappe, non voglio vedere classi modello!!

        //Voglio vedere poi:
        // - Lista delle schede dei film
        // - Lista dei titoli dei film
        // - Film più lungo
        // - Durata media dei film di un genere passato dall'utente
        // - Numero di film presenti per ogni genere disponibile
		
		ArrayList<Map<String,String>> netflix = new ArrayList<Map<String,String>>();
		
		Scanner file = new Scanner(new File("src/esercizio2/Dati.txt"));
		
		while(file.hasNextLine()) {
			Map<String,String> film = new LinkedHashMap<String, String>();
			String[] info = file.nextLine().split(",");
			
			//id,titolo,genere,durataMinuti
			
			film.put("id", info[0]);
			film.put("titolo", info[1]);
			film.put("genere", info[2]);
			film.put("durataMinuti", info[3]);
			
			netflix.add(film);
		
		}
		file.close();
		
		System.out.println(schedeFilm(netflix));
		System.out.println(listaTitoli(netflix));
		System.out.println(filmLungo(netflix));
		System.out.println(durataMedia(netflix, "Thriller"));
		System.out.println(numeroGenere(netflix, "Thriller"));
		
	}// FINE STATIC VOID MAIN

	// Metodi
	// - Lista delle schede dei film
	private static String schedeFilm(ArrayList<Map<String,String>> netflix) {
		String ris = "";
		for(Map<String,String> f : netflix) {
			
			ris += "ID: " + f.get("id") + "\n";
	        ris += "Titolo: " + f.get("titolo") + "\n";
	        ris += "Genere: " + f.get("genere") + "\n";
	        ris += "Durata (minuti): " + f.get("durataMinuti") + "\n\n";
		}
		return ris;
	}
	
	// - Lista dei titoli dei film
	private static String listaTitoli(ArrayList<Map<String,String>> netflix) {
		
		String ris = "";
		
		for(Map<String,String> f : netflix) {
			
			ris+= "\n" + f.get("titolo");
		}
		
		
		return ris;
	}
	
	// - Film più lungo
	private static String filmLungo(ArrayList<Map<String,String>> netflix) {
		String ris = "";
		int max = 0;
		for(Map<String,String> f : netflix) {
			if(Integer.parseInt(f.get("durataMinuti")) > max) {
				max = Integer.parseInt(f.get("durataMinuti"));
				ris = f.get("titolo");
			}else if(Integer.parseInt(f.get("durataMinuti")) == max) {
				ris += f.get("titolo");
			}
		}
		return ris;
	}

	// - Durata media dei film di un genere passato dall'utente
	private static double durataMedia(ArrayList<Map<String,String>> netflix, String genere) {
		double ris = 0.0;
		int conta = 0;
		for(Map<String,String> f : netflix) {
			if(f.get("genere").equalsIgnoreCase(genere)) {
				ris += Double.parseDouble(f.get("durataMinuti"));
				conta++;
			}
		}
		
		ris = ris/conta;
		return ris;
	}
	
	// - Numero di film presenti per ogni genere disponibile
	//Numero di film presenti per ogni genere disponibile
	public static String numeroGenere(ArrayList<Map<String,String>> netflix, String genere) {
	    String numeroFilmGenere = "NUMERO DI FILM PER GENERE\n";
	    ArrayList <String> generi = new ArrayList<String>();
	    LinkedHashMap <String,Integer> contaGeneri = new LinkedHashMap<String,Integer>();
	
	    for (Map<String,String> linkedHashMap : netflix){
	        if(!generi.contains(linkedHashMap.get("genere"))){
	            generi.add(linkedHashMap.get("genere"));
	        }
	    }
	
	    int conta = 0;
	    for (String value : generi) {
	        for (Map<String,String> linkedHashMap : netflix) {
	            if(linkedHashMap.get("genere").equals(value)){
	                conta++;
	            }
	        }
	
	        contaGeneri.put(value, conta);
	        conta = 0;
	    }
	
	    for (String key : contaGeneri.keySet()) {
	        numeroFilmGenere +="GENERE: " + key + " : N. PRESENZE " + contaGeneri.get(key) + "\n";
	    }
	    return numeroFilmGenere;
	}
	
}// FINE CLASSE MAIN
