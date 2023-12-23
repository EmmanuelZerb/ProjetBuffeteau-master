package sio.helplerebours.Entities;

public class SousMatiere
{
    private int id;
    private String sousMatiere;

    public SousMatiere(int id, String sousMatiere) {
        this.id = id;
        this.sousMatiere = sousMatiere;
    }

    public int getId() {
        return id;
    }

    public String getSousMatiere() {
        return sousMatiere;
    }
}
