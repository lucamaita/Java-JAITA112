package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Scuola;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scuola s = new Scuola("src/res/Dati.txt");
		
		// TESTING
		
		//System.out.println(s.listaStudenti());
		//System.out.println(s.listaDocenti());
		//System.out.println(s.listaCompleta());
		//System.out.println(s.listaPromossi());
		//System.out.println(s.nErasmus());
		//System.out.println(s.pensionamento());
		//System.out.println(s.totaleStipendiIta());
		//System.out.println(s.mediaStipendi());
		//System.out.println(s.mediaStipendiMate());
		//System.out.println(s.studenteBravo());
		//System.out.println(s.insegnanteVecchio());
		//System.out.println(s.insegnanteRicco());
		//System.out.println(s.studenteGiovane());
		//System.out.println(s.fuoriCorso());
		//System.out.println(s.studentiPerAula());
		
		Scanner tastiera = new Scanner(System.in);
		int scelta = 0;
		
		String menu = 	"\n\tMenu Principale:\n" +
				        "1. Lista completa insegnanti e studenti\n" +
				        "2. Lista dei soli insegnanti\n" +
				        "3. Lista dei soli studenti\n" +
				        "4. Lista degli studenti promossi e numero bocciati\n" +
				        "5. Numero degli studenti che possono andare in erasmus\n" +
				        "6. Lista di insegnanti prossimi alla pensione\n" +
				        "7. Totale stipendio degli insegnanti di italiano\n" +
				        "8. Media degli stipendi di tutti gli insegnanti\n" +
				        "9. Media degli stipendi degli insegnanti di matematica\n" +
				        "10. Studente bravo\n" +
				        "11. Insegnante più vecchio\n" +
				        "12. Insegnante più pagato\n" +
				        "13. Studente più giovane\n" +
				        "14. Fuori corso\n" +
				        "15. Studenti per aula\n" +
				        "16. Esci\n" +
				        "99. Menu";
		
		System.out.println(menu);
		
        do {
            do {
                try {
                    System.out.print("\nInserisci la tua scelta: \n");
                    scelta = Integer.parseInt(tastiera.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input non valido. Inserisci un numero.");
                }
            } while (true);

            switch (scelta) {
                case 1:
                    System.out.println(s.listaCompleta());
                    break;
                case 2:
                    System.out.println(s.listaDocenti());
                    break;
                case 3:
                    System.out.println(s.listaStudenti());
                    break;
                case 4:
                    System.out.println(s.listaPromossi());
                    break;
                case 5:
                    System.out.println("Numero degli studenti che possono andare in erasmus: " + s.nErasmus());
                    break;
                case 6:
                    System.out.println(s.pensionamento());
                    break;
                case 7:
                    System.out.println("Totale stipendio degli insegnanti di italiano: " + s.totaleStipendiIta() + "$");
                    break;
                case 8:
                    System.out.println("Media degli stipendi di tutti gli insegnanti: " + s.mediaStipendi() + "$");
                    break;
                case 9:
                    System.out.println("Media degli stipendi degli insegnanti di matematica: " + s.mediaStipendiMate() + "$");
                    break;
                case 10:
                    System.out.println(s.studenteBravo());
                    break;
                case 11:
                    System.out.println(s.insegnanteVecchio());
                    break;
                case 12:
                    System.out.println(s.insegnanteRicco());
                    break;
                case 13:
                    System.out.println(s.studenteGiovane());
                    break;
                case 14:
                    System.out.println(s.fuoriCorso());
                    break;
                case 15:
                    System.out.println(s.studentiPerAula());
                    break;
                case 16:
                    System.out.println("Arrivederci!");
                    break;
                case 99:
                	System.out.println(menu);
                	break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

        } while (scelta != 16);

        tastiera.close();

	} // FINE STATIC VOID MAIN

}//FINE MAIN
