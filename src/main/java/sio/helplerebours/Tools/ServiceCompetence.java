package sio.helplerebours.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.helplerebours.Entities.Competence;
import sio.helplerebours.Entities.Matiere;
import sio.helplerebours.Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ServiceCompetence {
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServiceCompetence()
    {
        uneCnx = ConnexionBDD.getCnx();
    }

    public void insertCompetence(Competence uneCompetence) throws SQLException, SQLException {
            ps = uneCnx.prepareStatement("INSERT INTO competence (competence.sous_matiere, competence.id_user,competence.id_Matiere, competence.statut)\n" +
                    "        VALUES (?, ?, ?, ?);");
            ps.setString(1, uneCompetence.getSousMatiere());
            ps.setInt(2, uneCompetence.getIdUser());
            ps.setInt(3, uneCompetence.getIdMatiere());
            ps.setInt(4, 1);
            ps.executeUpdate();
    }

    public ObservableList<Competence> getToutesLesCompetences(int idUser) throws SQLException {
        ObservableList<Competence> lesCompetences = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT matiere.designation, competence.sous_matiere ,competence.id " +
                "FROM competence \n " +
                "JOIN matiere ON competence.id_matiere = matiere.id "+
                "WHERE competence.id_user = ? ");

        ps.setInt(1, idUser);
        rs = ps.executeQuery();
        while(rs.next()){
            Competence uneCompetence = new Competence(rs.getInt(3),rs.getString(1),rs.getString(2));
            lesCompetences.add(uneCompetence);
        }
        return lesCompetences;
    }
    public void updateCompetence(int id,String sousMatieres) throws SQLException {
        ps = uneCnx.prepareStatement("UPDATE competence "
                + "SET sous_matiere = ? "
                + "WHERE competence.id = ? ");

        ps.setString(1, sousMatieres);
        ps.setInt(2, id);
        ps.executeUpdate();

    }

    public void deleteCompetence(int id) throws SQLException {
        ps = uneCnx.prepareStatement("DELETE FROM competence "
                + "WHERE id = ? ");

        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public HashMap<Integer, ArrayList<String>> getMesCompetences(int idUser) throws SQLException {
        HashMap<Integer, ArrayList<String>> lescompetences = new HashMap<>();
        ArrayList<String> mesCompetences = new ArrayList<>();
        ps = uneCnx.prepareStatement("SELECT competence.sous_matiere ,competence.id "
                + "FROM competence "
                + "WHERE competence.id_user = ?");

        ps.setInt(1, idUser);
        rs = ps.executeQuery();
        while (rs.next()) {
            String competences = rs.getString("sous_matiere");
            String[] splitSousMatiere = competences.split("#");
            for (String uneSousMatiere : splitSousMatiere) {
                if (!uneSousMatiere.isEmpty()) {
                    mesCompetences.add(uneSousMatiere);
                }
            }
            lescompetences.put(rs.getInt(2),mesCompetences);
        }
        return lescompetences ;
    }
    public int getUneCompetenceUser(int idUser,String nomMatiere) throws SQLException {
        ps = uneCnx.prepareStatement("SELECT competence.id "
                + "FROM competence " +
                "JOIN matiere on matiere.id = competence.id_matiere "
                + "WHERE competence.id_user = ? " +
                "AND matiere.designation = ? ");
        ps.setInt(1, idUser);
        ps.setString(2, nomMatiere);
        rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
}
