/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;

import gh.bean.Enseigner;
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
public class EnseignerDao {
    private PreparedStatement statement;
    Connection con;
    
    public EnseignerDao (){
     
        con =  Connexion.getConnexion();
             
    }
    
    public void createEnseignerInfos (Enseigner ensei){
       
        try {
            String query="insert into enseigner(idEnseignant ,idMatiere,idAnnee,idSemestre,HeureEcouler) values(?,?,?,?,?)";
            statement = con.prepareStatement(query); 
            statement.setInt(1, ensei.getIdEnseignan());
            statement.setInt(2, ensei.getIdMatier());
            statement.setInt(3, ensei.getIdAnne());
            statement.setInt(4, ensei.getIdSemestr());
            statement.setString(5, ensei.getHeureEcoulee().toString());
            statement.executeUpdate();
            
            System.out.println("créé");
             
            
        } catch (SQLException ex) {
            Logger.getLogger(EnseignerDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Non créé");
        }
    }
}
