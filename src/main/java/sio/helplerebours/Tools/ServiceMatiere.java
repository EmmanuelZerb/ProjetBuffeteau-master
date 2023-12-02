package sio.helplerebours.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.helplerebours.Entities.Matiere;
import sio.helplerebours.Entities.User;

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


    public ObservableList<Matiere> GetAllMatiere () throws SQLException {
        ObservableList<Matiere> lesMatieres = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT designation FROM matiere;");
        rs = ps.executeQuery();
        while(rs.next()){
            Matiere uneMatiere = new Matiere(rs.getString(1));
            lesMatieres.add(uneMatiere);
        }
        return lesMatieres;
    }
}
