
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhonoraire;

import com.sun.javafx.application.LauncherImpl;
import java.awt.SplashScreen;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 *
 * @author IDA(damessis)
 */
public class GestionHonoraire extends Application {
    
    private static final int COUNT_LIMIT = 10;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        
        Scene scene = new Scene(root);
        
        //Image logoGH = new Image (getClass().getResourceAsStream("logo GH.png"));
        
        stage.getIcons().add(new Image("/images/logoGH1.png"));
        
        stage.setTitle("Gestion d'honoraire");
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        
        //stage.setIconImage(logoGH.getImage());

    }
    
    @Override
    public void init() throws Exception {       
        
        // Perform some heavy lifting (i.e. database start, check for application updates, etc. )
        for (int i = 1; i <= COUNT_LIMIT; i++) {
            double progress =(double) i/10;
            System.out.println("progress: " +  progress);            
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
            Thread.sleep(500);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LauncherImpl.launchApplication(GestionHonoraire.class, MyPreloader.class, args);
    }
    
}
