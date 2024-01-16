package entities;

public class SerieTV
{
	//Proprieta
	private String titolo;
	private int durataMediaEpisodi;
	private int nStagioni;
	private int nPuntateStagione;
	private boolean conclusa;
	
	//Costruttore
	public SerieTV(String titolo, int durataMediaEpisodi, int nStagioni, int nPuntateStagione, boolean conclusa)
	{
		super();
		setTitolo(titolo);
		setDurataMediaEpisodi(durataMediaEpisodi);
		setnStagioni(nStagioni);
		setnPuntateStagione(nPuntateStagione);
		setConclusa(conclusa);
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
	public int getDurataMediaEpisodi()
	{
		return durataMediaEpisodi;
	}
	public void setDurataMediaEpisodi(int durataMediaEpisodi)
	{
		this.durataMediaEpisodi = durataMediaEpisodi;
	}
	public int getnStagioni()
	{
		return nStagioni;
	}
	public void setnStagioni(int nStagioni)
	{
		this.nStagioni = nStagioni;
	}
	public int getnPuntateStagione()
	{
		return nPuntateStagione;
	}
	public void setnPuntateStagione(int nPuntateStagione)
	{
		this.nPuntateStagione = nPuntateStagione;
	}
	public boolean isConclusa()
	{
		return conclusa;
	}
	public void setConclusa(boolean conclusa)
	{
		this.conclusa = conclusa;
	}
	
	//Metodi
	public String scheda()
	{
		return 	"\nTitolo: " 					+ titolo 					+
				"\nDurata media episodi: " 		+ durataMediaEpisodi + " minuti" +
				"\nNumero Stagioni: " 			+ nStagioni 				+
				"\nPuntate medie a stagione: " 	+ nPuntateStagione 			+
				"\nConclusa: " 					+ (conclusa ? "Si" : "No")	+
				"\n--------------------------------------------------------";
	}
	
	public int durataMediaStagione()
	{
		return durataMediaEpisodi * nPuntateStagione;
	}
	
	public int durataMediaSerie()
	{
		return durataMediaStagione() * nStagioni;
	}
	
	public boolean serieValida()
	{
		if(nStagioni >= 1 && nPuntateStagione >= 3)
			return true;
		else
			return false;
	}
	
}
