package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
//		1- Scrivere un programma che, dato un numero limite da parte dell'utente,
//		restituisca la serie di fibonacci fino all'indice indicato
//		(Fibonacci: ogni numero è dato dal risultato della somma dei due precedenti
//		ESEMPIO: L'utente dice 8, la serie sarà: 1, 1, 2, 3, 5, 8, 13, 21)
		
		//D
		Scanner scanner;
		int 	fibonacci;
		int 	previousFibonacci;
		int 	limite;
		int 	contatore;
		int 	risultato;
		String 	risposta;
		
		//I
		scanner = new Scanner(System.in);
		risultato = 0;
		fibonacci = 0;
		previousFibonacci = 1;
		limite = 0;
		contatore = 0;
		risposta = "";
		
		System.out.println("Digitare il numero limite");
		limite = Integer.parseInt(scanner.nextLine());
		
		//C
		while (contatore < limite)
		{
			contatore ++;
			risultato = fibonacci + previousFibonacci;
			previousFibonacci = fibonacci;
			fibonacci = risultato;
			risposta += "\n" + risultato;
		}
		
		System.out.println(risposta);
		
		scanner.close();
		
	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
