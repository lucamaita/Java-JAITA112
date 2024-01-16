package main;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		//D
		Scanner scanner;
		double 	capitale;
		double 	tassointeresse;
		double 	mesiInvestimento;
		double 	mediaMensile;
		double 	anni;
		
		//I
		scanner =  new Scanner(System.in);
		capitale = 0;
		tassointeresse = 0;
		mesiInvestimento = 0;
		mediaMensile = 0;
		anni = 0;
		
		System.out.println("Digitare l'importo del capitale, poi premere ENTER");
		capitale = Double.parseDouble(scanner.nextLine());
		
		System.out.println("Inserire il tasso di interesse annuo in percentuale, poi premere ENTER");
		tassointeresse = Double.parseDouble(scanner.nextLine());
		
		System.out.println("Digitare in mesi, la durata dell'investimento (solo anni interi)");
		mesiInvestimento = Double.parseDouble(scanner.nextLine());

		scanner.close();
		
		//C
		anni = mesiInvestimento / 12;
		mediaMensile = (capitale + (tassointeresse * anni)) / mesiInvestimento;
		
		//O
		System.out.println(mediaMensile);
	}

}
