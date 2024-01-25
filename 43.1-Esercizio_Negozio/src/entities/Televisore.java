package entities;

public class Televisore extends Articolo {
	
	// Proprieta
	private double pollici;
	private String modello;
	private boolean smartTv;
	
	// Costruttore
	public Televisore(String marca, int annoProduzione, double pollici, String modello, boolean smartTv) {
		super(marca, annoProduzione);
		setPollici(pollici);
		setModello(modello);
		setSmartTv(smartTv);
	}

	// Getters & Setters
	public double getPollici() {
		return pollici;
	}
	public void setPollici(double pollici) {
		this.pollici = pollici;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public boolean isSmartTv() {
		return smartTv;
	}
	public void setSmartTv(boolean smartTv) {
		this.smartTv = smartTv;
	}

	// Metodi
	@Override
	public String toString() {
		return 	"\nPollici: " + pollici + 
				"\nModello: " + modello + 
				"\nSmartTv: " + smartTv;
	}

	@Override
	double prezzo() {
		double prezzo = 500.0;
		
		prezzo += pollici * 10;
		prezzo += modello.equalsIgnoreCase("OLED") ? 500 : 50;
		prezzo += smartTv ? 100 : 0;
		return prezzo;
	}
	
	
	
	

}
