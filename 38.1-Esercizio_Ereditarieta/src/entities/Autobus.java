package entities;

public class Autobus extends Veicolo {
	
	//Proprieta
	private boolean doppioPiano;

	//Costruttore
	public Autobus (String mezzo, 
					String linea, 
					int postiSedere, 
					int postiPiedi, 
					boolean notturno, 
					boolean doppioPiano)
	{
		super(mezzo, linea, postiSedere, postiPiedi, notturno);
		setDoppioPiano(doppioPiano);
	}

	//Getters & Setters
	public boolean isDoppioPiano()
	{
		return doppioPiano;
	}
	public void setDoppioPiano(boolean doppioPiano)
	{
		this.doppioPiano = doppioPiano;
	}

	
	//Metodi
	@Override
	public String toString()
	{
		return 	super.toString() +
				"\nDoppio piano: " + (doppioPiano ? "Si" : "No")			+
				"\n------------------------------------------------------";

	}
	
	
}