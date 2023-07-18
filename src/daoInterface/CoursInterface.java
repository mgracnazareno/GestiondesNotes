/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import java.util.List;
import model.Cours;

/**
 *
 * @author mgrac
 */
public interface CoursInterface {
    public int addCours(Cours c);
    public int deleteCours(String coursId);
    public List<Cours> findAll();
}
