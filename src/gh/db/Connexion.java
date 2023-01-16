/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IDA(damessis)
 */
public class Connexion {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_honoraire";
    static final String USER = "adminDamessi";
    static final String PASS = "1234";
    static Statement statement = null;  
    static Connection connection = null;

public static Connection  getConnexion ()
    {
       
        try {
            Class.forName( JDBC_DRIVER );
      
            connection = DriverManager.getConnection( DATABASE_URL, USER, PASS);
            statement = connection.createStatement();
            System.out.println("Connexion bien établie !!!");

        } catch (ClassNotFoundException ex) {
           System.out.println("Impossible de trouver le pilote mysql");
        }
        catch (SQLException ex) {
             System.out.println("Base de données inacessible");
             System.out.println(ex.getMessage());
             
             return connection ;
            }
        finally
        {
           
        }
    return connection;
}
}
