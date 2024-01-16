package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		
	// LETTURA FILE ----------------------------------------------------------------------------------
		
		//D
		Scanner 	file;
		String	[]	nome;
		String	[] 	piattaforma;
		int		[]	limiteEta;
		int		[]	numeroGiocatori;
		boolean []	primaPersona;
		int 		dimensione;
		int			i;
		
		//I
		file = new Scanner(new File("src/res/Lista.txt"));
		
		dimensione 		= Integer.parseInt(file.nextLine());
		nome 			= new String 	[dimensione];
		piattaforma 	= new String 	[dimensione];
		limiteEta 		= new int 		[dimensione];
		numeroGiocatori = new int 		[dimensione];
		primaPersona 	= new boolean	[dimensione];
		i 				= 0;
		
		//C
		
		while(file.hasNextLine())
		{
			nome			[i] = file.nextLine();
			piattaforma		[i]	= file.nextLine();
			limiteEta		[i]	= Integer.parseInt(file.nextLine());
			numeroGiocatori	[i]	= Integer.parseInt(file.nextLine());
			primaPersona	[i]	= file.nextLine().equalsIgnoreCase("true");
			
			i++;
		}
		
		file.close();
		
	// MENU UTENTE -----------------------------------------------------------------------------------
		
		//D
		Scanner tastiera;
		String 	menu; //Legenda
		String	cmd;
		String 	risposta;
	
		//I
		tastiera 	= new Scanner(System.in);
		cmd			= "";
		risposta 	= "";
		menu		= 	"\n\t\tMENU PRINCIPALE\n" 														+
						"\n1) Visualizza le schede di tutti i giochi" 									+
						"\n2) Visualizza i titoli dei giochi filtrati per eta" 							+
						"\n3) Visualizza quanti giochi ci sono in prima o terza persona" 				+
						"\n4) Visualizza il numero medio di giocatori in base alla piattaforma"			+
						"\n5) Visualizza il numero di giocatori medio per ogni piattaforma disponibile"	+
						"\n6) Visualizza il numero totale di giochi per ogni limite di eta"				+
						"\n0) ESCI"																		;

		
						//Benvenuto, premi ENTER per continurare (chiedere???)
		
		//C
		
		System.out.println(menu);
		
		do
		{
			System.out.println("\nSeleziona il menu: ");
			cmd = tastiera.nextLine();
			risposta = "";
			
			switch(cmd)
			{
//CASE-1------------------------------------------------------------------------------------------------
			case "1":
				i = 0;
				
				while (i < nome.length)
				{
					risposta += "\nNome: " 				+ nome[i] 				+
								"\nPiattaforma: " 		+ piattaforma[i] 		+
								"\nEta Consigliata: " 	+ limiteEta[i] 			+
								"\nNumero giocatori: " 	+ numeroGiocatori[i] 	+
								"\nPrima persona: " 	+ (primaPersona[i] ? "Si" : "No") + //Ternario in stampa??
								"\n----------------------------------------------";
					i++;
				}
				break;
//CASE-2--------------------------------------------------------------------------------------------------
			case "2":
				i = 0;
				String filtriEta = "";
				System.out.println(	"\n\nSeleziona il filtro per eta: " +
									"\nDigita 1 per Anni: 3"			+
									"\nDigita 2 per Anni: 7"			+
									"\nDigita 3 per Anni: 18"			+
									"\nSelezione: "						);
				
				filtriEta = tastiera.nextLine();
				
				if (filtriEta.equalsIgnoreCase("1"))
				{
					while (i < limiteEta.length)
					{
						risposta += limiteEta[i] == 3 ? nome[i] + ", " : "";
						i++;
					}
				}
				
				if (filtriEta.equalsIgnoreCase("2"))
				{
					while (i < limiteEta.length)
					{
						risposta += limiteEta[i] == 7 ? nome[i] + ", " : "";
						i++;
					}
				}
				
				if (filtriEta.equalsIgnoreCase("3"))
				{
					while (i < limiteEta.length)
					{
						risposta += limiteEta[i] == 18 ? nome[i] + ", " : "";
						i++;
					}
				}
				
				risposta = risposta.substring(0, risposta.length()-2);
				
				break;
//CASE-3-----------------------------------------------------------------------------------------------
			case "3":
				
				i = 0;
				int contatorePrima = 0;
				int contatoreTerza = 0;
				
				while (i < primaPersona.length)
				{
					contatorePrima += primaPersona[i] ?  1 :  0;
					contatoreTerza += !primaPersona[i]?  1 :  0;
					i++;
				}
			
				risposta = "\nGiochi in prima persona: " + contatorePrima +
						   "\nGiochi in terza persona: " + contatoreTerza;
				
				break;
//CASE-4-------------------------------------------------------------------------------------------------
			case "4" :
				
				int sommaCase4 = 0;
				int contaCase4 = 0;
				
				i = 0;
				
				String piattaformaScelta = "";
				System.out.println(	"\n\nSelezionare la piattaforma: " 	+
									"\nDigita 1 per PC"					+
									"\nDigita 2 per PS5"				+
									"\nDigita 3 per XBOX"				+
									"\nSelezione: "						);					
				piattaformaScelta = tastiera.nextLine();
				piattaformaScelta = piattaformaScelta.equalsIgnoreCase("1") ? "PC" : piattaformaScelta;
				piattaformaScelta = piattaformaScelta.equalsIgnoreCase("2") ? "PS5" : piattaformaScelta;
				piattaformaScelta = piattaformaScelta.equalsIgnoreCase("3") ? "XBOX" : piattaformaScelta;
				
				while (i < piattaforma.length)
				{
					if (piattaformaScelta.equalsIgnoreCase(piattaforma[i]))
					{
						sommaCase4 += numeroGiocatori[i];
						contaCase4++;
					}
					i++;
				}
				
				risposta = "Media giocatori " + piattaformaScelta + ": " + sommaCase4/contaCase4;
				
				break;
//CASE-5-----------------------------------------------------------------------------------------------------
//			case "5" :
//				i = 0;
//				int sommaPC = 0;
//				int sommaPS5 = 0;
//				int sommaXBOX = 0;
//				int contaPC = 0;
//				int contaPS5 = 0;
//				int contaXBOX = 0;
//
//				
//				while (i < piattaforma.length)
//				{
//					if (piattaforma[i].equalsIgnoreCase("PC"))
//					{
//						sommaPC += numeroGiocatori[i];
//						contaPC++;
//					}
//					if (piattaforma[i].equalsIgnoreCase("PS5"))
//					{
//						sommaPS5 += numeroGiocatori[i];
//						contaPS5++;
//					}
//					if (piattaforma[i].equalsIgnoreCase("XBOX"))
//					{
//						sommaXBOX += numeroGiocatori[i];
//						contaXBOX++;
//					}
//					i++;
//				}
//				
//				risposta = 	"\n\t\tMEDIA GIOCATORI PER PIATTAFORMA\n" +
//							"\nPC: " 	+ sommaPC/contaPC 		+
//							"\nPS5: " 	+ sommaPS5/contaPS5 	+
//							"\nXBOX: " 	+ sommaXBOX/contaXBOX	;				
//				break;
			case "5" :
				

				break;
				
//CASE-6-----------------------------------------------------------------------------------------------------
			case "6" :
				i = 0;
				int contaCase6 = 0;
				
				while (i < limiteEta.length)
				{
					if (limiteEta[i] == 3)
						contaCase6++;
					i++;
				}
				risposta = "\nPEGI 3: " + contaCase6 + " giochi.";
				
				i=0;
				while (i < limiteEta.length)
				{
					if (limiteEta[i] == 7)
						contaCase6++;
					i++;
				}
				risposta += "\nPEGI 7: " + contaCase6 + " giochi.";
				
				i=0;
				while (i < limiteEta.length)
				{
					if (limiteEta[i] == 18)
						contaCase6++;
					i++;
				}
				risposta += "\nPEGI 18: " + contaCase6 + " giochi.";
				break;
//EXIT-------------------------------------------------------------------------------------------------------------------------
			case "0" :
				risposta = "Arrivederci";
				break;
			default :
				risposta = "Errore";
				break;
			}//FINE SWITCH
			
			System.out.println(risposta);
		
		}while(!cmd.equalsIgnoreCase("0"));//FINE DO WHILE
		
		tastiera.close();
		
		//O
		
	}

}
