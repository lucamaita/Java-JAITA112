package entities;

public class Metro extends Veicolo
{
	//Proprieta
	private int vagoni;
	private boolean superficie;
	
	//Costruttore
	public Metro(	
				String mezzo,
				String linea,
				int postiSedere,
				int postiPiedi,
				boolean notturno,
				int vagoni,
				boolean superficie
				)
	{
		super(mezzo, linea, postiSedere, postiPiedi, notturno);
		setVagoni(vagoni);
		setSuperficie(superficie);
	}

	//Getters & Setter
	public int getVagoni()
	{
		return vagoni;
	}
	public void setVagoni(int vagoni)
	{
		this.vagoni = vagoni;
	}
	public boolean isSuperficie()
	{
		return superficie;
	}
	public void setSuperficie(boolean superficie)
	{
		this.superficie = superficie;
	}


	//Metodi
	@Override
	public String toString()
	{
		return 	super.toString() 										+
				"\nVagoni: " 	+ vagoni 								+
				"\nSuperfice: " + (superficie ? "Si" : "No")			+
				"\n------------------------------------------------------";

	}
	
	
	
}