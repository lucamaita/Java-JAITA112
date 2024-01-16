package entities;

public class Veicolo 
{
	// Proprieta
	private String marca;
	private String modello;
	private String colore;
	private int capienzaSerbatoio;
	private double kilometriAlLitro;
	
	//Costruttore
	public Veicolo(String marca, String modello, String colore, int capienzaSerbatoio, double kilometriAlLitro) 
	{
		//Indica che Veicolo e figlio di Object, e che se vuole potrebbe usare il costruttore vuoto
		// di Object grazie al comando SUPER.
		// Nel nostro caso qui non serve, quindi se volete potete cancellarlo.
		super();
		setMarca(marca);
		setModello(modello);
		setColore(colore);
		setCapienzaSerbatoio(capienzaSerbatoio);
		setKilometriAlLitro(kilometriAlLitro);
	}

	//Getters & Setters
	public String getMarca()
	{
		return marca;
	}
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	public String getModello()
	{
		return modello;
	}
	public void setModello(String modello)
	{
		this.modello = modello;
	}
	public String getColore()
	{
		return colore;
	}
	public void setColore(String colore)
	{
		this.colore = colore;
	}
	public int getCapienzaSerbatoio()
	{
		return capienzaSerbatoio;
	}
	public void setCapienzaSerbatoio(int capienzaSerbatoio)
	{
		this.capienzaSerbatoio = capienzaSerbatoio;
	}
	public double getKilometriAlLitro()
	{
		return kilometriAlLitro;
	}
	public void setKilometriAlLitro(double kilometriAlLitro)
	{
		this.kilometriAlLitro = kilometriAlLitro;
	}

	
	//Metodi
	@Override
	public String toString()
	{
		return 	"\nMarca: " 			+ marca 			+
				"\nModello: " 			+ modello 			+
				"\nColore: " 			+ colore 			+
				"\nCapienzaSerbatoio: " + capienzaSerbatoio +
				"\nKilometriAlLitro: " 	+ kilometriAlLitro 	+
				"\nAutonomia: "			+ autonomia()		;
	}

	public double autonomia()
	{
		return capienzaSerbatoio * kilometriAlLitro;
	}

	
	
	
	
	
	
	
	
}
