/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;

import gh.bean.Filiere;
import gh.bean.Parcours;
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
public class ParcoursDao {
    private PreparedStatement statement;
    Connection con;
    
    public ParcoursDao(){
     
        con =  Connexion.getConnexion();       
    }
    
    public void createParcours(Parcours par){
       
        try {
            String query="insert into parcours(NomParcours) values(?)";
            statement = con.prepareStatement(query); 
            statement.setString(1, par.getNomParcours());
            statement.executeUpdate();
            
            System.out.println("Le Parcours "+par.getNomParcours()+" est bien créé");
        } catch (SQLException ex) {
            Logger.getLogger(ParcoursDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Parcours non créé");
        }
    }
              
    public void createCoutParcours(Parcours cout){
       
        try {
            String query="update parcours set cout=? where nomParcours=?";
            statement = con.prepareStatement(query); 
            statement.setDouble(1, cout.getCout());
            statement.setString(2, cout.getNomParcours());
            statement.executeUpdate();
            
            System.out.println("Le cout du parcours "+cout.getNomParcours()+" est bien créé");
        } catch (SQLException ex) {
            Logger.getLogger(ParcoursDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Cout parcours non créé");
        }
    }
    
    public void  deleteParcoursById (int id){
        try {
            String query = "delete from parcours where idParcours = ?";
              statement = con.prepareStatement(query); 
              statement.setInt(1, id);
              statement.executeUpdate();
              
              System.out.println("Le parcours avec l'id: "+id+" est supprimé");
              
              //JOptionPane.showMessageDialog(null, "L'enseignant "+nom+"est supprimé !!!");
        } catch (SQLException ex) {
            System.out.println("Parcours non supprimé");
            Logger.getLogger(ParcoursDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
