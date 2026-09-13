package dao;

import java.sql.*;
import util.DBConnection;
import model.Utente;
import util.HashPassword;

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


}

