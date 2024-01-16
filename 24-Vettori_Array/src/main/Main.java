package main;

public class Main
{

	public static void main(String[] args)
	{
		// VETTORI (o ARRAY)
		
		// Definizione: 
		// Un vettore (o array) e un insieme ordinato di elementi dello stesso tipo di dimensione fissa.
		
		// La definizione identifica 3 blocchi di informazioni importanti:
		// 1) Insieme ordinato: Significa che avremo tanti dati salvati.
		//						Ogni dato avra un identificativo, chiamato INDICE.
		//						L'indice parte sempre da 0 e arrivo fino a dimensione-1
		//						Nei vettori l'indice viene creato e assegnato in modo automatico.
		//
		// 2) Elementi dello stesso tipo: Significa che tutti i dati salvati saranno sempre 
		//									della stessa natura (tutti int, tutti double, tutti String...)
		//
		// 3) Dimensione Fissa: Significa che una volta deciso il numero di elementi da inserire,
		//						avremo sempre quel numero di posti da riempire, sia che li riempiamo tutti,
		//						sia che li lasciamo tutti vuoti.
		
		/*
		 		SINTASSI
		 		
		 	tipoDato[] nomeVettore = new tipoDato[dimensione];
		 */
		
		// Dichiarazione
		String[] nomi;
		
		// Inizializzazione
		nomi = new String[10];
		
		// Riempire un vettore
		nomi[0] 	= "Alice"; // Si legge "nomi in posizione 0 uguale Alice"
		nomi[1] 	= "Davide";
		nomi[2] 	= "Lorenzo";
		nomi[3] 	= "Claudia";
		nomi[4] 	= "Stefano";
		//nomi[5] 	= "Anna";
		nomi[6] 	= "Manuel";
		nomi[7] 	= "Diana";
		nomi[8] 	= "Diego";
		nomi[9] 	= "Christian";
		//nomi[10] 	= "Marco"; -> Non senga erorre subito ma quando lo lanciamo sara causa di errore in runtime
		
		// Posso valorizzare un vettore anche con questa sintassi
		// nomi = {"","","",};
		
		// Per studiare i singoli valori dobbiamo ciclare
		int indice = 0;
		while(indice < nomi.length)
		{
			//Voglio stampare solo i nomi che iniziano per A
			if(nomi[indice] != null && nomi[indice].toLowerCase().startsWith("a")) // controllo che le stringhe nell'indice non siano vuote
			{
				System.out.println(nomi[indice]);
			}
			else if (nomi[indice] == null)
				nomi[indice] = "AAAAAAA";
			
			//Questo mi serve per scorrere il vettore, altrimenti leggo sempre la stessa posizione all'infinito
			indice++;
		}
		
		// Stampare il contenuto di un vettore in console
		// System.out.println(nomi); 	// -> Mi stampa questo [Ljava.lang.String;@6504e3b2 che e l'indirizzo
									// di memoria della variabile
		indice = 0;
		while(indice < nomi.length)
		{
			System.out.println(nomi[indice]);
			indice++;
		}
		
	}

}
