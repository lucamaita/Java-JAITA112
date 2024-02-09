package entities;

import java.time.LocalDate;

public class Utente {
    
    //PROPRIETA
    private int id;
    private String nome;
    private String cognome;
    private LocalDate dob;
    private String azienda;
    private String mansione;
    private String corsoFrequentato;

    //COSTRUTTORE
    public Utente(int id, String nome, String cognome, LocalDate dob, String azienda, String mansione, String corsoFrequentato) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dob = dob;
        this.azienda = azienda;
        this.mansione = mansione;
        this.corsoFrequentato = corsoFrequentato;
    }

    //Getters and Setters
    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAzienda() {
        return azienda;
    }

    public String getMansione() {
        return mansione;
    }

    public String getCorsoFrequentato() {
        return corsoFrequentato;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    public void setCorsoFrequentato(String corsoFrequentato) {
        this.corsoFrequentato = corsoFrequentato;
    }

    //Metodi
    @Override
    public String toString() {
        return  "\n\tID: "              + id +
                "\nNome: "              + nome +
                "\nCognome: "           + cognome +
                "\nDob: "               + dob +
                "\nAzienda: "           + azienda +
                "\nMansione: "          + mansione +
                "\nCorso frequentato: " + corsoFrequentato;
    }
}


