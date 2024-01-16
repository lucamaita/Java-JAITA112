package entities;

public class Studente extends Persona{
	
	//Proprieta
	private int classe;
	private String sezione;
	private Double[] voti;
	
	//Costruttore
	public Studente(String nome, String dob, int classe, String sezione, Double[] voti) {
		super(nome, dob);
		this.classe = classe;
		this.sezione = sezione;
		this.voti = voti;
	}

	//Getters & Setters
	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public Double[] getVoti() {
		return voti;
	}

	public void setVoti(Double[] voti) {
		this.voti = voti;
	}

	//Metodi
	@Override
	public String toString() {
		return 	super.toString()								+
				"\nClasse: " 			+ classe  + "			┃"	+ 
				"\nSezione: " 			+ sezione + "			┃"	+		 
				"\nMedia Italiano: "	+ voti[0] + "		┃"	+
				"\nMedia Matematica: "	+ voti[1] + "		┃"	+
				"\nMedia Storia: "		+ voti[2] + "		┃"	+
				"\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
	}
	
	public int nInsuff() {
		int conta = 0;
		for(double v : voti)
			if(v < 6)
				conta++;
		return conta;
	}
	
	public double mediaComplessiva() {
		double somma = 0;
		for(double v : voti)
			somma += v;
		return somma/voti.length;
	}
	
	public String esito() {
		if(mediaComplessiva() >= 6 && nInsuff() <= 1)
			return "Promosso";
		else
			return "Bocciato";
	}
	
	public boolean erasmus() {
		if((classe == 4 || classe == 5 ) && esito().equalsIgnoreCase("Promosso") && mediaComplessiva() >= 8)
			return true;
		else
			return false;
	}

	public String classeCompleta() {
		return classe + sezione;
	}

}
