/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;


import gh.bean.Users;
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
public class UsersDao {
    private PreparedStatement statement;
    Connection con;
    
    public UsersDao (){
     
        con =  Connexion.getConnexion();
             
    }
    
    public void createUsers (Users us){
       
        try {
            String query="insert into comptable (dbUsername,dbPassword ) values(?,?)";
            statement = con.prepareStatement(query); 
            statement.setString(1, us.getDbUserNam());
            statement.setString(2, us.getDbPassw());
            statement.executeUpdate();
            
            System.out.println("L'utilisateur: "+us.getDbUserNam()+" est bien créé");
             
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Utilisateur non créé");
        }
    }
    
    public void  deleteUsersById (int id){
        try {
            String query = "delete from comptable where idUtilisateur = ?";
              statement = con.prepareStatement(query); 
              statement.setInt(1, id);
              statement.executeUpdate();
              
              System.out.println("L'utilisateur avec l'id: "+id+" est supprimé");
              
              //JOptionPane.showMessageDialog(null, "L'enseignant "+nom+"est supprimé !!!");
        } catch (SQLException ex) {
            System.out.println("Utilisateur non supprimé");
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
