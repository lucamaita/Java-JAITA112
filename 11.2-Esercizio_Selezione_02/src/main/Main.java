package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		//D
		Scanner scanner;
		double 	num1;
		double 	num2;
		double 	num3;
		double 	risposta;
		
		//I
		scanner = new Scanner(System.in);
		num1 = 0;
		num2 = 0;
		num3 = 0;
		risposta = 0;
		
		System.out.println("Digitare il primo numero, poi premere ENTER");
		num1 = Double.parseDouble(scanner.nextLine());
		System.out.println("Digitare il secondo numero, poi premere ENTER");
		num2 = Double.parseDouble(scanner.nextLine());
		System.out.println("Digitare il terzo numero, poi premere ENTER");
		num3 = Double.parseDouble(scanner.nextLine());
		
		scanner.close();
		
		//C
		if ((num1 > num2) && (num1 > num3))
		{
			risposta = num1;
		}
		else if ((num2 > num1) && (num2 > num3))
		{
			risposta = num2;
		}
		else if ((num3 > num1) && (num3 > num2))
		{
			risposta = num3;
		}
		
		//O
		System.out.println("Il numero piu grande e: " + risposta);
	} // NON CANCELLARE

} // NON CANCELLARE
