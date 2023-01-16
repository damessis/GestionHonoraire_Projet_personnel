/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;

import gh.bean.Annee;
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
public class AnneeDao {
    private PreparedStatement statement;
    Connection con;
    
    public AnneeDao (){
     
        con =  Connexion.getConnexion();
             
    }
    
    public void createAnnee (Annee a){
       
        try {
            String query="insert into  anneeacademique (NomAnnee) values(?)";
            statement = con.prepareStatement(query); 
            statement.setString(1, a.getNomAnnee());
            statement.executeUpdate();
            
            System.out.println("L'annee: "+a.getNomAnnee()+" est bien créée");
             
            
        } catch (SQLException ex) {
            Logger.getLogger(AnneeDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Annee non créée");
        }
    }
    
    public void  deleteAnneeById (int id){
        try {
            String query = "delete from anneeacademique where idAnnee = ?";
              statement = con.prepareStatement(query); 
              statement.setInt(1, id);
              statement.executeUpdate();
              
              System.out.println("L'annee avec l'id: "+id+" est supprimée");
              
              //JOptionPane.showMessageDialog(null, "L'enseignant "+nom+"est supprimé !!!");
        } catch (SQLException ex) {
            System.out.println("Annee non supprimée");
            Logger.getLogger(AnneeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
