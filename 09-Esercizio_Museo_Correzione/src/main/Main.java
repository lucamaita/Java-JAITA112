package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// Lavorate in una biglietteria a Vezio.
				// Sapete che il biglietto intero costa 10$.
				// Sapete anche che il museo applica i seguenti sconti (non cumulabili)
				// - I residenti a Vezio e a Como entrano gratis
				// - Gli studenti hanno diritto al 30% di sconto sul biglietto
				// - Gli under 12 e gli over 65 hanno diritto al 50% di sconto
				// - I militari e i medici hanno diritto al 65% di sconto
				
				// Scrivere un programma che chieda i dati all utente e calcoli il prezzo del suo biglietto
		
		//D
		Scanner tastiera;
		String risposta;
		double prezzoBiglietto;
		double scontoResidenza;
		double scontoStudenti;
		double scontoUnder12Over65;
		double scontoMilitarieMedici;
		String residenza;
		String professione;
		int eta;
		
		
		//I
		tastiera = new Scanner(System.in);
		prezzoBiglietto = 10;
		risposta = "";
		scontoResidenza = 100;
		scontoStudenti = 30;
		scontoUnder12Over65 = 50;
		scontoMilitarieMedici = 65;
		
		//I+C
		System.out.println("Dove sei residente?");
		residenza = tastiera.nextLine();
		
		if(residenza.equalsIgnoreCase("Como") || residenza.equalsIgnoreCase("Vezio"))
		{
			prezzoBiglietto = prezzoBiglietto - (prezzoBiglietto/100*scontoResidenza);
		}
		else
		{
			System.out.println("Che lavoro fai");
			professione = tastiera.nextLine();
			
			switch(professione.toLowerCase())
			{
				case "medico":
				case "militare":
					prezzoBiglietto = prezzoBiglietto - (prezzoBiglietto/100*scontoMilitarieMedici);
					break;
				case "studente":
					System.out.println("Quanti anni hai?");
					eta = Integer.parseInt(tastiera.nextLine());
					
					if(eta < 12 || eta > 65)
					{
						prezzoBiglietto = prezzoBiglietto - (prezzoBiglietto/100*scontoUnder12Over65);
					}
					else
					{
						prezzoBiglietto = prezzoBiglietto - (prezzoBiglietto/100*scontoStudenti);
					}
					break;
			} // FINE SWITCH
			
			if(prezzoBiglietto == 10)
			{
				System.out.println("Quanti anni hai?");
				eta = Integer.parseInt(tastiera.nextLine());
				
				if(eta < 12 || eta > 65)
				{
					prezzoBiglietto = prezzoBiglietto - (prezzoBiglietto/100*scontoUnder12Over65);
				}
			}
			
		} // FINE ELSE

	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
