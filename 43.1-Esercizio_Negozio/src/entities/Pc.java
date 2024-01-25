package entities;

public class Pc extends Articolo {
	
	// Proprieta
	private String modello;
	private int ram;
	private String cpu;
	private int hd;
	private String tipoHd;
	
	// Costruttore
	public Pc(int id, String marca, int annoProduzione, String modello, int ram, String cpu, int hd, String tipoHd) {
		super(id, marca, annoProduzione);
		setModello(modello);
		setRam(ram);
		setCpu(cpu);
		setHd(hd);
		setTipoHd(tipoHd);
	}

	// Getter & Setters
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getHd() {
		return hd;
	}
	public void setHd(int hd) {
		this.hd = hd;
	}
	public String getTipoHd() {
		return tipoHd;
	}
	public void setTipoHd(String tipoHd) {
		this.tipoHd = tipoHd;
	}
	
	// Metodi
	@Override
	public String toString() {
		return 	super.toString()			+	
				"\nModello: " 	+ modello 	+ 
				"\nRam: " 		+ ram 		+ "GB" +
				"\nCpu: " 		+ cpu 		+ 
				"\nHD: " 		+ hd 		+ "GB" + 
				"\nTipo HD: " 	+ tipoHd	+
				"\n----------------------------------------------";
	}

	public double prezzo() {
		
		double prezzo = 100.0;
		prezzo += 100 * ram;
		prezzo += cpu.contains("intel") ? 100 : 50;
		prezzo += 10  * hd;
		prezzo += tipoHd.equalsIgnoreCase("ssd") ? 100 : 50;
		return prezzo;
	}
	
	public boolean gaming() {
		if(cpu.contains("i7") && tipoHd.equalsIgnoreCase("HHD")) {
			return true;
		} else {
			return false;
		}
	}

	
	
	
	
}
