package model;

public class Elementi {
    private int id_prodottoK;
    private int id_ordineK;
    private int n_elementi;
    private double tot_parziale;

    public Elementi() {
    }

    public Elementi(int id_prodottoK, int id_ordineK, int n_elementi, double tot_parziale) {
        this.id_prodottoK = id_prodottoK;
        this.id_ordineK = id_ordineK;
        this.n_elementi = n_elementi;
        this.tot_parziale = tot_parziale;
    }

    public int getId_prodottoK() {
        return id_prodottoK;
    }

    public int getId_ordineK() {
        return id_ordineK;
    }

    public int getN_elementi() {
        return n_elementi;
    }

    public double getTot_parziale() {
        return tot_parziale;
    }

    public void setId_prodottoK(int id_prodottoK) {
        this.id_prodottoK = id_prodottoK;
    }

    public void setId_ordineK(int id_ordineK) {
        this.id_ordineK = id_ordineK;
    }

    public void setN_elementi(int n_elementi) {
        this.n_elementi = n_elementi;
    }

    public void setTot_parziale(double tot_parziale) {
        this.tot_parziale = tot_parziale;
    }

    @Override
    public String toString() {
        return "Elementi{" +
                "id_prodottoK=" + id_prodottoK +
                ", id_ordineK=" + id_ordineK +
                ", n_elementi=" + n_elementi +
                ", tot_parziale=" + tot_parziale +
                '}';
    }
}
