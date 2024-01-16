package entities;

public class Auto extends Veicolo
{
	private boolean ariaCondizionata;
	private boolean cerchiInLega;
	
	public Auto(String marca, String modello, String colore, int capienzaSerbatoio, double kilometriAlLitro,
				boolean ariaCondizionata, boolean cerchiInLega)
	{
		super(marca, modello, colore, capienzaSerbatoio, kilometriAlLitro);
		setAriaCondizionata(ariaCondizionata);;
		setCerchiInLega(cerchiInLega);;
	}

	public boolean isAriaCondizionata()
	{
		return ariaCondizionata;
	}
	public void setAriaCondizionata(boolean ariaCondizionata)
	{
		this.ariaCondizionata = ariaCondizionata;
	}
	public boolean isCerchiInLega()
	{
		return cerchiInLega;
	}
	public void setCerchiInLega(boolean cerchiInLega)
	{
		this.cerchiInLega = cerchiInLega;
	}

	
	@Override
	public String toString()
	{
		return  "\t\nAUTO\n"				+
				super.toString() 		+
				"\nAriaCondizionata: " 	+ (ariaCondizionata ? "Si" : "No") 	+ 
				"\nCerchiInLega: " 		+ (cerchiInLega ? "Si" : "No") 		+ 
				"\n------------------------------------------------------\n";
	}
	
	
}
