package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		//		Inserire il numero di adulti e di bambini che devono acquistare un biglietto. 
		//		Gli adulti pagano 10 euro, i bambini 5. 
		//		Ogni 10 bambini, un adulto è gratis. 
		//		Sopra i 50 bambini, il biglietto viene rifiutato
		//		(cioè viene stampato un messaggio di errore al posto del biglietto)
		
		//D
		Scanner scanner;
		int 	numeroadulti;
		int 	numerobambini;
		int 	bigliettoadulti;
		int 	bigliettobambini;
		int 	massimobambini;
		int 	conteggiobambini;
		int		scontiapplicabili;
		int 	totaleadulti;
		int 	totalebambini;
		
		//I
		scanner = 			new Scanner(System.in);
		numeroadulti = 		0;
		numerobambini = 	0;
		bigliettoadulti = 	10;
		bigliettobambini = 	5;
		massimobambini = 	50;
		conteggiobambini = 	0;
		scontiapplicabili= -1;
		totaleadulti = 		0;
		totalebambini = 	0;
		
		System.out.println("Inserire il numero di adulti: ");
		numeroadulti = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Inserire il numero di bambini: ");
		numerobambini = Integer.parseInt(scanner.nextLine());
		
		if (numerobambini > massimobambini)
		{
			System.out.println("Errore, limuite bambini superato");
		}
		
		while (conteggiobambini <= numerobambini)
		{
			conteggiobambini = conteggiobambini + 10;
			scontiapplicabili = scontiapplicabili + 1;
		}
		
		scanner.close();
		
		//C
		totaleadulti = numeroadulti * bigliettoadulti;
		totalebambini = numerobambini * bigliettobambini;
		
		if (numerobambini > 10)
		{
			totaleadulti = totaleadulti - (scontiapplicabili * bigliettoadulti);
		}
		
		//I
		if (numerobambini < 51)
		{
		System.out.println(	"Adulti: " + numeroadulti
							+ "\nBambini: " + numerobambini
							+ "\nTotale: " + (totaleadulti + totalebambini) + "$");
		}
		
	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
