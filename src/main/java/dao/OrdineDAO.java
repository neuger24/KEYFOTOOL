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
    private static final String NOME_STABELLA = "elementi";




    public List<Elementi> getEelmentiOrdine(int id_ordine){

        List<Elementi> EOrdinati = new ArrayList<>();




        return EOrdinati;
    }


}
