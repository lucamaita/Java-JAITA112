package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// BLOCCO di lettura del file------------------------------------------------------------------
		Scanner file;
		String[] piattaforme;
		String[] titoli;
		int[] numeroGiocatori;
		int[] limiteEta;
		boolean[] primaPersona;
		int dimensione;
		int i;
		
		file = new Scanner(new File("src/res/Dati.txt"));
		
		dimensione = Integer.parseInt(file.nextLine());
		
		//Si usa nel caso in cui il file abbia solo i dati e non la dimensione come prima riga
//		while(file.hasNextLine())
//		{
//			file.nextLine();
//			dimensione++;
//		}
//		
//		dimensione /= 5;
//		file.close();
//		file = new Scanner(new File("src/res/Dati.txt"))
		
		limiteEta = new int[dimensione];
		titoli = new String[dimensione];
		piattaforme = new String[dimensione];
		numeroGiocatori = new int[dimensione];
		primaPersona = new boolean[dimensione];
		
		i = 0;
		
		while(file.hasNextLine())
		{
			// Così è come leggo se le informazioni le ho una sotto le altre
//			titoli[i] = file.nextLine();
//			piattaforme[i] = file.nextLine();
//			limiteEta[i] = Integer.parseInt(file.nextLine());
//			numeroGiocatori[i] = Integer.parseInt(file.nextLine());
//			primaPersona[i] = file.nextLine().equalsIgnoreCase("s");
//			i++;
			
			// Così è come leggo se ho un file che rispetta le regole del CSV 
			// (Tutte le informazioni di un singolo elemento stanno sulla stessa riga e sono 
			//   separate dallo stesso simbolo)
			
			// .split() è uno strumento che vuole nelle tonde un (o una serie consecutiva) di simboli 
			// da cercare e per cui "rompere" la stringa originale. 
			// Il risultato di .split sarà SEMPRE un vettore di stringhe
			
			// file.nextLine() -> "Mario Kart,Nintendo,7,4,s"
			// 									  0             1       2    3     4
			// file.nextLine().split(",") -> "Mario Kart", "Nintendo", "7", "4" , "s"
			String[] infoRiga = file.nextLine().split(",");
			
			titoli[i] = infoRiga[0];
			piattaforme[i] = infoRiga[1];
			limiteEta[i] = Integer.parseInt(infoRiga[2]);
			numeroGiocatori[i] = Integer.parseInt(infoRiga[3]);
			primaPersona[i] = infoRiga[4].equalsIgnoreCase("s");
			
			i++;
		}
		
		file.close();
		
		//Controllo che tutto sia salvato al posto giusto
//		i = 0;
//		while(i < titoli.length)
//		{
//			System.out.println("indice: " + i + "\n" + titoli[i]+ "," +piattaforme[i] +"," + numeroGiocatori[i]);
//			i++;
//		}
		//---------------------------------------------------------------------------------------------
		
		// BLOCCO si occupa del menù per l'utente
		Scanner tastiera = new Scanner(System.in);
		String cmd;
		String ris;
		String legenda = "\n\tLEGENDA\n" +
				"1- Vedere tutte le schede\n" + 
				"2- Vedere tutti i titoli sopra un limiteEta a scelta\n" + 
				"3- Vedere quanti videogiochi ci sono in prima persona\n" + 
				"4- Vedere il numero medio di giocatori per una piattaforma a scelta\n" +
				"5- Vedere il numero di giocatori medio per ogni piattaforma disponibile\n" + 
				"6- Vedere il numero totale di giochi per ogni limiteEta\n";
		
		System.out.println("Benvenuto, eccoti la legenda\n" + legenda);
		
		do
		{
			System.out.println("Comando");
			cmd = tastiera.nextLine();
			ris = "";
			
			switch(cmd)
			{
				case "1":
					i = 0;
					
					while(i < titoli.length)
					{
						ris +=  "Videogioco " 		+ (i+1) 				+ 
								"\nTitolo: " 		+ titoli[i] 			+
								"\nPiattaforma: " 	+ piattaforme[i] 		+
								"\nGiocatori: " 	+ numeroGiocatori[i] 	+
								"\nEtà minima: " 	+ limiteEta[i] 			+
								"\n" 				+ (primaPersona[i] ? "Prima Persona" : "Terza Persona") +
								"\n--------------------------------------------\n";
						
						i++;
					}
					
					if(ris.isEmpty())
						ris = "Nessun Videogioco nel file";
					
					break;
				case "2":
					System.out.println("Che età ha il destinatario?");
					int etaUtente = Integer.parseInt(tastiera.nextLine());
					
					i = 0;
					
					while(i < limiteEta.length)
					{
						if(limiteEta[i] <= etaUtente)
							ris += "\n- " + titoli[i];
						
						i++;
					}
					
					if(ris.isEmpty())
						ris = "Nessun Videogioco per quel destinatario";
					
					break;
				case "3":
					int contaPP = 0;
					int contaTP = 0;
					
					i = 0;
					
					while(i < primaPersona.length)
					{
						if(primaPersona[i])
							contaPP++;
						else
							contaTP++;
						
						i++;
					}
					
					ris = "Giochi in Prima Persona: " + contaPP + "\nGiochi in Terza Persona: " + contaTP;
					
					break;
				case "4":
					System.out.println("Che piattaforma ti interessa?");
					String piattaforma = tastiera.nextLine();
					
					i = 0;
					int conta = 0;
					int somma = 0;
					
					while(i < piattaforme.length)
					{
						if(piattaforme[i].equalsIgnoreCase(piattaforma))
						{
							somma += numeroGiocatori[i];
							conta++;
						}
						i++;
					}
					
					if(conta > 0)
						ris = "Giocatori medi per " + piattaforma.toUpperCase() + ": " + (somma/conta);
					else
						ris = "Piattaforma non disponibile";
					
					break;
				case "5":
					// Prima trovo le piattaforme del file senza ripetizioni
					String piattaformeSenzaRipetizioni = "";
					
					i = 0;
					
					while(i < piattaforme.length)
					{
						if(!piattaformeSenzaRipetizioni.toLowerCase().contains(piattaforme[i].toLowerCase() + ","))
						{
							piattaformeSenzaRipetizioni += piattaforme[i] + ",";
						}
						
						i++;
					}
					
					piattaformeSenzaRipetizioni = piattaformeSenzaRipetizioni.substring(0,piattaformeSenzaRipetizioni.length()-1);
					
					String[] piattaformeSingole = piattaformeSenzaRipetizioni.split(",");
					
					// Conto le ripetizioni
					i = 0;
					
					while(i < piattaformeSingole.length)
					{
						conta = 0;
						somma = 0;
						int j = 0;
						
						while(j < piattaforme.length)
						{
							if(piattaformeSingole[i].equalsIgnoreCase(piattaforme[j]))
							{
								somma += numeroGiocatori[j];
								conta++;
							}
							
							j++;
						}
						
						ris += "\nPiattaforma: " + piattaformeSingole[i] + " Media Giocatori: " + (somma/conta);
						
						i++;
					}
					
					break;
				case "6":
					String limiteEtaSenzaRipetizioni = "";
					
					i = 0;
					
					while(i < limiteEta.length)
					{
						if(!limiteEtaSenzaRipetizioni.contains(limiteEta[i] + ";"))
							limiteEtaSenzaRipetizioni += limiteEta[i] + ";";
						i++;
					}
					
					limiteEtaSenzaRipetizioni = limiteEtaSenzaRipetizioni.substring(0,limiteEtaSenzaRipetizioni.length()-1);
					String[] etaSingole = limiteEtaSenzaRipetizioni.split(";");
					
					i = 0;
					
					while(i < etaSingole.length)
					{
						int eta = Integer.parseInt(etaSingole[i]);
						
						int j = 0;
						conta = 0;
						
						while(j < limiteEta.length)
						{
							if(eta == limiteEta[j])
								conta++;
							
							j++;
						}
						
						ris += "\nEtà: " + eta + " Numero Videogiochi: " + conta;
						
						i++;
					}
					break;
				case "9":
					ris = legenda;
					break;
				case "0":
					ris = "Arrivederci";
					break;
				default :
					ris = "Comando non valido";
			}
			
			System.out.println(ris);
			
		}while(!cmd.equalsIgnoreCase("0"));
		
		tastiera.close();
		System.out.println("END");
	}// Fine Programma
}// Fine Programma







