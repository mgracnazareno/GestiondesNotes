/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.ConnectionFactory;
import daoInterface.EtudiantInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Etudiant;

/**
 *
 * @author mgrac
 */
public class EtudiantDaoImp implements EtudiantInt {
    Connection conn = ConnectionFactory.getConnection();
    
    public EtudiantDaoImp(){}

    @Override
    public int addStudent(Etudiant etudiant) {
       PreparedStatement ps;
       int status = 0;
       
       try{
           String createQuery = "INSERT INTO Etudiant (etudiantId, nom, prenom) VALUES(?,?,?)";
           ps = conn.prepareStatement(createQuery);
           ps.setInt(1, etudiant.getEtudiantId());
           ps.setString(2, etudiant.getNom());
           ps.setString(3, etudiant.getPrenom());
           status = ps.executeUpdate();                             
       } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
      return status;  
    }

    @Override
    public int deleteEtudiant(int id) {
        PreparedStatement ps;
        int status =0;
        try{
            String deleteQuery = "DELETE FROM etudiant WHERE etudiantId=?";
            ps = conn.prepareStatement(deleteQuery);
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiantList = new ArrayList<Etudiant>();
        Etudiant etudiant;
        ResultSet rs;
        
        try{
            String selectAllQuery = "SELECT * FROM etudiant ORDER BY etudiantId";
            PreparedStatement ps = conn.prepareStatement(selectAllQuery);
            rs = ps.executeQuery();
            while(rs.next()){
                etudiant = new Etudiant();
                etudiant.setEtudiantId(rs.getInt("etudiantId"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiantList.add(etudiant);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etudiantList;
    }

}
