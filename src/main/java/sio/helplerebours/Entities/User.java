package sio.helplerebours.Entities;

public class User {

    private int id;

    private String email;

    private String password;

    private String nom;

    private String prenom;

    private String role;

    private int sexe;

    private int telephone;

    private String niveau;


    public User(int id, String email, String password, String nom, String prenom, String role, int sexe, int telephone, String niveau) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.sexe = sexe;
        this.telephone = telephone;
        this.niveau = niveau;
    }


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRole() {
        return role;
    }

    public int getSexe() {
        return sexe;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getNiveau() {
        return niveau;
    }
}
