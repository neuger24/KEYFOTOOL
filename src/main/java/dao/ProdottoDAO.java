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

        String query = "SELECT * FROM " + NOME_TABELLA + " WHERE disponibile = 1 ORDER BY id_prodotto DESC LIMIT ?";// da modificare per il prodotto in evidenza

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

    public Prodotto prodottoDaId(int id_prodotto) {
        Prodotto model = null;
        String query = "SELECT * FROM " + NOME_TABELLA + " WHERE id_prodotto = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id_prodotto);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    model = new Prodotto();

                    model.setId_prodotto(resultSet.getInt("id_prodotto"));
                    model.setNome_p(resultSet.getString("nome_p"));
                    model.setTipo(resultSet.getString("tipo"));
                    model.setDescrizione(resultSet.getString("descrizione"));
                    model.setFoto(resultSet.getString("foto"));
                    model.setPrezzo(resultSet.getDouble("prezzo"));
                    model.setDisponibile(resultSet.getInt("disponibile"));

                }
            }

        } catch (SQLException e) {
            System.err.println("Errore durante l'estrazione del prodotto per ID: " + e.getMessage());
        }

        return model;
    }

    public List<Prodotto> getProdottiFiltrati(String[] categorie, String prezzoMax, String sort, String searchQuery, int limit, int offset) {
        List<Prodotto> lista = new ArrayList<>();

        StringBuilder query = new StringBuilder("SELECT * FROM prodotto WHERE 1=1");

        if (categorie != null && categorie.length > 0) {
            query.append(" AND tipo IN (");
            for (int i = 0; i < categorie.length; i++) {
                query.append("?");
                if (i < categorie.length - 1) {
                    query.append(",");
                }
            }
            query.append(")");
        }

        if (prezzoMax != null && !prezzoMax.trim().isEmpty()) {
            query.append(" AND prezzo <= ?");
        }
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            query.append(" AND nome LIKE ?");
        }


        if (sort != null) {
            switch (sort) {
                case "price_asc":
                    query.append(" ORDER BY prezzo ASC");
                    break;
                case "price_desc":
                    query.append(" ORDER BY prezzo DESC");
                    break;
                case "name_asc":
                    query.append(" ORDER BY nome ASC");
                    break;
                //case "new":
                default:
                query.append(" ORDER BY id_prodotto DESC");
                break;
            }
        } else {
            query.append(" ORDER BY id_prodotto DESC");
        }
        query.append(" LIMIT ? OFFSET ?");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query.toString())) {

            int paramIndex = 1;

            if (categorie != null && categorie.length > 0) {
                for (String cat : categorie) {
                    ps.setInt(paramIndex++, Integer.parseInt(cat));
                }
            }

            if (prezzoMax != null && !prezzoMax.trim().isEmpty()) {
                ps.setDouble(paramIndex++, Double.parseDouble(prezzoMax));
            }

            if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + searchQuery.trim() + "%");
            }

            ps.setInt(paramIndex++, limit);
            ps.setInt(paramIndex++, offset);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prodotto model = new Prodotto();
                model.setId_prodotto(rs.getInt("id_prodotto"));
                model.setNome_p(rs.getString("nome"));
                model.setDescrizione(rs.getString("descrizione"));
                model.setFoto(rs.getString("foto"));
                model.setPrezzo(rs.getDouble("prezzo"));
                model.setDisponibile(rs.getInt("disponibile"));
                lista.add(model);
            }
        } catch (SQLException e) {
            System.err.println("Errore query filtrata: " + e.getMessage());
        }

        return lista;
    }

    public void salvaProdotto(Prodotto p) {
        String query = "INSERT INTO prodotti (nome_p, tipo, descrizione, foto, prezzo, disponibile) VALUES (?, ?, ?, ?, ?, ?)";

        try (java.sql.Connection con = DBConnection.getConnection();
             java.sql.PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, p.getNome_p());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getDescrizione());
            ps.setString(4, p.getFoto());
            ps.setDouble(5, p.getPrezzo());
            ps.setInt(6, p.getDisponibile());



            ps.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificaProdotto(Prodotto p) {
        String query = "UPDATE prodotti SET nome_p = ?, tipo = ?, descrizione = ?, foto = ?, prezzo = ?, disponibile = ? WHERE id_prodotto = ?";

        try (java.sql.Connection con = DBConnection.getConnection();
             java.sql.PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, p.getNome_p());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getDescrizione());
            ps.setString(4, p.getFoto());
            ps.setDouble(5, p.getPrezzo());
            ps.setInt(6, p.getDisponibile());
            ps.setInt(7, p.getId_prodotto());

            ps.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminaProdotto(int id_prodotto) {
        String query = "DELETE FROM prodotti WHERE id_prodotto = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id_prodotto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int contaProdottiFiltrati(String[] categorie, String prezzoMax, String searchQuery) {
        int totale = 0;
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM prodotti WHERE 1=1");

        if (categorie != null && categorie.length > 0) {
            query.append(" AND tipo IN (");
            for (int i = 0; i < categorie.length; i++) {
                query.append("?");
                if (i < categorie.length - 1) query.append(",");
            }
            query.append(")");
        }

        if (prezzoMax != null && !prezzoMax.trim().isEmpty()) {
            query.append(" AND prezzo <= ?");
        }
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            query.append(" AND nome LIKE ?");
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query.toString())) {

            int paramIndex = 1;

            if (categorie != null && categorie.length > 0) {
                for (String cat : categorie) {
                    ps.setInt(paramIndex++, Integer.parseInt(cat));
                }
            }
            if (prezzoMax != null && !prezzoMax.trim().isEmpty()) {
                ps.setDouble(paramIndex++, Double.parseDouble(prezzoMax));
            }
            if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                ps.setString(paramIndex++, "%" + searchQuery.trim() + "%");
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totale = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totale;
    }

}
