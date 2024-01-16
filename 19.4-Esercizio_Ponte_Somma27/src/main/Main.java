package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
//		2- Far inserire dei numeri all'utente finche la somma di essi non raggiunge il valore 27(quindi finchè somma < 27).
//		Stampare in console la somma dei numeri inseriti e il numero di volte che l'utente ha 
//		inserito un numero maggiore di 10.
		
		//D
		Scanner scanner;
		int 	somma;
		int 	totale;
		int 	contatore;
		int 	limite;
		
		//I+C
		scanner = new Scanner (System.in);
		somma = 0;
		totale = 0;
		contatore = 0;
		limite = 27;
	
		while (totale < limite)
		{
		System.out.println("Inserire i valori: ");
		somma = Integer.parseInt(scanner.nextLine());
		if (somma > 10) contatore ++;								// If in linea
//		contatore = somma > 10 ? contatore + 1 : contatore + 0; 	// Ternario
		totale += somma;
		}
		
		scanner.close();
		
		//O
		System.out.println(totale + ", " + contatore);
		
	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
