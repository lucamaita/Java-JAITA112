package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// PRINCIPI FONDAMENTALI DELLA PROGRAMMAZIONE CLASSICA
		// - Sequenza
		// - Selezione (IF, SWITCH, TERNARI)
		// - Iterazione (WHILE, ?)
		
		// 		Ciclo DO WHILE
		// Definizione
		// E un ciclo che itera da 1 a N volte
		
		// Rispetto a suo fratello WHILE, il DoWhile viene sempre eseguito almeno una volta.
		// Questo perche la condizione di iterazione non si trova in alto come il while, ma si trova in fondo
		
		/*
		 		SINTASSI
		 		
		 		do
		 		{
		 			istruzione1;
		 			istruzione2;
		 			..........
		 		}while();
		 */
		
		// Scrivere un file dei dati con nome, eta e residenza e stampare in console un menu che mi permetta
		// di vedere tutti i dati delle persone di un certo nome, sopra una certa eta o di un certo paese.
		
		Scanner file;
		Scanner tastiera;
		String 	nome;
		int 	eta;
		String 	residenza;
		String 	cercaNome;
		String	cercaEta;
		String	cercaResidenza;
		String 	risposta;
		String 	legenda;
		String 	cmd;
		
		tastiera = new Scanner(System.in);
		file = new Scanner(new File("src/res/Anagrafica.txt"));
		risposta = "";
		legenda = "\n\tLEGENDA\n" +
				  "\n1 > Cercare nel file tramite il nome" +
				  "\n2 > Cercare nel file tramite l'eta"  	+
				  "\n3 > Cercare nel file tramite la residenza" +
				  "\n4 > Legenda" +
				  "\n0 > Esci";
		
		System.out.println("Benevenuto nel mio programma!");
		
		System.out.println(legenda);
		
		do
		{
			System.out.println("Comando: ");
			cmd = tastiera.nextLine();
			
			switch(cmd)
			{
			case "1" :
				System.out.println("Digita il nome che vuoi cercare: ");
				cercaNome = tastiera.nextLine();
				
				file = new Scanner(new File("src/res/Anagrafica.txt"));

				
				while(file.hasNextLine())
				{
					nome = file.nextLine();
					eta = Integer.parseInt(file.nextLine());
					residenza = file.nextLine();
					
					if(nome.equalsIgnoreCase(cercaNome))
						risposta += nome + " di anni " + eta + " residente a " + residenza + "\n";
				}
				
				file.close();
				
				if(risposta.isEmpty())
					risposta = "Nessuna corrispondenza trovata";
				
				break;
			case "2" :
				System.out.println("Digita l'eta che vuoi cercare: ");
				cercaEta = tastiera.nextLine();
				
				file = new Scanner(new File("src/res/Anagrafica.txt"));
				
				while(file.hasNextLine())
				{
					nome = file.nextLine();
					eta = Integer.parseInt(file.nextLine());
					residenza = file.nextLine();
					
					if(nome.equalsIgnoreCase(cercaEta))
						risposta += nome + " di anni " + eta + " residente a " + residenza + "\n";
				}		
				
				file.close();
				
				if(risposta.isEmpty())
					risposta = "Nessuna corrispondenza trovata";
				
				break;
			case "3" :
				System.out.println("Digita la residenza che vuoi cercare: ");
				cercaResidenza = tastiera.nextLine();
				
				file = new Scanner(new File("src/res/Anagrafica.txt"));
				
				while(file.hasNextLine())
				{
					nome = file.nextLine();
					eta = Integer.parseInt(file.nextLine());
					residenza = file.nextLine();
					
					if(nome.equalsIgnoreCase(cercaResidenza))
						risposta += nome + " di anni " + eta + " residente a " + residenza + "\n";
				}		
				
				file.close();
				
				if(risposta.isEmpty())
					risposta = "Nessuna corrispondenza trovata";
								break;
			case "4" :
				risposta = legenda;
				break;
			case "0" :
				risposta = "Arrivedereci!";
				break;
			default  :
				risposta = "Comando inestitente";
				break;
			}
			
			System.out.println(risposta);
			
		}while(!cmd.equalsIgnoreCase("0"));	
		
		tastiera.close();
		file.close();
	}

}
