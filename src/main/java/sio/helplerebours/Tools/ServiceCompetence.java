package sio.helplerebours.Tools;

import sio.helplerebours.Entities.Competence;
import sio.helplerebours.Entities.Matiere;

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

    public void getComboBoxCompetence(String designation) throws SQLException{

        ps = uneCnx.prepareStatement(
                "SELECT matiere.designation" +
                "FROM matiere");

        rs = ps.executeQuery();

        Matiere matiere = null;

      /*  if(rs.next()){
            matiere = new Matiere(rs.getString(2));
        }
        return matiere;

       */
    }
}
