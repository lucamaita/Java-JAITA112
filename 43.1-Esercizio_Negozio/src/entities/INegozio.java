package entities;

import java.util.ArrayList;

public interface INegozio {
	
	public String elenco();
	public String elencoLaptop();
	public ArrayList<Entity> maxPrezzo();
	public double prezzoMedio (String tipo);
	public ArrayList<Pc> gaming();
	public String prezzoMassimo();
	public String prezzoMinimo();

}
