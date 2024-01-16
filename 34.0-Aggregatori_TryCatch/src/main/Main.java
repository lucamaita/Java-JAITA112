package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

// CLassi di Avvio
public class Main
{
	public static void main(String[] args) //throws FileNotFoundException
	{
		// Scritto così ci fidiamo che il percorso funzioni, ma le cose non sempre vanno
		//Libreria l = new Libreria("src/res/Dati.txt");
		
		//Mi comporto come nel modo seguente nel caso in cui volessi tenere in conto
		//degli imprevisti legati al file dei dati(viene spostato, viene rinominato..)
		Libreria l = null;
		String path = "src/res/Dati.txt";
		Scanner tastiera = new Scanner(System.in);
		// GESTIONE DELLE ECCEZIONI: significa gestire bene gli errori che possiamo incontrare
		// Per gestire gli errori si usa la struttura del TRY-CATCH
		do
		{
			try
			{
				// Come dice il nome, qui "tento" l'esecuzione delle righe di codice che so
				// possono dare vita a eccezioni
				l = new Libreria(path);
				break;
			}
			catch(FileNotFoundException e)
			{
				// Ha il compito di "catturare" l'eccezione prima che questa possa far cashare il programma.
				// Inoltre offre un percorso alternativo a quello che ha portato all'errore.
				System.out.println("Percorso errato");
				System.out.println("Digita il percorso corretto");
				path = tastiera.nextLine();
			}
//			catch(Exception ex)
//			{
//				// Possiamo scrivere tutti i catch che vogliamo, l'importante è che siano sempre in ordine
				// dal più specifico al più generico
//			}
//			finally
//			{
//				// E' FACOLTATIVO!!!
//				// Viene eseguito SEMPRE, sia che le cose vadano bene, sia che le cose vadano male.
//				// Ha una priorità così alta che blocca addirittura il crash dell'applicazione
//			}
		}while(true);
		
		
		String legenda = "\n\tLEGENDA" 								+
						 "\n1- Lista dei libri" 					+
						 "\n2- Libri più cari"						+
						 "\n3- Libri più lunghi"					+
						 "\n4- Libri di un autore a scelta"			+
						 "\n5- Prezzo Medio per un genere a scelta"	+
						 "\n6- Cerca per budjet"					;
		String cmd;
		String ris;
		
		System.out.println( "\n\tBenvenuto nella mia libreria!" +
				 			"\nEcco la legenda dei comandi:\n"  + legenda);
		
		do
		{
			System.out.println("\n  Comando:");
			cmd = tastiera.nextLine();
			
			switch(cmd)
			{
				case "1" :
					ris = "\n\tLISTA DEI LIBRI\n" + l.listaSchede();
					break;
				case "2" :
					ris = "\n\tLIBRI PIU' COSTOSI\n" + l.piuCari();
					break;
				case "3" :
					ris = "\n\tLIBRI PIU' LUNGHI\n" + l.piuLunghi();
					break;
				case "4" :
					String input;
					System.out.println("Inserisci un autore:");
					input = tastiera.nextLine();
					ris = l.ricercaAutore(input);
					break;
				case "5" :
					System.out.println("Che genere ti interessa?");
					String genere = tastiera.nextLine();
					
					ris = l.cercaGenere(genere);
					break;
				case "6" :
					double converti;
					do
					{
						System.out.println("Quanto puoi svenarti?");
						String valore = tastiera.nextLine();
						try
						{
							converti = Double.parseDouble(valore);
							break;
						}
						catch(NumberFormatException e)
						{
							System.out.println("Un numero signooo!!!");
						}
					}while(true);
					
					ris = l.cerca(converti);
					break;
				case "0" :
					ris = "Arrivederci";
					break;
				default :
					ris = "Comando non valido";
			}
			System.out.println(ris);
		}while(!cmd.equalsIgnoreCase("0"));
		
		tastiera.close();
		System.out.println("END");
	}
}