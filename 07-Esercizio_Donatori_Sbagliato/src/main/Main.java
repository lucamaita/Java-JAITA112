package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// ESERCIZIO SELEZIONE
		// Scrivere un programma che capisca se la persona davanti a lui puo donare oppure no.
		// Le regole sono le seguenti:
		// - Deve essere Maggiorenne
		// - Devono esserere passati 6 mesi per le donne e 4 per gli uomini dall'ultima donazione
		// - Non deve aver fatto tatuaggi negli ultimi 6 mesi
		// - Non deve essersi drogato
		// - Deve essere esente da patologie ematiche 
		// - Non deve aver subito trasfusioni negli ultimi 6 mesi
		
		// Chiedere i dati necessari all'utente e stampare in fine in console se puo donare oppure no 
		
		// D
		Scanner tastiera;
		String	nome;
		String	cognome;
		String 	rispostaY;
		String  rispostaN;
		String 	eta;
		String 	sesso;
		String 	donazioneM;
		String	donazioneF;
		String 	ultimotatuaggio;
		String 	sostanze;
		String	patologie;
		String 	trasfusioni;
		String  y;
		String  n;
		String  m;
		String  f;
		
		// I
		tastiera = new Scanner(System.in);
		nome = 				"";
		cognome = 			"";
		rispostaY = 		"";
		rispostaN = 		"";
		eta = 				"";
		sesso = 			"";
		donazioneM = 		"";
		donazioneF =  		"";
		ultimotatuaggio = 	"";
		sostanze = 			"";
		patologie = 		"";
		trasfusioni = 		"";
		y = 				"Y";
		n = 				"N";
		m = 				"M";
		f = 				"F";
		
		
		
		// ??
		System.out.println("Digitare il nome e premere ENTER");
		nome = tastiera.nextLine();
		System.out.println("Digitare il cognome e premere ENTER");
		cognome = tastiera.nextLine();
		System.out.println("Sei maggiorenne? Se si digitare Y, altrimenti digitare N, e premere ENTER");
		eta = tastiera.nextLine();
		if (eta.equalsIgnoreCase("N"));
		{
			System.out.println("Ci dispiace " + cognome + " " + nome + " ma non risulta idoneo alla donazione.");
		}
		System.out.println("Indicare il proprio sesso, digitare M per maschile o F per femminile, poi premere ENTER ");
		sesso = tastiera.nextLine();
		if(sesso == "M");
		{
			System.out.println("Sono passati almeno 4 mesi dall'ultima donazione? Se si digitare Y, altrimenti digitare N, e premere ENTER");
			donazioneM = tastiera.nextLine();
			if (donazioneM == "N");
			{
				System.out.println("Ci dispiace " + cognome + " " + nome + " ma non risulta idoneo alla donazione.");
				System.exit(0);
			}
		}
		if(sesso == "F");
		{
			System.out.println("Sono passati almeno 6 mesi dall'ultima donazione? Se si digitare Y, altrimenti digitare N, e premere ENTER");
			donazioneF = tastiera.nextLine();
			if (donazioneF == "N");
			{
				System.out.println("Ci dispiace " + cognome + " " + nome + " ma non risulta idoneo alla donazione.");
			}
		}
		System.out.println("Sono stati fatti tatuaggi negli ultimi 6 mesi? Se si digitare Y, altrimenti digitare N, e premere ENTER");
		ultimotatuaggio = tastiera.nextLine();
		if (ultimotatuaggio == "Y");
		{
			System.out.println("Ci dispiace " + cognome + " " + nome + " ma non risulta idoneo alla donazione.");
		}
		System.out.println("Si sono assunte droghe negli ultimi 6 mesi? Se si digitare Y, altrimenti digitare N, e premere ENTER");
		sostanze = tastiera.nextLine();
		if (sostanze == "Y");
		{
			System.out.println("Ci dispiace " + cognome + " " + nome + " ma non risulta idoneo alla donazione.");
		}
		System.out.println("Si e portatori di patologie ematiche? Se si digitare Y, altrimenti digitare N, e premere ENTER");
		patologie = tastiera.nextLine();
		if (patologie == "Y");
		{
			System.out.println("Ci dispiace " + cognome + " " + nome + " ma non risulta idoneo alla donazione.");
		}
		System.out.println("Sono state ricevute trasfusioni negli ultimi 6 mesi? Se si digitare Y, altrimenti digitare N, e prmere ENTER");
		trasfusioni = tastiera.nextLine();
		if (trasfusioni == "Y");
		{
			System.out.println("Ci dispiace " + cognome + " " + nome + ", ma non risulta idoneo alla donazione.");
		}
		
		tastiera.close();
		
		System.out.println("Gentile sig/sig.ra. " + cognome +  ", siamo felici di informarla che risulta idoneo alla donazione.");
		

			

	} // NON CANELLARE - CHIUSURA STATIC VOID

} // NON CANCELLARE - CHIUSUSRA MAIN
