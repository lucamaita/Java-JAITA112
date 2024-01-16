package main;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Menu;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Menu m = new Menu();
		
		//String[] ingredientiDaCercare = {"zucchero","sale"};
		
		m.leggiDaFile("src/res/Dati.txt");
		
		//TESTING
		
		//System.out.println(m.getPiatti());
		//System.out.println(m.listaPiatti("primo"));
		//System.out.println(m.piattiConIngrediente("zucchero"));
		//System.out.println(m.piattiConIngredienti(ingredientiDaCercare));
		//System.out.println(m.piuCostoso());
		//System.out.println(m.menuOrdinatoPerPrezzo());
		//System.out.println(m.costoMedioMenu());
		//System.out.println(m.piattiNonValidi());
		//System.out.println(m.listaTipi());
		//System.out.println(m.tipoRicorrente());
		//System.out.println(m.listaIngredienti());
		//System.out.println(m.ingredienteRicorrente());
		//System.out.println(m.tipiRicorrenti());
		//System.out.println(m.ingredientiRicorrenti());
		//System.out.println(m.menuOrdinatoPerNome());
		
		//MENU
		
		Scanner scanner = new Scanner(System.in);
        int scelta = -1;
		
        stampaMenu();

        do {
        	try {
        		System.out.print("Inserisci la tua scelta: ");
        		scelta = scanner.nextInt();
        		
        		switch (scelta) {
        		case 1:
        			System.out.println("Visualizza tutti i piatti: " + m.getPiatti());
        			break;
        		case 2:
        			System.out.print("Inserisci il tipo di piatti da visualizzare: ");
        			String tipoPiatti = scanner.next();
        			System.out.println("Visualizza piatti di tipo " + tipoPiatti + ": " + m.listaPiatti(tipoPiatti));
        			break;
        		case 3:
        			System.out.print("Inserisci l'ingrediente: ");
        			String ingrediente = scanner.next();
        			System.out.println("Visualizza piatti con " + ingrediente + ": " + m.piattiConIngrediente(ingrediente));
        			break;
        		case 4:
        			System.out.print("Inserisci gli ingredienti separati da virgola: ");
        			String[] ingredienti = scanner.next().split(",");
        			System.out.println("Visualizza piatti con ingredienti specificati: " + m.piattiConIngredienti(ingredienti));
        			break;
        		case 5:
        			System.out.println("Visualizza il piatto più costoso: " + m.piuCostoso());
        			break;
        		case 6:
        			System.out.println("Visualizza menu ordinato per prezzo: " + m.menuOrdinatoPerPrezzo());
        			break;
        		case 7:
        			System.out.println("Visualizza costo medio del menu: " + m.costoMedioMenu());
        			break;
        		case 8:
        			System.out.println("Visualizza piatti non validi: " + m.piattiNonValidi());
        			break;
        		case 9:
        			System.out.println("Trovare la moda del TIPO: " + m.tipoRicorrente());
        			break;
        		case 10:
        			System.out.println("Trovare la moda dell'ingrediente: " + m.ingredienteRicorrente());
        			break;
        		case 11:
        			System.out.println("Tipi di piatti ricorrenti: " + m.tipiRicorrenti());
        			break;
        		case 12:
        			System.out.println("Ingredienti ricorrenti: " + m.ingredientiRicorrenti());
        			break;
        		case 13:
        			System.out.println("Menu ordinato per nome (Bonus): " + m.menuOrdinatoPerNome());
        			break;
        		case 0:
        			System.out.println("Uscita dal programma.");
        			break;
        		default:
        			System.out.println("Scelta non valida. Riprova.");
        		}
        		
        	} catch (InputMismatchException e) {
                System.out.println("Inserisci un numero valido. Riprova.");
                scanner.next();
            }

        } while (scelta != 0);

        scanner.close();
    }

    // Metodo per stampare il menu iniziale
    private static void stampaMenu() {
        System.out.println("Benvenuto nel programma Ristorante!");
        System.out.println("Legenda:");
        System.out.println("1. Visualizza tutti i piatti");
        System.out.println("2. Visualizza piatti di un tipo specifico");
        System.out.println("3. Visualizza piatti con un ingrediente specifico");
        System.out.println("4. Visualizza piatti con ingredienti specifici");
        System.out.println("5. Visualizza il piatto più costoso");
        System.out.println("6. Visualizza menu ordinato per prezzo");
        System.out.println("7. Visualizza costo medio del menu");
        System.out.println("8. Visualizza piatti non validi");
        System.out.println("9. Trova la moda del TIPO");
        System.out.println("10. Trova la moda dell'ingrediente");
        System.out.println("11. Trova tipi di piatti ricorrenti");
        System.out.println("12. Trova ingredienti ricorrenti");
        System.out.println("13. Bonus: Visualizza menu ordinato per nome");
        System.out.println("0. Esci dal programma");
        System.out.println("----------------------------");
    }

}