package entities;

public class Film
{
	//Proprieta
	private String titolo;
	private int durataMin;
	private String regista;
	private boolean oscar;
	
	//Costruttore
	public Film(String titolo, int durataMin, String regista, boolean oscar)
	{
		super();
		setTitolo(titolo);
		setDurataMin(durataMin);
		setRegista(regista);
		setOscar(oscar);
	}

	//Getters & Setters
	public String getTitolo()
	{
		return titolo;
	}
	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}
	public int getDurataMin()
	{
		return durataMin;
	}
	public void setDurataMin(int durataMin)
	{
		this.durataMin = durataMin;
	}
	public String getRegista()
	{
		return regista;
	}
	public void setRegista(String regista)
	{
		this.regista = regista;
	}
	public boolean isOscar()
	{
		return oscar;
	}
	public void setOscar(boolean oscar)
	{
		this.oscar = oscar;
	}

	
	//Metodi
	public String scheda()
	{
		return 	"\nTitolo: " 	+ titolo 				+
				"\nDurata: " 	+ durataMin 			+
				"\nRegista: " 	+ regista 				+
				"\nOscar: " 	+ (oscar ? "Si" : "No")	+
				"\n------------------------------------";
	}
	
	public double prezzo()
	{
		double prezzo = 10000;
		prezzo = prezzo * durataMin;
		
		switch (regista.toLowerCase())
		{
		case "james cameron" :
			prezzo = prezzo + 100000;
			break;
		case "robert zemeckis" :
			prezzo = prezzo + 200000;
			break;
		case "frank darabont" :
			prezzo = prezzo + 300000;
			break;
		case "francis ford coppola" :
			prezzo = prezzo + 400000;
			break;
		case "quentin tarantino" :
			prezzo = prezzo + 500000;
			break;
		case "christopher nolan" :
			prezzo = prezzo + 600000;
			break;
		case "the wachowskis" :
			prezzo = prezzo + 700000;
			break;
		case "steven spielberg" :
			prezzo = prezzo + 800000;
			break;
		case "david fincher" :
			prezzo = prezzo + 900000;
			break;
		default:
			prezzo += 0;
			break;
		}
		return prezzo;
	}
	
	public boolean filmValido()
	{
		if(durataMin > 65)
			return true;
		else
			return false;
	}
	
}
