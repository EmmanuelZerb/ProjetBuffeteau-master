package sio.helplerebours.Entities;

public class Matiere {
    private int id;
    private String designation;



    public Matiere(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public int getId() {
        return id;
    }
}
