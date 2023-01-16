/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.dao;

import gh.bean.Annee;
import gh.bean.Semestre;
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
public class SemestreDao {
    private PreparedStatement statement;
    Connection con;
    
    public SemestreDao (){
     
        con =  Connexion.getConnexion();
             
    }
    
    /*public void createSemestre (Semestre sem){
       
        try {
            String query="insert into  semestre (idAnnee,idSemestre,NomSemestre,idParcours) values(?,?,?,?)";
            statement = con.prepareStatement(query); 
            statement.setString(1, sem.getNomSemestre());
            statement.executeUpdate();
            
            System.out.println("Le semestre: "+sem.getNomSemestre()+" est bien créé");
             
            
        } catch (SQLException ex) {
            Logger.getLogger(SemestreDao.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Annee non créé");
        }
    }*/
}
