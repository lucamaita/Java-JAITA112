package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
//		Scrivere un file coi dati delle figurine di un gioco.
//		Delle figurine sapete: nome del personaggio, attacco, difesa, vita, abilità(boolean), raro(boolean)
//		Scrivete minimo 5 personaggio.
//		Leggete il file e stampate in console:
//		La scheda di ogni personaggio
//		Il nome del/dei personaggi con difesa maggiore
//		La scheda del/dei personaggio/i con vita minore
//		Il numero di personaggi rari presenti
//		Il valore medio di attacco dei personaggi che hanno abilità come true
//		Il valore medio di vita dei personaggi rari con attacco superiore a 10
//		La scheda dei personaggi la cui difesa è superiore almeno del 5% rispetto al loro attacco
//
//		Usate una volta sola il comando System.out.println();
		
		//D
		Scanner file;
		String 	nome;
		int 	attacco;
		double 	attacco5prcnt;
		int 	difesa;
		int 	vita;
		int 	numeroVita10;
		boolean abilita;
		int 	numeroAbilita;
		boolean raro;
		int 	numeroRari;
		int 	difesaMaggiore;
		String 	nomePersonaggioDifesaMaggiore;
		int 	vitaMinore;
		String 	schedaVitaMinore;
		int 	numRari;
		double 	attaccoMedioAbilita;
		double 	vitaMediaAttaccoPiu10;
		String 	difesaSuperiore5Attacco;
		String 	risposta;
		
		//I
		file = new Scanner(new File("C:\\Users\\lucam\\Documents\\JAITA112\\19-Esercizio_Lettura_Da_File\\src\\res\\File.txt"));
		nome 							= "";
		attacco 						= 0;
		attacco5prcnt					= 0;
		difesa 							= 0;
		vita 							= 0;
		numeroVita10					= 0;
		abilita 						= false;
		numeroAbilita					= 0;
		raro 							= false;
		numeroRari 						= 0;
		difesaMaggiore 					= Integer.MIN_VALUE;
		nomePersonaggioDifesaMaggiore	= "";
		vitaMinore 						= Integer.MAX_VALUE;
		schedaVitaMinore				= "";
		numRari 						= 0;
		attaccoMedioAbilita 			= 0;
		vitaMediaAttaccoPiu10 			= 0;
		difesaSuperiore5Attacco 		= "";
		risposta 						= "";
		
		//C
		while (file.hasNextLine())
		{
			nome 		= file.nextLine();
			attacco 	= Integer.parseInt(file.nextLine());
			difesa 		= Integer.parseInt(file.nextLine());
			vita 		= Integer.parseInt(file.nextLine());
			abilita 	= file.nextLine().equalsIgnoreCase("y");
			raro 		= file.nextLine().equalsIgnoreCase("y");
			
			if (raro == true)
			{
				numeroRari += 1;
			} //
			
			if (abilita == true)
			{
				numeroAbilita += 1;
				attaccoMedioAbilita += attacco;
			} //
			
			if (attacco > 10)
			{
				numeroVita10 += 1;
				vitaMediaAttaccoPiu10 += vita;
			} //

			risposta += "\nNome: " 		+ nome 				+
						"\nAttacco: " 	+ attacco 			+ 
						"\nDifesa: "  	+ difesa		 	+ 
						"\nVita: "  	+ vita			 	+ "HP" +
						"\nAbilita: "  	+ abilita		 	+ 
						"\nRaro: "  	+ raro			 	+ 
						"\n------------------------------------------";
			
			if (vita < vitaMinore)
			{
				vitaMinore = vita;
				schedaVitaMinore = "\nNome: " 		+ nome 				+
									"\nAttacco: " 	+ attacco 			+ 
									"\nDifesa: "  	+ difesa		 	+ 
									"\nVita: "  	+ vita			 	+ "HP" +
									"\nAbilita: "  	+ abilita		 	+ 
									"\nRaro: "  	+ raro			 	+ 
									"\n------------------------------------------";;
			}
			
			if (difesa >= attacco + (attacco5prcnt = (0.05 * attacco)));
			{
				difesaSuperiore5Attacco = 	"\nSCHEDA PERSONAGGIO CON DIFESA >= ATTACCO + (5% DI ATTACCO):" + 
											"\nNome: " 		+ nome 				+
											"\nAttacco: " 	+ attacco 			+ 
											"\nDifesa: "  	+ difesa		 	+ 
											"\nVita: "  	+ vita			 	+ "HP" +
											"\nAbilita: "  	+ abilita		 	+ 
											"\nRaro: "  	+ raro			 	+ 
											"\n------------------------------------------";;
			}
			
			if (difesa > difesaMaggiore)
			{
				difesaMaggiore = difesa;
				nomePersonaggioDifesaMaggiore = nome;
			}
			else if (difesa == difesaMaggiore)
			{
				nomePersonaggioDifesaMaggiore += "," + nome;
			}
			
		} // FINE WHILE
		
		
		file.close();

		//O
		System.out.println(	"\tELENCO SCHEDE" 											+ risposta 						+ 
							"\nPersonaggi difesa Maggiore: " 							+ nomePersonaggioDifesaMaggiore	+
							"\n\nSCHEDA PERSONAGGIO CON VITA MINORE:"					+ schedaVitaMinore 				+
							"\nI Personaggi rari presenti sono: " 						+ numeroRari					+
							"\nAttacco medio di personaggi con abilita: " 				+ (attaccoMedioAbilita / numeroAbilita) +
							"\nVita media di personaggi con attacco superiore a 10: " 	+ (vitaMediaAttaccoPiu10 / numeroVita10) +
							"\n" 														+ difesaSuperiore5Attacco);
		
	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
