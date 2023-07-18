/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import java.util.List;
import model.Notes;


/**
 *
 * @author mgrac
 */
public interface NotesInterface {
    public int addNote(Notes note);
    public int deleteNote(int etudiantId);
    public List<Notes> findAll();
}
