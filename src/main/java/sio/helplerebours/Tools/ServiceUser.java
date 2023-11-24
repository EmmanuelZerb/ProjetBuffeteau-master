package sio.helplerebours.Tools;

import sio.helplerebours.Entities.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceUser {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;


    public ServiceUser(){
        uneCnx = ConnexionBDD.getCnx();
    }


    public User GetConnectionUser(String email, String password) throws SQLException {

        ps = uneCnx.prepareStatement("SELECT user.id, user.email, user.password, user.nom, user.prenom, user.role, user.sexe, user.telephone, user.niveau\n" +
                "FROM user\n" +
                "where user.email = ?" +
                "and user.password = ?;");
        ps.setString(1,email);
        ps.setString(2,password);

        rs = ps.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
        }
        return user;
    }


}
