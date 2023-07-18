/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementation;

import connection.ConnectionFactory;
import daoInterface.CoursInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cours;

/**
 *
 * @author mgrac
 */
public class CoursDaoImp implements CoursInterface{
      Connection conn = ConnectionFactory.getConnection();
    
    public CoursDaoImp(){}

    @Override
    public int addCours(Cours cours) {
       PreparedStatement ps;
       int status = 0;       
       try{
           String createQuery = "INSERT INTO Cours (coursId, nomCours) VALUES(?,?)";
           ps = conn.prepareStatement(createQuery);
           ps.setString(1, cours.getCoursId());
           ps.setString(2, cours.getNomCours());   
           status = ps.executeUpdate();                             
       } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
      return status;  
    }

    @Override
    public int deleteCours(String id) {
        PreparedStatement ps;
        int status =0;
        try{
            String deleteQuery = "DELETE FROM cours WHERE coursId=?";
            ps = conn.prepareStatement(deleteQuery);
            ps.setString(1, id);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public List<Cours> findAll() {
        List<Cours> coursList = new ArrayList<Cours>();
        Cours cours;
        ResultSet rs;
        
        try{
            String selectAllQuery = "SELECT * FROM cours ORDER BY coursId";
            PreparedStatement ps = conn.prepareStatement(selectAllQuery);
            rs = ps.executeQuery();
            while(rs.next()){
                cours = new Cours();
                cours.setCoursId(rs.getString("coursId"));
                cours.setNomCours(rs.getString("nomCours"));
                coursList.add(cours);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coursList;
    }
}
