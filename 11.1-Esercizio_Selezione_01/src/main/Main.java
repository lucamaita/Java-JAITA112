package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		//D
		Scanner 	scanner;
		double 		rettangolobase;
		double 		rettangoloaltezza;
		double 		quadratolato;
		double 		arearettangolo;
		double  	areaquadrato;
		double 		rettangoloperimetro;
		double 		quadratoperimetro;
		String 		areamaggiore;
		
		//I
		scanner  = 				new Scanner(System.in);
		rettangolobase = 		0;
		rettangoloaltezza = 	0;
		quadratolato = 			0;
		arearettangolo = 		0;
		areaquadrato = 			0;
		rettangoloperimetro = 	0;
		quadratoperimetro = 	0;
		areamaggiore = 			"";
		
		System.out.println("Digitare la base del rettangolo in cm, poi premere ENTER");
		rettangolobase = 	Integer.parseInt(scanner.nextLine());
		
		System.out.println("Digitare l'altezza del rettangolo in cm, poi premere ENTER");
		rettangoloaltezza = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Digitare il lato del quadrato in cm, poi premere ENTER");
		quadratolato = 		Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		//C
		quadratoperimetro 		= 		quadratolato * 4;
		rettangoloperimetro 	= 		2 * (rettangolobase + rettangoloaltezza);
		areaquadrato 			= 		quadratolato * quadratolato;
		arearettangolo 			= 		rettangolobase * rettangoloaltezza;
		
		if (arearettangolo > areaquadrato)
		{
			areamaggiore = "Rettangolo";
		}
		else
		{
			areamaggiore = "Quadrato";
		}
		
		//O
		System.out.println	( "Perimetro quadrato: " 				+ quadratoperimetro 	+ "cm"
							+ "\nPerimetro rettangolo: " 			+ rettangoloperimetro 	+ "cm"
							+ "\nArea quadrato: " 					+ areaquadrato 			+ "cm2"
							+ "\nArea rettangolo: " 				+ arearettangolo 		+ "cm2"
							+ "\nLa figura con l'area maggiore e: " + areamaggiore	);

	} // FINE STATIC VOID

} // FINE MAIN
