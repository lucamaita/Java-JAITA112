package entities;

public class Paziente extends Persona {

	//prorpeita
	private String malattia;
	private boolean contagioso;
	private int giorniDegenza;
	
	//Costruttore
	public Paziente(String nome, String cognome, String residenza, 
					String dob, String malattia, boolean contagioso,int giorniDegenza) {
		super(nome, cognome, residenza, dob);
		setMalattia(malattia);
		setContagioso(contagioso);
		setGiorniDegenza(giorniDegenza);
	}

	//Getters & Setters
	public String getMalattia() {
		return malattia;
	}
	public void setMalattia(String malattia) {
		this.malattia = malattia;
	}
	public boolean isContagioso() {
		return contagioso;
	}
	public void setContagioso(boolean contagioso) {
		this.contagioso = contagioso;
	}
	public int getGiorniDegenza() {
		return giorniDegenza;
	}
	public void setGiorniDegenza(int giorniDegenza) {
		this.giorniDegenza = giorniDegenza;
	}

	//Metodi
	@Override
	public String toString() {
		return 	"\n\tPAZIENTE\n" 	+
				super.toString() 	+
				"\nMalattia: " 		+ malattia 											+ 
				"\nStato: " 		+ (contagioso ? "Contagioso" : "Non Contagioso")	+ 
				"\nGiorniDegenza: " + giorniDegenza 	+ " giorni" 					+
				"\nCosto: "			+ spesaPaziente()	+ "$"							+
				"\n------------------------------------------------------------------\n";
	}
	
	public double spesaPaziente() {
		
		double ris = 150;
		
		ris += contagioso ? 300 : 0;
		
		ris += giorniDegenza * 100;
		
		return ris;
	}
	
}
