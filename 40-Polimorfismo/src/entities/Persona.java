package entities;

import java.time.LocalDate;

public class Persona {
	
	//Proprieta
	private String nome;
	private String cognome;
	private String residenza;
	private String dob;
	
	//COstruttore
	public Persona(String nome, String cognome, String residenza, String dob) {
		super();
		setNome(nome);
		setCognome(cognome);
		setResidenza(residenza);
		setDob(dob);
	}

	//Getters & Setters
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
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	//Metodi
	@Override
	public String toString() {
		return 	"\nNominativo: " 	+ nome + " " + cognome 	+ 
				"\nResidente a: " 	+ residenza 			+ 
				"\nNato il: " 		+ dob 					+ 
				"\nEta: "			+ eta()					;
	}

	public int eta() {
		return LocalDate.now().getYear() - Integer.parseInt(dob.split("-")[2]);
	}
	
	
	
}
