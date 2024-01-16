package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Classe Aggregatrice: ha il compito di fare da luogo di assembramento tra tutti gli oggetti delle
// 						nostri classi modello. Solitamente ha un nome che richiama il luogo nella
//						vita di tutti i giorni in cui troviamo gli elementi aggregati.
public class Libreria
{
	//Proprietà
	Libro[] libri;
	
	//Costruttore
	Libreria(String path) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(path));
		
		libri = new Libro[Integer.parseInt(file.nextLine())];
		
		int i = 0;
		
		while(file.hasNextLine())
		{
			String[] infoRiga = file.nextLine().split(";");
			//0   1    2       3        4    5   6
			//It;King;Horror;Mondadori;1560;1989;S
			Libro l = new Libro(
								infoRiga[0], 						//Titolo
								infoRiga[1], 						//Autore
								infoRiga[3], 						//Casa Editrice
								infoRiga[2], 						//Genere
								Integer.parseInt(infoRiga[5]), 		//Anno Pubblicazione
								Integer.parseInt(infoRiga[4]),		//Numero Pagine
								infoRiga[6].equalsIgnoreCase("s")	//Prima Edizione
								);
			
			libri[i] = l;
			i++;
		}
		
		file.close();
	}
	
	//Metodi
	String listaSchede()
	{
		String ris = "";
		
		for(int i = 0; i < libri.length; i++)
			ris += libri[i].scheda();
		
		return ris;
	}
	
	String piuCari()
	{
		double max = 0;
		String ris = "";
		
		for(int i = 0; i < libri.length; i++)
			if(libri[i].prezzo() > max)
			{
				max = libri[i].prezzo();
				ris = libri[i].scheda();
			}
			else if(libri[i].prezzo() == max)
				ris += libri[i].scheda();
		
		return ris;
	}
	
	String piuLunghi()
	{
		String ris = "";
		int piuLunghi = 0;
		
		for(int i = 0; i < libri.length; i++)
		{
			if(libri[i].numeroPagine > piuLunghi)
			{
				piuLunghi = libri[i].numeroPagine;
				ris = libri[i].scheda();
			}
			else if(libri[i].numeroPagine == piuLunghi)
				ris += libri[i].scheda();
		}
		
		return ris;
	}
	
	String ricercaAutore(String inputUtente)
	{
		String ris = "";
		int numAutore = 0;
		
		for(int i = 0; i < libri.length; i++)
		{
			if(libri[i].autore.toLowerCase().contains(inputUtente.toLowerCase()))
			{
				numAutore++;
				ris += libri[i].scheda() + "\n";
			}
		}
		
		if(ris.isEmpty())
		{
			ris = "Nessun libro dell'autore '" + inputUtente + "' trovato nella libreria";
		}
		else
		{
			ris = "Sono presenti " + numAutore + " corrispondenze con l'autore '" + inputUtente + "':\n" + ris;
		}
		
		return ris;		
	}
	
	String cercaGenere(String genere)
	{
		String ris = "";
		double somma = 0;
		int conta = 0;
		
		for(int i = 0; i < libri.length; i++)
		{
			if(libri[i].genere.equalsIgnoreCase(genere))
			{
				somma += libri[i].prezzo();
				conta++;
			}
		}
		
		if(conta > 0)
			ris = "Il prezzo medio dei libri di genere " + genere.toUpperCase() + " è di " + (somma/conta) + "€";
		else
			ris = "Non esistono libri di genere " + genere.toUpperCase() + " in magazzino";
		
		return ris;
	}
	
	String cerca(double soldini)
	{
		String ris = "";
		
		for(int i = 0; i < libri.length; i++)
			if(libri[i].prezzo() <= soldini)
				ris += "\n- " + libri[i].titolo + ": " + libri[i].prezzo() + "€";
		
		return ris.length() == 0 ? "Sei troppo povero per questo negozio" : "Ecco a te: " + ris;
	}
	
	
}// Fine Libreria
