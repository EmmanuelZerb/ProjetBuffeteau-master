package sio.helplerebours.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.helplerebours.Entities.Matiere;
import sio.helplerebours.Entities.SousMatiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMatiere {
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServiceMatiere()
    {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<Matiere> GetDesignationMatiere() throws SQLException
    {
        ObservableList<Matiere> lesMatieres = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT designation FROM matiere;");
        rs = ps.executeQuery();
        while(rs.next()){
            Matiere uneMatiere = new Matiere(rs.getInt(1),rs.getString(2));
            lesMatieres.add(uneMatiere);
        }
        return lesMatieres;
    }

    public ObservableList<SousMatiere> GetSousMatiereMatiere(String idMatiere) throws SQLException
    {
        ObservableList<SousMatiere> lesSousMatieres = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT matiere.sous_matiere\n" +
                "FROM matiere\n" +
                "where matiere.id = ?;");
        ps.setString(1, idMatiere);
        rs = ps.executeQuery();
        while(rs.next())
        {
            SousMatiere uneSousMatiere = new SousMatiere(rs.getInt(1),rs.getString(2));
            lesSousMatieres.add(uneSousMatiere);
        }
        return lesSousMatieres;
    }


    public ObservableList<String> GetLesSousMatieres(String designation) throws SQLException {
        ObservableList<String> lesSousMatieres = FXCollections.observableArrayList();

        // Requête SQL
        ps = uneCnx.prepareStatement("SELECT matiere.sous_matiere FROM matiere WHERE matiere.designation = ?");
        ps.setString(1, designation);
        rs = ps.executeQuery();

        while (rs.next()) {
            String sousMatiere = rs.getString("sous_matiere");
            String[] splitSousMatiere = sousMatiere.split("#");
            for (String item : splitSousMatiere) {
                if (!item.isEmpty()) {
                    lesSousMatieres.add(item);
                }
            }
        }

        return lesSousMatieres;
    }
    public ObservableList<Matiere> GetLesMatieres() throws SQLException
    {
        ObservableList<Matiere> lesMatieresObj = FXCollections.observableArrayList();

        ps = uneCnx.prepareStatement("SELECT matiere.id, matiere.designation, matiere.sous_matiere \n"
                +"FROM `matiere`\n");

        rs = ps.executeQuery();
        while(rs.next())
        {
            Matiere laMatiere = new Matiere(rs.getInt(1), rs.getString(2));
            lesMatieresObj.add(laMatiere);
        }
        return lesMatieresObj;
    }

    public int getIdMatiere(String designation) throws SQLException {
        ps = uneCnx.prepareStatement("SELECT matiere.id "
                +"FROM `matiere`" +
                "where designation = ? \n");
        ps.setString(1,designation);
        rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
}
