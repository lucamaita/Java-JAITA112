package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE CLASSICA
		// > Sequenza
		// > Selezione (IF, SWITCH, TERNARI)
		// > Iterazione (WHILE, ?)
		
		// FAMIGLIA WHILE: Ciclo while
		// Definizione: Un ciclo WHILE e un ciclo che va da 0 a infinite volte
		
		// SINTASSI
		/*
		 		while(condizione)
		 		{
		 			instruzioni da ciclare;
		 		}
		 */
		
		// Data la posizione della condizione, il ciclo puo non partire mai (se la condizione e sempre falsa)
		// oppure andare avanti all'infinito (se la condizione e sempre vera).
		// Entrambe queste situazioni estreme possono essere problematiche se non gestite bene.
		
		// Esempio pratico
		
		// Chiedere all'utente dei numeri e stampare in console la loro somma. 
		// Fermarsi quando l'utente un numero negativo.
		
		//D
		Scanner scanner;
		int 	numero;
		int 	somma;
		
		//I
		scanner =  new Scanner(System.in);
		numero = 0;
		somma = 0;
		
		while(numero >= 0)
		{
			System.out.println("DIgita un numero: ");
			numero = Integer.parseInt(scanner.nextLine());
			
			//C
			somma += numero;
		}
		
		// Chiudere sempre dopo il ciclo, altrimenti al primo ciclo funzionera e dal secondo si rompera.
		scanner.close();
		
		//O
		System.out.println("La somma vale " + somma);
		
	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
