package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		//D
		Scanner 	scanner;
		double		bigliettoBase;
		String		nome;
		String		cognome;
		int 		eta;
		int 		bagagli;
		int 		destinazione;
		String 		destinazioneScelta;
		double		tariffaBagaglio;
		double 		scontoUnder;
		double 		scontoOver;
		String 		scontoBiglietto;
		double 		totale;
		
		//I
		scanner = 				new Scanner(System.in);
		bigliettoBase = 		50;
		nome = 					"";
		cognome = 				"";
		eta = 					0;
		bagagli = 				0;
		destinazione = 			0;
		destinazioneScelta =  	"";
		tariffaBagaglio = 		20;
		scontoUnder = 			0.5;
		scontoOver = 			0.75;
		scontoBiglietto = 		"";
		totale = 				0;
		
		System.out.println(	"Benvenuti alla Generation Airlines!"
						+ 	"\nVi informiamo che il biglietto base in questo aereoporto ammonta a 50$"
						+ 	"\nSe si desidera procedere, digitare il proprio Nome, e in seguito premere ENTER");
		nome = 		scanner.nextLine();
		
		System.out.println(	"Digitare il proprio Cognome, poi premere ENTER");
		cognome = 	scanner.nextLine();
		
		System.out.println(	"Inserire la propria eta, poi premere ENTER");
		eta = 		Integer.parseInt(scanner.nextLine());
		
		System.out.println(	"Indicare il numero di bagagli, poi premere ENTER");
		bagagli = 	Integer.parseInt(scanner.nextLine());
					
		System.out.println(	"\nSelezionare la destinazione desiderata.)."
							+ "\nDigitare 1 per New York  (200$)"
							+ "\nDigitare 2 per Milano (150$)"
							+ "\nDigitare 3 per Madrid (100$)"
							+ "\nDigitare 4 per Napoli (80$)"
							+ "\nDigitare 5 per Campobasso (1500$)"
							+ "\nPremere ENTER una volta digitato il numero corrispondente.");
		destinazione = Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		switch(destinazione)
		{
			case 1:
				destinazione = 200;
				destinazioneScelta = "New York";
				break;
			case 2:
				destinazione = 150;
				destinazioneScelta = "Milano";
				break;
			case 3:
				destinazione = 100;
				destinazioneScelta = "Madrid";
				break;
			case 4:
				destinazione = 80;
				destinazioneScelta = "Napoli";
				break;
			case 5:
				destinazione = 1500;
				destinazioneScelta = "Campobasso";
				break;
			default:
				destinazione = 999999;
				destinazioneScelta = "Input Error";
				break;
		} // FINE SWITCH
		
		//C
		totale = bigliettoBase + destinazione + (tariffaBagaglio * bagagli);
		
		if (eta <18)
		{
			totale = totale * scontoUnder;
			scontoBiglietto = "(Sconto minorenni: -50%)";
		}
		
		else if (eta > 70)
		{
			totale = totale * scontoOver;
			scontoBiglietto = "(Sconto over 70: -25%)";
		}
		
		else if ((eta > 18) && (eta < 71))
		{
			scontoBiglietto = "(Nessuno sconto applicabile)";
		}
		
		//O
		System.out.println  ( "---------------------------------------------------------------------"
							+ "\n\n\t\t\tBiglietto"
							+ "\n\nNominativo: \t\t" 		+ nome + " " + cognome
							+ "\nEta: \t\t\t" 				+ eta
							+ "\nNumero Bagagli: \t" 		+ bagagli
							+ "\nDestinazione: \t\t" 		+ destinazioneScelta 
							+ "\nTotale Biglietto: \t" 		+ totale + "$" + " " + scontoBiglietto
							+ "\n---------------------------------------------------------------------"); 
	
	
	} // NON CANCELLARE - FINE STATIC VOID MAIN

} // NON CANCELLARE - FINE MAIN
