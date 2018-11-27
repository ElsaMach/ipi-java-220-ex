package com.ipiecoles.java.java220;
import java.lang.String;
import java.util.Objects;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {

    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    /**
     * Getter de nom
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Setter de nom
     * @param name
     */
    public void setNom(String name){
        this.nom = name;
    }

    /**
     * Getter de prenom
     * @return prenom
     */
    public String getPrenom(){
        return this.prenom;
    }

    /**
     * Setter de prenom
     * @param surname
     */

    public void setPrenom(String surname){
        this.prenom = surname;
    }

    /**
     * Getter de matricule
     * @return matricule
     */
    public String getMatricule(){
        return this.matricule;
    }

    /**
     * Setter de matricule
     * @param mat
     */
    public void setMatricule(String mat){
        this.matricule = mat;
    }

    /**
     * Getter de dateEmbauche
     * @return dateEmbauche
     */

    public LocalDate getDateEmbauche(){
        return this.dateEmbauche;
    }

    /**
     * Setter de dateEmbauche
     * @param dateE
     */
    public void setDateEmbauche(LocalDate dateE) throws Exception{
        if(dateE != null && dateE.isAfter(LocalDate.now())){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateE;
    }


    /**
     * Getter de salaire
     * @return salaire
     */

    public Double getSalaire(){
        return this.salaire;
    }

    /**
     * Setter de salaire
     * @param sal
     */
    public void setSalaire(Double sal){
        this.salaire = sal;
    }

    /**
     * Constructeur par défaut
     */
    public Employe(){

    }

    /**
     * Constructeur de la classe Employe
     * @param nom
     * @param prenom
     * @param matricule
     * @param dateEmbauche
     * @param salaire
     */
    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;

    }

    /**
     *  méthode getNombreAnneeAnciennete calculant le nombre d'année d'ancienneté d'un employe
     */
    public final Integer getNombreAnneeAnciennete(){
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }

    public Integer getNbConges() {
        return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public String toString(){
        return "Employe{"+"nom='"+nom+"', prenom='"+prenom+"', matricule='"+matricule+"', dateEmbauche="+dateEmbauche+", salaire="+salaire+"}";
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Employe)) return false;

        Employe employe = (Employe) o;

        if (Double.compare(employe.salaire, salaire) != 0) return false;
        if (nom != null ? !nom.equals(employe.nom) : employe.nom != null) return false;
        if (prenom != null ? !prenom.equals(employe.prenom) : employe.prenom != null) return false;
        if (matricule != null ? !matricule.equals(employe.matricule) : employe.matricule != null) return false;
        return dateEmbauche != null ? dateEmbauche.equals(employe.dateEmbauche) : employe.dateEmbauche == null;

    }


    public int hashCode(){
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    public void augmenterSalaire(Double pourcentage) {
        this.salaire = this.getSalaire() * (1 + pourcentage);
    }
    public abstract Double getPrimeAnnuelle();



}