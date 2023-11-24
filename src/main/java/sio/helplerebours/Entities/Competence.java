package sio.helplerebours.Entities;

public class Competence {
    private int id;

    private int idMatiere;

    private int idUser;

    private String sousMatiere;

    private int statut;

    public Competence(int id, int idMatiere, int idUser, String sousMatiere, int statut) {
        this.id = id;
        this.idMatiere = idMatiere;
        this.idUser = idUser;
        this.sousMatiere = sousMatiere;
        this.statut = statut;
    }



}
