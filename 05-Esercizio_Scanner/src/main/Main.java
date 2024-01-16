package main;

import java.util.Scanner;


public class Main
{

	public static void main(String[] args)
	{
		// Scrivere un programma che calcoli le entrate annuali di un lavoratore.
		// Del lavoratore vi interessa sapere:
		// Nominativo (nome e cognoome), stipendio medio mensile, mensilita contrattuali (13esima, 14esima)
		// Stampare in console "Buonasera sign. [congonome] il suo lordo annuale vale [calcolo]$"
		
		String 	nome;
		String	cognome;
		double 	stipendio;
		int 	mensilita;
		Scanner tastiera;
		double 	lordo_annuale;
		String 	risposta;
		
		
		
		tastiera = 	new Scanner(System.in);
		nome = 		"";
		cognome = 	"";
		risposta = "";
		stipendio = 0;
		mensilita = 0;
		
		
		
		System.out.println("Digita il tuo Nome, poi premi ENTER.");
		nome = tastiera.nextLine();
		System.out.println("Digita il tuo Cognome, poi premi ENTER.");
		cognome = tastiera.nextLine();
		System.out.println("Digita il tuo stipendio medio mensile, poi premi ENTER.");
		stipendio = Double.parseDouble(tastiera.nextLine());
		System.out.println("inserire il numero di mensilita annue fruite, poi premi ENTER.");
		mensilita = Integer.parseInt(tastiera.nextLine());
		
		
	
		tastiera.close();
		
		
		
		lordo_annuale = stipendio * mensilita;
		
		
		
		
		risposta = "Buonasera sign. " + cognome + " il suo lordo annuale vale " + lordo_annuale + "$";
		System.out.println(risposta);

		

		


	} // NON CANCELLARE

} // NON CANCELLARE
