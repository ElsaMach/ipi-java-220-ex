package com.ipiecoles.java.java220;
import com.ipiecoles.java.java220.Exceptions.TechnicienException;
import org.joda.time.LocalDate;

import java.util.Objects;


public class Technicien extends Employe implements Comparable<Technicien> {

    private Integer grade;

    /**
     * constructeur par défaut
     */
    public Technicien() {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade)throws TechnicienException {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.setGrade(grade);
    }


    public Double getPrimeAnnuelle() {
        return null;
    }

    /**
     *modification du getter de conges
     */
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }




    /**
     * getter de grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * setter de grade
     */
    public void setGrade(Integer grade) throws TechnicienException {
        if(grade <= 0 || grade > 5) {
            throw new TechnicienException(TechnicienException.GRADE, this, grade);
        }
        this.grade = grade;
    }

    /**
     * modification de set salaire
     * @param salaire
     */
    public void setSalaire(Double salaire){
        super.setSalaire( salaire * (1 + (double) grade / 10));
    }







    @Override
    public String toString() {
        return "Technicien{" +
                "grade=" + grade +
                "} " + super.toString();
    }

    /**
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technicien)) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }**/

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public int compareTo(Technicien o) {
        return 0;
    }
}
