package main;

import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// La classe MAIN si chiama CLASSI DI AVVIO, perche non fa da modello a degli oggetti, ma ha il compito
// Di interfacciarsi con l'esterno, cioe con la console.
// OCCHIO: Potete avere tutte le classi modello che volete, ma in un programma esiste
// UNA SOLA classi di avvio alla volta.

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// PROGRAMMAZIONE A OGGETTI: Cosa sono gli oggetti?
		
		// Di base, un oggetto e' una variabile che rappresenta un elemento concreto del mondo reale.
		// Ogni elemento reale ha delle caratteristiche che lo rappresentano: per distinguere i singoli
		// oggetti ci serve sapere il valore associato a quelle caratteristiche.
		
		// L'oggetto e il caso concreto (cioe l'insieme dei valori delle sue caratteristiche) mentre cio
		// che determina quali caratteristiche ci interessano si chiama CLASSE
		
		// DEFINIZIONE
		// La classe e l'idea, il modello di un elemento, l'oggetto e' il caso concreto.
		
		// Convenzioni nomi classi: prima lettera maiuscola, no spazi, sempre singolare!!!
		
		// LEGGO IL FILE DEI DATI ------------------------------------------------------------------------------------------------------------
		Scanner file = new Scanner(new File("src/res/Dati.txt"));
		
		int dim = Integer.parseInt(file.nextLine());
		
		// Ogni riga del file rappresenta un oggetto, quindi d'ora in poi i nostri vettori
		// non conterranno piu dati semplici (int, String, ecc) ma conterranno oggetti.
		// Il tipo degli oggetti e sempre il nome della loro classe di apparntenenza
		// Quindi avremo una variabile "persone" che sara di tipo "vettore di Persona".
		Persona[] persone = new Persona[dim];
		
		// I comandi in programmazione si leggono sempre al contrario di come si scrivono:
		// se le cose le scrivo da sx a destra allora verranno eseguite da destra a sinistra, per cui nnella riga 38
		// si esegue prima il contenitore vettore e poi decido cosa metterci dentro (tipo persona)
		dim = 0;
		
		while(file.hasNextLine())
		{
			String[] infoRiga = file.nextLine().split(";");
			
			// Questo e come si dichiara e si inizializza a vuoto un oggetto.
			Persona persona = new Persona();
			
			// Ora asseggno alle proprieta dell'oggetto vuoto i valori letti da file
			persona.nome = infoRiga[0];
			persona.cognome = infoRiga[1];
			persona.eta = Integer.parseInt(infoRiga[2]);
			persona.patentato = infoRiga[3].equalsIgnoreCase("s");
			
			// Ora il mio oggetto e pieno quindi posso salvarlo nel vettore
			persone[dim] = persona;
			
			dim++;
		}

		file.close();
		//-----------------------------------------------------------------------------------------------------------------------------------
		for(int i = 0; i < persone.length; i++)
		{
			System.out.println(persone[i].scheda());
		}
		
		System.out.println("\n\n----------------------------------------------------------------\n\n");
		
		// Voglio vedere le schede delle persone che possono guidare
		for(int i = 0; i < persone.length; i++)
		{
			if(persone[i].patentato)
				System.out.println(persone[i].scheda());
		}
		
		System.out.println("\n\n----------------------------------------------------------------\n\n");

		
		// Voglio vedere la scheda della persona o delle persone piu anziane
		int max = Integer.MIN_VALUE;
		String ris = "";
		for(int i = 0; i < persone.length; i++)
		{
			if(persone[i].eta > max)
			{
				max = persone[i].eta;
				ris = persone[i].scheda();
			}
			else if(persone[i].eta == max)
			{
				ris += persone[i].scheda();
			}
		}
		System.out.println(ris);
		
		System.out.println("\n\n----------------------------------------------------------------\n\n");

		
		// Voglio sapere quante persone sono maggiorenni
		ris="";
		for(int i = 0; i < persone.length; i++)
		{
			if(persone[i].eta > 17)
				ris += ", " + persone[i].nome;
		}
		
		ris = ris.substring(2);
		
		System.out.println(ris);
		
		System.out.println("\n\n----------------------------------------------------------------\n\n");
		
		// Voglio sapere i nomi dei minorenni con la patente
		ris = "";
		int conta = 0;
		for (int i = 0; i < persone.length; i++) 
		{
			if((persone[i].eta < 18) && (persone[i].patentato == true))
			{
				conta++;
			}
		}
		System.out.println("\nle persone minorenni con patente sono: " + conta);
		
		System.out.println("\n\n----------------------------------------------------------------\n\n");

		// Voglio sapere quante persone hanno la patente da almeno 20 anni (immaginate che tutti l'abbiano presa a 18)
		ris = "";
		conta = 0;
		
		for (int i = 0; i < persone.length; i++)
		{
			if(persone[i].eta > 37 && persone[i].patentato == true)
			{
				conta++;
			}
		}
		System.out.println("Le persone patentate da almeno 20 sono: " + conta);
		
		System.out.println("\n\n----------------------------------------------------------------\n\n");
		
		// Voglio permettere all'utente di cerca la scheda di una persona tramite il suo cognome
		Scanner tastiera = new Scanner(System.in);
		String cercaCognome = "";
		ris = "";
		
		System.out.println("Inserire il cogome che si vuole cercare: ");
		cercaCognome = tastiera.nextLine();
		
		for (int i = 0; i < persone.length; i++)
		{
			if(cercaCognome.equalsIgnoreCase(persone[i].cognome))
			{
				ris += persone[i].scheda();
			}
		}		
		if(ris.isEmpty())
			ris = "Nessuna corrispondenza trovata";
		System.out.println(ris);
		
	}
}
