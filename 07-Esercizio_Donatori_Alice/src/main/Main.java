package main;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		// ESERCIZIO SELEZIONE
		// Scrivere un programma che capisca se la persona davanti a lui può donare oppure no.
		// Le regole sono le seguenti:
		// - Deve essere maggiorenne
		// - Devono essere passati 6 mesi per le donne e 4 per gli uomini dall'ultima donazione
		// - Non deve aver fatto tatuaggi negli ultimi 6 mesi
		// - Non deve essersi drogato
		// - Deve essere esente da patologie ematiche
		// - Non deve aver subito trasfusioni negli ultimi 6 mesi
		
		// Chiedere i dati necessari all'utente e stampare infine in console se può donare oppure no
		
		// D
		Scanner tastiera;
		String nome;
		int eta;
		String sesso;
		int mesiDallUltimaDonazione;
		int mesiDallUltimoTatuaggio;
		boolean drogato;
		boolean patologieEmatiche;
		int mesiDallUltimaTrasfusione;
		String risposta;
		
		// I
		tastiera = new Scanner(System.in);
		//risposta = ""; -> Se uso questa devo togliere i commenti a tutti gli else sotto
		risposta = "Spiacenti, non puoi donare";
		// Volendo potrei inizializzare tutte le mie variabili con valori neutri 
		//(0 per i numeri, "" per le stringhe e false per i booleani) 
		
		// C
		System.out.println("Come ti chiami?");
		nome = tastiera.nextLine();
		
		System.out.println("Quanti anni hai?");
		eta = Integer.parseInt(tastiera.nextLine());
		
		if(eta > 17)
		{
			// Se entro qui significa che la persona è maggiorenne, e potrò fare altre domande
			System.out.println("Indica il tuo genere: M per maschio e F per femmina");
			sesso = tastiera.nextLine();
			System.out.println("Quanti mesi sono passati dall'ultima donazione?");
			mesiDallUltimaDonazione = Integer.parseInt(tastiera.nextLine());
			
			// Le stringhe si uguagliano con .equalsIgnoreCase()
			// Java è caseSensitive(cioè A è diverso da a): lo strumento scritto sopra 
			// permette di ignorare la differenza legata al CAPS dei caratteri
			
			// Operatori Logici
			// AND -> && Prevede che entrambe le condizioni siano vere in contemporanea
			// OR  -> || Prevede che anche solo una delle condizioni sia vera
			// NOT -> !  Prevede che la condizione sia falsa (si usa quando cerchiamo DIVERSO DA)
			
			// 			UGUAGLIANZE tra tipi
			// == 	--> si usa per numeri(interi o decimali non importa) e per booleani
			// .equalsIgnoreCase() 	--> si usa per i tipi String
			// 			DISUGUAGLIANZE
			// != --> numeri e booleani (5 != 6 oppure drogato != true)
			// !nome_variabile.equalsIgnoreCase() --> si usa per le stringhe
			if(
				(sesso.equalsIgnoreCase("m") && mesiDallUltimaDonazione > 4) ||
				(sesso.equalsIgnoreCase("f") && mesiDallUltimaDonazione > 6)
			  )
			{
				System.out.println("Ti sei mai drogato? Y/N");
				// Scrivendo così riesco a trasformare la stringa letta in console in TRUE/FALSE 
				// grazie alla mediazione dello strumento .equalsIgnoreCase()
				drogato = tastiera.nextLine().equalsIgnoreCase("y");
				
				if(drogato == false)
				{
					System.out.println("Quanti mesi sono passati dall'ultimo tatuaggio? "
							         + "Se non hai tatuaggi scrivi -1");
					mesiDallUltimoTatuaggio = Integer.parseInt(tastiera.nextLine());
					
					if(mesiDallUltimoTatuaggio > 6 || mesiDallUltimoTatuaggio < 0)
					{
						System.out.println("Hai patologie ematiche? Y/N");
						patologieEmatiche = tastiera.nextLine().equalsIgnoreCase("y");
						
						if(patologieEmatiche == false)
						{
							System.out.println("Quanti mesi sono passati dall'ultima trasfusione? "
							         		 + "Se non hai trasfuso scrivi -1");
							mesiDallUltimaTrasfusione = Integer.parseInt(tastiera.nextLine());
							
							if(mesiDallUltimaTrasfusione > 6 || mesiDallUltimaTrasfusione < 0)
							{
								risposta = "Ottimo " + nome + " puoi donare!";
							}
//							else
//							{
//								risposta = "Spiacenti " + nome + " non puoi donare perchè hai trasfuso";
//							}
						}
//						else
//						{
//							risposta = "Spiacenti " + nome + " non puoi donare perchè sei malato";
//						}
					}
//					else
//					{
//						risposta = "Spiacenti " + nome + " non puoi donare perchè ti sei tatuato di recente";
//					}
				}
//				else
//				{
//					risposta = "Spiacenti " + nome + " non puoi donare perchè ti droghi";
//				}
			}
//			else
//			{
//				// Arrivo qui se la persona non rispetta il limite del sesso/mesi donazione
//				risposta = "Spiacenti " + nome + " non puoi donare perchè non è passato abbastanza "
//						 + "tempo dall'ultima donazione";
//			}
			
			// Arrivo qui se ho finito tutti gli IF sopra
		}
//		else
//		{
//			risposta = "Spiacenti " + nome + " non puoi donare perchè minorenne";
//		}
		
		tastiera.close();
		// O
		System.out.println(risposta);
	}
}