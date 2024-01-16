package main;

public class Main 
{
	public static void main(String[] args) 
	{
		// VARIABILI
		// Le variabili sono delle scatole che contengono un valore mutevole nel tempo.
		
		// Le variabili hanno due caratteristiche principali:
		// - TIPO: e la natura del dato che ci salvo dentro (int, double, string..)
		// - NOME: e un etichetta univoca assegnata all scatola 
		// 			(CONVENZIONI: 
		//				> Prima lettera piccola - convenzione
		//				> Niente spazi nei comi composti (CamelCase)
		//				> MAI iniziare con un numero o simbolo o spazio - errore
		//				> Dare un nome chiaro e sensato
		
		// TIPI su JAVA
		// > Numeri ----> Interi (int, Long), Decimali (double, float)
		// > Testo -----> Caratteri singoli (char), Parole/Frasi (String)
		// > Booleani --> boolean (sono dati che possono essere solo TRUE o FALSE (tutto minuscolo))
		
		// DICHIARAZIONE: dico al programma che esiste una variabile di tipo intero chiamata numero
		int numero;
		int numero2;
		int somma;
		
		// INIZIALIZZAZIONE: cioe do un valore iniziale alla mia variabile
		numero = 5;
		numero2 = 9;
		somma = 0;
		
		// VALORIZZAZIONE/ASSEGNAZIONE: cioe do un valore alla mia variabile (dal secondo in poi)
		numero = 6;
		
		//CALCOLO
		somma = numero + numero2;
		
		// Stampo una somma
		System.out.println(somma);
		System.out.println(numero + numero2);
		
		double numero3 = 10.5;
		
		//SIMBOLI MATEMATICI
		// piu     		  +
		// meno    		  -
		// per            *
		// diviso         /
		// Resto/Modulo   %
		
		String parola;
		String parola2;
		parola = ""; 	  // Inizializzato a vuoto
		parola = "Ciao";  // Sempre doppie virgolette
		parola = "ciao \"citazione\" \n\tfine citazione"; 	//usare virgoeltte per citazione BACKSLASH
		parola = "ciao";										// i backslash servono per indicare che il carettere che segue sara parte
													      	// del testo, spesso in coppia con delle lettere come \n, \t, \r, in questo caso
		                                              		// la combo ha valore di codice
		                                              		// parola = 'ciao D\'Annunzio;
		parola2 = "Alice";
		
		
		
		
		System.out.println(parola);
		// Il simbolo + con le stringhe fa un lavoro chiamato CONCATENAZIONE, cioe attacca il contenuto
		// delle variabili in questione
		System.out.println(parola + " " + parola2);
		
		// In questo caso, dato che ci sono delle stringhe il + ha solo valore di concatenazione
		System.out.println(parola2 + ": " + numero + numero2);
		System.out.println("somma" + numero + numero2); // solo concatenazione --> somma69
		System.out.println(numero + "somma" + numero2); // solo concatenazione --> 6somma9
		System.out.println(numero + numero2 + "somma"); // somma poi concatenazione --> 15somma
		System.out.println("somma" + (numero + numero2)); // Le tonde hanno priorita ma esce comunque una stringa --> 15somma
	}
}