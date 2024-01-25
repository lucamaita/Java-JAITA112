package entities;

import java.time.LocalDate;

public abstract class Persona extends Entity {
	
	// Proprieta
	private String nome;
	private String cognome;
	private String dob;
	private String residenza;
	
	// Costruttore
	public Persona(int id, String nome, String cognome, String dob, String residenza) {
		super(id);
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setResidenza(residenza);
	}

	//Getter & Setters
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
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	
	//Metodi
	@Override
	public String toString() {
		return 	super.toString()			+
				"\nnome: " 		+ nome 		+ 
				"\ncognome: " 	+ cognome 	+ 
				"\ndob: " 		+ dob 		+ 
				"\nresidenza: " + residenza	;
	}
	
	public int eta() {
		
		return LocalDate.now().getYear() - Integer.parseInt(dob.split("-")[2]);
	}
	
	public abstract double bonus();
	
	
	
	
	
	
	
}
