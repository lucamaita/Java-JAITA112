package esercizio_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
//		Creare un programma che gestisca un agenzia viaggi.
//		Formattare un file con le seguenti informazioni:
//			destinazione
//			mezzo di trasporto
//			giorni di vacanza
//			costo giornaliero
//			numero persone.
//		Creare un programma che acquisite le informazioni dal file sia in
//		grado di calcolare i prezzi dei singoli viaggi.
//		Calcolo del prezzo:
//		> Prezzo base 100;
//		> se la destinazione è Dubai o Tokyo aggiungo 200, se è Dublino o Londra aggiungo 150,
//			se è New York o Miami aggiungo 300. In tutti gli altri casi aggiungo 50
//		> se il mezzo di trasporto è aereo o traghetto aggiungo 500, se è treno aggiungo 200,
//			e è automobile o autobus aggiungo 100. In tutti gli altri casi aggiungo 1000
//		> se le persone sono più di 5 scontare il viaggio del 5%, se invece sono più di 10 scontare il
//			viaggio del 10%.
//		Stampare in console:
//		-Scheda di ogni viaggio disponibile nel file
//		-Lista destinazioni(senza ripetizioni)
//		-Lista mezzi di trasporto(senza ripetizioni)
//		-Costo medio dei viaggi in aereo
//		-Costo medio dei viaggi a Dubai
//		-Viaggi più economici(Viaggio/i che costano meno tra tutti quelli nel file)
//		-Viaggi di lusso(Viaggio/i che costano di più tra tutti quelli del file)
		
		//D
		Scanner file;
		String destinazione;
		String mezzoDiTrasporto;
		int giorni;
		double prezzoGiornaliero;
		int personeComitiva;
		double prezzoViaggio;
		String schedaViaggio;
		String schedeViaggio;
		String listaDestinazioni;
		String listaMezziTrasporto;
		double sommaViaggiAereo;
		int numeroViaggiAereo;
		double sommaViaggioDubai;
		int numeroViaggiDubai;
		double prezzoMax;
		double prezzoMin;
		String viaggiEconomico;
		String viaggiDiLusso;
		
		//I
		file = new Scanner(new File("src/res/Dati_AgenziaViaggi.txt"));
		// Si deve ricordare di tutti i giro del file, quindi si inizializza fuori dal ciclo
		schedeViaggio = "";
		listaDestinazioni = ", ";
		listaMezziTrasporto = ", ";
		sommaViaggiAereo = 0;
		sommaViaggioDubai = 0;
		numeroViaggiAereo = 0;
		numeroViaggiDubai = 0;
		prezzoMax = 0;
		prezzoMin = Double.MAX_VALUE;
		viaggiEconomico = "";
		viaggiDiLusso = "";
		
		while(file.hasNextLine())
		{
			// A ogni giro riparte pulita da zero, senza memoria dei dati del giro prima
			schedaViaggio = "";
			
			destinazione = file.nextLine();
			mezzoDiTrasporto = file.nextLine();
			giorni = Integer.parseInt(file.nextLine());
			prezzoGiornaliero = Double.parseDouble(file.nextLine());
			personeComitiva = Integer.parseInt(file.nextLine());
			
//			> Prezzo base 100;
			prezzoViaggio = 100;

			//C
			
//			> se la destinazione è Dubai o Tokyo aggiungo 200, se è Dublino o Londra aggiungo 150,
//				se è New York o Miami aggiungo 300. In tutti gli altri casi aggiungo 50
			switch(destinazione.toLowerCase())
			{
				case "dubai" :
				case "tokyo" :
					prezzoViaggio += 200;
					break;
				case "dublino" :
				case "londra" :
					prezzoViaggio += 150;
					break;
				case "new york" :
				case "miami" :
					prezzoViaggio += 300;
					break;
				default :
					prezzoViaggio += 50;				
			}
			
//			> se il mezzo di trasporto è aereo o traghetto aggiungo 500, se è treno aggiungo 200,
//				se è automobile o autobus aggiungo 100. In tutti gli altri casi aggiungo 1000
			switch(mezzoDiTrasporto.toLowerCase())
			{
				case "aereo" :
				case "traghetto" :
					prezzoViaggio += 500;
					break;
				case "treno" :
					prezzoViaggio += 200;
					break;
				case "automobile" :
				case "autobus" :
					prezzoViaggio += 100;
					break;
				default :
					prezzoViaggio += 1000;
			}
			
			prezzoViaggio += giorni*prezzoGiornaliero;
			
//			> se le persone sono più di 5 scontare il viaggio del 5%, se invece sono più di 10 scontare il
//				viaggio del 10%.
			if(personeComitiva >= 10)
				prezzoViaggio -= prezzoViaggio/100*10;
			else if(personeComitiva >= 5)
				prezzoViaggio -= prezzoViaggio/100*5;
			
//			-Scheda di ogni viaggio disponibile nel file
			schedaViaggio = "Destinazione: " 			+ destinazione 		+
							"\nMezzo di Trasporto: " 	+ mezzoDiTrasporto 	+
							"\nDurata: " 				+ giorni 			+ "giorni" 	+
							"\nPartecipanti: " 			+ personeComitiva 	+ "persone" +
							"\nCosto Giornaliero: " 	+ prezzoGiornaliero + "€" 		+
							"\nCosto Totale: " 			+ prezzoViaggio 	+ "€" 		+
							"\n-----------------------------------------------\n"		;
			
			schedeViaggio += schedaViaggio;
			
//			-Lista destinazioni(senza ripetizioni)
			// .contains() ci permette di controllare se nella stringa messa prima del punto 
			// è presente la serie di caratteri scritta dentro le tonde.
			// PROBLEMA 1: Java è CASESENSITIVE cioè Dublino per lui è diverso da dublino. Per risolvere
			// 				uso il .toLowerCase() per uniformare il confronto
			// PROBLEMA 2: Lavorando come insiemi di caratteri a volte trova delle corrispondenze 
			//				incomplete (Es New York per lui esclude York)
			if(!listaDestinazioni.toLowerCase().contains(", " + destinazione.toLowerCase() + ", "))
				listaDestinazioni += destinazione + ", ";
			
			
//			-Lista mezzi di trasporto(senza ripetizioni)
			if(!listaMezziTrasporto.toLowerCase().contains(", " + mezzoDiTrasporto.toLowerCase() + ", "))
				listaMezziTrasporto += mezzoDiTrasporto + ", ";
			
//			-Costo medio dei viaggi in aereo
			if(mezzoDiTrasporto.equalsIgnoreCase("aereo"))
			{
				sommaViaggiAereo += prezzoViaggio;
				numeroViaggiAereo++;
			}
			
//			-Costo medio dei viaggi a Dubai
			if(destinazione.equalsIgnoreCase("dubai"))
			{
				sommaViaggioDubai += prezzoViaggio;
				numeroViaggiDubai++;
			}
			
//			-Viaggi più economici(Viaggio/i che costano meno tra tutti quelli nel file)
			if(prezzoViaggio < prezzoMin)
			{
				prezzoMin = prezzoViaggio;
				viaggiEconomico = schedaViaggio;
			}
			else if(prezzoMin == prezzoViaggio)
				viaggiEconomico += schedaViaggio;
			
//			-Viaggi di lusso(Viaggio/i che costano di più tra tutti quelli del file)
			if(prezzoViaggio > prezzoMax)
			{
				prezzoMax = prezzoViaggio;
				viaggiDiLusso = schedaViaggio;
			}
			else if(prezzoViaggio == prezzoMax)
				viaggiDiLusso += schedaViaggio;
			
		}
		
		file.close();
		
		// Ogni stringa per il PC non è altro che un insieme di caratteri che vengono numerati
		// per essere riconosciuti dal programma.
		// 	RICORDATEVI che in informatica si parte a contare sempre da 0
		// listaDestinazioni.length() mi dice quanti caratteri ci sono in totale nella stringa
		// Io so che devo eliminare gli ultimi due caratteri (, ) quindi so che devo 
		// fermarmi a listaDestinazioni.length()-2
		// listaDestinazioni.substring() ci permette di ritagliare una parte della stringa,
		// indicado nell'ordine da che indice iniziare a che indice finire
		// Dato che io voglio tenere tutti i caratteri della stringa tranne gli ultimi 2
		// devo scrivere nello tonde (0, listaDestinazioni.length()-2)
		// Per salvare il pezzo di stringa tagliato in memoria lo assegno a listaDestinazioni
		listaDestinazioni = listaDestinazioni.substring(2, listaDestinazioni.length()-2);
		
		listaMezziTrasporto = listaMezziTrasporto.substring(2, listaMezziTrasporto.length()-2);
		
		//O
		System.out.println(
							schedeViaggio 		+ "\n\n" 	+ 
							listaDestinazioni 	+ "\n\n" 	+ 
							listaMezziTrasporto + "\n\n" 	+
							"Prezzo Medio Viaggi Aereo: " 	+ (sommaViaggiAereo/numeroViaggiAereo) 	+
							"\nPrezzo Medio Viaggi Dubai: " + (sommaViaggioDubai/numeroViaggiDubai) +
							"\nViaggi Economici:\n" 		+ viaggiEconomico 						+
							"\nViaggi di Lusso:\n"  		+ viaggiDiLusso
						  );
	}
}