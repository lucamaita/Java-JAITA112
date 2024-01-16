package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		//  PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE CLASSICA
		// > Sequenza
		// > Selezione (IF, SWITCH, TERNARIO)
		// > ?
		
		// 		TERNARIO
		// Il ternario e uno strumento della selezione, che e nato come risultato dei tentativi
		// di comprimere la scrittura di un IF-ELSE per tenerlo in linea.
		
		// 		SINTASSI
		// variabileFinale = condizione ? istruzione_nel_caso_sia_vero : istruzione_sia_falso;
		
		// I simboli (? : ;) sono sempre obbligatori!!!!
		// Come sono sempre obbligatori i blocchi per le istruzioni_vere e per le istruzioni_false
		// Il ternario e obbligato a restituire un valore, quindi siamo obbligati a assegnmare quel
		// valore a qualcosa
		
		// CONSIGLIO PERSONALE DEL DOCENTE
		// Usate i ternari per situazioni faicili, mentre se dovete fare tante istruzioni di fila meglio un IF
		
		// Esercizio Ternari
		/* Scrivere un programma che permetta di calcolare se
		uno studente può andare in erasmus
		uno studente inserisce direttamente le medie di 4 materie
		italiano, matematica, inglese e francese
		-se la media globale è superiore a 7
		può andare in erasmus a Londra e avere una borsa di studio di 300 euro
		-se la media globale è superiore a 7
		e la media di francese è maggiore di 8
		può andare in erasmus a Parigi o a Londra e può avere una borsa di 400 euro
		-se la media globale è superiore a 8
		e la media di francese o la media di inglese
		è maggiore di 8
		può andare in erasmus a Vancouver e può avere una borsa di studio di 1000 euro
		*/
		
		//D
		boolean erasmus;
		Scanner scanner;
		double 	mediaItaliano;
		double 	mediaMatematica;
		double 	mediaInglese;
		double 	mediaFrancese;
		double 	mediaGlobale;
		String 	localitaErasmusPapabili;
		double 	borsaStudio;
		String 	risposta;

		//I
		scanner = new Scanner(System.in);
		erasmus = false;
		mediaGlobale = 0;
		localitaErasmusPapabili = "Non puoi andare";
		borsaStudio = 0;
		
		System.out.println("Media Italiano: ");
		mediaItaliano = Double.parseDouble(scanner.nextLine());
		System.out.println("Media Matematica: ");
		mediaMatematica = Double.parseDouble(scanner.nextLine());
		System.out.println("Media Inglese: ");
		mediaInglese = Double.parseDouble(scanner.nextLine());
		System.out.println("Media Francese: ");
		mediaFrancese = Double.parseDouble(scanner.nextLine());
		
		scanner.close();
		
		//C
		mediaGlobale = (mediaInglese + mediaFrancese + mediaInglese + mediaMatematica)/4.0;
		
		// METODO 1: IF PIATTI
		
//		if (mediaGlobale > 7)
//		{
//			erasmus = true;
//			localitaErasmusPapabili = "Londra";
//			borsaStudio = 300;
//		}
//		if (mediaGlobale > 7 && mediaFrancese > 8)
//		{
//			erasmus = true;
//			localitaErasmusPapabili = "Londra o Parigi";
//			borsaStudio = 400;
//		}
//		if (mediaGlobale > 8 && (mediaFrancese > 8 || mediaInglese > 8));
//		{
//			erasmus = true;
//			localitaErasmusPapabili = "Vancouver";
//			borsaStudio = 1000;
//		}
//		
//		//O
//		if (erasmus == true)
//		{
//			System.out.println("Puoi andare in ERASMUS a " + localitaErasmusPapabili + ", con "
//								+ borsaStudio + "$ di borsa di studio");
//		}
//		else
//		{
//			System.out.println("Non puoi andare in ERASMUS");
//		}
		
		// METODO 2 : TERNARI
		erasmus = mediaGlobale > 7 ? true : false;
		
		localitaErasmusPapabili = mediaGlobale > 7 ? "Londra" : localitaErasmusPapabili;
		borsaStudio = mediaGlobale > 7 ? 300 : 0;
		
//		// Assegnazione di piu variabili in un solo ternario
//		risposta = (mediaGlobale > 7) ? 
//										(erasmus = true)					 +
//										(localitaErasmusPapabili = "Londra") +
//										(borsaStudio = 300)
//										:
//										"Non puoi andare in Erasmus";
		
		
		localitaErasmusPapabili = mediaGlobale > 7 ? "Londra o Parigi" : localitaErasmusPapabili;
		borsaStudio = mediaGlobale > 7 && mediaFrancese > 8 ? 400 : 0;
		
		localitaErasmusPapabili = mediaGlobale > 8 && (mediaFrancese > 8 || mediaInglese > 8)? "Vancouver" : localitaErasmusPapabili;
		borsaStudio = mediaGlobale > 8 && (mediaFrancese > 8 || mediaInglese > 8) ? 1000 : 0;
		
		risposta = erasmus ? 
								"Destinazioni Papabili: " + localitaErasmusPapabili +
								"\nBorsa Studio: " + borsaStudio + "$"
								:
								"nessun ERASMUS per te";
		
		System.out.println(risposta);
	}

}
