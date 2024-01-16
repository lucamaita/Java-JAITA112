package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// CLASSE DI AVVIO: L'unica che si interfaccia con la console
public class Main
{

	// METODO: questo metodo e' la causa per cui la classe Main si dice di avvio.
	public static void main(String[] args) throws FileNotFoundException
	{
		// Leggo il file --------------------------------------------------------
		Scanner file = new Scanner(new File("src/res/Dati.txt"));	
		
		Persona[] persone = new Persona[Integer.parseInt(file.nextLine())];
		
		int indice = 0;
		while(file.hasNextLine())
		{
			String[] info = file.nextLine().split(";");
			
			
			// Cosi valorizziamo una proprieta alla volta, che va bene!
			// Ma siamo anche piu soggetti a perderci dei pezzi.
			// Per evitare questi problemi, i programmatori si sono inventati una soluzione
			// che viene chiamata COSTRUTTORE
			// Questa funzione va implementata (cioe scritta) nella classe, quindi andiamo a farlo.
		
			Persona p = new Persona(info[0],info[1],info[2],info[3],info[4],info[5].equalsIgnoreCase("s"));
			//						nome	cognome	dob	  personal	obbiettivo	abbonato
			
//			p.nome = info[0];
//			p.cognome = info[1];
//			p.dob = info[2];
//			p.personalTrainer = info[3];
//			p.obbiettivo = info[4];
//			p.abbonamento = info[5].equalsIgnoreCase("S");
			
			persone[indice] = p;
			
			indice++;
		}
		
		
		
		file.close();		
		//----------------------------------------------------------------------=
		
		// Proviamo a stampare in console i nostri oggetti
		for(int i = 0; i < persone.length; i++)
			System.out.println(persone[i].scheda());
		
		System.out.println("\n\n-----------------------------------------------------------------------------------------------\n\n");
		
		// Voglio vedere la scheda della persona piu giovane
		int minore;
		String risposta;
		risposta = "";
		minore = Integer.MAX_VALUE;
		
		for(int i = 0; i < persone.length; i++)
		{
			if(persone[i].eta() < minore)
			{
				minore = persone[i].eta();
				risposta = persone[i].scheda();
			}
			else if(persone[i].eta() == minore)
				risposta += persone[i].scheda();
		}
		System.out.println(risposta);
		
		System.out.println("\n\n-----------------------------------------------------------------------------------------------\n\n");
		
		// Voglio vedere i nominativi dei clienti di un personal trainer a scelta dell'utente
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il nome di un personal trainer: ");
		String cerca = tastiera.nextLine();
		risposta = "";
		
		for(int i = 0; i < persone.length; i++)
		{
			if(persone[i].personalTrainer.equalsIgnoreCase(cerca))
			{
				risposta += "\n-" + persone[i].nome + " " + persone[i].cognome;
			}
		}
		tastiera.close();
		System.out.println(risposta);
		
		System.out.println("\n\n-----------------------------------------------------------------------------------------------\n\n");
		
		// Voglio vedere la persona piu vecchia con un abbonamento
		int anziano = Integer.MIN_VALUE;
		String piuAnziano = "";
		
		for(int i = 0; i < persone.length; i++)
		{
			if(persone[i].abbonamento)
			{
				if(persone[i].eta() > anziano)
				{
					anziano = persone[i].eta();
					piuAnziano = persone[i].scheda();
				}
				else if(persone[i].eta() == anziano)
				{
					piuAnziano += persone[i].scheda();
				}
			}
		}
		
		System.out.println(piuAnziano);
		
		System.out.println("\n\n-----------------------------------------------------------------------------------------------\n\n");
		
		
	}

}
