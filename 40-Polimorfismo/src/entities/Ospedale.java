package entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Ospedale {
	
	private ArrayList<Persona> persone;
	
	public Ospedale(String path) throws FileNotFoundException {
		
		persone = new ArrayList<Persona>();
		
		Scanner file = new Scanner(new File(path));
		
		Persona p = null;
		
		while(file.hasNextLine()) {
			
			p = null;
			
			String[] info = file.nextLine().split(",");
			
			switch(info[0].toLowerCase()) {
			
				case "pe" :
					p = new Persona(info[1],info[2],info[3],info[4]);
					break;
				case "me" :
					p = new Medico(info[1], info[2], info[3], info[4], info[5], info[6], Double.parseDouble(info[7]));
					break;
				case "pa" :
					p = new Paziente(info[1], info[2], info[3], info[4], info[5], info[6].equalsIgnoreCase("s"),Integer.parseInt(info[7]));
					break;
				default:
					System.out.println("Riga errata nel file");
					break;
			}
			
			if(p != null)
				persone.add(p);
		}//Fine While
		file.close();
	}//Fine costruttore
	
	// Voglio un metodo che stampi la lista completa di tutte le persone del file
	public String listaCompleta() {
		
		String ris = "";
		for(Persona p : persone) {
			ris += p.toString();
		}
		
		return ris;
	}// Fine listaCompleta()
	
	//Voglio vedere il nominativo della persona piu giovane
	public String personaGiovane() {
		
		String ris = "";
		int min = 145;
		
		for(Persona p : persone) {
			if(p.eta() < min) {
				min = p.eta();
				ris = p.getNome() + " " + p.getCognome();
			} else if(p.eta() == min) {
				ris += p.getNome() + " " + p.getCognome();
			}
		}
		return ris;
	}//Fine personaGiovane()

	//Voglio vedere il nominativo del medico piu giovane
	public String medicoGiovane() {
		
		String ris = "";
		int min = 145;
		
		for(Persona p : persone) {
			if(p instanceof Medico) { //INSTANCEOF controlla se il tipo concreto dell'oggetto P e uguale al tipo Medico
				if(p.eta() < min) {
					min = p.eta();
					ris = p.getNome() + " " + p.getCognome();
				} else if(p.eta() == min) {
					ris += p.getNome() + " " + p.getCognome();
				}
			}
		}
		return ris;
	}
	
	//Voglio vedere il medico con lo stipendio maggiore
	public String medicoPiuPagato() {
		
		String ris = "";
		double max = 0;
		
		for(Persona p : persone) {
			if(p instanceof Medico) {
				
				// Di seguito abbiamo due modi diversi di fare lo stesso casting:
				// Metodo 1: Si chiamano solo casting e dura per l'intero blocco di appartenenza dell'oggett m
				
//				Medico m = (Medico)p;
//				m.getStipendio();
				
				// Metodo 2: Si chiama casting in linea ed e temporaneo al comando in cui e scritto.
				
//				((Medico) p).getStipendio();
				
				if(((Medico) p).getStipendio() > max) {
					
					max = ((Medico) p).getStipendio();
					ris = p.toString();
				} else if( ((Medico)p).getStipendio() == max) {
					ris += p.toString();
				}
				
			}
		}
		
		// NOTA BENE:
		// Il cast puo sempre potenzialmente avvenire a patto che stiate attenti a una cosa:
		// il tipo su cui effettuiamo il casting (p) deve poter essere trasformato nel tipo di interesse (Medico)
		// perche altrimenti in fase di running il cast dara vita a un eccezione che blocchera il programma.
		// Per questo motivo e fondamentale quando si tratta di oggetti, effettuare prima del cast il comando
		// instanceof, cosi da evitare errori in fase di running
		
		
		
		
		return ris;
	}
	
	//Voglio vedere la spesa sostenuta dall'ospedale per tutti i pazienti con una malattia passata
	public double spesa(String malattia) {
		
		double ris = 0;
		
		for(Persona p : persone) {
			if(p instanceof Paziente) {
				Paziente m = (Paziente)p;
				
				if(m.getMalattia().equalsIgnoreCase(malattia)) {
					ris += m.spesaPaziente();
				}
			}
		}
		
		return ris;
	}
	
	//Voglio sapere quanto spende in totale l'ospedale immaginando di trattare tutti i pazienti del file di
	// pagare lo stipendio mensile di tutti i medici del file
	public double spesaTotale() {
		
		double ris = 0;
		
		for(Persona p : persone) {
			if(p instanceof Paziente) {
				ris += ((Paziente) p).spesaPaziente();
			} else if(p instanceof Medico) {
				ris += ((Medico) p).getStipendio();
			}
		}
		return ris;
	}
	
	//Fare lo stesso conto di prima, ma per ogni medico fuori sede, aggiungere alla spesa calcolata
	// un rimborso spese per il medico pari al 25% del suo stipendio
	public double speseConRimborsi() {
		
		double ris = 0;
		
		for(Persona p : persone) {
			if(p instanceof Paziente) {
				ris += ((Paziente) p).spesaPaziente();
			} else if(p instanceof Medico) {
				ris += ((Medico) p).getStipendio();
				if(((Medico) p).fuoriSede()) {
					ris += ((Medico) p).getStipendio()/100*25;
				}
			}
		}
		return ris;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//Fine classe
