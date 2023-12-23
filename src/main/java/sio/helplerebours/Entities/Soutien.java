package sio.helplerebours.Entities;

import java.sql.SQLException;

public class Soutien {

    private int idDemande;
    private int idCompetence;
    private String dateDuSoutient;
    private String dateUptdated;
    private String description;
    private int status;

    public Soutien(int idDemande, int idCompetence, String dateDuSoutient, String dateUptdated, String description) {
        this.idDemande = idDemande;
        this.idCompetence = idCompetence;
        this.dateDuSoutient = dateDuSoutient;
        this.dateUptdated = dateUptdated;
        this.description = description;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public String getDateDuSoutient() {
        return dateDuSoutient;
    }

    public String getDateUptdated() {
        return dateUptdated;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }
}
