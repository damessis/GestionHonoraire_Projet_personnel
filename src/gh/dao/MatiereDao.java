/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;


import gh.bean.Matiere;
import gh.db.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IDA(damessis)
 */
public class MatiereDao {
    
    private PreparedStatement statement;
    Connection con;
    
    public MatiereDao (){
     
        con =  Connexion.getConnexion();
             
    }
    
    
    public void createMatiere (Matiere mat  ){
       
        try {
            String query="insert into matiere(NomMatiere,heureInit) values(?,?)";
            statement = con.prepareStatement(query); 
            statement.setString(1, mat.getNomMatiere());
            statement.setString(2, mat.getHeureInit().toString());
            statement.executeUpdate();
            
            System.out.println("La matiere: "+mat.getNomMatiere()+" est bien créée");
             
            
        } catch (SQLException ex) {
            Logger.getLogger(MatiereDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Matiere non créée");
        }
    }
    
    public void  deleteMatiereById (int id){
        try {
            String query = "delete from matiere where idMatiere = ?";
              statement = con.prepareStatement(query); 
              statement.setInt(1, id);
              statement.executeUpdate();
              
              System.out.println("La matiere avec l'id: "+id+" est supprimé");
              
        } catch (SQLException ex) {
            System.out.println("Esneignant non supprimé");
            Logger.getLogger(MatiereDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
