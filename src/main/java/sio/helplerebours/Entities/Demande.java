package sio.helplerebours.Entities;

public class Demande {

    private int idDemande;

    private int idUser;

    private int idMatiere;
    private String designation;

    private String sousMatiere;

    private String dateUpdate;

    private String dateLimite;
    private int Status;

    public Demande(int idUser, int idMatiere, String sousMatiere, String dateUpdate, String dateLimite, int status) {
        this.idUser = idUser;
        this.idMatiere = idMatiere;
        this.sousMatiere = sousMatiere;
        this.dateUpdate = dateUpdate;
        this.dateLimite = dateLimite;
        Status = status;
    }

    public Demande(int idDemande,String designation, String sousMatiere, String dateLimite) {
        this.idDemande = idDemande;
        this.designation = designation;
        this.sousMatiere = sousMatiere;
        this.dateLimite = dateLimite;
    }
    public Demande(String sousMatiere, String dateLimite,String dateUpdate,int idDemande) {
        this.idDemande = idDemande;
        this.sousMatiere = sousMatiere;
        this.dateLimite = dateLimite;
    }
    public Demande(String dateLimite,int idDemande,String sousMatiere, String designation) {
        this.idDemande = idDemande;
        this.sousMatiere = sousMatiere;
        this.dateLimite = dateLimite;
        this.designation =designation;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public String getSousMatiere() {
        return sousMatiere;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public String getDateLimite() {
        return dateLimite;
    }

    public int getStatus() {
        return Status;
    }
    public int getIdDemande() {
        return idDemande;
    }
    public String getDesignation() {
        return designation;
    }
}
