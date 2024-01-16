package entities;

public class Persona
{
	// Esempi di proprieta con diversi livelli di visibilita: per vedere come lavorano, guardare main
//	String nome;
//	public String cognome;
//	protected int eta;
//	private String residenza;
	
	private String nome;
	private String cognome;
	private int eta;
	private String residenza;
	
	// Per generare in automatico il costruttore si puo fare:
	// - tasto destro -> Source -> Generate constructor using fields
	// - Alt+Shift+S+o
	
	// Il super() fate finta che non esista (per ora non ci interessa, cancellare se volete)
	public Persona(String nome, String cognome, int eta, String residenza)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
	}
	
	// GETTER e SETTER: Sono metodi che rispettivamente mostrano o modificano il contenuto delle proprieta
	/**
	 * JavaDoc: e' lo specchietto che si apre come spiegazione ai metodi
	 * @return
	 */
	public String getNome()
	{
		return nome;
	}
	// VOID: si mette al posto del tipo di ritorno quando non volete che il metodo dia un risultato.
	// Un metodo VOID e' un metodo che altera lo STATO DELL'OGGETTO
	
	// DEFINIZIONE stato dell'oggetto: e' l'insieme dei valori delle proprieta di un oggetto in un dato momento
	public void setNome(String nome)
	{
		if(nome.length() >= 2)
		this.nome = nome;
	}
	public String getCognome()
	{
		return cognome;
	}
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	public int getEta()
	{
		return eta;
	}
	public void setEta(int eta)
	{
		this.eta = eta;
	}
	public String getResidenza()
	{
		return residenza;
	}
	public void setResidenza(String residenza)
	{
		this.residenza = residenza;
	}
	
	public String scheda()
	{
		return "\n" + nome + " " + cognome + ", di anni" + eta + " residente a " + residenza.toUpperCase();
	}
		
} // Fine classe
