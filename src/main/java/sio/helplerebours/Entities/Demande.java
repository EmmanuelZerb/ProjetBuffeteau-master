package sio.helplerebours.Entities;

public class Demande {

    private int id;

    private int dateUpdatedDemande;

    private int dateFinDemande;

    private String sousMatiere;

    private int idUser;

    private int idMatiere;

    private int status;


    public Demande(int id, int dateUpdatedDemande, int dateFinDemande, String sousMatiere, int idUser, int idMatiere, int status) {
        this.id = id;
        this.dateUpdatedDemande = dateUpdatedDemande;
        this.dateFinDemande = dateFinDemande;
        this.sousMatiere = sousMatiere;
        this.idUser = idUser;
        this.idMatiere = idMatiere;
        this.status = status;
    }



}
