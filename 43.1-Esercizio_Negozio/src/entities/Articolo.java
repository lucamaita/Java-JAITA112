package entities;

import java.time.Year;

public abstract class Articolo extends Entity{
	
	// Proprieta
	private String marca;
	private int annoProduzione;

	// Costruttore
	public Articolo(int id, String marca, int annoProduzione) {
		super(id);
		setMarca(marca);
		setAnnoProduzione(annoProduzione);
	}

	// Getters & Setters
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAnnoProduzione() {
		return annoProduzione;
	}
	public void setAnnoProduzione(int annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	// Metodi
	@Override
	public String toString() {
		return 	super.toString()		+
				"\nMarca: " 			+ marca 		+ 
				"\nAnno di Produzione: " 	+ annoProduzione;
	}

	public int eta() {
		return Year.now().getValue() - annoProduzione;
	}
	
	abstract double prezzo();
	
	
}
