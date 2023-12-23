package sio.helplerebours.Tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sio.helplerebours.Entities.Demande;
import sio.helplerebours.Entities.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ServiceDemande {

    private Connection uneCnx;
    private PreparedStatement ps;
    private ResultSet rs;
    ServiceCompetence serviceCompetence = new ServiceCompetence();
    public ServiceDemande() {
        uneCnx = ConnexionBDD.getCnx();
    }


    public ObservableList<Matiere> GetMatiere() throws SQLException
    {
        ObservableList lesMatieres=FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("select id,designation from matiere");
        rs = ps.executeQuery();
        while (rs.next())
        {
            Matiere laMatiere  = new Matiere(rs.getInt(1),rs.getString(2));
            lesMatieres.add(laMatiere);
        }
        return lesMatieres;
    }
    public void updateDemande(String dateDebut, String dateFin, String lesSousMatieres, int idDemande) throws SQLException {
        // Vous devez exécuter une requête UPDATE pour modifier la demande.
        ps = uneCnx.prepareStatement("UPDATE demande "
                + "SET date_updated = ?, date_fin_demande = ?, sous_matiere = ? "
                + "WHERE demande.id = ? ");

        ps.setString(1, dateDebut);
        ps.setString(2, dateFin);
        ps.setString(3, lesSousMatieres);
        ps.setInt(4, idDemande);

        ps.executeUpdate();
        ps.close();
    }

    public void insertDemande(Demande uneDemande) throws SQLException {
        ps = uneCnx.prepareStatement("INSERT INTO demande (demande.date_fin_demande, demande.date_updated, demande.sous_matiere, demande.id_user, demande.id_matiere, demande.status)\n" +
                "        VALUES (?, ?, ?, ?, ?, ?);");
        ps.setString(1, uneDemande.getDateLimite());
        ps.setString(2, uneDemande.getDateUpdate());
        ps.setString(3, uneDemande.getSousMatiere());
        ps.setInt(4, uneDemande.getIdUser());
        ps.setInt(5, uneDemande.getIdMatiere());
        ps.setInt(6, 1);
        ps.executeUpdate();
        ps.close();
    }

    public ObservableList<Demande> getToutesLesDemandes(int userId ) throws SQLException {
        ObservableList<Demande> mesDemandes = FXCollections.observableArrayList();
        ps = uneCnx.prepareStatement("SELECT demande.id, demande.date_fin_demande, matiere.designation, demande.sous_matiere " +
                                        " FROM demande " +
                                        " JOIN matiere ON demande.id_matiere = matiere.id " +
                                        " WHERE demande.id_user = ?");

        ps.setInt(1, userId);
        rs = ps.executeQuery();
        while (rs.next()) {
            int idMatiere = rs.getInt("demande.id");
            String sousMatiere = rs.getString("demande.sous_matiere");
            String dateFin = rs.getString("demande.date_fin_demande");
            String designationMatiere = rs.getString("matiere.designation");

            Demande uneDemande = new Demande(idMatiere,designationMatiere,sousMatiere,dateFin);
            mesDemandes.add(uneDemande);
        }
      return  mesDemandes;
    }
    public ObservableList<Demande> getlesAutresDemandes(int idUser) throws SQLException {
        HashMap<Integer, ArrayList<String>> mesCompetences= serviceCompetence.getMesCompetences(idUser);
        ServiceUser serviceUsers=new ServiceUser();
        int leIntNiveau = serviceUsers.getNiveau(idUser);
        ps = uneCnx.prepareStatement("SELECT user.id, user.nom, user.prenom, user.niveau, demande.id, demande.id_matiere, demande.date_updated, demande.date_fin_demande, matiere.designation, demande.sous_matiere "
                + "FROM demande "
                + "JOIN matiere ON demande.id_matiere = matiere.id "
                + "JOIN user ON user.id = demande.id_user "
                + "WHERE demande.id_user != ? "
                + "AND user.niveau <= ? "
                +"AND demande.status = 0");

        ps.setInt(1, idUser);

        int parametreNiveau = leIntNiveau - 2;
        ps.setInt(2, parametreNiveau);
        rs = ps.executeQuery();

        ObservableList<Demande> lesDemandes = FXCollections.observableArrayList();

        while (rs.next()) {
            String matiereDesignation = rs.getString("matiere.designation");
            String sousMatiere = rs.getString("demande.sous_matiere");
            String dateFin = rs.getString("demande.date_fin_demande");
            int idDemande = rs.getInt("demande.id");
            String[] splitSousMatiereDem = sousMatiere.split("#");
            String sousMatiereDem = "";
            for (String uneSousMatiere : splitSousMatiereDem) {
                if (!uneSousMatiere.isEmpty()) {
                    for (int idComp : mesCompetences.keySet()) {
                        for (String competence : mesCompetences.get(idComp)) {
                            if (uneSousMatiere.equals(competence)) {
                                sousMatiereDem += "#" + uneSousMatiere;
                            }
                        }
                    }
                }
            }
            if (!sousMatiereDem.equals("")) {
                Demande unedemande = new Demande(dateFin,idDemande, sousMatiere,matiereDesignation);
                lesDemandes.add(unedemande);
            }
        }
        return lesDemandes;
    }
}

