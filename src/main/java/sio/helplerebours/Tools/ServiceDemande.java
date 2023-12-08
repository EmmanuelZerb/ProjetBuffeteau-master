package sio.helplerebours.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDemande {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServiceDemande() {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ArrayList<String> GetMatiere() throws SQLException {
        ArrayList<String> laMatiere = new ArrayList<>();

        ps = uneCnx.prepareStatement("select designation from matiere");
        rs = ps.executeQuery();
        while (rs.next()) {
            laMatiere.add(rs.getString(1));
        }
            return laMatiere;

    }

    public ArrayList<String> GetSousMatiere(String IdDesignation) throws SQLException {
        ArrayList<String> laMatiere = new ArrayList<>();

        ps = uneCnx.prepareStatement("select Designation, sous_matiere from matiere Where Designation = ?");
        ps.setString(1,IdDesignation);
        rs = ps.executeQuery();
        while (rs.next()) {
            laMatiere.add(Integer.parseInt(rs.getString(1)),rs.getString(2));
        }
        return laMatiere;

    }
}

