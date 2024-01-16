package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// Scrivere un programma che chieda all'utente di inserire una serie di numeri postivi.
		// Se il numero inserito e negativo, segnalare tramite una stampa che il numero non va bene
		// e non considerarlo nei calcoli.
		// per terminare il programma indicare all'utente di scrivere 0.
		// il programma deve:
		// - fare la somma di tutti i numeri inseriti
		// - fare la somma dei numeri pari
		// - fare il prodotto dei numeri multipli di 3
		// - contare quanti numeri dispari scrive l'utente
		// BONUS
		// - trovare il numero maggiore inserito dall'utente
		
		// Stampare infine in console in modo ordinato le richieste precedenti
		
		//D
		Scanner scanner;
		String 	numeroNonValido;
		int 	numero;
		int 	sommaTutti;
		int 	sommaPari;
		int 	prodottox3;
		int 	conteggioDispari;
		int 	numMaggiore;
		
		//I
		scanner = new Scanner(System.in);
		numeroNonValido = "Il numero inserito non e valido";
		numero = 1;
		sommaTutti = 0;
		sommaPari = 0;
		prodottox3 = 1;
		conteggioDispari = 0;
		numMaggiore = 0;
		
		while (numero > 0)
		{
			System.out.println("Digita un numero: " + "\nPer terminare il programma digitare 0");
			numero = Integer.parseInt(scanner.nextLine());
			
			if (numero > 0)
			{
				sommaTutti = numero + sommaTutti;
				
				if ((numero % 2) == 0)
				{
					sommaPari = numero + sommaPari;
				}
				else
				{
					conteggioDispari = conteggioDispari + 1;
				}
				if ((numero % 3) == 0)
				{
					prodottox3 = numero * prodottox3; // (if prodotto =1 || prodotto < 3 allora prodotto = 0 (?))
				}
				if (numero > numMaggiore)
				{
					numMaggiore = numero;
				}
			} // FINE IF
			else if (numero < 0)
			{
				System.out.println(numeroNonValido);
				numero = 1;
			}
			
		prodottox3 = (prodottox3 == 1) ? 0 : prodottox3;
		
		} // FINE WHILE
		
		scanner.close();
		
		System.out.println("La somma di tutti i numeri Inseriti e: " 		+ sommaTutti
							+ "\nLa somma di tutti i numeri pari e: " 		+ sommaPari
							+ "\nIl prodotto dei numeri multipli di 3 e: " 	+ prodottox3
							+ "\nI numeri dispari inseriti sono: " 			+ conteggioDispari
							+ "\nIl numero maggiore inserito e: " 			+ numMaggiore);
	} // FINE STATIC VOID

} // FINE MAIN
