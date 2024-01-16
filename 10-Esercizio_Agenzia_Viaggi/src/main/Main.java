package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// AGENZIA VIAGGI
		
		// Dovete organizzare un viaggio all'estero.
		// Dal clienete (che e un'agenzia viaggi) vi farete passare le seguenti informazioni:
		// 	- destinazione
		// 	- mezzo di locomozione
		// 	- durata viaggio (quanti giorni)
		// 	- numero di partecipanti al viaggio
		
		// Dovete creare una scheda ordinata con le informazioni che vi hanno passato e dovete calcolare il
		// prezzo del viaggio per i singoli partecipanti, sapendo che:
		// Il costo in base al mezzo di locomozione sara:
		// 	- aereo: 500$
		// 	- treno: 300$
		// 	- traghetto: 450$
		// 	- pullman: 350$
		// 	- altro: 1000$
		// Il costo in base alla destinazione sara:
		// 	- Roma: 50$
		// 	- Dubai: 200$
		// 	- Tokyo: 500$
		// 	- Dublino: 150$
		// 	- Amsterdam: 90$
		// 	- Altro: 1500$
		// Ogni giorno di viaggio ha una base fissa di 10.50$
		// Se il numero di partecipanti e inferiore a 10 si calcoli una penale aggiuntiva del 2%,
		///se sono tra 11 e 20, pagano una penale del 0.5%,
		// se sono piu di 20, hanno diritto allo sconto comitiva del 5% sul totale
		// Nella scheda ordinata del viaggio voglio vedere tutti i dati che sono stati passati dal cliente
		// il prezzo complessivo del viaggio e il prezzo che paga la singola persona che partecipa al viaggio 
		
		/*
		 * 			SCHEDA VIAGGIO
		 * 		Destinazione: Dubai
		 * 		Mezzo: Monopattino Elettrico
		 * 		Durata : 40 giorni
		 * 		Partecipanti : 30 persone
		 * 
		 * 		Costo totale: millemila euro
		 * 		Sconto: 5% / Penale: 2% (Facoltativo)
		 * 		Costo per partecipante: 10 euro caduno
		 */
		
		
		
		//D
		Scanner	scanner;
		String 	risposta;
		int 	destinazione;
		String  destinazioneScheda;
		int 	mezzo;
		String  mezzoScheda;
		int 	durata;
		int 	partecipanti;
		double 	costoMezzo;
		double 	costoDestinazione;
		double	tariffaGiornaliera;
		double 	penale;
		double 	penaleMid;
		double 	sconto;
		String  sconto_penale;
		double 	totale;
		double 	totale_a_persona;
		
		//I
		scanner = 				new Scanner(System.in);
		risposta = 				"";
		destinazione =			0;
		destinazioneScheda = 	"";
		mezzo = 				0;
		mezzoScheda = 			"";	
		durata = 				0;
		partecipanti = 			0;
		costoMezzo = 			0;
		costoDestinazione = 	0;
		tariffaGiornaliera = 	10.50;
		penale = 				0.02;
		penaleMid = 			0.005;
		sconto = 				0.05;
		totale = 				0;
		totale_a_persona = 		0;
		sconto_penale =         "";
		
		System.out.println("Selezionare la destinazione:"
							+ "\nDigitare 1 per Roma (50$)."
							+ "\nDigitare 2 per Dubai (200$)"
							+ "\nDigitare 3 per Tokyo (500$)"
							+ "\nDigitare 4 per Dublino (150$)"
							+ "\nDigitare 5 per Amsterdam (90$)"
							+ "\nDigitare 6 per Altro (1500$)"
							+ "\nPremere ENTER una volta digitato il numero corrispondente.");
		destinazione = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Selezionare il mezzo di trasporto desiderato:"
							+ "\nDigitare 1 per Aereo (50$)."
							+ "\nDigitare 2 per Treno (300$)"
							+ "\nDigitare 3 per Traghetto (450$)"
							+ "\nDigitare 4 per Pullman (350$)"
							+ "\nDigitare 5 per Altro (1000$)"
							+ "\nPremere ENTER una volta digitato il numero corrispondente.");
		mezzo = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Specificare la durata del viaggio in giorni, poi premere ENTER");
		durata = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Specificare il numero di partecipanti al viaggio, poi premere ENTER");
		partecipanti = Integer.parseInt(scanner.nextLine());
		
		scanner.close();

		
		switch(destinazione)
		{
			case 1:
				destinazione = 50;
				destinazioneScheda = "Roma";
				break;
			case 2:
				destinazione = 200;
				destinazioneScheda = "Dubai";
				break;
			case 3:
				destinazione = 500;
				destinazioneScheda = "Tokyo";
				break;
			case 4:
				destinazione = 150;
				destinazioneScheda = "Dublino";
				break;
			case 5:
				destinazione = 90;
				destinazioneScheda = "Amsterdam";
				break;
			case 6:
				destinazione = 1500;
				destinazioneScheda = "Altro";
				break;
			default:
				destinazione = 9999999;
				destinazioneScheda = "Input Error";
				break;
		} // FINE SWITCH
		
		switch(mezzo)
		{
			case 1:
				mezzo = 500;
				mezzoScheda = "Aereo";
				break;
			case 2:
				mezzo = 300;
				mezzoScheda = "Treno";
				break;
			case 3:
				mezzo = 450;
				mezzoScheda = "Traghetto";
				break;
			case 4:
				mezzo = 350;
				mezzoScheda = "Pullman";
				break;
			case 5:
				mezzo = 1000;
				mezzoScheda = "Altro";
				break;
			default:
				mezzo = 9999999;
				mezzoScheda = "Input Error";
				break;
		} // FINE SWITCH
		
		//C
		totale = (destinazione + mezzo) + ((tariffaGiornaliera * durata) * partecipanti);
		
		if (partecipanti <10)
		{
			totale = totale + (totale * penale);
			sconto_penale = "E stata applicata una penale del 2% poiche i partecipanti sono inferiori a 10";
		}
		else if ((partecipanti >10) && (partecipanti <21))
		{
			totale = totale + (totale * penaleMid);
			sconto_penale = "E stata applicata una penale del 0.5% poiche i partecipanti sono inferiori a 21";
		}
		else if (partecipanti >20)
		{
			totale = totale - (totale * sconto);
			sconto_penale = "E stato applicato uno sconto del 5% poiche i partecipanti sono superiori a 20";
		}
		
		totale_a_persona = totale/partecipanti;
		
		
		
		//O
		System.out.println("\t\t\tSCHEDA VIAGGIO"
				+ "\nDestinazione: \t\t" + destinazioneScheda 
				+ "\nMezzo: \t\t\t" + mezzoScheda
				+ "\nDurata: \t\t" + durata + " giorni"
				+ "\nPartecipanti: \t\t" + partecipanti
				+ "\nCosto totale: \t\t" + totale
				+ "\nCosto per partecipante: " + totale_a_persona
				+ "\n" + sconto_penale);

	} // NON CANCELLARE - CHIUSURA STATIC VOID MAIN

} // NON CANCELLARE - CHIUSURA MAIN
