package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Magazzino
{
	// PROPRIETA
	Prodotto[] prodotti;
	
	// COSTRUTTORE
	Magazzino(String path) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(path));
		
		prodotti = new Prodotto[Integer.parseInt(file.nextLine())];
		
		int i = 0;
		
		while(file.hasNextLine())
		{
			String[] infoRiga = file.nextLine().split(",");
			Prodotto m = new Prodotto(
										infoRiga[0],
										Integer.parseInt(infoRiga[1]),
										Double.parseDouble(infoRiga[2]),
										Double.parseDouble(infoRiga[3]),
										(infoRiga[4]),
										infoRiga[5]);
			prodotti[i] = m;
			i++;
		}
		
		file.close();
	}
	
	// METODI
	String listaSchede()
	{
		String ris = "";
		
		for(int i = 0; i < prodotti.length; i++)
		{
			ris += prodotti[i].scheda();
		}
		
		return ris;
	}
	
	String daOrdinare()
	{
		String ris = "";
		
		for(int i = 0; i < prodotti.length; i++)
		{
			if(prodotti[i].quantita <= 5)
			{
				ris += "\n - " + prodotti[i].nome;
			}
		}
		
		return ris;
	}
	
	String costosi()
	{
		String ris = "";
		double max = Double.MIN_VALUE;
		
		for (int i = 0; i < prodotti.length; i++)
		{
			if(prodotti[i].prezzoAlPubblico() > max)
			{
				max = prodotti[i].prezzoAlPubblico();
				ris = "\n - "  + prodotti[i].nome;
			}
			else if(prodotti[i].prezzoAlPubblico() == max)
				ris += "\n - " + prodotti[i].nome;
		}
		
		return ris;
	}
	
	String menoTassati()
	{	
		String ris = "";
		Double min = Double.MAX_VALUE;
		
		for(int i = 0; i < prodotti.length; i++)
		{
			if(prodotti[i].tassaAlPubblico < min)
			{
				min = prodotti[i].tassaAlPubblico;
				ris = "\n - " + prodotti[i].nome;
			}
			else if (prodotti[i].tassaAlPubblico == min)
				ris += "\n - " + prodotti[i].nome;
		}

		return ris;
	}
	
	String piuColorati()
	{
		String ris = "";
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < prodotti.length; i++)
			
			if(prodotti[i].quantitaColori() > max)
			{
				max = prodotti[i].quantitaColori();
				ris = "\n - " + prodotti[i].nome;
			}
			else if(prodotti[i].quantitaColori() == max)
				ris += "\n - " + prodotti[i].nome;

		return ris;
	}
	
	String cercaNome(String cercaNome)
	{
		String ris = "";
		
		for(int i = 0; i < prodotti.length; i++)
		{
			if (cercaNome.equalsIgnoreCase(prodotti[i].nome))
			{
				ris = prodotti[i].scheda();
			}
		}
		
		if(ris.isEmpty())
			ris = "Nessuna corrispondenza";
	
		return ris;
	}
	
	String cercaBudget(double cercaBudget)
	{
		String ris = "";
		
		for(int i = 0; i < prodotti.length; i++)
		{
			if(prodotti[i].prezzoAlPubblico() < cercaBudget)
			{
				ris += prodotti[i].scheda();
			}
		}
		if(ris.isEmpty())
			ris = "Nessuna corrispondenza trovata";

		return ris;
	}
	
	double prezzoMedio3Componenti()
	{
		double ris = 0;
		double totale = 0;
		int conta = 0;
		
		for(int i = 0; i < prodotti.length; i++)
		{
			if(prodotti[i].quanteParti() >= 3)
			{
				conta++;
				totale += prodotti[i].prezzoAlPubblico();
			}
		}
		
		ris = totale/conta;
		return ris;
	}
	
	double mediaRapportoPrezzoComponenti()
	{
		double ris = 0;
		double somma = 0;
		int conta = 0;
		
		for(int i = 0; i < prodotti.length; i++)
		{
			somma += prodotti[i].rapportoPrezzoComponenti();
			conta++;
		}
		
		ris = somma/conta;
			
		return ris;
	}
	
	String prodottiRapportoSuperioreMedia()
	{
		String ris = "";
		
		for(int i = 0; i < prodotti.length; i++)
		{
			if(prodotti[i].rapportoPrezzoComponenti() > mediaRapportoPrezzoComponenti())
			{
				ris += "\n - " + prodotti[i].nome;
			}
		}
		return ris;
	}
	
	double incassoIpoeteticaVendita()
	{
		double ris = 0;
		
		for(int i = 0; i < prodotti.length; i++)
		{
			ris += prodotti[i].prezzoAlPubblico() * prodotti[i].quantita;
		}
		return ris;
	}
	
	double ricompraTutto()
	{
		double ris = 0;
		
		for(int i = 0; i < prodotti.length; i++)
		{
			ris += prodotti[i].prezzoAlPezzo * prodotti[i].quantita;
		}
		return ris;
	}
}
