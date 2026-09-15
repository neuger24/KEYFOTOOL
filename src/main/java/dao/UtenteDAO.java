package dao;

import java.sql.*;
import util.DBConnection;
import model.Utente;
import util.HashPassword;
//gestiamo anche M_pagamentoDAO
public class UtenteDAO {

    public Utente login(String email, String plainPassword) throws Exception {

        String sql = "SELECT * FROM utente WHERE email = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next() && HashPassword.verifyPassword(plainPassword, rs.getString("password"))) {

                    return new Utente(
                            rs.getInt("id_cliente"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("nome"),
                            rs.getString("cognome"),
                            rs.getDate("data_di_nascita"),
                            rs.getInt("ruolo") // 0 per utente, 1 per admin
                    );
                }
            }
        }

        return null;
    }

    public boolean salvaUtente(Utente utente) {
        boolean salvataggioCompletato = false;
        String query = "INSERT INTO utenti (username, email, passward, nome, cognome, data_di_nascita ) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, utente.getUsername());
            preparedStatement.setString(2, utente.getEmail());
            preparedStatement.setString(3, utente.getPassword());
            preparedStatement.setString(4, utente.getNome());
            preparedStatement.setString(5, utente.getCognome());
            preparedStatement.setDate(6, (Date) utente.getData_di_nascita());
            int righeModificate = preparedStatement.executeUpdate();

            if (righeModificate > 0) {
                salvataggioCompletato = true;
            }

        } catch (SQLException e) {
            System.err.println("Errore durante la registrazione dell'utente: " + e.getMessage());
            e.printStackTrace();
        }

        return salvataggioCompletato;
    }


}

