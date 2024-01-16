package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
//		1) 	Scrivere un programma che chieda all'utente di inserire dei numeri: quando l'uente scrive 0, 
//    		stampare in console: la somma dei pari, la lista dei multipli di 7, il numero più presente scritto
//    		(usate gli arraylist!!)
		
		Scanner tastiera = new Scanner(System.in);
		int input = 0;
		int i = 0;
		ArrayList<Integer> numeri = new ArrayList<Integer>();
		System.out.println("Inserire il numero desiderato, e premere invio, per terminare il programma digitare 0 e premere invio");
		
		do
		{
			input = Integer.parseInt(tastiera.nextLine());
			if(input != 0)
			{
				numeri.add(i, input);				
			}
			i++;
		}while(input != 0);
		
		tastiera.close();
		
		// SOMMA DEI NUMERI PARI ----------------------------------------------------------------------------------------------------
		
		int somma = 0;
		
		for (Integer n : numeri)
		{
			if(n % 2 == 0)
			{
				somma += n;
			}
		}
		
		System.out.println("\nLa somma dei numeri pari e: " + somma);
		
		// LISTA MULTIPLI DI 7 ---------------------------------------------------------------------------------------------------------
		
		String lista = "";
		
		for (Integer n : numeri)
		{
			if(n % 7 == 0)
			{
				lista += n + ", ";
			}
		}
		
		System.out.println("\nLa lista dei multipli di 7 e: " + lista.substring(0, lista.length()-2));
		
		// IL NUMERO PIU PRESENTE SCRITTO ------------------------------------------------------------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
