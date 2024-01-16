package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// LETTURA FILE ------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//D
		Scanner 	file;
		String 		percorso;
		String[]	infoRiga;
		String[] 	titolo;
		String[]	genere;
		int[]		numeroStagioni;
		int[]		episodiMediAStagione;
		int 		dimensioneVettore;
		
		//I
		percorso 				= "src/res/Catalogo.txt";
		file 					= new Scanner(new File(percorso));
		dimensioneVettore 		= Integer.parseInt(file.nextLine());
		titolo 					= new String[dimensioneVettore];
		genere 					= new String[dimensioneVettore];
		numeroStagioni 			= new int[dimensioneVettore];
		episodiMediAStagione 	= new int[dimensioneVettore];
		
		for(int i = 0; file.hasNextLine(); i++)
		{
			infoRiga= file.nextLine().split(";");
			
			titolo[i] = infoRiga[0];
			genere[i] = infoRiga[1];
			numeroStagioni[i] = Integer.parseInt(infoRiga[2]);
			episodiMediAStagione[i] = Integer.parseInt(infoRiga[3]);
		}
		
//		CONTROLLO DATI		
//		
//		for(int i = 0; i < dimensioneVettore; i++)
//		{
//			System.out.println(	"\ni: " + i + 
//								"\nTitolo: " + titolo[i] + 
//								"\nGenere: " + genere[i] +
//								"\nStagioni: " + numeroStagioni[i] +
//								"\nEpisodi Medi: " + episodiMediAStagione[i]);
//									
//		}
		
		// MENU UTENTE --------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//D
		String 	menu;
		String 	ris;
		String 	cmd;
		Scanner tastiera = new Scanner(System.in);
		
		
		
		//I
		ris	 = 	"";
		cmd  =	"";
		menu = 	"\n1) Lista delle serie TV" + 
				"\n2) Nome della serie TV con il maggior numero di stagioni" +
				"\n3) Nome della serie TV con il maggior numero di puntate a stagione" +
				"\n4) Nome della serie TV con il minior numero di stagioni" +
				"\n5) Nome della serie TV con il minor numero di puntate a stagione" +
				"\n6) Numero medio di stagioni tra tutte le serie TV" +
				"\n7) Filtra elenco tramite TITOLO" +
				"\n8) Filtra elenco tramite GENERE" +
				"\n9) Visualizza per ogni genere quante serie sono presenti" +
				"\n10) Visualizza le serie TV che hanno un numero totale di episodi minori alla media" +
				"\nM) Torna al menu" +
				"\n0) Esci";
		
		System.out.println(menu);
		
		do
		{
			cmd = tastiera.nextLine().toUpperCase();
			ris = "";
			
			switch (cmd) 
			{
// CASO 1 ------------------------------------------------------------------------------------------
			case "1":
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					ris += 	"\n" 							+ titolo[i] + 
							"\nGenere: " 					+ genere[i] + 
							"\nStagioni: " 					+ numeroStagioni[i] +
							"\nEpisodi medi a stagione: " 	+ episodiMediAStagione[i] +
							"\n----------------------------------------------------";
				}
				break;
// CASO 2 -----------------------------------------------------------------------------------------
			case "2":
				
				int max = Integer.MIN_VALUE;
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					if(numeroStagioni[i] > max)
					{
						max = numeroStagioni[i];
						ris = "\nSerie TV con piu stagioni: " + titolo[i];
					}
					else if(numeroStagioni[i] == max)
					{
						ris += ", " + titolo[i];
					}
				}
				
				break;
// CASE 3 ------------------------------------------------------------------------------------------
			case "3":
				
				max = Integer.MIN_VALUE;
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					if(episodiMediAStagione[i] > max)
					{
						max = episodiMediAStagione[i];
						ris = "\nSerie TV con piu episodi in media a stagione: " + titolo[i];
					}
					else if(episodiMediAStagione[i] == max)
					{
						ris += ", " + titolo[i];
					}
				}
				
				break;
// CASE 4 -------------------------------------------------------------------------------------------
			case "4":
				
				int min = Integer.MAX_VALUE;
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					if(numeroStagioni[i] < min)
					{
						min = numeroStagioni[i];
						ris = "\nSerie TV con meno stagioni: " + titolo[i];
					}
					else if(numeroStagioni[i] == min)
					{
						ris += ", " + titolo[i];
					}
				}
				
				break;
// CASE 5 -------------------------------------------------------------------------------------------
			case "5":
				
				min = Integer.MAX_VALUE;
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					if(episodiMediAStagione[i] < min)
					{
						min = episodiMediAStagione[i];
						ris = "\nSerie TV con meno episodi in media a stagione: " + titolo[i];
					}
					else if(episodiMediAStagione[i] == min)
					{
						ris += ", " + titolo[i];
					}
				}
				
				break;
// CASE 6 ------------------------------------------------------------------------------------------
			case "6":
				
				ris = "Il numero di stagioni medie di tutte le serie TV e: ";
				
				int mediaStagioni = 0;
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					mediaStagioni += numeroStagioni[i];
				}
				
				mediaStagioni = (mediaStagioni/dimensioneVettore);
				ris += mediaStagioni;
				
				break;
// CASE 7 -----------------------------------------------------------------------------------------
			case "7":
				
				String ricercaTitolo = "";
				
				System.out.println("\nInserire il titolo della serie che si desidera cercare, poi premere ENTER");
				ricercaTitolo = tastiera.nextLine();
				
				for(int i = 0; i < dimensioneVettore;i++)
				{
					if(ricercaTitolo.equalsIgnoreCase(titolo[i]))
					{
						ris = 	"\n" 							+ titolo[i] + 
								"\nGenere: " 					+ genere[i] + 
								"\nStagioni: " 					+ numeroStagioni[i] +
								"\nEpisodi medi a stagione: " 	+ episodiMediAStagione[i] +
								"\n----------------------------------------------------";
					}
				}
				if(ris.isEmpty())
					ris = "Il titolo inserito non ha prodotto alcun risultato.";
				
				break;
// CASE 8 -----------------------------------------------------------------------------------------
			case "8":
				
				String ricercaGenere = "";
				
				System.out.println("\nInserire il genere della serie che si desidera cercare, poi premere ENTER");
				ricercaGenere = tastiera.nextLine();
				ris = "";
				
				for(int i = 0; i < dimensioneVettore;i++)
				{
					if(ricercaGenere.equalsIgnoreCase(genere[i]))
					{
						ris += titolo[i] + ", ";
					}
				}
				
				if(!ris.isEmpty())
					ris = ris.substring(0, ris.length()-2);
				else if(ris.isEmpty())
					ris = "Il genere inserito non ha generato alcun risultato.";
				
				break;
// CASE 9 -------------------------------------------------------------------------------------------
			case "9":
				
//				ricercaGenere = "";
//				System.out.println("Inserire il genere che si desidera contare: ");
//				ricercaGenere = tastiera.nextLine();
//				ris = "";
//				int conta = 0;
//
//				for(int i = 0; i < dimensioneVettore; i++)
//				{
//					if(ricercaGenere.equalsIgnoreCase(genere[i]))
//					{
//						conta++;
//					}
//				}
//				
//				ris = "\nLe serie TV di genere " + ricercaGenere.toUpperCase() + " sono: " + conta;
//				
//				if(conta == 0)
//					ris = "Nessuna serie TV di genere " + ricercaGenere.toUpperCase() + " trovata";
				
				String generiSenzaRipetizioni = "";;
				int conta = 0;
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					if(!generiSenzaRipetizioni.contains(genere[i] + ", "))
					{
						generiSenzaRipetizioni += genere[i] + ", ";
					}
				}
				
				String generiSingoli[] = generiSenzaRipetizioni.split(", ");
				
				
				for(int i = 0; i < generiSingoli.length; i++)
				{
					conta = 0;
					for(int j = 0; j < genere.length; j++)
					{
						if(generiSingoli[i].equalsIgnoreCase(genere[j]))
						{
							conta++;
						}
						
					} // FINE CICLO J
					
					ris += "\n " + generiSingoli[i].toUpperCase() + ": " + conta;
				} // FINE CICLO I
				
				break;
// CASE 10 -------------------------------------------------------------------------------------------
			case "10":
				int[] totaleEpisodi = new int[dimensioneVettore];
				int mediaTotaleEpisodi = 0;
				ris = "\nSerie TV che hanno un numero totale di episodi minori alla media: \n";
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					totaleEpisodi[i] = episodiMediAStagione[i] * numeroStagioni[i];
				}
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					mediaTotaleEpisodi += totaleEpisodi[i];
				}
				
				mediaTotaleEpisodi /= dimensioneVettore;
				
				for(int i = 0; i < dimensioneVettore; i++)
				{
					if(totaleEpisodi[i] < mediaTotaleEpisodi)
						ris += "\n" + titolo[i];
				}
				break;
// MENU ----------------------------------------------------------------------------------------------
			case "M":
				ris = menu;
				break;
// EXIT ----------------------------------------------------------------------------------------------
			case "0":
				ris = "\nArrivederci!";
				break;
// DEFAULT -------------------------------------------------------------------------------------------
			default:
				ris = "\nErrore, comando non valido!";
				break;
				
			} // FINE SWITCH 
			
			
			System.out.println(ris);
			
		}while(!cmd.equalsIgnoreCase("0"));
		
		tastiera.close();
		
		//C
		
		//O
		
	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
