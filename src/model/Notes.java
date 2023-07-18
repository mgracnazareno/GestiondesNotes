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
public class Notes {
   
    private Etudiant etudiantId;
    private Cours coursId;
     private double note1;
    private double note2;

    public Notes(Etudiant etudiantId, Cours coursId, double note1, double note2) {
        this.etudiantId = etudiantId;
        this.coursId = coursId;
        this.note1 = note1;
        this.note2 = note2;
        
    }

    public Notes() {
    }

    public double getNote1() {
        return note1;
    }

    public void setNote1(double note1) {
        this.note1 = note1;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public Etudiant getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Etudiant etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Cours getCoursId() {
        return coursId;
    }

    public void setCoursId(Cours coursId) {
        this.coursId = coursId;
    }

    @Override
    public String toString() {
        return "Notes{" + "note1=" + note1 + ", note2=" + note2 + ", etudiantId=" + etudiantId + ", coursId=" + coursId + '}';
    }
}
