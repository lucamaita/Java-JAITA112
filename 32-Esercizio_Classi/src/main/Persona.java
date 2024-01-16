package main;

import java.time.LocalDate;

// CLASSE MODELLO: Ha come scopo la creazione di oggetti.
public class Persona
{
	// PROPRIETA
	String nome;
	String cognome;
	String dob;
	String personalTrainer;
	String obbiettivo;
	boolean abbonamento;
	
	// COSTRUTTORE: Ha il compito di costruire un oggetto, 
	// cioe ha il compito di valorizzare le proprieta della classe.
	// In sostanza un costruttore e un metodo un po piu particolare degli altri.
	Persona()
	{
		// Scritto cosi si chiama COSTRUTTORE VUOTO ed e sempre presente in automatico
		// se voi non scrivete nulla.
		// Nel momento in cui scrivete voi a mano un costruttore, quello vuoto si disattiva.
		
	}
	
	// COSTRUTTORE PIENO: Significa che ha dei PARAMETRI, cioe chiede dei dati in input per fare i calcoli nel metodo
	// ATTENZIONE! Nei metodi dei parametri ci importa molto del loro tipo, ma poco e niente del loro nome.
	//				Percio nella firma del metodo la definizione ora dice "la firma e composta da nome del metodo
	//				e dall'ordine dei tipi dei parametri".
	Persona(String nome, String cognome, String dob, String personalTrainer, String obbiettivo, boolean abbonamento)
	{	
		// Proprieta = Parametro -> THIS si usa solo nei casi di omonimia (stesso nome) e nel nostro caso indica
		// 							quale delle due e la proprieta.
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.personalTrainer = personalTrainer;
		this.obbiettivo = obbiettivo;
		this.abbonamento = abbonamento;
	}
	
	// Quanti costruttori posso avere in una classe? 	Potenzialmente infiniti, l'unico limite sara dettato dalla natura
	//													dei parametri che voglio scrivere nella firma del metodo.
	
	
	// METODI
	String scheda() // Convenzioni nomi metodi, prima lettera piccola, niente spazi, uso camelCase
	{
		String ris = "";
		
		ris = 	"Cliente: " 		+ nome 				+ " " 			+ cognome 	+
				"\nNato il: " 		+ dob 				+ " di anni " 	+ eta() 	+
				"\nSeguito da: " 	+ personalTrainer 								+ 
				"\nObbiettivo: " 	+ obbiettivo 									+ 
				"\nAbbonato: " 		+ (abbonamento 		? "Si" 			: "No") 	+
				"\n------------------------------------------------------------------";
		
		return ris;
	}
	
	int eta()
	{
		int ris = 0;
		
		String[] data = dob.split("-"); // => "dd", "mm", "yyyy"
		String anno = data[2]; // -> "yyyy"
		int annoNumero = Integer.parseInt(anno); // -> yyyy
		
		// Scrittura compressa dei tre passaggi sopra
		// int yob = Integer.parseInt(dob.split("-")[2]);
		
		// LocalDate.now().getYear() 
		// -> LocalDate importa una classe dalla JDK che gestisce il formato delle date
		// -> .now() Preleva la data del sistema 
		// -> .getYear() estrapola solo l'anno
		ris = LocalDate.now().getYear() - annoNumero;
		
		return ris;
	}
	
}
