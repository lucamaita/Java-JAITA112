package main;

import java.io.FileNotFoundException;

import entities.Blockbuster;

public class Main
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Blockbuster b = new Blockbuster("src/res/Dati.txt");
		
		System.out.println(b.schedaFilm());
		System.out.println(b.schedaSerie());
		System.out.println(b.schedaCompleta());
		System.out.println(b.durataMediaFilm());
		System.out.println(b.filmCaro());
		System.out.println(b.invalidi());
		System.out.println(b.registaFrequente());
		
		
		
		
		
		
	}

}
