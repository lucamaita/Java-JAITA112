package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
	//		2) Chiedere all'utente di inserire 5 nomi
	//	Per ogni nome concatenare in una variabile:
	//	 - se il nome è Uberto o Zenelao "Il tuo nome è raro"
	//	 - se il nome è Estella o Frisella "Il tuo nome è esotico"
	//	 - se il tuo nome è Mario salvare unicamente "Ti chiami come l'idrauilico più famoso al mondo"
	//	 - se il nome finisce con la lettera a "Il tuo nome termina con 'A'"
	//	 - se il nome termina con la lettera o "Il tuo nome termina con 'O'"
	//	 - se il nome ha un numero di lettere superiore a 7 "Il tuo nome è lungo"
	//	Stampare in console la variabile caricata dopo i controlli sopra
	//	(Il comando .length() che vi dice il numero di caratteri di una stringa, il resto provate a cercarlo con amico Google)
	
		Scanner tastiera;
		String nome_1;
		String nome_2;
		String nome_3;
		String nome_4;
		String nome_5;
		String risposta;
		String risposta_1;
		String risposta_2;
		String risposta_3;
		String risposta_4;
		String risposta_5;
		
		
		tastiera = new Scanner(System.in);
		risposta = "";
		risposta_1 = "";
		risposta_2 = "";
		risposta_3 = "";
		risposta_4 = "";
		risposta_5 = "";
		
		System.out.println("1° Nome:");
		nome_1 = tastiera.nextLine();
		System.out.println("2° Nome:");
		nome_2 = tastiera.nextLine();
		System.out.println("3° Nome:");
		nome_3 = tastiera.nextLine();
		System.out.println("4° Nome:");
		nome_4 = tastiera.nextLine();
		System.out.println("5° Nome:");
		nome_5 = tastiera.nextLine();
		
		tastiera.close();
		
		risposta += "\n\t NOME " + nome_1 + ":";
		
		switch(nome_1.toLowerCase())
		{
			case "uberto":
			case "zenelao":
				risposta_1 = "\n- Il tuo nome è raro";
				break;
			case "estella" :
			case "frisella" :
				risposta_1 = "\n- Il tuo nome è esotico";
				break;
			case "mario" :
				risposta_1 = "\n- Ti chiami come l'idrauilico più famoso al mondo";
				break;
		}
		
		if(nome_1.toLowerCase().endsWith("a"))
		{
			risposta_1 += "\n- Il tuo nome termina con 'A'";
		}
		else if(nome_1.toLowerCase().endsWith("o"))
		{
			risposta_1 += "\n- Il tuo nome termina con 'O'";
		}
		
		if(nome_1.length() > 7)
		{
			risposta_1 += "\n- Il tuo nome è lungo";
		}
		
		risposta += risposta_1;
		
		risposta += "\n\t NOME " + nome_2 + ":";
		
		switch(nome_2.toLowerCase())
		{
			case "uberto":
			case "zenelao":
				risposta_2 = "\n- Il tuo nome è raro";
				break;
			case "estella" :
			case "frisella" :
				risposta_2 = "\n- Il tuo nome è esotico";
				break;
			case "mario" :
				risposta_2 = "\n- Ti chiami come l'idrauilico più famoso al mondo";
				break;
		}
		
		if(nome_2.toLowerCase().endsWith("a"))
		{
			risposta_2 += "\n- Il tuo nome termina con 'A'";
		}
		else if(nome_2.toLowerCase().endsWith("o"))
		{
			risposta_2 += "\n- Il tuo nome termina con 'O'";
		}
		
		if(nome_2.length() > 7)
		{
			risposta_2 += "\n- Il tuo nome è lungo";
		}
		
		risposta += risposta_2;
		
		risposta += "\n\t NOME " + nome_3 + ":";
		
		switch(nome_3.toLowerCase())
		{
			case "uberto":
			case "zenelao":
				risposta_3 = "\n- Il tuo nome è raro";
				break;
			case "estella" :
			case "frisella" :
				risposta_3 = "\n- Il tuo nome è esotico";
				break;
			case "mario" :
				risposta_3 = "\n- Ti chiami come l'idrauilico più famoso al mondo";
				break;
		}
		
		if(nome_3.toLowerCase().endsWith("a"))
		{
			risposta_3 += "\n- Il tuo nome termina con 'A'";
		}
		else if(nome_3.toLowerCase().endsWith("o"))
		{
			risposta_3 += "\n- Il tuo nome termina con 'O'";
		}
		
		if(nome_3.length() > 7)
		{
			risposta_3 += "\n- Il tuo nome è lungo";
		}
		
		risposta += risposta_3;
		
		risposta += "\n\t NOME " + nome_4 + ":";
		
		switch(nome_4.toLowerCase())
		{
			case "uberto":
			case "zenelao":
				risposta_4 = "\n- Il tuo nome è raro";
				break;
			case "estella" :
			case "frisella" :
				risposta_4 = "\n- Il tuo nome è esotico";
				break;
			case "mario" :
				risposta_4 = "\n- Ti chiami come l'idrauilico più famoso al mondo";
				break;
		}
		
		if(nome_4.toLowerCase().endsWith("a"))
		{
			risposta_4 += "\n- Il tuo nome termina con 'A'";
		}
		else if(nome_4.toLowerCase().endsWith("o"))
		{
			risposta_4 += "\n- Il tuo nome termina con 'O'";
		}
		
		if(nome_4.length() > 7)
		{
			risposta_4 += "\n- Il tuo nome è lungo";
		}
		
		risposta += risposta_4;
		
		risposta += "\n\t NOME " + nome_5 + ":";
		
		switch(nome_5.toLowerCase())
		{
			case "uberto":
			case "zenelao":
				risposta_5 = "\n- Il tuo nome è raro";
				break;
			case "estella" :
			case "frisella" :
				risposta_5 = "\n- Il tuo nome è esotico";
				break;
			case "mario" :
				risposta_5 = "\n- Ti chiami come l'idrauilico più famoso al mondo";
				break;
		}
		
		if(nome_5.toLowerCase().endsWith("a"))
		{
			risposta_5 += "\n- Il tuo nome termina con 'A'";
		}
		else if(nome_5.toLowerCase().endsWith("o"))
		{
			risposta_5 += "\n- Il tuo nome termina con 'O'";
		}
		
		if(nome_5.length() > 7)
		{
			risposta_5 += "\n- Il tuo nome è lungo";
		}
		
		risposta += risposta_5;
		
		System.out.println(risposta);
	}

}
