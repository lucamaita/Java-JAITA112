package main;

//import significa che java va a cercare altrove l'elemento che mi serve
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// Stesso programma ma con dati inseriti dall'utente
		
		// DICO --> e un acronimo che sta per Dichiarazione, Inizializzazione, Calcolo e Output
		// E anche un pattern, cioe una soluzione a un problema ricorrente
		
		// DICHIARAZIONE (D)
		double altezza;
		double peso;
		String nome;
		double bmi;
		String risposta;
		// Scanner e uno strumento che mi permettera di assorbire quello che l'utente scrive
		// in console tramite la tastiera del pc
		Scanner tastiera;
		
		// INIZIALIZZAZIONE (I)
		tastiera = new Scanner(System.in);
		bmi = 0;
		risposta = "";
		System.out.println("Digita il tuo nome e poi premi ENTER");
		nome = tastiera.nextLine();
		// tastiera.nextline() legge quello che utente ha scritto in console.
		// Il dato letto da console viene portato nel programma sempre come stringa
		System.out.println("Digita il tuo peso in chilogrammi e poi premi ENTER");
		// Per trasformare il dato letto in double devo usare Double.parseDouble() che tenta
		// di trasformare ad esempio "82.4" in 82.4
		// Per gli interi di scrive Integer.parseInt()
		peso = Double.parseDouble(tastiera.nextLine());
		System.out.println("Digita la tua altezza in metri e poi premi ENTER");
		altezza = Double.parseDouble(tastiera.nextLine());
		
		// Chiudere lo scanner SEMPRE
		tastiera.close();
		
		//CALCOLO (C)
		bmi = peso/(altezza*altezza);
		
		//OUTPUT (O)
		risposta = "Ciao " + nome + " il tuo BMI vale " + bmi + "KG/m2";
		System.out.println(risposta);

	} // NON SI CANCELLA

} // NON SI CANCELLA
