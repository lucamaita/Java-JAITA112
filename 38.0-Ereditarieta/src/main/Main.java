package main;

import java.io.FileNotFoundException;

import entities.Concessionaria;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Concessionaria c = new Concessionaria("src/res/Dati.txt");
		
		System.out.println(c.elencoAuto());
		System.out.println(c.elencoMoto());
		System.out.println("\n\n\n" + c.maggioreAutonomia());
		System.out.println("\n\nXXX" + c.raggiunge(300, 2));
		System.out.println("\n\nCCC" + c.cerca("ducati"));
		
		
	} // FINE STATIC VOID MAIN

} // FINE CLASSE MAIN
