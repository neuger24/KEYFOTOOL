package model;

public class Prodotto {

    private int id_prodotto;
    private String nome_p;
    private String tipo;
    private String descrizione;
    private double prezzo;

    public Prodotto() {

    }

    public Prodotto(int id_prodotto, String nome_p, String tipo, String descrizione, double prezzo) {
        this.id_prodotto = id_prodotto;
        this.nome_p = nome_p;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public String getNome_p() {
        return nome_p;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public void setNome_p(String nome_p) {
        this.nome_p = nome_p;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id_prodotto=" + id_prodotto +
                ", nome_p='" + nome_p + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}

