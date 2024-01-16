package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		//D
		Scanner 			scanner;
		String 				nomecognome;
		int					eta;
		int 				residenza;
		double 				stipendiomedio;
		double 				tassemensili;
		double 				tassamensilepagata;
		double 				tasseannualipagate;
		int 				mensilita;
		double 				tassacomune;
		double 				tassaeta;
		
		//I
		scanner = 			new Scanner(System.in);
		nomecognome = 		"";
		eta = 				0;
		residenza = 		0;
		stipendiomedio = 	0;
		tassemensili = 		0;
		tasseannualipagate =0;
		mensilita = 		0;
		tassacomune = 		0;
		tassaeta = 			0;
		tassamensilepagata =0;
		
		System.out.println("Digitare Nome e Cognome, poi premere ENTER");
		nomecognome = 		scanner.nextLine();
		
		System.out.println("Digitare l'eta, poi premere ENTER");
		eta = 				Integer.parseInt(scanner.nextLine());
		
		System.out.println("Digitare lo stipendio medio percepito, poi premere ENTER");
		stipendiomedio = 	Double.parseDouble(scanner.nextLine());
		
		System.out.println("Digitare il numero di mensilita percepite, poi premere ENTER");
		mensilita = 		Integer.parseInt(scanner.nextLine());
		
		System.out.println(	"\nSelezionare il comune di appartenenza."
							+ "\nDigitare 1 per Milano"
							+ "\nDigitare 2 per Roma"
							+ "\nDigitare 3 per Bergamo");
		residenza = 		Integer.parseInt(scanner.nextLine());
		
		scanner.close();
		
		//C
		switch (residenza)
		{
			case 1:
				tassacomune = 0.02;
				if 		(eta < 21)
				{
						tassaeta = 0;
				}
				else if ((eta >= 21) && (eta < 35))
				{
						tassaeta = 0.01;
				}
				else if ((eta >= 35) && (eta < 65))
				{
						tassaeta = 0.02;
				}
				else if (eta > 65)
				{
						tassaeta = 0;
				}
			break;
			case 2:
				tassacomune = 0.015;
				if 		(eta <25)
				{
					tassaeta = 0;
				}
				else if ((eta >= 25) && (eta <65))
				{
					tassaeta = 0.02;	
				}
				else if (eta >=65)
					tassaeta = 0;
				// Questo passaggio puo essere compattato, lascio la versione estesa per chiarezza
			break;
			case 3:
				tassacomune = 0.01;
				if (eta < 25)
				{
					tassaeta = 0.005;
				}
				else
				{
					tassaeta = 0.015;
				}
				// Abbreviato
			break;
			default:
				tassacomune = 0.025;
			break;
				
		} // SWITCH END
		
		//C
		tassemensili = 			tassacomune + tassaeta;
		tassamensilepagata = 	tassemensili * stipendiomedio;
		tasseannualipagate = 	tassamensilepagata * mensilita;
		
		//O
		System.out.println  ( "---------------------------------------------------------------------"
				+ "\n\n\t\t\tTASSE"
				+ "\n\nNominativo: \t\t\t\t" 					+ nomecognome 
				+ "\nImporto tasse in mesi: \t\t\t" 			+ tassamensilepagata + "$"
				+ "\nImporto tasse annuale totale: \t\t" 		+ tasseannualipagate + "$"
				+ "\n-------------------------------------------------------------------------------"); 
		
	} // DO NOT DELETE - STATIC VOID END

} // DO NOT DELETE - MAIN END
