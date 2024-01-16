package entities;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Blockbuster
{
	private ArrayList <Film> listaFilm = new ArrayList<Film>();
	private ArrayList <SerieTV> listaSerie = new ArrayList<SerieTV>();
	
	public Blockbuster(String path) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(path));
		
		while(file.hasNextLine())
		{
			String [] info = file.nextLine().split(";");
			
			switch (info[0].toLowerCase())
			{
			case "film" :
				listaFilm.add
				(
						new Film(
								info[1],
								Integer.parseInt(info[2]),
								info[3],
								info[4].equalsIgnoreCase("true")
								)
				);
				break;
			case "serie tv" :
				listaSerie.add
				(
						new SerieTV(
								info[1],
								Integer.parseInt(info[2]),
								Integer.parseInt(info[3]),
								Integer.parseInt(info[4]),
								info[5].equalsIgnoreCase("true")
								)
				);
				break;
			default: 
				System.out.println("File non valido");
				break;
			}
		}
		
		file.close();
	}
	
	//Metodi
	public String schedaFilm()
	{
		String ris = "";
		
		for(Film f : listaFilm)
			ris += f.scheda();
		
		return 	"\n\t\tSCHEDE FILM\n" +
				ris;
		
	}
	
	public String schedaSerie()
	{
		String ris = "";
		
		for(SerieTV s : listaSerie)
			ris += s.scheda();
		
		return 	"\n\t\tSCHEDE SERIE TV\n" +
				ris;
	}
	
	public String schedaCompleta()
	{
		String ris = "";
		
				for(Film f : listaFilm)
					ris += f.scheda();
				for(SerieTV s : listaSerie)
					ris += s.scheda();

				return  "\n\t\tSCHEDE COMPLETE\n" + ris;
	}
	
	public String durataMediaFilm()
	{
		double somma = 0;
		
		for(Film f : listaFilm)
			somma += f.getDurataMin();
		
		return  "\nDurata media film: " +
				(somma / listaFilm.size());
	}
	
	public String filmCaro()
	{
		String ris = "";
		double max = 0;
		
		for(Film f : listaFilm)
			if(f.prezzo() > max)
			{	
				max = f.prezzo();
				ris = f.scheda();
			}
			else if (f.prezzo() == max)
				ris += f.scheda();
		
		return  "\nFILM CARO: \n" +
				ris;
	}
	
	public String invalidi()
	{
		String ris = "";
		
		for(Film f : listaFilm)
		{
			if(!f.filmValido())
			{
				ris += f.scheda();
			}
		}
		for(SerieTV s : listaSerie)
		{
			if(!s.serieValida())
			{
				ris += s.scheda();
			}
		}
		
		if(ris.isEmpty())
			return "\nNESSUN FILM INVALIDO";
		else
			return  "\nFILM INVALIDI: \n" +
			ris;
		
	}
	
	public String registaFrequente()
	{
		String ris = "";
		int contaRegista = 0;
		int max = 0;
		ArrayList<String> registi = new ArrayList<String>();
		
		for(Film f : listaFilm)
			if(!registi.contains(f.getRegista()))
			{
				registi.add(f.getRegista());
			}
		
		for(String r : registi)
		{
			for(Film f : listaFilm)
			{
				if(r.equalsIgnoreCase(f.getRegista()))
				{
					contaRegista++;
				}
			}
			if(contaRegista > max)
			{
				max = contaRegista;
				ris = r;
			}
			contaRegista = 0;
			
		}
				
		return  "\nREGISTA PIU FREQUENTE: \n" +
				ris + "\nNumero film: " + max;
	}
	
	
}
