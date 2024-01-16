package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// Selezione
		// > IF (if, if-else, elseif)
		// > SWITCH
		// > ?
		
		// SWITCH: Mi permette di valutare e quindi sceglire che comportamento tenere in situazioni
		// 		   piu "limitate" rispetto all'IF.
		// 		   E comunque molto piu performante.
		
		/*
		 		SINTASSI
		 		
		 		switch(variabile_che_vogliamo_controllare)
		 		{
		 			case valore_di_paragone_1:
		 				istruzione1;
		 				istruzione2;
		 				istruzione3;
		 			break;
		 			case valore_di_paragone_2:
		 				istruzione1;
		 				istruzione2;
		 			break;
		 			default :
		 				istruzione1;
		 				istruzione2;
		 				.....
		 			break;
		 		}
		 */
		
		// Immaginiamo di dover calcolare il prezzo di un biglietto del treno che parte da Milano Centrale
		
		// D
		String stazionePartenza;
		String stazioneArrivo;
		double prezzoBiglietto;
		Scanner tastiera;
		String risposta;
		
		// I
		tastiera = new Scanner(System.in);
		stazionePartenza = "Stazione Centrale Milano";
		prezzoBiglietto = 0;
		risposta = "";
		
		System.out.println("In che stazione vuoi andare?");
		stazioneArrivo = tastiera.nextLine();
		
		tastiera.close();
		
		// C
		// .toLowerCase -> Rende temporaneamente il contenuto della variabile tutto minuscolo
		switch(stazioneArrivo.toLowerCase())
		{
			case "bergamo":
			case "como":
				// In questo caso, Bergamo e Como hanno la stessa fascia tariffaria quindi mi torna comodo
				// levare il break di turno
				prezzoBiglietto = 5.50;
				break;
			case "brescia":
				prezzoBiglietto = 8.60;
				break;
			case "venezia":
				prezzoBiglietto = 45.90;
				break; // Se manca si finisce in automatico nei comandi del case sottostante
			case "napoli":
				prezzoBiglietto = 79.90;
				break;
			// Qui dentro finiscono tutti i casi che non sono stati considerati dai CASE sopra
			// DEFAULT e facolatativo: cioe potete metterlo o non metterlo, non cambia nulla
			default:
				risposta = "La stazione non esiste";
				break;
		
		} // FINE SWITCH
		
		// risposta puo avere 2 valori soltanto:
		// "" -> accade se la stazione e valida e ha caricato il prezzo del biglietto
		// "La stazione non esiste" -> Accade se la stazione non e valida e il biglietto resta a 0
		
		if(risposta.isEmpty()) // .isEmpty() mi da True se risposta non contiene caratteri al suo interno
		{
			risposta = "Il tuo biglietto cosa " + prezzoBiglietto + "$";
		}
		System.out.println(risposta);
		
		
		

	} // NON CANCELLARE - CHIUSURA STATIC VOID

} // NON CANCELLARE - CHIUSURA MAIN
