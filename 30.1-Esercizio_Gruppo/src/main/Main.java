package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		//CONSEGNA
		//
		//			Dovete creare un programma che lette delle bolle di consegna di materiali, gestisca il magazzino.
		//			Dei materiali sapete:
		//		    nome, quantita, prezzoAlPezzo, tassaAlPubblico, eventualiComponentiTerzi( saranno papabilemente molte informazioni ), colori.
		//
		//		    ( ESEMPIO: SET Tavolo Giardino,45,90.50,22,sedie-tovaglia,nero-grigio-verdone )
		//
		//		    Creare un menu per l'azienda che permetta di:

		//		        1 Vedere le schede di tutti i prodottui presenti in magazzino

		//		        2 Vedere i nomi dei prodotti da ordinare ( si ordina quando la quantita è minore o uguale a 5 pezzi )

		//		        3 Vedere i nomi dei prodotti con il costo al pubblico maggiori

		//		        4 Vedere i nomi dei prodotti meno tassati

		//		        5 Vedere i nomi dei prodotti disponibili nella maggior gamma di colori

		//		        6 Cercare un prodotto tramite il suo nome (voglio poi vedere la scheda)

		//		        7 Cercare un prodotto tramite un budget (lista dei prodotti che potrò acquistare con i soldi indicati )

		//		        8 Prezzo medio dei prodotti con almeno 3 componenti terzi

		//		        9 Vedere i nomi dei prodotti il cui rapporto componentiTerzi:prezzoTassato superiore alla media // (prezzoTassato / componentiTerzi)

		//		       10 Ipotizzando di vendere tutti i pezzi in magazzino al pubblico, quanto incassera l'azienda?

		//		       11 Ipotizzando di dover ricomprare tutto, quanto spendera l'azienda?
		
		String path = "src/res/Dati.txt";
		Scanner tastiera = new Scanner(System.in);
		String cmd = "";
		String ris = "";
		Magazzino m = new Magazzino(path);
		String legenda = 	"\n\tLEGENDA" +
							"\n 1- Visualizza le schede di tutti i prodotti presenti in magazzino" +
							"\n 2- Visualizza i nomi dei prodotti da ordinare" +
							"\n 3- Visualizza i nomi dei prodotti con il costo al pubblico maggiore" +
							"\n 4- Visualizza i nomi dei prodotti meno tassati" +
							"\n 5- Visualizza i nomi dei prodotti disponibili nella maggior gamma di colori" +
							"\n 6- Cerca un prodtto tramite il suo nome" +
							"\n 7- Cerca un prodotto tramite budget" +
							"\n 8- Prezzo medio dei prodotti con almeno 3 componenti terzi" +
							"\n 9- Prodotti con rapporto componentiTerzi/PrezzoTassato superiore alla media" +
							"\n 10- Incasso in caso di vendita di tutto il magazzino al pubblico" +
							"\n 11- Costo per ricomprare tutto" +
							"\n L- Legenda" +
							"\n 0- Esci";
		
		System.out.println(legenda);
		
		do 
		{
			System.out.println("\nComando: ");
			cmd = tastiera.nextLine().toUpperCase();
			
			switch (cmd)
			{
				case "1" :
					ris = "\n\t\tSCHEDA DI TUTTI I PRODOTTI\n" + m.listaSchede();
					break;
				case "2" :
					ris = "\n\tPRODOTTI DA ORDINARE\n" + m.daOrdinare();
					break;
				case "3" :
					ris = "\n\tPRODOTTO PIU COSTOSO\n" + m.costosi();
					break;
				case "4" :
					ris = "\n\tPRODOTTO MENO TASSATO\n" + m.menoTassati();
					break;
				case "5" : 
					ris = "\n\tPRODOTTI CON PIU COLORI\n" + m.piuColorati();
					break;
				case "6" :
					String cercaNome = "";
					System.out.println("Inserisci il nome del prodotto da cercare: ");
					cercaNome = tastiera.nextLine();
					ris = m.cercaNome(cercaNome);
					break;
				case "7" :
					double cercaBudget = 0;
					System.out.println("Inserisci il budget: ");
					cercaBudget = Double.parseDouble(tastiera.nextLine());
					ris = m.cercaBudget(cercaBudget);
					break;
				case "8" :
					ris = "\n\tPREZZO MEDIO PRODOTTI CON ALMENO 3 COMPONENTI\n" + m.prezzoMedio3Componenti() + "$";	
					break;
				case "9" : 
					ris = "\n\tPRODDOTI CON RAPPORTO PREZZO/COMPONENTI SUPERIORE ALLA MEDIA\n" + m.prodottiRapportoSuperioreMedia(); 					
					break;
				case "10" :
					ris = "\n\tINCASSO IN CASO DI VENDITA DI TUTTO IL MAGAZZINO AL PUBBLICO\n" + m.incassoIpoeteticaVendita() + "$";
					break;
				case "11" :
					ris = "\n\tCOSTO PER RICOMPRARE TUTTA LA MERCE IN MAGAZZINO\n" + m.ricompraTutto() + "$";
					break;
				case "L" :
					ris = legenda;
					break;
				case "0" :
					ris = "ARRIVEDERCI!";
					break;
				default :
					ris = "Comando invalido";
					break;
			}		
			System.out.println(ris);
		}while(!cmd.equalsIgnoreCase("0"));
		
		tastiera.close();
		
	}

}
