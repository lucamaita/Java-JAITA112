package entities;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Scuola {
	
	private ArrayList<Persona> personeAL;
	
	public Scuola(String path) throws FileNotFoundException {
		
		Scanner file = new Scanner(new File(path));
		
		personeAL = new ArrayList<Persona>();
		
		while(file.hasNextLine()){
			
			String[] info = file.nextLine().split(";");
			
			
			
			switch(info[0].toLowerCase()) {
			case "studente":
				
				Double[] arrayVoti = {	Double.parseDouble(info[5]), 
										Double.parseDouble(info[6]), 
										Double.parseDouble(info[7])};
				
				personeAL.add(
						new Studente(
								info[1], info[2],
								Integer.parseInt(info[3]),
								info[4],
								arrayVoti
								)
						);
				
				break;
			case "insegnante":
				personeAL.add(
						new Insegnante(
								info[1],
								info[2],
								info[3],
								Double.parseDouble(info[4])
								)
						);
				break;
			default:
				System.out.println("File non compatibile");
				break;
			}
		}
		file.close();
	}
	
	//Metodi
	
	public String listaCompleta() {
		String ris = "";
		for(Persona p : personeAL)
			ris += p.toString();
		return 	"\n\t▼ LISTA COMPLETA ▼\n" + 
				"\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
				ris;
	}

	public String listaStudenti() {
		String ris = "";
		for(Persona p : personeAL) {
			if (p instanceof Studente) {
				ris += p.toString();
			}
		}
		return 	"\n\t▼ LISTA STUDENTI ▼\n" + 
				"\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
				ris;
	}
	
	public String listaDocenti() {
		String ris = "";
		for(Persona p : personeAL) {
			if (p instanceof Insegnante) {
				ris += p.toString();
			}
		}
		return 	"\n\t▼ LISTA DOCENTI ▼\n" + 
				"\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
				ris;
	}
	
	public String listaPromossi() {
	    int contaBocciati = 0;
	    String ris = "";
	    for (Persona p : personeAL) {
	        if (p instanceof Studente) {
	            Studente s = (Studente) p;
	            if (s.esito().equalsIgnoreCase("Promosso")) {
	                ris += s.toString();
	            } else {
	                contaBocciati++;
	            }
	        }
	    }
	
	    return "\n\t▼ LISTA PROMOSSI ▼\n" +
	            "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
	            ris +
	            "\n\nStudenti Bocciati: " + contaBocciati + "\n";
	}

	public int nErasmus() {
	    int conta = 0;
	    for (Persona p : personeAL) {
	        if (p instanceof Studente) {
	            Studente s = (Studente) p;
	            if (s.erasmus()) {
	                conta++;
	            }
	        }
	    }
	    return conta;
	}
	
	public String pensionamento() {
	    String ris = "";
	    for (Persona p : personeAL) {
	        if (p instanceof Insegnante) {
	            Insegnante i = (Insegnante) p;
	            if (i.anniPensione() <= 5) {
	                ris += i.toString();
	            }
	        }
	    }
	
	    if (ris.isEmpty()) {
	        return "\nNESSUN INSEGNANTE PROSSIMO ALLA PENSIONE\n";
	    } else {
	        return "\n\t▼ LISTA INSEGNANTI PROSSIMI ALLA PENSIONE ▼\n" +
	                "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
	                ris;
	    }
	}
	
	public double totaleStipendiIta() {
	    double totale = 0;
	    for (Persona p : personeAL) {
	        if (p instanceof Insegnante) {
	            Insegnante i = (Insegnante) p;
	            if (i.getMateriaInsegnante().equalsIgnoreCase("italiano")) {
	                totale += i.stipendio();
	            }
	        }
	    }
	    return totale;
	}
	
	public double mediaStipendi() {
	    double somma = 0;
	    for (Persona p : personeAL) {
	        if (p instanceof Insegnante) {
	            Insegnante i = (Insegnante) p;
	            somma += i.stipendio();
	        }
	    }
	    return somma / personeAL.size();
	}
	
	public double mediaStipendiMate() {
	    double somma = 0;
	    int contaMate = 0;
	    for (Persona p : personeAL) {
	        if (p instanceof Insegnante) {
	            Insegnante i = (Insegnante) p;
	            if (i.getMateriaInsegnante().equalsIgnoreCase("matematica")) {
	                somma += i.stipendio();
	                contaMate++;
	            }
	        }
	    }
	    return somma / contaMate;
	}
	
	//PRO VERSION
	public String studenteBravo() {
	    double mediaMax = 0;
	    String ris = "";
	    for (Persona p : personeAL) {
	        if (p instanceof Studente) {
	            Studente s = (Studente) p;
	            if (s.mediaComplessiva() > mediaMax) {
	                mediaMax = s.mediaComplessiva();
	                ris = s.getNome();
	            }
	        }
	    }
	    return "\n\t▼ STUDENTE MIGLIORE ▼\n" +
	            "\nNome: " + ris +
	            "\nMedia complessiva: " + mediaMax;
	}

	public String insegnanteVecchio() {
	    int etaMax = 0;
	    String ris = "";
	    for (Persona p : personeAL) {
	        if (p instanceof Insegnante) {
	            Insegnante i = (Insegnante) p;
	            if (i.eta() > etaMax) {
	                etaMax = i.eta();
	                ris = i.getNome();
	            }
	        }
	    }
	    return "\n\t▼ INSEGNANTE PIU VECCHIO ▼\n" +
	            "\nNome: " + ris +
	            "\nEta: " + etaMax;
	}

	public String insegnanteRicco() {
	    double stipendioMax = 0;
	    String materia = "";
	    String nome = "";

	    for (Persona p : personeAL) {
	        if (p instanceof Insegnante) {
	            Insegnante i = (Insegnante) p;
	            if (i.stipendio() > stipendioMax) {
	                stipendioMax = i.stipendio();
	                nome = i.getNome();
	                materia = i.getMateriaInsegnante();
	            }
	        }
	    }
	    return "\n\t▼ INSEGNANTE PIU RICCO ▼\n" +
	            "\nNome: " + nome +
	            "\nMateria: " + materia +
	            "\nStipendio: " + stipendioMax + "$";
	}
	
	public String studenteGiovane() {
	    String nome = "";
	    int etaMin = 100;
	    String classe = "";

	    for (Persona p : personeAL) {
	        if (p instanceof Studente) {
	            Studente s = (Studente) p;
	            if (s.eta() < etaMin) {
	                etaMin = s.eta();
	                nome = s.getNome();
	                classe = s.classeCompleta();
	            }
	        }
	    }
	    return "\n\t▼ STUDENTE PIU GIOVANE ▼\n" +
	            "\nNome: " + nome +
	            "\nEta: " + etaMin +
	            "\nClasse: " + classe;
	}
	
	public String fuoriCorso() {
	    String risNome = "";
	    int risEta = 0;

	    for (Persona p : personeAL) {
	        if (p instanceof Studente) {
	            Studente s = (Studente) p;
	            if (s.getClasse() == 5 && s.eta() >= 18 && s.eta() <= 19) {
	                risNome = s.getNome();
	                risEta = s.eta();
	            } else if (s.getClasse() == 4 && s.eta() >= 17 && s.eta() <= 18) {
	                risNome = s.getNome();
	                risEta = s.eta();
	            } else if (s.getClasse() == 3 && s.eta() >= 16 && s.eta() <= 17) {
	                risNome = s.getNome();
	                risEta = s.eta();
	            } else if (s.getClasse() == 2 && s.eta() >= 15 && s.eta() <= 16) {
	                risNome = s.getNome();
	                risEta = s.eta();
	            } else if (s.getClasse() == 1 && s.eta() >= 14 && s.eta() <= 15) {
	                risNome = s.getNome();
	                risEta = s.eta();
	            }
	        }
	    }
	    if (risNome.isEmpty()) {
	        return "\nNESSUN STUDENTE FUORI CORSO\n";
	    } else {
	        return "\n\t▼ FUORI CORSO ▼\n" +
	                "\nNome: " + risNome +
	                "\nEta: " + risEta;
	    }
	}
	
	public String studentiPerAula() {
	    int conta = 0;
	    String ris = "";
	    ArrayList<String> classi = new ArrayList<String>();

	    for (Persona p : personeAL) {
	        if (p instanceof Studente) {
	            Studente s = (Studente) p;
	            if (!classi.contains(s.classeCompleta())) {
	                classi.add(s.classeCompleta());
	            }
	        }
	    }

	    for (String c : classi) {
	        for (Persona p : personeAL) {
	            if (p instanceof Studente) {
	                Studente s = (Studente) p;
	                if (c.equalsIgnoreCase(s.classeCompleta())) {
	                    conta++;
	                }
	            }
	        }
	        ris += "\nClasse: " + c + " - Numero Studenti: " + conta;
	        conta = 0;
	    }

	    return "\n\t▼ STUDENTI PER AULA ▼\n" +
	            ris;
	}

}
