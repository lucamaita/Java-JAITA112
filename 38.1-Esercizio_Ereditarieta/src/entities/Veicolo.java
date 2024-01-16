package entities;

public class Veicolo
{
	//Proprieta
	private String 	mezzo;
	private String 	linea;
	private int 	postiSedere;
	private int 	postiPiedi;
	private boolean notturno;
	
	//Costruttore
	public Veicolo	(	
					String mezzo,
					String linea,
					int postiSedere,
					int postiPiedi,
					boolean notturno
					)
	{
		super();
		setMezzo(mezzo);
		setLinea(linea);
		setPostiSedere(postiSedere);
		setPostiPiedi(postiPiedi);
		setNotturno(notturno);
	}

	
	//Getters & Setters
	public String getMezzo()
	{
		return mezzo;
	}
	public void setMezzo(String mezzo)
	{
		this.mezzo = mezzo;
	}
	public String getLinea()
	{
		return linea;
	}
	public void setLinea(String linea)
	{
		this.linea = linea;
	}
	public int getPostiSedere()
	{
		return postiSedere;
	}
	public void setPostiSedere(int postiSedere)
	{
		this.postiSedere = postiSedere;
	}
	public int getPostiPiedi()
	{
		return postiPiedi;
	}
	public void setPostiPiedi(int postiPiedi)
	{
		this.postiPiedi = postiPiedi;
	}
	public boolean isNotturno()
	{
		return notturno;
	}
	public void setNotturno(boolean notturno)
	{
		this.notturno = notturno;
	}


	
	//Metodi
	@Override
	public String toString()
	{
		return 	"\nVeicolo: " 			+ mezzo 					+
				"\nLinea: " 			+ linea 					+
				"\nPosti a sedere: " 	+ postiSedere 				+ 
				"\nPosti in piedi: " 	+ postiPiedi 				+
				"\nNotturno: " 			+ (notturno ? "Si" : "No")	+
				"\nTotale posti: " 		+ totalePosti()				;
	}
	
	public int totalePosti()
	{
		return postiSedere + postiPiedi;
	}
	
	
}