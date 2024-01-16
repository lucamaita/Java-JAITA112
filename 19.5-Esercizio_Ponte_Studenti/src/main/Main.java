package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
//		4- Scrivere un programma che permetta di richiedere all’utente di inserire i dati di N studenti, 
//		dove N è il numero di studenti da chiedere come prima informazione.
//		I dati da richiedere sono il nome, il voto finale di italiano,di inglese, di informatica e di matematica.
//		Voglio vedere in console:
//		- La media complessiva di ogni singolo studente e il nome dello studente con la media ottenuta
//		- Il nome dello studente e il suo esito(è promosso se ha almeno tre voti maggiori di 5 e la media complessiva è maggiore di 6) 
//		- Il numero di studenti bocciati
//		- Il numero di studenti con il voto di informatica superiore a 8
		
		// STEP 1:
		// Leggo la consegna per intero, in questo modo devo capire dove voglio andare a parare
		// Rileggo la consegna per capire quali passaggi e quali calcoli devo fare 
		// -> Leggo una frase alla volta e cerco di capire la logica e il codice che traducono quella frase
		
		//D
		Scanner scanner;
		int 	numeroStudenti;
		String 	nome;
		double 	votoItaliano;
		double 	votoInglese;
		double 	votoInformatica;
		double 	votoMatematica;
		int 	contatore;
		double 	mediaStudente;
		String 	nomeStudenteEMediaStudente;
		String 	nomeStudenteEEsito;
		boolean esito;
		int 	votiSopraIl5;
		int 	studentiBocciati;
		int 	studentiInformaticaMaggioreDi8;
		
		
		
		
		//I
		scanner = new Scanner(System.in);
		contatore = 0;
		mediaStudente = 0;
		nomeStudenteEMediaStudente = "";
		nomeStudenteEEsito = "";
		esito = false;
		studentiBocciati = 0;
		studentiInformaticaMaggioreDi8 = 0;
		
		System.out.println("Quanti studenti devi immettere?");
		numeroStudenti = Integer.parseInt(scanner.nextLine());
		
		while (contatore < numeroStudenti)
		{
			votiSopraIl5 = 0;
			// Serve a indicare a che giro siamo all'utente (facoltativo)
			System.out.println("\n\tSTUDENTE NUMERO" + (contatore+1));
			
			// Chiedo all'utente le informazioni dello studente da inserire
			System.out.println("Nome: ");
			nome = scanner.nextLine();
			System.out.println("Voto Italiano: ");
			votoItaliano = Double.parseDouble(scanner.nextLine());
			System.out.println("Voto Inglese: ");
			votoInglese = Double.parseDouble(scanner.nextLine());
			System.out.println("Voto Informatica: ");
			votoInformatica = Double.parseDouble(scanner.nextLine());
			System.out.println("Voto Matematica: ");
			votoMatematica = Double.parseDouble(scanner.nextLine());
			
			//C
			mediaStudente = (votoItaliano+votoInglese+votoInformatica+votoMatematica)/4;
			nomeStudenteEMediaStudente += "\n- " + nome + ": " + mediaStudente;
			
			votiSopraIl5 += votoInformatica > 5 ? 1 : 0;
			votiSopraIl5 += votoInglese 	> 5 ? 1 : 0;
			votiSopraIl5 += votoItaliano 	> 5 ? 1 : 0;
			votiSopraIl5 += votoMatematica 	> 5 ? 1 : 0;
			
			
			esito = mediaStudente > 6 && votiSopraIl5 >= 3 ? true : false;
			nomeStudenteEEsito += "\n- " + nome + ": " + (esito ? "PROMOSSO" : "BOCCIATO");
			
			studentiBocciati += esito == false ? 1 : 0;
			
			studentiInformaticaMaggioreDi8 += votoInformatica > 8 ? 1 : 0;
			
			
			// Aumento il conteggio dei giri effettuati (la prassi e di metterlo sempre alla fine del ciclo)
			contatore ++;
			
			// DIFFERENZE
			// (contatore+1) -> calcola 1+1
			// contatore++ 	 -> calcola e salva 1+1
		}
		
		scanner.close();
		
		//O
		System.out.println("\n\n\t RIASSUNTO STUDENTI: " 	+
							"\n\tNOME e MEDIA: " 				+ nomeStudenteEMediaStudente 		+
							"\n\tNome e Esito"				+ nomeStudenteEEsito 				+
							"\nTOTALE BOCCIATI: " 			+ studentiBocciati 					+
							"\nNERD: " 						+ studentiInformaticaMaggioreDi8 	
						  );
		
	}

}
