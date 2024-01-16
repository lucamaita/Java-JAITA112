package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE CLASSICA
		//
		// 1 > Sequenza 
		// 2 > Selezione (IF, SWITCH, TERNARIO)
		// 3 > Iterazione (WHILE, FOR)
		// 
		//				CICLO FOR
		//Definizione
		//Il ciclo for si dice che cicla per indice.
		//
		//
		//				SINTASSI
		/*
		 	for(int i = 0; i < limite; 1++)
		 	{
		 		istruzione1 da ciclare
		 		istruzione2 da ciclare
		 		....
		 	}
		 	
		 	Nomenclatura parti del FOR:
		 		int i = 0 -> Dichiarazione e inizializzazione dell'indice
		 		i < limite -> Condizione di iterazione
		 		i++ -> Incremento dell'indice
		 
		 	Come ciclo e nato tempo dopo il WHILE e si propone di centralizzare le regole di uso dell'indice.
		 	E il ciclo per eccellenza dei vettori.
		 	
		 	VANTAGGI:
		 		> l'indice e locale solo per il ciclo in questione, fuori dal ciclo i non esiste.
		 		>  Maggiore controllo dell'indice, sia del valore di partenza che dell'incremento.
		 		> Potete scegliere per ogni ciclo da dove partire a leggere, potete scegliere di quanto salire
		 		> Il FOR e una versione del WHILE dopata -> for(;condizione;) posso togliere la prima e l'utima parte. I ; sono obbligatori anche se vuoti.
		 		
		 	CONTRO:
		 		> FOR per sua natura e portato a ciclare un numero finito di volte (non 0 e non infinito)
		 
		 */
		//
		//------------------------------ESERCIZIO------------------------------------------------------------------
		//
		// Chiedere all'utente quante persone ci sono in una classe. Per ogni persona chiedere l'eta
		// Alla fine, voglio vedere l'eta media della classe, il numero di persone sopra i 25 anni, l'eta minore presente.
		
//Passaggi: divido in 4 blocchi: chiederee salvare i dati, quesito1, quesito2, quesito3 
		
// AQUISIZIONE DATI---------------------------------------------------------------------------------------------------------------------------------------------
		//D
		Scanner tastiera;
		int 	numeroPersone;
		int[] 	eta;
		
		//I
		tastiera = (new Scanner(System.in));
		
		System.out.println("Quante persone ci sono in aula?");
		numeroPersone = Integer.parseInt(tastiera.nextLine());
		
		eta = new int[numeroPersone];
		
		//C
		// Si legge "per ogni i che parte da zero, finche i e minore della dimensione di eta, i aumentera di uno a ogni giro
		for(int i = 0; i < eta.length; i++)
		{
			System.out.println("Digita l'eta della persona " + (i+1));
			eta[i] = Integer.parseInt(tastiera.nextLine());
		}
		
		//O
		tastiera.close();
		
// BLOCCO 1---------------------------------------------------------------------------------------------------------------------------------------
		
		//D
		int somma;
		
		//I
		somma = 0;
		
		//C
		for(int i =0; i < eta.length; i++)
		{
			somma += eta[i];
		}
			
		//O
		System.out.println("L'eta media della classe e: " + (somma/eta.length));
		
// BLOCCO 2---------------------------------------------------------------------------------------------------------------------------------------		
		
		//D
		int conta;
		
		//I
		conta = 0;
		
		//C
		for(int i = 0; i < eta.length; i++)
		{
			if(eta[i] > 25)
				conta++;
		}
		
		//O
		System.out.println("Le persone sopra i 25 anni sono: " + conta);
		
		
		
// BLOCCO 3---------------------------------------------------------------------------------------------------------------------------------------		
		
		//D
		int etaMinore;
		
		//I
		etaMinore = Integer.MAX_VALUE;
		
		//C
		for(int i =0; i < eta.length; i++)
		{
			if(eta[i] < etaMinore)
				etaMinore = eta[i];
		}
		
		//O
		System.out.println("L'eta minore e: " + etaMinore);
		
	}

}
