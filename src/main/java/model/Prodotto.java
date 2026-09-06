package model;

public class Prodotto {

    private int id_prodotto;
    private String nome_p;
    private String tipo;
    private String descrizione;
    private String foto;
    private double prezzo;
    private int disponibile;

    public Prodotto() {

    }

    public Prodotto(int id_prodotto, String nome_p, String tipo, String descrizione,String foto , double prezzo, int disponibile) {
        this.id_prodotto = id_prodotto;
        this.nome_p = nome_p;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.foto = foto;
        this.prezzo = prezzo;
        this.disponibile = disponibile;
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

    public String getFoto() {
        return foto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getDisponibile() {
        return disponibile;
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

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setDisponibile(int disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id_prodotto=" + id_prodotto +
                ", nome_p='" + nome_p + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", foto='" + foto + '\'' +
                ", prezzo=" + prezzo +
                ", disponibile=" + disponibile +
                '}';
    }
}

