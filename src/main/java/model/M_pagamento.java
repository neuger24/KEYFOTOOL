package model;

public class M_pagamento {

    private int id_metodo;
    private int iD_Cliente;
    private String tipo;/*{carta,PayPal}*/
    private String username;
    private String passward;
    private String tnome_int;
    private String cognome_int;
    private int id_carta;
    private int cvc;
    private int scadenza_mese;
    private int scadenza_anno;

    public M_pagamento() {
    }

    public M_pagamento(int id_metodo, int iD_Cliente,String tipo ,String username, String passward, String tnome_int, String cognome_int, int id_carta, int cvc, int scadenza_mese, int scadenza_anno) {
        this.id_metodo = id_metodo;
        this.iD_Cliente = iD_Cliente;
        this.tipo = tipo;
        this.username = username;
        this.passward = passward;
        this.tnome_int = tnome_int;
        this.cognome_int = cognome_int;
        this.id_carta = id_carta;
        this.cvc = cvc;
        this.scadenza_mese = scadenza_mese;
        this.scadenza_anno = scadenza_anno;
    }

    public int getId_metodo() {
        return id_metodo;
    }

    public int getiD_Cliente() {
        return iD_Cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassward() {
        return passward;
    }

    public String getTnome_int() {
        return tnome_int;
    }

    public String getCognome_int() {
        return cognome_int;
    }

    public int getId_carta() {
        return id_carta;
    }

    public int getCvc() {
        return cvc;
    }

    public int getScadenza_mese() {
        return scadenza_mese;
    }

    public int getScadenza_anno() {
        return scadenza_anno;
    }

    public void setId_metodo(int id_metodo) {
        this.id_metodo = id_metodo;
    }

    public void setiD_Cliente(int iD_Cliente) {
        this.iD_Cliente = iD_Cliente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public void setTnome_int(String tnome_int) {
        this.tnome_int = tnome_int;
    }

    public void setCognome_int(String cognome_int) {
        this.cognome_int = cognome_int;
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public void setScadenza_mese(int scadenza_mese) {
        this.scadenza_mese = scadenza_mese;
    }

    public void setScadenza_anno(int scadenza_anno) {
        this.scadenza_anno = scadenza_anno;
    }

    @Override
    public String toString() {
        return "M_pagamento{" +
                "id_metodo=" + id_metodo +
                ", iD_Cliente=" + iD_Cliente +
                ", tipo='" + tipo + '\'' +
                ", username='" + username + '\'' +
                ", passward='" + passward + '\'' +
                ", tnome_int='" + tnome_int + '\'' +
                ", cognome_int='" + cognome_int + '\'' +
                ", id_carta=" + id_carta +
                ", cvc=" + cvc +
                ", scadenza_mese=" + scadenza_mese +
                ", scadenza_anno=" + scadenza_anno +
                '}';
    }
}
