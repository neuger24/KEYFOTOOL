package model;

import java.util.Date;

public class Ordine {

    private int id_ordine;
    private int id_clienteKK;
    private Date data;
    private double totale;

    public Ordine() {
    }

    public Ordine(int id_ordine, int id_clienteKK, Date data, double totale) {
        this.id_ordine = id_ordine;
        this.id_clienteKK = id_clienteKK;
        this.data = data;
        this.totale = totale;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public int getId_clienteKK() {
        return id_clienteKK;
    }

    public Date getData() {
        return data;
    }

    public double getTotale() {
        return totale;
    }

    public void setId_ordine(int id_ordine) {
        this.id_ordine = id_ordine;
    }

    public void setId_clienteKK(int id_clienteKK) {
        this.id_clienteKK = id_clienteKK;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", id_clienteKK=" + id_clienteKK +
                ", data=" + data +
                ", totale=" + totale +
                '}';
    }
}
