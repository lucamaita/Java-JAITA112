package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

	// throws FileNotFoundExpception indica che no nvogliamo gestire gli errori legati alla location del file:
	// se il file non viene trovato, il programma esplode con il nostro permesso
	public static void main(String[] args) throws FileNotFoundException
	{
		// Il nostro compito e leggere il contenuto di file.txt e poi:
		// - Scheda dei singoli alcolici
		// - Il nome dell'alcolico con gradazione minore
		
		//D
		Scanner file;
		String 	tipoAlcolico;
		String 	nomeAlcolico;
		double 	gradazioneAlcol;
		double 	minoreGradazione;
		String 	risposta;
		String 	percorsoGlobale;
		String 	percorsoLocale;
		String 	nomeAlcolicoMinore;
		
		//I
		risposta = "";
		minoreGradazione = Integer.MAX_VALUE; //oppure 100 perche sappiamo che la gradazione non puo superare i 100 gradi 
		nomeAlcolicoMinore = "";
		
		// PERCORSO: e la strada che il pc deve fare per arrivare esattamente dove e salvato il 
		// 				file che vi interessa
		// Globale: percorso completo che parte dal vostro disco rigido (di solito C:)
		// Locale: percorso ristretto perche parte dalla cartella del progetto che stiamo usando (inizia di solito con src)
		percorsoGlobale = "C:\\Users\\lucam\\Documents\\JAITA112\\18-Lettura_Da_File\\src\\res\\File.txt";
		percorsoLocale = "src/res/File.txt";
		
		// importare file sceglieno il pacchetto java.io.file;
		// Bisogna scegliere la voce "Add throws Exception" per levare la sottolineatura
		file = new Scanner(new File(percorsoLocale));
		
		//C
		//.hasNextLine() -> Controlla se esiste una riga da leggere (TRUE/FALSE)
		while (file.hasNextLine())
		{
			// Dato che il file e stato formattato secondo l'ordine: tipo-nome-gradazione
			// so che leggero in ordine tipoAlcolico, nomeAlcolico, gradazioneAlcol
			
			// Sapendo l'ordine, parto a leggere e assegnare i valori del file
			
			// Leggo tutti i dati del primo alcolico
			tipoAlcolico = file.nextLine();
			nomeAlcolico = file.nextLine();
			gradazioneAlcol = Double.parseDouble(file.nextLine());
			//bandiera = file.nextLine().equalsIgnoreCase("") // lettura booleano con lettera
			
			// Scrivo la scheda ordinata dell'alcolico letto
			risposta += "\nTipo: " 			+ tipoAlcolico 		+
						"\nNome: " 			+ nomeAlcolico 		+
						"\nGradazione: "  	+ gradazioneAlcol 	+ "%" +
						"\n------------------------------------------";
			
			// Trovo la gradazione minore
			if(gradazioneAlcol < minoreGradazione)
			{
				minoreGradazione = gradazioneAlcol;
				nomeAlcolicoMinore = nomeAlcolico;
			}
			else if(gradazioneAlcol == minoreGradazione)
			{
				nomeAlcolicoMinore += ", " + nomeAlcolico;
			}
		} // Fine WHILE
		
		file.close();
		
		//O
		System.out.println(	"\tELENCO ALCOLICI" 					 + risposta + 
							"\nL'alcolico con gradazione minore e: " + nomeAlcolicoMinore +
							" con " 								 + minoreGradazione + "%");
		
		
		
	} // NON CANCELLARE - FINE STATIC VOID


} // NON CANCELLARE - FINE MAIN
