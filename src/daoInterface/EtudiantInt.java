/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import java.util.List;
import model.Etudiant;

/**
 *
 * @author mgrac
 */
public interface EtudiantInt {
    public int addStudent(Etudiant e);
    public int deleteEtudiant(int id);
    public List<Etudiant> findAll();
}
