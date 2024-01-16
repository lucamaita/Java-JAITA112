package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Ospedale {


	Paziente[] pazienti;
	Medico[] medici;

	Ospedale(String path) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(path));

		String[] dim = file.nextLine().split(",");

		pazienti = new Paziente[Integer.parseInt(dim[0])];
		medici = new Medico[Integer.parseInt(dim[1])];

		int indicePazienti = 0;
		int indiceMedici = 0;

		try 
		{
			for (int i = 0; file.hasNextLine(); i++) 
			{
				String[] infoRiga = file.nextLine().split(",");

				try 
				{
					if (infoRiga[0].equalsIgnoreCase("paziente")) 
					{
						Paziente p = new Paziente(infoRiga[1],
								infoRiga[2],
								infoRiga[3],
								infoRiga[4],
								infoRiga[5],
								infoRiga[6],
								infoRiga[7].equalsIgnoreCase("s"),
								Integer.parseInt(infoRiga[8]));

						pazienti[indicePazienti++] = p;

					} else if (infoRiga[0].equalsIgnoreCase("medico")) 
					{
						Medico m = new Medico(infoRiga[1],
								infoRiga[2],
								infoRiga[3],
								infoRiga[4],
								infoRiga[5],
								Integer.parseInt(infoRiga[6]),
								Integer.parseInt(infoRiga[7]),
								Integer.parseInt(infoRiga[8]));

						medici[indiceMedici++] = m;
					}
				} catch (ArrayIndexOutOfBoundsException e) 
				{
					System.err.println("Errore nella riga " + i + ": Dati mancanti");
					
				} catch (NumberFormatException e) 
				{
					System.err.println("Errore nella riga " + i + ": Errore nella conversione del numero");
					
				}
			}
		} catch (Exception e) 
		{
			System.err.println("Errore durante la lettura del file: " + e.getMessage());
			
		} 
	}


	//Metodi
	String listaPazienti() 
	{
		String ris = 	"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n" +
                		"| Nome         | Cognome      | Data di nascita | Residenza    | Patologia    | Reparto            | Contagioso  | Probabilita' di morte |\n" +
                		"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n";
		for(int i = 0; i < pazienti.length; i++) {
			if(pazienti[i]!=null)
				ris += pazienti[i].scheda();
		}
		
		ris += "+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n";
				
		return ris.isEmpty() ? "Nessun risultato trovato." : "\n\tLISTA DEI PAZIENTI!\n\n"+ris;
	}

	String listaMedici() 
	{
		String ris =	"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n" 	+
        				"| Nome         | Cognome      | Data di nascita | Residenza    | Reparto         | Anni di servizio | Pazienti curati | Pazienti persi  |\n" 	+
        				"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n"	;
		for(int i = 0; i< medici.length; i++) {
			if(medici[i]!=null)
				ris += medici[i].schedaMedici();
		}
		
		ris += "+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n";

		return ris.isEmpty() ? "Nessun risultato trovato." : "\n\tLISTA DEI MEDICI!\n" + ris;
	}

	String listaTotale() {
		String listaPazienti = listaPazienti();
		String listaMedici = listaMedici();

		if (listaPazienti.isEmpty() && listaMedici.isEmpty()) {
			return "Nessun risultato trovato.";
		}

		return "\n\tLISTA TOTALE\n\n" + "\n\n" + listaPazienti + "\n\n" + listaMedici;
	}


	String nomiKiller() {
		String ris = "";
		String nomiKillers = "";

		for (int i = 0; i < medici.length; i++) {
			if (medici[i].killer()) {
				nomiKillers += (medici[i].nome.toUpperCase() + " " + medici[i].cognome.toUpperCase() + "\n");
			}
		}
		ris = nomiKillers;

		return ris.isEmpty() ? "Nessun risultato trovato." : "\n\t LISTA DEI MEDICI KILLER:\n" + ris;
	}

	String cerca(String cercaPatologia) {

		String ris = "";

		for(int i = 0; i < pazienti.length; i++) {
			if(pazienti[i].patologia.equalsIgnoreCase(cercaPatologia))
				ris += "\nNominativo: "+ pazienti[i].nome + " " + pazienti[i].cognome + "; ";	
		}

		return ris = ris.isEmpty() ? "Nessun paziente con la patologia richiesta" : ris;
	}

	String cerca(String nome, String cognome)
	{
		String ris = "";
		for(int i = 0; i < pazienti.length; i++)
			if(pazienti[i].nome.equalsIgnoreCase(nome) && pazienti[i].cognome.equalsIgnoreCase(cognome))
				ris += 	"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n" +
                		"| Nome         | Cognome      | Data di nascita | Residenza    | Patologia    | Reparto            | Contagioso  | Probabilita' di morte |\n" +
						"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n"+
						pazienti[i].scheda() +
						"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n";
		for(int i = 0; i < medici.length; i++)
			if(medici[i].nome.equalsIgnoreCase(nome) && medici[i].cognome.equalsIgnoreCase(cognome))
				ris += 	"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n" +
        				"| Nome         | Cognome      | Data di nascita | Residenza    | Reparto         | Anni di servizio | Pazienti curati | Pazienti persi  |\n" +
        				"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n"+
						medici[i].schedaMedici()+
						"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n";
		return ris.isEmpty() ? "Nessun risultato trovato." : ris;
	}

	String rischiosi()
	{
		String ris = "";

		for(int i = 0; i < pazienti.length; i++)
		{
			if(pazienti[i].rischioZombie() == true)
			{
				ris += "\n- " + pazienti[i].nome + " " +  pazienti[i].cognome;
			}
		}
		return ris.isEmpty() ? "Nessun risultato trovato." : "\nPazienti a rischio zombificazione: \n" + ris;
	}

	String statistichePazienti()
	{
		String ris = "";
		int contGravi = 0;
		int contLieve = 0;


		for(int i = 0; i < pazienti.length; i++)
		{
			if(pazienti[i].probMorte > 80)
				contGravi ++;
			else
				contLieve ++;
		}
		if (contGravi > 0 && contLieve > 0) {
			ris = "Statistiche pazienti:" +
					"\nI pazienti gravi sono " + contGravi +
					"\nI pazienti lievi sono " + contLieve;
		} else if (contGravi > 0) {
			ris = "Nessun caso lieve presente.\nI pazienti gravi sono " + contGravi;
		} else if (contLieve > 0) {
			ris = "Nessun caso grave presente.\nI pazienti lievi sono " + contLieve;
		} else {
			ris = "Nessun risultato trovato.";
		}

		return ris;

	}





}