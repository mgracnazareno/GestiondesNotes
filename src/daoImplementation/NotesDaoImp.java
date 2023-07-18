/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionFactory;
import daoInterface.NotesInterface;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cours;
import model.Etudiant;
import model.Notes;

/**
 *
 * @author mgrac
 */
public class NotesDaoImp implements NotesInterface {

    Connection conn = ConnectionFactory.getConnection();

    public NotesDaoImp() {
    }

    @Override
    public int addNote(Notes note) {
        PreparedStatement ps;
        int status = 0;
        try {
            String createQuery = "INSERT INTO notes (etudiantId, coursId, note1, note2) VALUES(?,?,?,?)";
            ps = conn.prepareStatement(createQuery);
            ps.setInt(1, note.getEtudiantId().getEtudiantId());
            ps.setString(2, note.getCoursId().getCoursId());
            ps.setDouble(3, note.getNote1());
            ps.setDouble(4, note.getNote2());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public int deleteNote(int etudiantId) {
        PreparedStatement ps;
        int status = 0;

        try {
            String deleteQuery = "DELETE FROM notes WHERE etudiantId=?";
            ps = conn.prepareStatement(deleteQuery);
            ps.setInt(1, etudiantId);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotesDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public List<Notes> findAll() {
        List<Notes> listNote = new ArrayList<Notes>();
        Notes note;
        ResultSet rs;
        try {
            String selectAllQuery = "SELECT * FROM notes ORDER BY etudiantId";
            PreparedStatement ps = conn.prepareStatement(selectAllQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                note = new Notes();
                Etudiant etud = new Etudiant();
                Cours cours = new Cours();
                
                etud.setEtudiantId(rs.getInt("etudiantId"));
                cours.setCoursId(rs.getString("coursId"));

                note.setEtudiantId(etud);
                note.setCoursId(cours);
                note.setNote1(rs.getDouble("note1"));
                note.setNote2(rs.getDouble("note2"));
                listNote.add(note);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNote;
    }

}
