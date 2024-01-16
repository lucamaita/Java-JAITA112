package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	private ArrayList<Piatto> listaPiatti;
	
	public Menu() {
		
		this.listaPiatti = new ArrayList<Piatto>();
	}
	
	public void leggiDaFile(String path) throws FileNotFoundException {
		Scanner file = new Scanner(new File(path));
		
		while (file.hasNextLine()) {
			
			String riga = file.nextLine();
			Piatto p = creaPiattoDaStringa(riga);
			aggiungiPiatto(p);	
		}
		
		file.close();
	}
	
	private Piatto creaPiattoDaStringa(String riga) {
		
		String[] info = riga.split(",");
		
		String nome = info[0];
		String tipo = info[1];
		double prezzo = Double.parseDouble(info[2]);
		String[] ingredienti = info[3].toLowerCase().split("-");
		
		Piatto p = new Piatto(nome, tipo, prezzo, ingredienti);

		return p;
	}
	
	public void aggiungiPiatto(Piatto p) {
		listaPiatti.add(p);
	}
	
	public ArrayList<Piatto> getPiatti() {
		return listaPiatti;
	}
	
	public ArrayList<Piatto> listaPiatti(String tipo) {
		
		ArrayList<Piatto> listaPiattiTipo = new ArrayList<Piatto>();
		
		for(Piatto l : listaPiatti)
			if (l.getTipo().equalsIgnoreCase(tipo))
				listaPiattiTipo.add(l);
		
		return listaPiattiTipo;
	}
	
	public ArrayList<Piatto> piattiConIngrediente(String ingrediente) {
		
		ArrayList<Piatto> listaPiattiIngrediente = new ArrayList<Piatto>();
		
		for(Piatto l : listaPiatti)
			for(String I : l.getIngredienti())
				if(I.equalsIgnoreCase(ingrediente))
					listaPiattiIngrediente.add(l);
		
		return listaPiattiIngrediente;
	}
	
	public ArrayList<Piatto> piattiConIngredienti(String[] ingredienti) {
		
		int conta = 0;
		ArrayList<Piatto> listaPiattiIngredienti = new ArrayList<Piatto>();
		
		for(Piatto l : listaPiatti) {
			
			for(String I : l.getIngredienti()) {
				
				for(String i : ingredienti) {
					
					if(I.equalsIgnoreCase(i)) {
						
						conta++;
					}
				}
			}
			if(conta == ingredienti.length)
				listaPiattiIngredienti.add(l);
			conta = 0;
		}
		return listaPiattiIngredienti;
			
	}

	public Piatto piuCostoso() {
		
		double max = 0;
		Piatto piattoCostoso = null;
		
		for(Piatto l : listaPiatti) 
			if(l.getPrezzo() > max) {
				max = l.getPrezzo();
				piattoCostoso = l;
			}
		return piattoCostoso;
	}
	
	// ALGORITMO BUBBLE SORT
	// L'ho dovuto cercare su Google, l'ho abbastanza capito ma non troppo
	public ArrayList<Piatto> menuOrdinatoPerPrezzo() {
		
		for(int i = 0; i < listaPiatti.size() - 1; i++) {
			for(int j = 0; j < listaPiatti.size() - i - 1; j++) {
				Piatto piattoCorrente = listaPiatti.get(j);
				Piatto piattoSuccessivo = listaPiatti.get(j+1);
				
				if(piattoCorrente.getPrezzo() > piattoSuccessivo.getPrezzo()) {
					listaPiatti.set(j, piattoSuccessivo);
					listaPiatti.set(j+1, piattoCorrente);
				}
			}
		}
		return listaPiatti;
	}
	
	public double costoMedioMenu() {
		
		double somma = 0;
		
		for(Piatto l : listaPiatti)
			somma += l.getPrezzo();
		return somma/listaPiatti.size();
	}
	
	public ArrayList<Piatto> piattiNonValidi() {
		
		ArrayList <Piatto> nonValidi = new ArrayList <Piatto>();
		
		for(Piatto l : listaPiatti)
			if(!l.valido())
				nonValidi.add(l);
		
		return nonValidi;
				
	}
	
	public ArrayList<String> listaTipi() {
		
		ArrayList <String> listaTipi = new ArrayList <String>();
		
		for(Piatto l : listaPiatti) {
			if(!listaTipi.contains(l.getTipo())) {
				listaTipi.add(l.getTipo());
			}
		}
		return listaTipi;
	}
	
	public String tipoRicorrente() {
		
		int conta = 0;
		int max = 0;
		String moda = "";
		
		for(String t : listaTipi()) {
			for(Piatto l : listaPiatti) {
				if(l.getTipo().equalsIgnoreCase(t)) {
					conta++;
				}
			}
			
			if(conta > max) {
				max = conta;
				moda = t;
			}
			conta = 0;
		}
		
		
		return moda + " " + max;
	}
	
	public ArrayList<String> listaIngredienti() {
		
		ArrayList <String> listaIngredienti = new ArrayList <String>();
		
		for(Piatto l : listaPiatti) {
			for (String i : l.getIngredienti()) {
				if(!listaIngredienti.contains(i)) {
					listaIngredienti.add(i);
				}
			}
		}
		return listaIngredienti;
		
	}
	
	public String ingredienteRicorrente() {
		
		String ris = "";
		int max = 0;
		int conta = 0;
		
		for(String t : listaIngredienti()) {
			for(Piatto l : listaPiatti) {
				for (String i : l.getIngredienti()) {
					if(i.equalsIgnoreCase(t)) {
						conta++;
					}
				}
			}
			if(conta > max) {
				max = conta;
				ris = t;
			}
			conta = 0;
		}
		return ris + " " + max;
	}

	public ArrayList<String> tipiRicorrenti() {
		
		ArrayList<String> tipiModa = new ArrayList<String>();
		int max = 0;
		
		for(String t : listaTipi()) {
			int conta = 0;
			
			for(Piatto l : listaPiatti) {
				if(l.getTipo().equalsIgnoreCase(t)) {
					conta++;
				}
			}
			if (conta > max) {
				tipiModa.clear();
				tipiModa.add(t);
				max = conta;
			}else if(conta == max) {
				tipiModa.add(t);
			}
		}
		return tipiModa;
	}
	
	public ArrayList<String> ingredientiRicorrenti() {
		
		ArrayList<String> ingredientiModa = new ArrayList<String>();
		int max = 0;
		
		for(String i : listaIngredienti()) {
			int conta = 0;
			for(Piatto l : listaPiatti) {
				for(String I : l.getIngredienti()) {
					if(I.equalsIgnoreCase(i)) {
						conta++;
					}
				}
			}
			
			if(conta > max) {
				ingredientiModa.clear();
				ingredientiModa.add(i);
				max = conta;
			} else if(conta == max) {
				ingredientiModa.add(i);
			}
		}
		return ingredientiModa;
	}
	
	//il nostro caro amico chatgpt consigliava l'uso di Collections.sort(), 
	//	ma non ho capito esattamente cosa fosse, quindi Bubble Sort di nuovo
	//???Spiegazione su compareIgnoreCase()?
	public ArrayList<Piatto> menuOrdinatoPerNome() {
	    ArrayList<Piatto> menuOrdinato = new ArrayList<>(listaPiatti);

	    int n = menuOrdinato.size();
	    boolean scambiato;

	    do {
	        scambiato = false;

	        for (int i = 0; i < n - 1; i++) {
	            if (menuOrdinato.get(i).getNome().compareToIgnoreCase(menuOrdinato.get(i + 1).getNome()) > 0) {
	                // Scambia gli elementi se sono nell'ordine sbagliato
	                Piatto temp = menuOrdinato.get(i);
	                menuOrdinato.set(i, menuOrdinato.get(i + 1));
	                menuOrdinato.set(i + 1, temp);
	                scambiato = true;
	            }
	        }
	    } while (scambiato);

	    return menuOrdinato;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
