package main;

import java.io.FileNotFoundException;

import entities.MezziTrasporto;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		MezziTrasporto m = new MezziTrasporto("src/res/Dati.txt");
		
		System.out.println(m.elencoTram());
		System.out.println(m.elencoMetro());
		System.out.println(m.elencoAutobus());
		System.out.println(m.elencoNotturni());
		System.out.println(m.mezzoDatoNPasseggeri(20));
		System.out.println(m.mezzoMinoreCapienza());
		System.out.println(m.cercaLinea("1"));
	}

}
