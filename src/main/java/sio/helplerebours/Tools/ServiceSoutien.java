package sio.helplerebours.Tools;

import sio.helplerebours.Entities.Soutien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ServiceSoutien {
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;
    public ServiceSoutien() {
        uneCnx = ConnexionBDD.getCnx();
    }

    public void InsertSoutient(Soutien soutien) throws SQLException {
        ps = uneCnx.prepareStatement("INSERT INTO soutien (id_demande, id_competence, date_du_soutien, date_updated,description, status) "+
                "VALUES (?,?,?,?,?,?)");

        ps.setInt(1, soutien.getIdDemande());
        ps.setInt(2, soutien.getIdCompetence());
        ps.setString(3, soutien.getDateDuSoutient());
        ps.setString(4, soutien.getDateUptdated());
        ps.setString(5, soutien.getDescription());
        ps.setInt(6, 1);
        ps.executeUpdate();
        ps.close();

        ps = uneCnx.prepareStatement("UPDATE Demande set status = ? " +
                "Where id= ? ");
        ps.setInt(1, 1);
        ps.setInt(2, soutien.getIdDemande());
        ps.executeUpdate();
        ps.close();

    }
}
