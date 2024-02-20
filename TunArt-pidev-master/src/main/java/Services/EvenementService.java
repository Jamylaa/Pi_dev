package Services;

import Entites.Evenement;
import Entites.Formation;
import Utils.ConnexionDB;

import java.sql.SQLException;
import java.util.List;

import java.sql.*;

public class EvenementService  implements IService<Evenement> {

    private Statement ste;
    private static EvenementService serEv;


    public EvenementService() {
        try {
            Connection con1 = ConnexionDB.getInstance().getCon();
            ste = con1.createStatement();}
        catch (SQLException e) {System.out.println(e.getMessage());}
    }

    public static EvenementService getInstance() {
        if (serEv == null) serEv = new EvenementService();
        return serEv;}

    @Override
    public void add(Evenement evenement) throws SQLException {
        String req = "INSERT INTO `evenement` (`idEvent`,`lieu`, `nom_Event`," +
                " `nb_publique`," + " `date`) " +
                "VALUES (NULL, '" + evenement.getLieu() + "', '" +
                evenement.getNom_Event() + "', '" + evenement.getNb_publique() + "', '"
                + evenement.getDate() + "');";
        ste.executeUpdate(req); }

    @Override
    public boolean delete(Evenement evenement) throws SQLException {
        return false;}

    @Override
    public boolean update(Evenement evenement) throws SQLException {
        return false;}

    @Override
    public Evenement findById(Evenement evenement) throws SQLException {
        return null;}

    @Override
    public List<Evenement> findAll() throws SQLException {
        return null;}

}