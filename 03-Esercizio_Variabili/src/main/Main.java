package main;

public class Main 
{

	public static void main(String[] args) 
	{
		// Vogliamo scrivere un programma che inseriti dal programmatore i dati di:
		// Altezza, Peso e Nome
		// Restituisca in console la scritta "Ciao [nome] il tuo BMI vale [calcolo]"
		// BMI = kg/alezza al quadrato ---- kg/m^2
		
		// 1 Step: Capire tutti i dati che ho e quelli di cui ho bisogno
		double altezza;
		double peso;
		String nome;
		double bmi;
		String risposta;
		
		// 2 Step: Devo inizializzare i dati che ho trovato
		altezza = 1.80;
		peso = 85;
		nome = "Luca";
		bmi = 0;
		risposta = "";
		
		// 3 Step: Calcolare e fare tutti i percorsi di logica necessari
		bmi = peso/(altezza*altezza);
		
		// Step 4: Scrivere una risposta per l`utente
		risposta = "Ciao " + nome + " il tuo BMI vale " + bmi + "KG/m2";
		System.out.println(risposta);

	}// Chiusura main(): NON SI CANCELLA!!!

}// Chiusura Main: NON SI CANCELLA!!
