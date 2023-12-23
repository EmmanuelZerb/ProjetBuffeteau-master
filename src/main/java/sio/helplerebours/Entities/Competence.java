package sio.helplerebours.Entities;

public class Competence {
    private int id;
    private int idUser;
    private int idMatiere;
    private String designation;
    private String sousMatiere;


    public Competence(int idUser,int idMatiere,String sousMatiere) {
        this.idUser = idUser;
        this.idMatiere = idMatiere;
        this.sousMatiere = sousMatiere;
    }
    public Competence(String designation,String sousMatiere) {
        this.designation = designation;
        this.sousMatiere = sousMatiere;
    }
    public Competence(int id, String designation,String sousMatiere) {
        this.id = id;
        this.designation = designation;
        this.sousMatiere = sousMatiere;
    }

    public int getId() {
        return id;
    }

    public String getSousMatiere() {
        return this.sousMatiere;
    }
    public int getIdUser() {
        return idUser;
    }
    public int getIdMatiere() {
        return idMatiere;
    }

    public String getDesignation() {
        return designation;
    }
}
