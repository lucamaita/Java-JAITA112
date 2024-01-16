package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// Lavorate in una biglietteria a Vezio.
		// Sapete che il biglietto intero costa 10$.
		// Sapete anche che il museo applica i seguenti sconti (non cumulabili)
		// - I residenti a Vezio e a Como entrano gratis
		// - Gli studenti hanno diritto al 30% di sconto sul biglietto
		// - Gli under 12 e gli over 65 hanno diritto al 50% di sconto
		// - I militari e i medici hanno diritto al 65% di sconto
		
		// Scrivere un programma che chieda i dati all utente e calcoli il prezzo del suo biglietto
		
		//-D
		Scanner 	tastiera;
		int 		intero;
		String		categoria;
		double		prezzoBiglietto;
		String 		risposta;
		
		//-I
		tastiera = 			new Scanner(System.in);
		intero =			10;
		categoria = 		"";
		risposta =			"";
		
		System.out.println("Benvenuti al museo di Vezio, selezionare la propria categoria di apparntenenza."
							+ "\nIn caso apprteniate a piu categorie, selezionate quella con lo sconto piu elevato."
							+ "\nDigitare 1 se si e residenti a Vezio o Como - 100% Off"
							+ "\nDigitare 2 se si e studenti - 30% Off"
							+ "\nDigitare 3 se si e sotto i 12 anni o oltre i 65 - 50% Off"
							+ "\nDigitare 4 se si e militari o medici.- 65% Off"
							+ "\nPremere ENTER se non si rientra in nessuna categoria");
							
		categoria = tastiera.nextLine();
		
		tastiera.close();
		
		switch(categoria)
		{
			case "1":
				prezzoBiglietto = 0;
				break;
			case "2":
				prezzoBiglietto = intero * 0.7;
				break;
			case "3":
				prezzoBiglietto = intero * 0.5;
				break;
			case "4":
				prezzoBiglietto = intero * 0.35;
				break;
			default:
				prezzoBiglietto = intero;
				risposta = "Nessuno sconto applicato. Totale:" + intero + "$";
				break;
		} // FINE SWITCH
	
		if(risposta.isEmpty())
		{
			risposta = "Il tuo biglietto cosa " + prezzoBiglietto + "$";
		}
		System.out.println(risposta);

		
	} // NON ELIMINARE - FINE STATIC VOID

} // NON ELIMINARE - FINE MAIN
