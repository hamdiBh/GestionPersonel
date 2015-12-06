package isims.gsc.gestionpersonel;

/**
 * Created by hamdi on 07/11/15.
 */
public class Personne {

    String nom,prenom,matricule,fonction;

    public  Personne(){

    }

    public Personne(String nom, String prenom, String matricule, String fonction) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.fonction = fonction;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", fonction='" + fonction + '\'' +
                '}';
    }
}
