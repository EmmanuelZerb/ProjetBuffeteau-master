package sio.helplerebours.Entities;

public class Matiere {
    private String designation;

    private String sousMatiere;

    public Matiere(String designation, String sousMatiere) {
        this.designation = designation;
        this.sousMatiere = sousMatiere;
    }

    public Matiere(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
