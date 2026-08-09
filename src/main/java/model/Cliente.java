package model;

import java.util.Date;

public class Cliente {
    private int id_cliente;
    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private Date data_di_nascita;

    public Cliente() {

    }

    public Cliente(int id_cliente, String username, String email, String password, String nome, String cognome, Date data_di_nascita) {
        this.id_cliente = id_cliente;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Date getData_di_nascita() {
        return data_di_nascita;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setData_di_nascita(Date data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                '}';
    }
}
