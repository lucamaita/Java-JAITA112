package entities;

public class Medico extends Persona {
	//Proprieta
	private String specializzazione;
	private String ospedale;
	private double stipendio;
	
	//Costruttore
	public Medico(String nome, String cognome, String residenza, String dob, 
					String specializzazione, String ospedale,double stipendio) {
		super(nome, cognome, residenza, dob);
		setSpecializzazione(specializzazione);
		setOspedale(ospedale);
		setStipendio(stipendio);
	}

	//Getters & Setters
	public String getSpecializzazione() {
		return specializzazione;
	}
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	public String getOspedale() {
		return ospedale;
	}
	public void setOspedale(String ospedale) {
		this.ospedale = ospedale;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	//Metodi
	@Override // -> Si chiama NOTAZIONE ed e codice!
	public String toString() {
		return 	"\n\tMEDICO\n" 			+
				super.toString()		+
				"specializzazione: " 	+ specializzazione 						+ 
				"\nospedale: " 			+ ospedale 								+ 
				"\nstipendio: " 		+ stipendio + "$"						+ 
										  (fuoriSede() ? "\nFuori Sede" : "") 	+
				"\n----------------------------------------------------------\n";
	}
	
	public boolean fuoriSede() {
		
		String sedeOspedale = "";
		
		switch(ospedale.toLowerCase())
		{
		case "san raffaele":
		case "fatebene fratelli":
		case "humanitas":
			sedeOspedale = "Milano";
			break;
		case "ponte san pietro":
			sedeOspedale = "Bergamo";
			break;
		case "ospedali civili" :
			sedeOspedale = "Brescia";
			break;
		}
		
		return !getResidenza().equalsIgnoreCase(sedeOspedale);
	}
	
}
