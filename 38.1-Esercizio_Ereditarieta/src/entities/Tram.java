package entities;

public class Tram extends Veicolo
{
	//Proprieta
	private int vagoni;
	private boolean binarioSingolo;
	
	//Costruttore
	public Tram(String mezzo,
				String linea,
				int postiSedere,
				int postiPiedi,
				boolean notturno,
				int vagoni,
				boolean binarioSingolo)
	{
		super(mezzo, linea, postiSedere, postiPiedi, notturno);
		setVagoni(vagoni);
		setBinarioSingolo(binarioSingolo);
	}

	//Getters & Setters
	public int getVagoni()
	{
		return vagoni;
	}
	public void setVagoni(int vagoni)
	{
		this.vagoni = vagoni;
	}
	public boolean isBinarioSingolo()
	{
		return binarioSingolo;
	}
	public void setBinarioSingolo(boolean binarioSingolo)
	{
		this.binarioSingolo = binarioSingolo;
	}

	//Metodi
	@Override
	public String toString()
	{
		return 	super.toString() 										+
				"\nVagoni: " 			+ vagoni 						+
				"\nBinario Singolo: " 	+ (binarioSingolo ? "Si" : "No")+
				"\n------------------------------------------------------";
	}
	
	
	
	
	
}