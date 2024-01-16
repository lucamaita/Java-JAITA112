package entities;

public class Insegnante extends Persona {
	
	//Proprieta
	private String materiaInsegnante;
	private double stipendioBase;
	
	//Costruttore
	public Insegnante(String nome, String dob, String materiaInsegnante, double stipendioBase) {
		super(nome, dob);
		this.materiaInsegnante = materiaInsegnante;
		this.stipendioBase = stipendioBase;
	}

	//Getters & Setters
	public String getMateriaInsegnante() {
		return materiaInsegnante;
	}

	public void setMateriaInsegnante(String materiaInsegnante) {
		this.materiaInsegnante = materiaInsegnante;
	}

	public double getStipendioBase() {
		return stipendioBase;
	}

	public void setStipendioBase(double stipendioBase) {
		this.stipendioBase = stipendioBase;
	}

	//Metodi
	@Override
	public String toString() {
		return 	super.toString()							+
				"\nMateria Insegnata: " + materiaInsegnante + "	┃" + 
				"\nStipendio Base: " 	+ stipendioBase +"$"+ "		┃" + 
				"\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
	}
	
	public int anniPensione() {
		return 70 - eta();
	}
	
	public double stipendio() {
		
		double stipendioFinale = stipendioBase;
		
		if(eta() >= 30 && eta() <= 40) {
			stipendioFinale += 300;
		} else if (eta() >= 40 && eta() <= 50) {
			stipendioFinale += 500;
		} else if (eta() >= 50 && eta() <= 60) {
			stipendioFinale += 800;
		} else if (eta() > 60) {
			stipendioFinale += 1000 + (50 * anniPensione());
		}
		return stipendioFinale;
	}
}
