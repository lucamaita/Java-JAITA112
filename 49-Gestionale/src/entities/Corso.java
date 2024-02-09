package entities;

public class Corso {
    
    //PROPRIETA
    private int id;
    private String nome;
    private int totale_ore;
    private int numero_lezioni;
    private String lingua;
    private String materiali;
    
    //COSTRUTTORE
    public Corso(int id, String nome, int totale_ore, int numero_lezioni, String lingua, String materiali) {
        this.id = id;
        this.nome = nome;
        this.totale_ore = totale_ore;
        this.numero_lezioni = numero_lezioni;
        this.lingua = lingua;
        this.materiali = materiali;
    }
    
    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getTotale_ore() {
        return totale_ore;
    }
    public void setTotale_ore(int totale_ore) {
        this.totale_ore = totale_ore;
    }
    public int getNumero_lezioni() {
        return numero_lezioni;
    }
    public void setNumero_lezioni(int numero_lezioni) {
        this.numero_lezioni = numero_lezioni;
    }
    public String getLingua() {
        return lingua;
    }
    public void setLingua(String lingua) {
        this.lingua = lingua;
    }
    public String getMateriali() {
        return materiali;
    }
    public void setMateriali(String materiali) {
        this.materiali = materiali;
    }

    //METODI
    @Override
    public String toString() {
        return  "\n\tID: "          + id + 
                "\nNome: "          + nome + 
                "\nTotale ore: "    + totale_ore + 
                "\nNumero lezioni=" + numero_lezioni + 
                "\nLingua="         + lingua + 
                "\nMateriali="      + materiali;
    }

    
  
    
}
