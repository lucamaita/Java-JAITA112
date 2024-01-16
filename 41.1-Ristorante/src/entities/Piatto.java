package entities;

import java.util.Arrays;

public class Piatto {
	
	//Proprieta
	private final static String[] TIPI_VALIDI = {"Antipasto", "Primo", "Secondo", "Dolce"};
	private final static String[] INGREDIENTI_VALIDI = {"farina", "glutine", "zucchero", "sale", "glutammato", "olio"};
	
	private String nome;
	private String tipo;
	private double prezzo;
	private String[] ingredienti;
	
	//Costruttore
	public Piatto(String nome, String tipo, double prezzo, String[] ingredienti) {
		super();
		setNome(nome);
		setTipo(tipo);
		setPrezzo(prezzo);
		setIngredienti(ingredienti);
	}

	//Getters & Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String[] getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(String[] ingredienti) {
		this.ingredienti = ingredienti;
	}

	//Metodi
	@Override
	public String toString() {
		return 	"\nNome: " 			+ nome 							+ 
				"\nTipo: " 			+ tipo 							+ 
				"\nPrezzo: " 		+ prezzo 						+ 
				"\nIngredienti: " 	+ Arrays.toString(ingredienti) 	+
				"\n------------------------------------------------";
	}
	
	public boolean tipoValido() {
		
		for(String t : TIPI_VALIDI) {
			if(tipo.equalsIgnoreCase(t)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean ingredientiValidi() {
		
		int conta = 0;
		
		for(String i : ingredienti) {
			for(String I : INGREDIENTI_VALIDI) {
				if(i.equalsIgnoreCase(I)) {
					conta++;
				}
			}
		}
		if(conta == ingredienti.length)
			return true;
		else
			return false;

	}
	
	public boolean valido() {
		
		if(tipoValido() && ingredientiValidi())
			return true;
		else
			return false;
	}
	
	public boolean contieneIngrediente(String ingrediente) {
		
		for(String i : ingredienti)
			if(ingrediente.equalsIgnoreCase(i))
				return true;
		
		return false;
	}
	
	public boolean contieneIngredienti(String[] ingredientiRichiesti) {
		
		int conta = 0;
		
		for(String i : ingredienti)
			for(String I : ingredientiRichiesti)
				if(i.equalsIgnoreCase(I))
					conta++;
		
		if(conta == ingredientiRichiesti.length)
			return true;
			else
				return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
