package entities;

import java.time.LocalDate;

public class Persona {
	
	//Proprieta
	private String nome;
	private String dob;
	
	//Costruttore
	public Persona(String nome, String dob) {
		super();
		setNome(nome);
		setDob(dob);
	}

	//Getters & Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return 	"\nNome: " 				+ nome 	+ "		┃" +
				"\nAnno di nascita: " 	+ dob 	+ "		┃" ;
				
	}

	public int eta() {
		return LocalDate.now().getYear() - Integer.parseInt(dob);	
	}
	
}
