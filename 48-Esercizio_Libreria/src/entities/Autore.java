package entities;

import java.util.Map;

import factory.IFactory;

public class Autore extends Entity implements IFactory{
	
	// Proprieta
	private String nome;
	private String cognome;
	private String dob;
	private String nazionalita;
	private String biografia;
	
	// Costruttore
	public Autore(int id, String nome, String cognome, String dob, String nazionalita, String biografia) {
		super(id);
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setNazionalita(nazionalita);
		setBiografia(biografia);
	}
	

	public Autore() {
		// TODO Auto-generated constructor stub
	}

	// Getters & Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	
	// Metodi
	@Override
	public String toString() {
		return 	super.toString()	+
				"\nNome: " + nome + 
				"\nCognome: " + cognome + 
				"\nDOB: " + dob + 
				"\nNazionalita: " + nazionalita +
				"\nBiografia: " + biografia +
				"\n----------------------------";
	}
	
	public void create(Map<String,String> map)
	{
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));
		setCognome(map.get("cognome"));
		setDob(map.get("dob"));
		setNazionalita(map.get("nazionalita"));
		setBiografia(map.get("biografia"));
	}


	
}
