package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
//		3- Gestisco gli ingressi a un cinema.
//		Chiedere il nome,l'età e il lavoro svolto.
//		Il prezzo base del biglietto costa 8€ a persona.
//		Scontistiche:
//			Se la persona è uno studente risparmia 2€;
//			Se la persona è over65 paga la metà;
//			Se la persona è un militare o un poliziotto risparmia 3€;
//			
//		Sovrapprezzi
//			Se la persona è un medico paga 2€ in più;
//			Se la persona ha tra i 25 e i 32 anni compresi paga 1€ in più.
//		
//		Se la persona è in un gruppo, permettere di calcolare anche il biglietto delle altre persone.
//		Se il gruppo supera le 5 persone, scontare 2€ dal prezzo totale del biglietto.
//		Stampare lo scontrino col prezzo del biglietto nominativo e la somma del prezzo dei singoli biglietti
//		(Quindi voglio vedere il nome del cliente e il prezzo del suo biglietto e alla fine il prezzo e lo sconto applicato)
		
		//D
		Scanner 	scanner;
		String 		nome;
		int 		eta;
		int 		lavoro;
		double 		prezzobase;
		int 		contatorepersone;
		String 		risposta;
		boolean 	nuovobiglietto;
		double	 	totaleBigliettoSingolo;
		
		
		//I
		scanner = 				new Scanner (System.in);
		nome = 					"";
		eta = 					0;
		lavoro = 				0;
		prezzobase = 			8;
		contatorepersone = 		0;
		risposta = 				"";
		nuovobiglietto = 		true;
		totaleBigliettoSingolo = 0;
		
		while (nuovobiglietto = true)
		{ 
			System.out.println("Inserire il proprio nome, poi premere ENTER");
			nome = scanner.nextLine();
			System.out.println("Inserire la propria eta, poi premere ENTER");
			eta = Integer.parseInt(scanner.nextLine());
			System.out.println(	"Scegliere la propria professione: " 			+ 
								"\nDigitare 1 per Studente (-2$)" 				+
								"\nDigitare 2 per Militare o Poliziotto (-3$)" 	+ 
								"\nDigitare 3 per Medico (+2$)" 				+
								"\nAltro (-0$)");
			lavoro = Integer.parseInt(scanner.nextLine());
			switch (lavoro) 
			{
			case 1:
				totaleBigliettoSingolo = prezzobase - 8;
				break;

			default:
				break;
			}
		}
		
		
		
		
		scanner.close();
		
	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
