package entities;

import java.util.Map;

import factory.IFactory;

public class Libro extends Entity implements IFactory {

	// Proprieta
	private String titolo;
	private String genere;
	private int	   numero_pagine;
	private String casa_editrice;
	private Double prezzo;
	private Autore autore;
	
	// Costruttore
	public Libro() {
		// TODO Auto-generated constructor stub
	}
	
	public Libro(int id, String titolo, String genere, int numero_pagine, String casa_editrice, Double prezzo,
			Autore autore) {
		super(id);
		setTitolo(titolo);
		setGenere(genere);
		setNumero_pagine(numero_pagine);
		setCasa_editrice(casa_editrice);
		setPrezzo(prezzo);
		setAutore(autore);
	}


	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public int getNumero_pagine() {
		return numero_pagine;
	}
	public void setNumero_pagine(int numero_pagine) {
		this.numero_pagine = numero_pagine;
	}
	public String getCasa_editrice() {
		return casa_editrice;
	}
	public void setCasa_editrice(String casa_editrice) {
		this.casa_editrice = casa_editrice;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	// METODI
	@Override
	public String toString() {
		return 	super.toString()	+
				"\nTitolo: " 		+ titolo + 
				"\nGenere: " 		+ genere + 
				"\nNumero_pagine: " + numero_pagine + 
				"\nCasa_editrice: " + casa_editrice + 
				"\nPrezzo: " 		+ prezzo + 
				"\nAutore: " 		+ autore.getNome() + " " + autore.getCognome() +" id: " + autore.getId() +
				"\n---------------------------------";
	}

	@Override
	public void create(Map<String,String> map)
	{
		setId(Integer.parseInt(map.get("castoro")));
		setTitolo(map.get("titolo"));
		setGenere(map.get("genere"));
		setNumero_pagine(Integer.parseInt(map.get("numero_pagine")));
		setCasa_editrice(map.get("casa_editrice"));
		setPrezzo(Double.parseDouble(map.get("prezzo")));
		
		Autore a = new Autore();
		a.setNome(map.get("nome"));
		a.setCognome(map.get("cognome"));
		a.setId(Integer.parseInt(map.get("id")));
		setAutore(a);
	}
}
