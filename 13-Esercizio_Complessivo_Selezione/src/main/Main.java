package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		// ESERCIZIO

        // Dovete gestire una libreria.
        // Chiedete all'utente i dati dei libri.
        // Del libro vi interessa sapere: 
        //    titolo, autore, genere, anno di pubblicazione, numero di pagine, 
        //    casa editrice e tipo di copertina(rigida o no)
        // Il compito del programma è quello di calcolare il prezzo di copertina secondo queste regole:
        //  - Il costo per stampare una pagina del libro è di 0.05 euro
        //  - La copertina rigida implica 3 euro di spesa in più
        //  - Se l'autore è King +5.5, se è Rowling +2.1, se è Manfredi +4, se è Carrisi +6.5, per gli altri +2.5
        //  - Se il genere è Horror +5.5, se è Thriller o Giallo +6.5, se è storico +2.1, se è romanzo +8, gli altri generi +1.9
        //  - Se la casa editrice è rizzoli +3.5, se è mondadori +5.5, se è hoepli -0.5
        //  - Se l'anno di pubblicazione è antecedente al 2000 -4.5, se è compreso tra 2000 e 2015, -2.1, se ha meno di 2 anni +0.9
        //  - In ogni caso, un libro non può mai costare meno delle spese della materia prima
        //  - Siamo in periodo saldi, quindi tutti i libri con un costo superiore ai 25 euro saranno scontati del 5%

        // Stampare in console la scheda ordinata del libro, il suo costo totale e, se è presente, lo sconto applicato in euro

        /*
                 [titoloLibro] di [autore]
                 Copertina: [rigida o flessibile]
                 Pubblicato nel: [anno] da [casa editrice]
                 [numero di pagine] pagine
                 Costo Totale: [costo del libro] 
                 Applicato lo sconto del 5% -> [sconto in euro]€
                 Costo Finale: [costo del libro scontato]
         */
		
		//D
		Scanner 	scanner;
		String 		titolo;
		int 		autore;
		int 		genere;
		int 		annopubblicazione;
		int 		numeropagine;
		int 		casaeditrice;
		boolean 	copertina;
		String 		copertinaScheda;
		double 		costostampapagina;
		double 		costorigida;
		double 		pre2000;
		double 		tra2000e2015;
		double 		meno2anni;
		double 		scontosaldi;
		double 		costomateria;
		double 		totale;
		String 		autoreScheda;
		String  	genereScheda;
		String 		casaScheda;
		boolean 	scontatoSioNo;
		double 		scontoInEuro;
		
		//I
		scanner = 			new Scanner(System.in);
		titolo = 			"";
		autore = 			0;
		genere = 			0;
		annopubblicazione = 0;
		numeropagine = 		0;
		casaeditrice = 		0;
		copertina = 		false;
		copertinaScheda =   "";
		costostampapagina = 0.05;
		costorigida = 		3;
		pre2000 = 			4.5;
		tra2000e2015 = 		2.1;
		meno2anni = 		0.9;
		scontosaldi = 		0.05;
		costomateria = 		0;
		totale = 			0;
		autoreScheda = 		"";
		genereScheda = 		"";
		casaScheda = 		"";
		scontatoSioNo = 	false;
		scontoInEuro = 		0;
		
		System.out.println("Digitare il titolo del libro, poi premere ENTER");
		titolo = 			scanner.nextLine();
		
		System.out.println(	"\nSelezionare l'autore, poi premere ENTER."
							+ "\nDigitare 1 per King (+5.5$)"
							+ "\nDigitare 2 per Rowling (+2.1$)"
							+ "\nDigitare 3 per Manfredi (+4$)"
							+ "\nDigitare 4 per Carrisi (+6.5$)"
							+ "\nDigitare 5 per altro (+2.5$)");
		autore = 			Integer.parseInt(scanner.nextLine());
		
		System.out.println(	"\nSelezionare il genere, poi premere ENTER."
							+ "\nDigitare 1 per Horror (+5.5$)"
							+ "\nDigitare 2 per Thriller/Giallo (+6.5$)"
							+ "\nDigitare 3 per Storico (+2.1$)"
							+ "\nDigitare 4 per Romanzo (+8$)"
							+ "\nDigitare 5 per altro (+1.9$)");
		genere = 			Integer.parseInt(scanner.nextLine());
		
		System.out.println("Digitare l'anno di pubblicazione, poi premere ENTER");
		annopubblicazione = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Digitare il numero di pagine, poi premere ENTER");
		numeropagine = 		Integer.parseInt(scanner.nextLine());
		
		System.out.println(	"\nSelezionare la casa editrice, poi premere ENTER."
							+ "\nDigitare 1 per Rizzoli (+3.5$)"
							+ "\nDigitare 2 per Mondadori (+5.5$)"
							+ "\nDigitare 3 per Hoepli (-0.5$)");
		casaeditrice = 		Integer.parseInt(scanner.nextLine());
		
		System.out.println("La copertina e rigida? (Y/N)");
		copertina = scanner.nextLine().equalsIgnoreCase("y");
		
		scanner.close();
		
		costomateria = numeropagine * costostampapagina;
		costomateria = copertina == true ? costomateria + costorigida : costomateria;
		
		if (copertina == true)
		{
			copertinaScheda = "Rigida";	
		}
		else
		{
			copertinaScheda = "Flessibile";
		}
		
		switch (autore)
		{
			case 1:
				totale = costomateria + 5.5;
				autoreScheda = "King";
			break;
			case 2:
				totale = costomateria + 2.1;
				autoreScheda = "Rowling";
			break;
			case 3:
				totale = costomateria + 4;
				autoreScheda = "Manfredi";
			break;
			case 4:
				totale = costomateria + 6.5;
				autoreScheda = "Carrisi";
			break;
			case 5:
				totale = costomateria + 2.5;
				autoreScheda = "Altro";
			break;
			default:
				totale = 9999;
				autoreScheda = "InputError";
			break;
		}
		
		switch (genere)
		{
			case 1:
				totale = totale + 5.5;
				genereScheda = "Horror";
			break;
			case 2:
				totale = totale + 6.5;
				genereScheda = "Thriller/Giallo";
			break;
			case 3:
				totale = totale + 2.1;
				genereScheda = "Storico";
			break;
			case 4:
				totale = totale + 8;
				genereScheda = "Romanzo";
			break;
			case 5:
				totale = totale + 1.9;
				genereScheda = "Altro";
			break;
			default:
				totale = 9999;
				genereScheda = "InputError";
			break;
		}
		
		switch (casaeditrice)
		{
			case 1:
				totale = totale + 3.5;
				casaScheda = "Rizzoli";
			break;
			case 2:
				totale = totale + 5.5;
				casaScheda = "Mondadori";
			break;
			case 3:
				totale = totale - 0.5;
				casaScheda = "Hoepli";
			break;
			default:
				totale = 9999;
				casaScheda = "InputError";
			break;
		}
		
		//C
		if (annopubblicazione < 2000)
		{
			totale = totale - 4.5;
		}
		else if (annopubblicazione > 2000 && annopubblicazione < 2016)
		{
			totale = totale - 2.1;
		}
		else if(annopubblicazione > 2021 && annopubblicazione < 2024)
		{
			totale = totale + 0.9;
		}
		
		totale = totale < costomateria ? costomateria : totale; 	// Controllo costo non superiore a costo materia
		if (totale >= 25)
		{
			scontatoSioNo = true;
			scontoInEuro = totale * scontosaldi;
		}
		totale = totale >= 25 ? (totale - (totale * scontosaldi)) : totale; // Controllo sconto over 25
		totale = totale < costomateria ? totale = costomateria : totale;    // controllo nuovamente che prezzoscontato non sia minore di costo materia
		
		//O
		System.out.println  ("\n\n" + titolo + " di " + autoreScheda
							+ "\nCopertina: " +  copertinaScheda
							+ "\nPubblicato nel: " + annopubblicazione + " da " + casaScheda 
							+ "\nPagine: " + numeropagine
							+ "\nCosto totale: " + (totale + (scontoInEuro)) + "$");
		
		if (scontatoSioNo == true)
		{
			System.out.println("Applicato lo sconto del 5% ->" + scontoInEuro
			    			+ "\nCosto finale: " + totale);
		}
		
		
		
	} // DO NOT DELETE - STATIC VOID MAIN

} // DO NOT DELETE - MAIN
