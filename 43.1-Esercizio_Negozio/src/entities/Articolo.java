package entities;

import java.time.Year;

public abstract class Articolo {
	
	// Proprieta
	private String marca;
	private int annoProduzione;

	// Costruttore
	public Articolo(String marca, int annoProduzione) {
		super();
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
		return 	"\nMarca: " 			+ marca 		+ 
				"\nAnnoProduzione: " 	+ annoProduzione;
	}

	public int eta() {
		return Year.now().getValue() - annoProduzione;
	}
	
	abstract double prezzo();
	
	
}
