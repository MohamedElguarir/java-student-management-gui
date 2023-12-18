package models;

public class Student {
    private int id;
    private String nom;
    private String prenom;
    private String filiere;
    private int age;
    private double moyenne;

    public Student(int id, String nom, String prenom, String filiere, int age, double moyenne) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.age = age;
        this.moyenne = moyenne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public String toString() {
        String st = "-ID: " + this.id + "\n";
        st += "-Nom: " + this.nom + "\n";
        st += "-Prenom: " + this.prenom + "\n";
        st += "-Filiere: " + this.filiere + "\n";
        st += "-Age: " + this.age + "\n";
        st += "-Moyenne: " + this.moyenne + "\n";
        return st;
    }

}
