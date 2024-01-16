package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Scrivere un file le informazioni legate alle scommesse sui cavalli.
		// Il file sara formattato con nome, numero, quotato, razza
		// Stampare poi un menu che permetta all'utente di chiedere:
		// - Lista dei cavalli del file
		// - Lista delle razze senza ripetizioni
		// - Cavallo/cavalli piu quotato
		// - Quota media dei cavalli di razza a richiesta dell'utente
		
		// STEP 1: Se la consegna parla di file dei dati, per primissima cosa si scrive il file
		// STEP 2: Leggi la consegna e cerca di capire cosa bisogna fare
		// STEP 3: Iniziare a seguire il DICO e scrivere il codice
		
		//D
		Scanner file;
		Scanner tastiera;
		String 	percorso;
		String 	nome;
		int 	numero;
		double 	quotazione;
		String 	razza;
		String 	listaCavalli;
		String 	listaRazzeSenzaRipetizioni;
		double 	quotazioneMassima;
		String 	cavalloQuotazioneMassima;
		String 	razzaRichiestaUtente;
		int 	contaRazzaRichiesta;
		double 	sommaQuotazioniRazzaRichiesta;
		String 	legenda;
		
		//I
		percorso 						= "src/res/Dati.txt";
		file 							= new Scanner(new File(percorso));
		listaCavalli 					= "";
		listaRazzeSenzaRipetizioni 		= "";
		quotazioneMassima 				= 0;
		cavalloQuotazioneMassima 		= "";
		legenda 						= "\n\tLEGENDA"
										+ "\n1- Lista dei Cavalli"
										+ "\n2- Lista delle razze"
										+ "\n3- Quotazioni Massime"
										+ "\n4- Quota Media Razza a Richiesta"
										+ "\nL- Legenda"
										+ "\n0- Exit";
		//C
		while(file.hasNextLine())
		{
			nome		= file.nextLine();
			numero		= Integer.parseInt(file.nextLine());
			quotazione	= Double.parseDouble(file.nextLine());
			razza		= file.nextLine();
			
			listaCavalli += "\nNome: " 		+ nome 			+
							"\nRazza: " 	+ razza 		+
							"\nNumero: " 	+ numero 		+
							"\nQuotato: " 	+ quotazione 	+ ":1" 	+
							"\n-------------------------------\n"	;
			
			if(!listaRazzeSenzaRipetizioni.toLowerCase().contains(razza.toLowerCase() + ", "))
			{
				listaRazzeSenzaRipetizioni += razza + ", ";
			}
			
			if(quotazione > quotazioneMassima)
			{
				quotazioneMassima = quotazione;
				cavalloQuotazioneMassima = nome;
			}
			else if (quotazione == quotazioneMassima)
			{
				cavalloQuotazioneMassima += "; " + nome;
			}
		}
		
		file.close();
		
		listaRazzeSenzaRipetizioni = listaRazzeSenzaRipetizioni.substring(0, listaRazzeSenzaRipetizioni.length()-2);
		
		tastiera = new Scanner(System.in);
		String cmd = "";
		String risposta = "";
		
		System.out.println("Benveuto nel mio centro scommesse!\nEcco i comandi disponibili" + legenda);
		
		do
		{
			System.out.println("Comando: ");
			cmd = tastiera.nextLine();
			
			switch(cmd.toLowerCase())
			{
				case "1" :
					risposta = listaCavalli;
					break;
				case "2" :
					risposta = listaRazzeSenzaRipetizioni;
					break;
				case "3" :
					risposta = cavalloQuotazioneMassima;
					break;
				case "4" :
					System.out.println("Che razza ti interessa?");
					razzaRichiestaUtente = tastiera.nextLine();
					
					sommaQuotazioniRazzaRichiesta	= 0;
					contaRazzaRichiesta				= 0;
					
					file = new Scanner(new File(percorso));
					
					while(file.hasNextLine())
					{
						nome		= file.nextLine();
						numero		= Integer.parseInt(file.nextLine());
						quotazione	= Double.parseDouble(file.nextLine());
						razza		= file.nextLine();
						
						if(razza.equalsIgnoreCase(razzaRichiestaUtente))
						{
							sommaQuotazioniRazzaRichiesta += quotazione;
							contaRazzaRichiesta++;
						}
					}
					
					file.close();
					
					if(contaRazzaRichiesta == 0)
						risposta = "Razza non presente nell'archivio";
					else
						risposta = "Quota media: " + (sommaQuotazioniRazzaRichiesta/contaRazzaRichiesta);
					
					break;
				case "l" :
					risposta = legenda;
					break;
				case "0" :
					risposta = "Arrivederci!";
					break;
				default :
					risposta = "Comando non valido";
					break;
			}
			
			System.out.println(risposta);
		}while (!cmd.equalsIgnoreCase("0"));
		
		//O
		tastiera.close();
		System.out.println();
	}

}
