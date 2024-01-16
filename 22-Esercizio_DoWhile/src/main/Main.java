package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Leggere da un file le informazioni riguardanti alcuni film proiettati al cinema
        // I dati saranno: titolo, genere, durata(minuti), annoUscita, vietatoMinori(bool)
        // Scrivere un menù che permetta all'utente le seguenti scelte:
        // - Schede complete dei singoli film
        // - Il titolo dei film antecedenti al 1992
        // - Il numero di film vietati ai minori
        // - Il titolo del film più lungo (o dei film)
        // - La durata media dei film di genere Azione
		
		//D
		Scanner 	file;
		Scanner 	tastiera;
		String 		schede;
		String		titolo;
		String 		genere;
		int 		durata;
		int 		durataMax;
		int 		durataMediaAzione;
		int 		contatoreAzione;
		int			anno;
		boolean 	vietato;
		String 		vietatoprnt;
		String 		filmVecchi;
		int 		contatoreVietati;
		String 		filmLunghi;
		String 		mainMenu;
		String 		cmd;
		
		//I
		file 				= 	new Scanner(new File("src/res/Film.txt"));
		tastiera 			=  	new Scanner(System.in);
		schede 				=	"";
		titolo 				= 	"";
		genere 				= 	"";
		durata 				= 	0;
		durataMax			=	Integer.MIN_VALUE;
		durataMediaAzione 	= 	0;
		contatoreAzione 	= 	0;
		anno 				= 	0;
		vietato 			= 	false;
		vietatoprnt 		= 	"";
		filmVecchi 			= 	"";
		contatoreVietati 	= 	0;
		filmLunghi 			= 	"";
		mainMenu 			=	"";
		cmd 				= 	"";
		
		while(file.hasNextLine())
		{
			titolo 				= 	file.nextLine();
			genere 				= 	file.nextLine();
			durata 				= 	Integer.parseInt(file.nextLine());
			
			if (genere.equalsIgnoreCase("action")) // Durata media film d'azione
			{
				durataMediaAzione += durata;
				contatoreAzione++;
			}
			
			if (durata == durataMax) // Se ci sono piu film dalla durata maggiore, concatenare i titoli
			{
				filmLunghi += titolo + ", "; 
			}
			
			if (durata > durataMax) // se trovo un film piu lungo, sostituire i titoli con quello nuovo
			{
				durataMax = durata;
				filmLunghi = titolo + ", ";
			}
			
			anno 				=	Integer.parseInt(file.nextLine());
			filmVecchi 			+= 	anno < 1992 ? (titolo + ", ") : ""; // Film precedenti al 92
			
			vietato 			= 	file.nextLine().equalsIgnoreCase("true"); // Contatore di film vietati
			contatoreVietati 	= 	vietato == true ? contatoreVietati + 1 : contatoreVietati + 0;
			vietatoprnt 		= 	vietato == true ? "SI" : "NO";
			
			schede  			+= 	"\nTitolo: " 			+ titolo 		+
									"\nGenere: " 			+ genere 		+
									"\nDurata: "  			+ durata 		+
									"\nAnno di uscita: " 	+ anno 			+
									"\nVietato ai minori: " + vietatoprnt	+
									"\n------------------------------------";
		}// FINE WHILE
		
		durataMediaAzione = (durataMediaAzione/contatoreAzione); // Media film azione
		
		file.close();
		
		mainMenu = 	"\n\t\tMAIN MENU\n" +
					"\n1) Visualizza le schede complete di tutti i film." 					+
					"\n2) Visualizza i titoli dei film antecedenti al 1992" 				+
					"\n3) Visualizza il numero di film vietati ai minori"					+
					"\n4) Visualizza il titolo del film piu lungo (o dei film piu lunghi)" 	+
					"\n5) Visualizza la durata media dei film d'azione"						+
					"\n6) Torna al menu principale"											+
					"\n0) Esci";
		
		System.out.println("Benvenuto al Cinema Italia!");
		System.out.println(mainMenu);
		
		filmVecchi = filmVecchi.substring(0, filmVecchi.length()-2); // Tolgo il virgola e spazio dagli elenchi
		filmLunghi = filmLunghi.substring(0, filmLunghi.length()-2);
		
		do
		{
			System.out.println("Selezionare la categoria desiderata: ");
			cmd = tastiera.nextLine();
			
			switch(cmd)
			{
			case("1"):
				System.out.println(schede);
				break;
			case("2"):
				System.out.println("I film antecedenti al 1992 sono: " + filmVecchi);
				break;
			case("3"):
				System.out.println("I film vietati ai minori sono: " + contatoreVietati);
				break;
			case("4"):
				System.out.println("I film dalla durata maggiore sono: " + filmLunghi);
				break;
			case("5"):
				System.out.println("La durata media dei film d'azione e: " + durataMediaAzione + " minuti");
				break;
			case("6"):
				System.out.println(mainMenu);
				break;
			case("0"):
				System.out.println("Arrivederci!");
				break;
			default:
				System.out.println("Input Error");
				break;
			}
			
		}while(!cmd.equalsIgnoreCase("0"));
		
		tastiera.close();
		
//		System.out.println(schede); 				// NON CANCELLARE - 
//													// STAMPE TEST UTILIZZATE IN FASE DI SVILUPPO
//		System.out.println(filmVecchi);
//		System.out.println(contatoreVietati);
//		System.out.println(filmLunghi);
//		System.out.println(durataMediaAzione = (durataMediaAzione/contatoreAzione));

	} // NON CANCELLARE - FINE STATIC VOID

} // NON CANCELLARE - FINE MAIN
