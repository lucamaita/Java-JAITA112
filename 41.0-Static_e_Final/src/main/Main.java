package main;

import entities.Persona;

public class Main {

	public static void main(String[] args) {
		
		int min = Persona.etaMin;
		
		int eta = 26;
		String provincia = "MI";
		
		if(Persona.valida(eta,provincia)) {
			Persona p = new Persona("Alice", "Bensanelli", "LO", "Zelo", 26);
			System.out.println(p.toString());
		} else {
			System.out.println("Eta non valida, oggetto non creato.");
		}
		
		

	}

}
