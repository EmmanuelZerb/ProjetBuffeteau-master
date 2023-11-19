package sio.helplerebours.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServiceCompetence {
    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServiceCompetence()
    {
        uneCnx = ConnexionBDD.getCnx();
    }
}
