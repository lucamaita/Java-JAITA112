package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Scrivere in un file i nomi e i voti complessivi di una serie di studenti.
		// Il file scrivetelo come CSV (nome, voto)
		// Leggere i file e salvare i dati nei vettori giusti.
		// Voglio poi vedere:
		// - La lista di tutti gli studenti con i loro voti
		// - Il nome dello studente (o degli studenti) con il voto maggiore.
		// - I nomi degli studenti con un voto superiore alla media complessiva dei voti nel file
		
		// LETTURA FILE -------------------------------------------------------------------------------------------------------------
		
		//D
		Scanner 	file;
		String[] 	nomi;
		int[] 		voti;
		int			numeroStudenti;
		String[]	infoStudente;
		
		//I
		file = new Scanner(new File("src/res/Pagella.txt"));
		numeroStudenti = Integer.parseInt(file.nextLine());
		nomi = new String[numeroStudenti];
		voti = new int[numeroStudenti];
		
		//C
		for (int i = 0; file.hasNextLine(); i++)
		{
			infoStudente = file.nextLine().split(";");
			
			nomi[i] = infoStudente[0];
			voti[i] = Integer.parseInt(infoStudente[1]);
		}
		
		file.close();
		
		// PROBLEMA 1 ---------------------------------------------------------------------------------------------------------
		
		//D
		String ris1;
		
		//I
		ris1 = "\n\t\tLISTA STUDENTI" + "\n" ;
		
		//C
		for (int i = 0; i < numeroStudenti; i++)
			ris1 += nomi[i] + ": " + voti[i] + "\n";
		
		//O
		System.out.println(ris1);
		
		// PROBLEMA 2 ----------------------------------------------------------------------------------------------------------
		
		//D
		int 	max;
		String 	secchioni;
		String 	ris2;
		
		//I
		max = Integer.MIN_VALUE;
		secchioni = "";
		ris2 = "\nMiglior studente/i: "; 
		
		//C
		for (int i = 0; i < numeroStudenti; i++)
		{
			if (voti[i] > max)
			{
				max = voti[i];
				secchioni = nomi[i];
			}
			else if (voti[i] == max)
				secchioni += ", " + nomi[i];
		}
		
		//O
		System.out.println(ris2 + secchioni);
		
		// PROBLEMA 3 -------------------------------------------------------------------------------------------------------
		
		//D
		int 	mediaDiTutti;
		String 	ris3;
		String 	studentiBravi;
		
		//I
		mediaDiTutti = 0;
		ris3 = "\nStudenti sopra la media: ";
		studentiBravi = "";
		
		//C
		for (int i = 0; i < numeroStudenti; i++)
			mediaDiTutti += voti[i];
		
		 mediaDiTutti = mediaDiTutti/numeroStudenti;
		
		for(int i = 0; i < numeroStudenti; i++)
		{
			if (voti[i] > mediaDiTutti)
				studentiBravi += nomi[i] + ", ";
		}
		
		studentiBravi = studentiBravi.substring(0, studentiBravi.length()-2);
		
		//O
		System.out.println(ris3 + studentiBravi);
		
	} // FINE STATIC VOID 

} // FINE MAIN
