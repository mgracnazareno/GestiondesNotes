/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mgrac
 */
public class Cours {
    private String coursId;
    private String nomCours;

    public Cours(String coursId, String nomCours) {
        this.coursId = coursId;
        this.nomCours = nomCours;
    }

    public Cours() {
    }

    public Cours(String coursId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCoursId() {
        return coursId;
    }

    public void setCoursId(String coursId) {
        this.coursId = coursId;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    @Override
    public String toString() {
        return "Cours{" + "coursId=" + coursId + ", nomCours=" + nomCours + '}';
    }       
}
