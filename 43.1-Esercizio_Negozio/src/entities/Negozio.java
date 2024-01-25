package entities;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Negozio implements INegozio {
	
	private ArrayList<Entity> articoli;
	
	public Negozio(String path) throws FileNotFoundException {
		
		articoli = new ArrayList<Entity>();
		
		Scanner file = new Scanner(new File(path));
		
		Entity e;
		
		while(file.hasNextLine()) {
			
			String[] info = file.nextLine().split(",");
			
			e = null;
			
			if(info[0].equalsIgnoreCase("p")) {
				
				e = new Pc(Integer.parseInt(info[1]),
							info[2],
							Integer.parseInt(info[3]),
							info[4],
							Integer.parseInt(info[5]),
							info[6],
							Integer.parseInt(info[7]),
							info[8]);
			}
			else if (info[0].equalsIgnoreCase("t")) {
				
				e = new Televisore(Integer.parseInt(info[1]),
									info[2],
									Integer.parseInt(info[3]),
									Double.parseDouble(info[5]),
									info[4],
									(info[6].equalsIgnoreCase("true") ? true : false));
			}

			if(e != null)
				articoli.add(e);
		}
		file.close();
		
	}
	
	// Metodi
	
	public String elenco() {
		
		String ris = "";
		
		for (Entity e : articoli) {
			ris += e.toString();
		}
		return ris;
	}
	
	public String elencoLaptop() {
		
		String ris = "";
		
		for (Entity e : articoli) {
			if(e instanceof Pc) {
				if (((Pc) e).getModello().contains("Portatile")) {
					ris += e.toString();
				}
			}
		}
		return ris;
	}
	
	public ArrayList<Entity> maxPrezzo() {
		
		ArrayList <Entity> risPc = new ArrayList <Entity>();
		ArrayList <Entity> risTv = new ArrayList <Entity>();

		double maxPc = 0.0;
		double maxTv = 0.0;
		
		for (Entity e : articoli) {
			
			if (e instanceof Pc) {
				
				if (((Pc) e).prezzo() > maxPc) {
					maxPc = ((Pc) e).prezzo();
					risPc.clear();
					risPc.add(e);
				}
				else if (((Pc) e).prezzo() == maxPc) {
					risPc.add(e);
				}
			} 
			else if (e instanceof Televisore) {
				
				if (((Televisore) e).prezzo() > maxTv) {
					
					maxTv = ((Televisore) e).prezzo();
					risTv.clear();
					risTv.add(e);
				}
				else if (((Televisore) e).prezzo() == maxTv) {
					risTv.add(e);
				}
			}
		}
		risPc.addAll(risTv);
		return risPc;
	}
	
	public double prezzoMedio (String tipo) {
		
		double sommaPrezzi = 0;
	    int conteggioArticoli = 0;
		
		for (Entity e : articoli) {
			
			if (e instanceof Pc && tipo.equalsIgnoreCase("pc")) {
	            sommaPrezzi += (((Pc)e).prezzo());
	            conteggioArticoli++;
	        } else if (e instanceof Televisore && tipo.equalsIgnoreCase("tv")) {
	            sommaPrezzi += (((Televisore)e).prezzo());
	            conteggioArticoli++;
	        }
		}
		
	    if (conteggioArticoli == 0) {
	        return 0; 
	    } else {
	        return sommaPrezzi / conteggioArticoli;
	    }
		
	}
	
	public ArrayList<Pc> gaming() {
	    ArrayList<Pc> pcDaGaming = new ArrayList<Pc>();

	    for (Entity e : articoli) {
	        if (e instanceof Pc) {
	            Pc pc = (Pc) e;
	            if (pc.gaming()) {
	                pcDaGaming.add(pc);
	            }
	        }
	    }

	    return pcDaGaming;
	}
	
	public String prezzoMassimo() {
		
		double max = 0.0;
		String ris = "";
		
		for (Entity e : articoli) {
			
			if(((Articolo)e).prezzo() > max) {
				max = (((Articolo)e).prezzo());
				ris = e.toString();
			}
			else if(((Articolo)e).prezzo() == max) {
				ris += e.toString();
			}
		}
		return ris;
	}
	
	public String prezzoMinimo() {
		double min = Double.MAX_VALUE;
		String ris = "";
		
		for (Entity e : articoli) {
			
			if(((Articolo)e).prezzo() < min) {
				min = (((Articolo)e).prezzo());
				ris = e.toString();
			}
			else if(((Articolo)e).prezzo() == min) {
				ris += e.toString();
			}
		}
		return ris;
	}
	
	
	
	
}
