package entities;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MezziTrasporto
{
	private ArrayList <Tram> tramList;
	private ArrayList <Metro> metroList;
	private ArrayList <Autobus> autobusList;
	
	public MezziTrasporto (String path) throws FileNotFoundException
	{
		tramList = new ArrayList<Tram>();
		metroList = new ArrayList<Metro>();
		autobusList = new ArrayList<Autobus>();
		
		Scanner file = new Scanner(new File(path));
		
		while(file.hasNextLine())
		{
			String [] info = file.nextLine().split(",");
			
			switch (info[0].toLowerCase())
			{
			case "tram" :
				tramList.add
				(
						new Tram(
								info[0].toUpperCase(),
								info[1],
								Integer.parseInt(info[3]),
								Integer.parseInt(info[4]),
								info[6].equalsIgnoreCase("true"),
								Integer.parseInt(info[2]),
								info[5].equalsIgnoreCase("true")
								)
				);
				break;
			case "metro" :
				metroList.add
				(
								new Metro
								(
									info[0].toUpperCase(),
									info[1],
									Integer.parseInt(info[3]),
									Integer.parseInt(info[4]),
									info[6].equalsIgnoreCase("true"),
									Integer.parseInt(info[2]),
									info[5].equalsIgnoreCase("true")
								)
								
				);
				break;
			case "autobus" :
				autobusList.add
				(
								new Autobus
								(
									info[0].toUpperCase(),
									info[1],
									Integer.parseInt(info[2]),
									Integer.parseInt(info[3]),
									info[5].equalsIgnoreCase("true"),
									info[4].equalsIgnoreCase("true")
								)

				);
				break;
			default:
				System.out.println("File non valido!");
			}
		}
		
		file.close();
	}
	
	public String elencoTram()
	{
		String ris = 	"\n\t\tELENCO TRAM\n" +
						"\n------------------------------------------------------";
;
		
		for(Tram t : tramList)
		{
			ris += t.toString();
		}
		
		return ris;
	}
	
	public String elencoMetro()
	{
		String ris = 	"\n\t\tELENCO METRO\n" +
						"\n------------------------------------------------------";
		
		for(Metro m : metroList)
		{
			ris += m.toString();
		}
		
		return ris;
	}
	
	public String elencoAutobus()
	{
		String ris = 	"\n\t\tELENCO AUTOBUS\n" +
						"\n------------------------------------------------------";
		
		for(Autobus a : autobusList)
		{
			ris+= a.toString();
		}
		
		return ris;
	}
	
	public String elencoNotturni()
	{
		String ris = 	"\n\t\tELENCO NOTTURNI\n" +
						"\n------------------------------------------------------";
		
		for(Tram t : tramList)
		{
			if(t.isNotturno())
			{
				ris += t.toString();
			}
		}
		
		for(Metro m : metroList)
		{
			if(m.isNotturno())
			{
				ris += m.toString();
			}
		}
		
		for(Autobus a : autobusList)
		{
			if(a.isNotturno())
			{
				ris += a.toString();
			}
		}
		
		return ris;
	}
	
	public String mezzoDatoNPasseggeri(int passeggeri)
	{
		String ris = "";
		int postiAvanzatiMax = Integer.MIN_VALUE;
		
		for(Tram t : tramList)
		{
			if((t.totalePosti() - passeggeri) > postiAvanzatiMax)
			{
				postiAvanzatiMax = t.totalePosti() - passeggeri;
				ris = t.toString();
			}
			else if ((t.totalePosti() - passeggeri) == postiAvanzatiMax)
				ris += t.toString();
		}
		
		for(Metro m : metroList)
		{
			if((m.totalePosti() - passeggeri) > postiAvanzatiMax)
			{
				postiAvanzatiMax = m.totalePosti() - passeggeri;
				ris = m.toString();
			}
			else if ((m.totalePosti() - passeggeri) == postiAvanzatiMax)
				ris += m.toString();

		}
		
		for(Autobus a : autobusList)
		{
			if((a.totalePosti() - passeggeri) > postiAvanzatiMax)
			{
				postiAvanzatiMax = a.totalePosti() - passeggeri;
				ris = a.toString();
			}
			else if ((a.totalePosti() - passeggeri) == postiAvanzatiMax)
				ris += a.toString();
		}
		
		
		return "\n\tMEZZO MIGLIORE PER N PERSONE: " + passeggeri + "\n" + ris;
		
		// Cosa si intende per migliore?
		// Ho inteso come mezzo spazioso, in cui si sta piu larghi,
		// ma cosi il mezzo sara sempre il quello con piu posti, da rivedere.
	}
	
	public String mezzoMinoreCapienza()
	{
		String ris = "";
		int minoreCapienza =  Integer.MAX_VALUE;
		
		for(Tram t : tramList)
			if(t.totalePosti() < minoreCapienza)
			{
				minoreCapienza = t.totalePosti();
				ris = t.toString();
			}
			else if(t.totalePosti() == minoreCapienza)
				ris += t.toString();
		
		for(Metro m : metroList)
			if(m.totalePosti() < minoreCapienza)
			{
				minoreCapienza = m.totalePosti();
				m.toString();
			}
			else if(m.totalePosti() == minoreCapienza)
				ris += m.toString();
		
		for(Autobus a : autobusList)
			if(a.totalePosti() < minoreCapienza)
			{
				minoreCapienza = a.totalePosti();
				a.toString();
			}
			else if(a.totalePosti() == minoreCapienza)
				ris += a.toString();
		
		return "\n\tMEZZO MINORE CAPIENZA: \n" + ris;
	}

	public String cercaLinea(String linea)
	{
		String ris = "";
		
		for(Tram t : tramList)
			if(t.getLinea().equalsIgnoreCase(linea))
				ris += t.toString();
		
		for(Metro m : metroList)
			if(m.getLinea().equalsIgnoreCase(linea))
				ris += m.toString();
		
		for(Autobus a : autobusList)
			if(a.getLinea().equalsIgnoreCase(linea))
				ris += a.toString();
		
		return "\n\tRISULTATI RICERCA LINEA: " + linea + "\n" + ris;
	}
	
	
	
	
	
	
	
	
	
}