package factory;

import java.util.Map;

public interface IFactory
{
	// Questo metodo si rif� a un metodo dentro alla classe modello che ci interessa.
	// Questo metodo della classe modello avr� il compito di usare la mappa per riempire l'oggetto.
	public void create(Map<String,String> map);
}
