package dao;

import model.Elementi;
import model.Prodotto;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//gestiamo anche ElementiDAO
public class OrdineDAO {
    private static final String NOME_TABELLA = "ordine";
    private static final String NOME_S_TABELLA = "elementi";




    public List<Elementi> getEelmentiOrdine(int id_ordine){

        List<Elementi> EOrdinati = new ArrayList<>();
        String query = "SELECT * FROM " + NOME_S_TABELLA +" WHERE id_prodottoK = ? ";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Elementi model = new Elementi();

                    model.setId_prodottoK(resultSet.getInt("id_prodottoK"));
                    model.setId_ordineK(resultSet.getInt("id_ordineK"));
                    model.setN_elementi(resultSet.getInt("n_elementi"));
                    model.setTot_parziale(resultSet.getDouble("tot_parziale"));

                }
            }

        } catch (SQLException e) {
            System.err.println("Errore : " + e.getMessage());
        }
        return EOrdinati;
    }


}
