package sio.helplerebours.Entities;

public class Competence {
    private String prenom;
    private String nom;
    private String classe;
    private String matiere;
    private String SousMatiere;
    private int DateLimite;

    public Competence(String prenom, String nom, String classe, String matiere, String sousMatiere, int dateLimite) {
        this.prenom = prenom;
        this.nom = nom;
        this.classe = classe;
        this.matiere = matiere;
        SousMatiere = sousMatiere;
        DateLimite = dateLimite;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getClasse() {
        return classe;
    }

    public String getMatiere() {
        return matiere;
    }

    public String getSousMatiere() {
        return SousMatiere;
    }

    public int getDateLimite() {
        return DateLimite;
    }
}
