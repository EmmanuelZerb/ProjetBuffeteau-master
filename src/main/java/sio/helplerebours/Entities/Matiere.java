package sio.helplerebours.Entities;

public class Matiere {

    private int id;

    private String designation;

    private int code;

    private String sousMatiere;

    public Matiere(int id, String designation, int code, String sousMatiere) {
        this.id = id;
        this.designation = designation;
        this.code = code;
        this.sousMatiere = sousMatiere;
    }

    public String getDesignation() {
        return designation;
    }
}
