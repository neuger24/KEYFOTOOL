package dao;

import model.Prodotto;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    private static final String NOME_TABELLA = "prodotto";
    public List<Prodotto> getProdottiInEvidenza(int limit) {
        List<Prodotto> prodotti = new ArrayList<>();

        String query = "SELECT * FROM " + NOME_TABELLA + " WHERE disponibile = 1";// da modificare per il prodotto in evidenza

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, limit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Prodotto model = new Prodotto();

                    model.setId_prodotto(resultSet.getInt("id_prodotto"));
                    model.setNome_p(resultSet.getString("nome_p"));
                    model.setTipo(resultSet.getString("tipo"));
                    model.setDescrizione(resultSet.getString("descrizione"));
                    model.setFoto(resultSet.getString("foto"));
                    model.setPrezzo(resultSet.getDouble("prezzo"));
                    model.setDisponibile(resultSet.getInt("disponibile"));
                    prodotti.add(model);
                }
            }

        } catch (SQLException e) {
            System.err.println("Errore durante l'estrazione dei prodotti in evidenza: " + e.getMessage());
        }

        return prodotti;
    }

}
