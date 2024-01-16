package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// PRINCIPI PROGRAMMAZIONE CLASSICA
		// 1- Sequenza: 	Il codice viene letto e conosciuto dalla riga 1 alla riga N in ordine di scrittura
		// 2- Selezione:	Strumenti che ci permettono di scegliere quali comandi eseguire in base a delle condizioni
		//					La selezione ha 3 famiglie di strumenti (IF,?,?)
		// 3- ?????????
		
		// FAMIGLIA IF
		/*
		  		if(condizione)
		  		{
		  			istruzione da eseguire se la condizione e vera;
		  			istruzione2 da eseguire se la condizione e vera;
		  			istruzione3 da eseguire se la condizione e vera;
		  			.....
		  		}
		  		
		  		quando mettiamo tanti IF uno sotto l'altro si chiamano IF PIATTI
		 */
		
		// Chiedere l'eta all' utente e stampare se e maggiorenne o minorenne
		
		// D
		Scanner tastiera;
		int eta;
		String nome;
		String risposta;
		
		// I
		tastiera = new Scanner(System.in);
		eta = 0;
		nome = "";
		risposta = "";
		
		System.out.println("Digita il tuo nome");
		nome = tastiera.nextLine();
		System.out.println("Digita la tua eta");
		eta = Integer.parseInt(tastiera.nextLine());
		
		tastiera.close();
		
		// C
		// IF PIATTI
		if(eta > 17)
		{
			// Se la condizione e vera il programma legge la riga 55, se la condizione e 
			// falsa, il proghramma salta subito alla riga 57
			risposta = "MAGGIORENNE";
		}
		if(eta < 18)
		{
			// Se la condizione e vera il programma legge la riga 61, se la condizione e 
			// falsa, il proghramma salta subito alla riga 65
			risposta = "MINORENNE";
		}
		
		// IF ELSE
		if(eta > 17)
		{
			risposta = "MAGGIORENNE";
		}
		else
		{
			// ELSE  prende tutti i casi che non rientrano nelle condizioni dell'IF
			risposta = "MINORENNE";
		}
		// O
		System.out.println("Ciao " + nome + " sei " + risposta);

	} // NON CANCELLARE - CHIUSURA STATIC VOID

} // NON CANCELLARE - CHIUSURA MAIN
