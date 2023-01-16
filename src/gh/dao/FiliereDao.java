/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;

import gh.bean.Filiere;
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
public class FiliereDao {
    private PreparedStatement statement;
    Connection con;
    
    public FiliereDao(){
     
        con =  Connexion.getConnexion();       
    }
              
    public void createFiliere(Filiere fil){
       
        try {
            String query="insert into filiere(NomFiliere,SigleFiliere) values(?,?)";
            statement = con.prepareStatement(query); 
            statement.setString(1, fil.getNomFiliere());
            statement.setString(2, fil.getSigleFiliere());
            statement.executeUpdate();
            
            System.out.println("La filiere "+fil.getNomFiliere()+" est bien créée");
        } catch (SQLException ex) {
            Logger.getLogger(FiliereDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Filiere non créée");
        }
    }
    
    public void  deleteFiliereById (int id){
        try {
            String query = "delete from filiere where idFiliere = ?";
              statement = con.prepareStatement(query); 
              statement.setInt(1, id);
              statement.executeUpdate();
              
              System.out.println("La filiere avec l'id: "+id+" est supprimée");
              
        } catch (SQLException ex) {
            System.out.println("Esneignant non supprimée");
            Logger.getLogger(FiliereDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
