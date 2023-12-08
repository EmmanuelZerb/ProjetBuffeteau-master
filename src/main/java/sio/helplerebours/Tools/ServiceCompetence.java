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

public class ServiceCompetence {
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServiceCompetence()
    {
        uneCnx = ConnexionBDD.getCnx();
    }

    public ObservableList<Competence> getCompetence() throws SQLException {
        ObservableList<Competence> lesCompetences = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT user.prenom, user.nom, user.niveau, matiere.designation, competence.sous_matiere, demande.date_fin_demande\n" +
                "FROM user\n" +
                "INNER JOIN matiere on user.id = matiere.id\n" +
                "INNER JOIN competence on matiere.id = competence.id\n" +
                "INNER JOIN demande on competence.id = demande.id;");
        rs = ps.executeQuery();
        while(rs.next()){
            Competence uneCompetence = new Competence(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            lesCompetences.add(uneCompetence);
        }
        return lesCompetences;
    }
}
