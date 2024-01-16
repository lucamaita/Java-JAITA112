package main;

public class Prodotto
{
	// PROPRIETA
	String 	nome;
	int 	quantita;
	double 	prezzoAlPezzo;
	double 	tassaAlPubblico;
	String 	componentiTerzi;
	String	colori;
	
	// COSTRUTTORE
	Prodotto(String nome,int quantita, double prezzoAlPezzo,double tassaAlPubblico,String componentiTerzi,String colori)
	{
		this.nome = nome;
		this.quantita = quantita;
		this.prezzoAlPezzo = prezzoAlPezzo;
		this.tassaAlPubblico = tassaAlPubblico;
		this.componentiTerzi = componentiTerzi;
		this.colori = colori;
	}
	
	// METODI
	String scheda()
	{
		String ris = "";
		
		ris = 	"\n--------------------------------------------"+
				"\n\t" 					+ nome.toUpperCase() 	+
				"\nQuantita: " 			+ quantita 				+
				"\nPrezzo al pezzo: " 	+ prezzoAlPezzo 		+
				"\nTassa al pubblico: " + tassaAlPubblico 		+
				"\nComponenti terzi: " 	+ componentiTerzi 		+
				"\nColori: " 			+ colori				+
				"\n--------------------------------------------";

		return ris;
	}
	
	Double prezzoAlPubblico()
	{
		Double ris = 0.0;
		
		ris = prezzoAlPezzo + (prezzoAlPezzo * (tassaAlPubblico/100));

		return ris;
	}
	
	int quantitaColori()
	{
		int ris = 0;
		String[] infoColori = colori.split("-");
		
		ris = infoColori.length;
		
		return ris;
	}
	
	int quanteParti() 
	{
		int ris = 0;
		
		String[] quanteParti = componentiTerzi.split("-");
		
		ris = quanteParti.length;
		
		if (ris == 0)
			ris =1;
		
		return ris;
	}
	
	double rapportoPrezzoComponenti()
	{
		double ris = 0;
		
		
		ris = prezzoAlPubblico()/quanteParti();
			
		return ris;
	}

}
