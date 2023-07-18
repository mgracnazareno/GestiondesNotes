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
public class Etudiant {
    private int etudiantId;
    private String nom;
    private String prenom;

    public Etudiant(int etudiantId, String nom, String prenom) {
        this.etudiantId = etudiantId;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant() {
    }

    public Etudiant(int etudiantId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
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

    @Override
    public String toString() {
        return "Etudiant{" + "etudiantId=" + etudiantId + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
}
