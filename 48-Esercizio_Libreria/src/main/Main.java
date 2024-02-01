package main;

import dao.*;
import db.*;

public class Main {

	public static void main(String[] args) {
		
		DAOAutore a = null;

        a = new DAOAutore("libreria");

        DAOLibro l = new DAOLibro("libreria");


        //        -lista completa dei libri presenti nel DB
        System.out.println(l.list());
        //----------------------------------------------------------------------
        //        -inserimento di un nuovo libro
        //Autore autoreNuovo = new Autore(7,"Stepano", "Re", "1947-09-21", "Americagno", "Stepano Edwin RE è uno scrittore statunscente...");
        //Entity libroNuovo = new Libro(8, "Il piccolo principe", "Fantasy", "Mondadori",400 , 39.20, autoreNuovo);
        //System.out.println(l.insert(libroNuovo));

        //---------------------------------------------------------------------------
        //        -modifica di un libro
        //Entity e = l.find(1);
        //((Libro)e).setTitolo("PooPoo");
        //System.out.println(l.update(e));
        //----------------------------------------------------------------------------            
        //        -eliminazione di un libro
        //System.out.println(l.delete(2));

        //----------------------------------------------------------------------------        
        //        -lista completa degli autori
        //System.out.println(a.list());
        //----------------------------------------------------------------------------            
        //        -modifica di un autore
        //Entity e = a.find(3);
        //((Autore)e).setNome("Bubu");
        //System.out.println(a.update(e));
        //----------------------------------------------------------------------------    
        //        -eliminazione di un autore
        //System.out.println(a.delete(2));
        //----------------------------------------------------------------------------    
        //        -inserimento di un autore
        //Entity autoreNuovo = new Autore(8,"Stepano", "Re", "1947-09-21", "Americagno", "Stepano Edwin RE è uno scrittore statunscente...");
        //System.out.println(a.insert(autoreNuovo));
        //----------------------------------------------------------------------------    
        //        -ricerca di un libro in base al titolo
        //System.out.println(l.findByTitolo("Harry"));
        //---------------------------------------------------------------------------
        //        -ricerca di una serie di libri in base al genere
        //System.out.println(l.findByGenere("Fantasy"));
        //----------------------------------------------------------------------------------
        //        -l'elenco dei libri ordinati per prezzo, dal più caro al meno caro
        //System.out.println(l.libriPerPrezzo());
        //----------------------------------------------------------------------------------
        //        -l'elenco delle casa editrici con il numero di libri posseduti
        //System.out.println(l.libriCaseEditrici());
        //-----------------------------------------------------------------------------------
        //        -il nominativo di ogni autore e il numero di libri che ha pubblicato
        //System.out.println(a.libriAutore());
	}

}
