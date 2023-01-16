/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;

import gh.bean.Enseignant;
import gh.db.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author IDA(damessis)
 */
public class EnseignantDao {
    private PreparedStatement statement;
    Connection con;
    
    public EnseignantDao (){
     
        con =  Connexion.getConnexion();
             
    }
    
    public void createEnseignant (Enseignant ens){
       
        try {
            String query="insert into enseignant(NomEnseignant,PrenomE,Tel,Email,Adresse) values(?,?,?,?,?)";
            statement = con.prepareStatement(query); 
            statement.setString(1, ens.getNomEnseignant());
            statement.setString(2, ens.getPrenomEnseignant());
            statement.setInt(3, ens.getTelEnseignant());
            statement.setString(4, ens.getEmailEnseignant());
            statement.setString(5, ens.getAdresseEnseignant());
            statement.executeUpdate();
            
            System.out.println("L'enseignant: "+ens.getNomEnseignant()+" est bien créé");
             
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Enseignant non créé");
        }
    }
    
    
//    public void  findEnseignantByNom (String nom)
//        {
//            
//            ObservableList<Enseignant> listeFind = FXCollections.observableArrayList();
//            
//        try {
//            String query="select * from enseignant where NomEnseignant = ?";
//            
//                statement = con.prepareStatement(query); 
//                statement.setString (1, nom);
//           
//                ResultSet result = statement.executeQuery();
//           
//            while(result.next())
//            {
//                /*System.out.println("Enseignant id : "+result.getInt("idEnseignant")+" Enseignant nom :"+result.getString("NomEnseignant")+"Enseignant prenom"+
//                        result.getString("PrenomE"));*/
//                listeFind.add(new Enseignant(result.getInt("idEnseignant"),result.getString("NomEnseignant"),result.getString("PrenomE"),
//                        result.getInt("Tel"),result.getString("Email"),result.getString("Adresse")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void  deleteEnseignantById (int id){
        try {
            String query = "delete from enseignant where idEnseignant = ?";
              statement = con.prepareStatement(query); 
              statement.setInt(1, id);
              statement.executeUpdate();
              
              System.out.println("L'enseignant avec l'id: "+id+" est supprimé");
              
              //JOptionPane.showMessageDialog(null, "L'enseignant "+nom+"est supprimé !!!");
        } catch (SQLException ex) {
            System.out.println("Esneignant non supprimé");
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
