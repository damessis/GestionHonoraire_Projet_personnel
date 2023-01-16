/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhonoraire;

import gh.bean.Annee;
import gh.bean.CompEnsei;
import gh.dao.EnseignantDao;
import gh.bean.Enseignant;
import gh.bean.Semestre;
import gh.bean.Enseigner;
import gh.bean.Matiere;
import gh.dao.FiliereDao;
import gh.bean.Filiere;
import gh.bean.Parcours;
import gh.bean.Users;
import gh.dao.AnneeDao;
import gh.dao.EnseignerDao;
import gh.dao.MatiereDao;
import gh.dao.ParcoursDao;
import gh.dao.SemestreDao;
import gh.dao.UsersDao;
import gh.db.Connexion;
import java.awt.SplashScreen;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author IDA(damessis)
 */
public class FXMLDocumentController implements Initializable {
    
    // splash screen...
    
    @FXML
    private ProgressBar progressGH;
    public static ProgressBar statProgressBar;
    
    @FXML
    private Label progress;
    public static Label label;
    
    //login page...
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Button btnLogin;
    
     @FXML
    private Button btnDeconnexion;
    
    @FXML
    private Button btnBack;
    
    // erreurs...
    
    @FXML
    private Label errorNom;

    @FXML
    private Label errorPrenom;
    
    @FXML
    private Label errorTel;
    
    // users...
    
    @FXML
    private Button btnUsers;
    
    @FXML
    private TextField txtIdUsers;

    @FXML
    private TextField txtPassw;

    @FXML
    private Button btnValiUsers;

    @FXML
    private TextField txtDeleteUsers;

    @FXML
    private TableView<Users> tableUsers;

    @FXML
    private TableColumn<Users, Integer> col_idUsers;

    @FXML
    private TableColumn<Users, String> col_userNam;

    @FXML
    private TableColumn<Users, String> col_passsw;

    @FXML
    private Button btnActuUsers;

    @FXML
    private Button btnDelUSer;
    
    //password forget...
    
    @FXML
    private TextField txtUsernamePassw;

    @FXML
    private Button btnPasswForget;

    @FXML
    private TableView<Users> tablePass;

    @FXML
    private TableColumn<Users, Integer> col_iden;

    @FXML
    private TableColumn<Users, String> col_passw;
    
    @FXML
    private Hyperlink passworForgetPage;
    
    
    @FXML
    private Button btnEnseignant;
    
    @FXML
    private Button btnValiderEnseignant;
    
    @FXML
    private Button btnAfficherEnseignant;

    @FXML
    private Button btnActualiserEnseignant1;

    @FXML
    private Button btnOKresearchEnsei;

    @FXML
    private Button btnOKdeleteEnsei;

    @FXML
    private Button btnMatiere;
    
    @FXML
    private Button btnValiderMatiere;
    
    @FXML
    private Button btnAfficherMatiere;
    
    @FXML
    private TextField txtResearchMat;

    @FXML
    private TextField txtDeleteMat;

    @FXML
    private Button btnOKresearchMat;

    @FXML
    private Button btnOKdeleteMat;

    @FXML
    private Button btnFiliere;
    
     @FXML
    private TextField txtNomF;

    @FXML
    private TextField txtSigle;

    @FXML
    private Button btnValiderFiliere;
    
     @FXML
    private TableView<Filiere> tableFiliere;

    @FXML
    private TableColumn<Filiere, Integer> col_idF;

    @FXML
    private TableColumn<Filiere, String> col_nomF;

    @FXML
    private TableColumn<Filiere, String> col_sigleF;
    
     @FXML
    private Button btnAfficherFiliere;
   

    @FXML
    private TextField txtResearchFil;

    @FXML
    private TextField txtDeleteFil;

    @FXML
    private Button btnOKresearchFil;

    @FXML
    private Button btnOKdeleteFil;

    @FXML
    private Button btnParcours;
    
    @FXML
    private TextField txtParcours;

    @FXML
    private TableView<Parcours> tableParcours;

    @FXML
    private TableColumn<Parcours, Integer> col_idParcours;

    @FXML
    private TableColumn<Parcours, String> col_nomParcours;

    @FXML
    private Button btnValiderParcours;

    @FXML
    private Button btnAfficherParcours;
    
    @FXML
    private Button btnValiderCoutP;
    
    @FXML
    private TextField txtResearchPar;

    @FXML
    private TextField txtDeletePar;

    @FXML
    private Button btnOKresearchPar;

    @FXML
    private Button btnOKdeletePar;
    
    // semestre...
    @FXML
    private Button btnSemestre;
    
    @FXML
    private TextField txtIdAnnSem;

    @FXML
    private TextField txtIdSem;

    @FXML
    private TextField txtNomSem;

    @FXML
    private TextField txtIdParSem;

    @FXML
    private Button btnValiderSemestre;

    @FXML
    private TableView<Semestre> tableSemestre;

    @FXML
    private TableColumn<Semestre, Integer> col_idSem;

    @FXML
    private TableColumn<Semestre, String> col_nomSem;

    @FXML
    private Button btnAfficherSemestre;

    // Annee...
    @FXML
    private Button btnAnnee;
    
    @FXML
    private TableView<Annee> tableAnnee;

    @FXML
    private TableColumn<Annee, Integer> col_idA;

    @FXML
    private TableColumn<Annee, String> col_nomA;

    @FXML
    private TextField txtAnnee;

    @FXML
    private Button btnValiderAnnee;

    @FXML
    private Button btnAfficherAnnee;
    
    @FXML
    private TextField txtResearchAnn;

    @FXML
    private TextField txtDeleteAnn;

    @FXML
    private Button btnOKresearchAnn;

    @FXML
    private Button btnOKdeleteAnn;
    
    @FXML
    private TextField txtNomE;
    
    @FXML
    private TextField txtNomM;

    @FXML
    private TextField txtPrenom;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAdresse;
    
     @FXML
    private TextField txtHeure;
    
    @FXML
    private TableView<Enseignant> tableEnseignant;

    @FXML
    private TableColumn<Enseignant, Integer> col_idE;

    @FXML
    private TableColumn<Enseignant, String> col_nomE;

    @FXML
    private TableColumn<Enseignant, String> col_prenomE;

    @FXML
    private TableColumn<Enseignant, Integer> col_telE;

    @FXML
    private TableColumn<Enseignant, String> col_emailE;

    @FXML
    private TableColumn<Enseignant, String> col_adresseE;
    
    
    @FXML
    private TableView<Matiere> tableMatiere;
    
    @FXML
    private TableColumn<Matiere, Integer> col_idM;

    @FXML
    private TableColumn<Matiere, String> col_nomM;

    @FXML
    private TableColumn<Matiere, String> col_heureM;
    
    @FXML
    private TextField txtResearchEns;

    @FXML
    private TextField txtDeleteEns;
    
    //comptable...
    
    @FXML
    private Button btnEnseignantComp;
    
    @FXML
    private Button btnAfficherEnseignantComp;
    
      @FXML
    private TableView<Enseignant> tableEnseignantComp;
      
      @FXML
    private TableColumn<Enseignant, Integer> col_idEComp;

    @FXML
    private TableColumn<Enseignant, String> col_nomEComp;

    @FXML
    private TableColumn<Enseignant, String> col_prenomEComp;

    @FXML
    private TableColumn<Enseignant, Integer> col_telEComp;
    
    @FXML
    private Button btnCout;
    
    @FXML
    private TextField txtParc;
    
    @FXML
    private TextField txtCout;
    
    @FXML
    private Button btnBackComp;
    
    @FXML
    private Button btnAfficherCoutComp;
    
    @FXML
    private Button btnComptablePay;
    
    @FXML
    private TableView<Parcours> tableCoutComp;  
    
    @FXML
    private TableColumn<Parcours, Integer> col_idCoutComp;

    @FXML
    private TableColumn<Parcours, String> col_nomCoutComp;

    @FXML
    private TableColumn<Parcours, Integer> col_coutComp;
    
    // comptable payement...

    @FXML
    private TableView<CompEnsei> tableInfosEnseiComp;

    @FXML
    private TableColumn<CompEnsei, String> col_IDEnseignantComp;

    @FXML
    private TableColumn<CompEnsei, String> col_IDMatiereComp;

    @FXML
    private TableColumn<CompEnsei, String> col_IDAnneeComp;

    @FXML
    private TableColumn<CompEnsei, String> col_IDSemestreComp;

    @FXML
    private TableColumn<CompEnsei, String> col_IDHeurComp;

    @FXML
    private Button btnAfficherInfosEnsComp;

    @FXML
    private TextField txtNomEComp;

    @FXML
    private TextField txtParcoursComp;

    
    @FXML
    private Button btnPayer;
    
    //secretaire...
    
    @FXML
    private Button btnBackSecre2;
    
     @FXML
    private Button btnAffEnseiInfos;
    
    @FXML
    private Button btnAfficherInfosEnsSecre;
    
    @FXML
    private TableView<Enseigner> tableInfosEnseiSecre;
    
    @FXML
    private Button btnSecreFich;
    
    @FXML
    private TextField txtSecreIdEns;

    @FXML
    private TextField txtSecreIdMat;

    @FXML
    private TextField txtSecreIdAnn;

    @FXML
    private TextField txtSecreIdSem;

    @FXML
    private TextField txtSecreHeu;

    @FXML
    private Button btnValiderSecre;

    @FXML
    private TableView<Enseignant> tableInfos;

    @FXML
    private TableColumn<Enseignant, Integer> col_idSe;

    @FXML
    private TableColumn<Enseignant, String> col_nomSe;
    
    @FXML
    private TableView<Matiere> tableInfos2;

    @FXML
    private TableColumn<Matiere, Integer> col_idSe2;

    @FXML
    private TableColumn<Matiere, String> col_nomSe2;

    @FXML
    private TableView<Annee> tableInfos3;

    @FXML
    private TableColumn<Annee, Integer> col_idSe3;

    @FXML
    private TableColumn<Annee, String> col_nomSe3;

    @FXML
    private TableView<Semestre> tableInfos4;

    @FXML
    private TableColumn<Semestre, Integer> col_idSe4;

    @FXML
    private TableColumn<Semestre, String> col_nomSe4;

    @FXML
    private Button btnAffiInfoEns;

    @FXML
    private Button btnAffiInfoMat;

    @FXML
    private Button btnAffiInfoAnn;

    @FXML
    private Button btnAffiInfoSem;

    @FXML
    private Button btnBackSecre;
    
    // style...
    
    @FXML
    private Pane pane;
    
    //script passwforget...
    
     @FXML
    void passworForgetPageAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pagePasswordForget.fxml"));
        Stage scene = (Stage) passworForgetPage.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnPasswForgetAction(ActionEvent event) {
        ObservableList<Users> listePassw = FXCollections.observableArrayList();
        
        
        try {
            String pass = txtUsernamePassw.getText();
            
            System.out.println(pass);
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from users where dbUsersName = ?";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            statement.setString(1,pass);
                    
            ResultSet result = statement.executeQuery();
           
            if(result.next())
            {
                listePassw.add(new Users(result.getInt("idUsers"),result.getString("dbUsersName"),result.getString("dbUsersPassw")));
            }
            else{
                JOptionPane.showMessageDialog(null, "Identifiant invalide !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_iden.setCellValueFactory(new PropertyValueFactory<>("dbUserNam"));
        col_passw.setCellValueFactory(new PropertyValueFactory<>("dbPassw"));
        
        tablePass.setItems(listePassw);
    }
    
    //users...
    
    @FXML
    void btnUsersAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pageUsers.fxml"));
        Stage scene = (Stage) btnUsers.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnValiUsersAction(ActionEvent event) {
        String uid = txtIdUsers.getText();
        String upass = txtPassw.getText();
        
        UsersDao usDao = new UsersDao();
        Users us1 = new Users (uid,upass);
        usDao.createUsers(us1);
        
        System.out.println(uid+"\n"+upass);
        
        JOptionPane.showMessageDialog(null, "Utilisateur enregistrer !!!");
        
        txtIdUsers.setText(""); 
        txtPassw.setText("");
    }
    
     @FXML
    void btnActuUsersAction(ActionEvent event) {
        ObservableList<Users> listeUser = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from  comptable";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeUser.add(new Users(result.getInt("idUtilisateur"),result.getString("dbUsername"),result.getString("dbPassword")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idUsers.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        col_userNam.setCellValueFactory(new PropertyValueFactory<>("dbUserNam"));
        col_passsw.setCellValueFactory(new PropertyValueFactory<>("dbPassw"));
        
        tableUsers.setItems(listeUser);
    }
    
    @FXML
    void btnDelUSerAction(ActionEvent event) {
        System.out.println("Btn deleteUsers ok !");
        
        int us1 = Integer.parseInt(txtDeleteUsers.getText());
        System.out.println(us1);
        
        
        UsersDao usDao2 = new UsersDao();
        usDao2.deleteUsersById(us1);
        
        ObservableList<Users> listeUser = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from  comptable";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeUser.add(new Users(result.getInt("idUtilisateur"),result.getString("dbUsername"),result.getString("dbPassword")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idUsers.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        col_userNam.setCellValueFactory(new PropertyValueFactory<>("dbUserNam"));
        col_passsw.setCellValueFactory(new PropertyValueFactory<>("dbPassw"));
        
        tableUsers.setItems(listeUser);
        
        txtDeleteUsers.setText(""); 
    }

    
    
    // Login script...
    @FXML
    private void connexionLoginAction(ActionEvent event) throws Exception {
        System.out.println("Login page ok !");
        
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        if(username.equals("") && password.equals("")){
            JOptionPane.showMessageDialog(null, "identifiant et mot de passe svp !!!");
        }
        
        else if (!username.equals("") && !password.equals("")){
         try {                
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_honoraire", "root", "");
             
            PreparedStatement psta = con.prepareStatement("select * from comptable where dbUsername = ? and dbPassword = ?");
                
            psta.setString(1, username);
            psta.setString(2, password);
            
            ResultSet resultat = psta.executeQuery();
               
               if(resultat.next()){
                   JOptionPane.showMessageDialog(null, "Vous etes bien connecte a l'application !!!");
                   
                    Parent root = FXMLLoader.load(getClass().getResource("dashboardComptable.fxml"));
                    Stage scene = (Stage) btnLogin.getScene().getWindow();
                    scene.setScene(new Scene(root));
               }
               else{
                   try {
        // login comptable...               
               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/db_honoraire", "root", "");
               
               psta = con.prepareStatement("select * from admin where  	dbUsernameAdmin = ? and  dbPasswordAdmin = ?");
                
               psta.setString(1, username);
               psta.setString(2, password);
                
               resultat = psta.executeQuery();
        // login admin       
               if(resultat.next()){
                    JOptionPane.showMessageDialog(null, "Vous etes bien connecte a l'application !!!");
                    
                    Parent root = FXMLLoader.load(getClass().getResource("dashboardAdmin.fxml"));
                    Stage scene = (Stage) btnLogin.getScene().getWindow();
                    scene.setScene(new Scene(root));
                }
        // login secre
               else{
                   try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/db_honoraire", "root", "");
               
               psta = con.prepareStatement("select * from secretaire where dbSecreUsername = ? and  dbSecrePassword = ?");
                
               psta.setString(1, username);
               psta.setString(2, password);
                
               resultat = psta.executeQuery();
               
               if(resultat.next()){
                    JOptionPane.showMessageDialog(null, "Vous etes bien connecte a l'application !!!");
                    
                    Parent root = FXMLLoader.load(getClass().getResource("dashboardSecre.fxml"));
                    Stage scene = (Stage) btnLogin.getScene().getWindow();
                    scene.setScene(new Scene(root));
                }
               else{
                   JOptionPane.showMessageDialog(null, "Erreur de connexion !!!");
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtUsername.requestFocus();
               }
            } catch (ClassNotFoundException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        
  
    }       catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
               } catch (ClassNotFoundException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        
  
    }       catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        
  
    }       catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
    
    
    // Annee 
    @FXML
    void btnAnneeAction(ActionEvent event) throws Exception {
        System.out.println("Btn annee ok !");
        
        Parent root = FXMLLoader.load(getClass().getResource("pageAnnee.fxml"));
        Stage scene = (Stage) btnAnnee.getScene().getWindow();
        scene.setScene(new Scene(root));
        
    }
    
    @FXML
    void btnAfficherAnneeAction(ActionEvent event) {
        ObservableList<Annee> listeAnn = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from  anneeacademique";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeAnn.add(new Annee(result.getInt("idAnnee"),result.getString("NomAnnee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idA.setCellValueFactory(new PropertyValueFactory<>("idAnnee"));
        col_nomA.setCellValueFactory(new PropertyValueFactory<>("nomAnnee"));
        
        tableAnnee.setItems(listeAnn);
    }
    
    @FXML
    void btnValiderAnneeAction(ActionEvent event) {
        String v = txtAnnee.getText();
        
        AnneeDao annDao = new AnneeDao();
        Annee ann1 = new Annee (v);
        annDao.createAnnee(ann1);
        
        System.out.println(v);
        
        JOptionPane.showMessageDialog(null, "Annee enregistrer !!!");
        
        txtAnnee.setText(""); 
    }
    
    @FXML
    void btnOKdeleteAnnAction(ActionEvent event) {
        System.out.println("Btn suppresionAnn ok !");
        
        int y = Integer.parseInt(txtDeleteAnn.getText());
        System.out.println(y);
        
        
        AnneeDao annDao2 = new AnneeDao();
        annDao2.deleteAnneeById(y);
        
        ObservableList<Annee> listeAnn = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from  anneeacademique";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeAnn.add(new Annee(result.getInt("idAnnee"),result.getString("NomAnnee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idA.setCellValueFactory(new PropertyValueFactory<>("idAnnee"));
        col_nomA.setCellValueFactory(new PropertyValueFactory<>("nomAnnee"));
        
        tableAnnee.setItems(listeAnn);
        
        txtDeleteAnn.setText("");
    }

    @FXML
    void btnOKresearchAnnAction(ActionEvent event) {
       System.out.println("Btn reschercheAnn ok !");
        
        String z = txtResearchAnn.getText();
        System.out.println(z);
        
        ObservableList<Annee> listSearchAnn = FXCollections.observableArrayList();
        
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from  anneeacademique where NomAnnee = ?";
            
            PreparedStatement statement = con.prepareStatement(query); 
            statement.setString (1, z);
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listSearchAnn.add(new Annee(result.getInt("idAnnee"),result.getString("NomAnnee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idA.setCellValueFactory(new PropertyValueFactory<>("idAnnee"));
        col_nomA.setCellValueFactory(new PropertyValueFactory<>("nomAnnee"));
        
        tableAnnee.setItems(listSearchAnn);
        
        txtResearchAnn.setText(""); 
    }
    
    
    //enseignant...

    @FXML
    void btnEnseignantAction(ActionEvent event) throws Exception {
        System.out.println("Btn enseignant ok !");
        
        
    // script page creation, afficher, recherche et suppression enseignant...
        
        Parent root = FXMLLoader.load(getClass().getResource("pageEnseignant.fxml"));
        Stage scene = (Stage) btnEnseignant.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnValiderEnseignantAction(ActionEvent event) {
        //recuperation des saisies dans les textfiedl...
        
        String a = txtNomE.getText();
        
        if(a.isEmpty()) {
            errorNom.setText("Veuillez entrer un nom");
        }
        
        String b = txtPrenom.getText();
        
        if(b.isEmpty()) {
            errorPrenom.setText("Veuillez entrer un prenom");
        }
        
        int c = Integer.parseInt(txtTel.getText());
        
        String d = txtEmail.getText();
        String e = txtAdresse.getText();
        
        //creation d'un objet de EnseignantDao et Enseignant...
        
        EnseignantDao ensDao = new EnseignantDao();
        Enseignant ens1 = new Enseignant (a,b,c,d,e);
        ensDao.createEnseignant(ens1);
        
        System.out.println(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e);
        
        JOptionPane.showMessageDialog(null, "Enseignant enregistrer !!!");
        
        
        txtNomE.setText("");
        txtPrenom.setText("");
        txtTel.setText("");
        txtEmail.setText("");
        txtAdresse.setText("");
        
    }
    
    
    // afficher enseignants...
    
    
    @FXML
    void btnAfficherEnseignantAction(ActionEvent event) {
        ObservableList<Enseignant> liste = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from enseignant";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                liste.add(new Enseignant(result.getInt("idEnseignant"),result.getString("NomEnseignant"),result.getString("PrenomE"),
                        result.getInt("Tel"),result.getString("Email"),result.getString("Adresse")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idE.setCellValueFactory(new PropertyValueFactory<>("idEnseignant"));
        col_nomE.setCellValueFactory(new PropertyValueFactory<>("nomEnseignant"));
        col_prenomE.setCellValueFactory(new PropertyValueFactory<>("prenomEnseignant"));
        col_telE.setCellValueFactory(new PropertyValueFactory<>("telEnseignant"));
        col_emailE.setCellValueFactory(new PropertyValueFactory<>("emailEnseignant"));
        col_adresseE.setCellValueFactory(new PropertyValueFactory<>("adresseEnseignant"));
        
        tableEnseignant.setItems(liste);
    }
    
    
    
    @FXML
    void btnOKdeleteEnseiAction(ActionEvent event) {
        System.out.println("Btn suppresionEns ok !");
        
        int f = Integer.parseInt(txtDeleteEns.getText());
        System.out.println(f);
        
        
        EnseignantDao ensDao2 = new EnseignantDao();
        ensDao2.deleteEnseignantById(f);
        
        ObservableList<Enseignant> liste = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from enseignant";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                liste.add(new Enseignant(result.getInt("idEnseignant"),result.getString("NomEnseignant"),result.getString("PrenomE"),
                        result.getInt("Tel"),result.getString("Email"),result.getString("Adresse")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idE.setCellValueFactory(new PropertyValueFactory<>("idEnseignant"));
        col_nomE.setCellValueFactory(new PropertyValueFactory<>("nomEnseignant"));
        col_prenomE.setCellValueFactory(new PropertyValueFactory<>("prenomEnseignant"));
        col_telE.setCellValueFactory(new PropertyValueFactory<>("telEnseignant"));
        col_emailE.setCellValueFactory(new PropertyValueFactory<>("emailEnseignant"));
        col_adresseE.setCellValueFactory(new PropertyValueFactory<>("adresseEnseignant"));
        
        tableEnseignant.setItems(liste);
        
        txtDeleteEns.setText("");
    }

    @FXML
    void btnOKresearchEnseiAction(ActionEvent event) {
        System.out.println("Btn reschercheEns ok !");
        
        String g = txtResearchEns.getText();
        System.out.println(g);
        
        ObservableList<Enseignant> listSearchEns = FXCollections.observableArrayList();
        
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from enseignant where NomEnseignant = ?";
            
            PreparedStatement statement = con.prepareStatement(query); 
            statement.setString (1, g);
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listSearchEns.add(new Enseignant(result.getInt("idEnseignant"),result.getString("NomEnseignant"),result.getString("PrenomE"),
                        result.getInt("Tel"),result.getString("Email"),result.getString("Adresse")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //col_id.setCellValueFactory(new PropertyValueFactory<>("id));
        col_idE.setCellValueFactory(new PropertyValueFactory<>("idEnseignant"));
        col_nomE.setCellValueFactory(new PropertyValueFactory<>("nomEnseignant"));
        col_prenomE.setCellValueFactory(new PropertyValueFactory<>("prenomEnseignant"));
        col_telE.setCellValueFactory(new PropertyValueFactory<>("telEnseignant"));
        col_emailE.setCellValueFactory(new PropertyValueFactory<>("emailEnseignant"));
        col_adresseE.setCellValueFactory(new PropertyValueFactory<>("adresseEnseignant"));
        
        tableEnseignant.setItems(listSearchEns); 
        
        txtResearchEns.setText("");
     
    }
    
    
    // filiere...
    
    @FXML
    void btnFiliereAction(ActionEvent event) throws Exception {
        System.out.println("Btn filiere ok !");
        
        Parent root = FXMLLoader.load(getClass().getResource("pageFiliere.fxml"));
        Stage scene = (Stage) btnFiliere.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    //creation...
    
    @FXML
    void btnValiderFiliereAction(ActionEvent event) {
        String j = txtNomF.getText();
        String k = txtSigle.getText();
        
        FiliereDao filDao = new FiliereDao ();
        Filiere fil1 = new Filiere (j,k);
        filDao.createFiliere(fil1);
        
        System.out.println(j+"\n"+k);
        
        JOptionPane.showMessageDialog(null, "Filiere enregistrée !!!");
        
        txtNomF.setText("");
        txtSigle.setText("");
    }
    
    //affichage filiere dans le tableau...
    
    @FXML
    void btnAfficherFiliereAction(ActionEvent event) {
        ObservableList<Filiere> listeF = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from filiere";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeF.add(new Filiere(result.getInt("idFiliere"),result.getString("NomFiliere"),result.getString("SigleFiliere")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idF.setCellValueFactory(new PropertyValueFactory<>("idFiliere"));
        col_nomF.setCellValueFactory(new PropertyValueFactory<>("nomFiliere"));
        col_sigleF.setCellValueFactory(new PropertyValueFactory<>("sigleFiliere"));
        
        tableFiliere.setItems(listeF);
    }
    
    //recherche et suppression filiere...
    
    @FXML
    void btnOKdeleteFilAction(ActionEvent event) {
        System.out.println("Btn suppresionFil ok !");
        
        int l = Integer.parseInt(txtDeleteFil.getText());
        System.out.println(l);
        
        
        FiliereDao filDao2 = new FiliereDao();
        filDao2.deleteFiliereById(l);
        
        ObservableList<Filiere> listeF = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from filiere";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeF.add(new Filiere(result.getInt("idFiliere"),result.getString("NomFiliere"),result.getString("SigleFiliere")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idF.setCellValueFactory(new PropertyValueFactory<>("idFiliere"));
        col_nomF.setCellValueFactory(new PropertyValueFactory<>("nomFiliere"));
        col_sigleF.setCellValueFactory(new PropertyValueFactory<>("sigleFiliere"));
        
        tableFiliere.setItems(listeF);
        
        txtDeleteFil.setText("");
    }

    @FXML
    void btnOKresearchFilAction(ActionEvent event) {
        System.out.println("Btn reschercheFil ok !");
        
        String m = txtResearchFil.getText();
        System.out.println(m);
        
        ObservableList<Filiere> listSearchFil = FXCollections.observableArrayList();
        
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from filiere where SigleFiliere = ?";
            
            PreparedStatement statement = con.prepareStatement(query); 
            statement.setString (1, m);
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listSearchFil.add(new Filiere(result.getInt("idFiliere"),result.getString("NomFiliere"),result.getString("SigleFiliere")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idF.setCellValueFactory(new PropertyValueFactory<>("idFiliere"));
        col_nomF.setCellValueFactory(new PropertyValueFactory<>("nomFiliere"));
        col_sigleF.setCellValueFactory(new PropertyValueFactory<>("sigleFiliere"));
        
        tableFiliere.setItems(listSearchFil);
        
        txtResearchFil.setText("");
    }
    
    //matiere...

    @FXML
    void btnMatiereAction(ActionEvent event) throws Exception {
        System.out.println("Btn matiere ok !");
        
        Parent root = FXMLLoader.load(getClass().getResource("pagaMatiere.fxml"));
        Stage scene = (Stage) btnMatiere.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    //creation matiere et tout...
    
    @FXML
    void btnValiderMatiereAction(ActionEvent event) {
        
        String h = txtNomM.getText();
        String i = txtHeure.getText();
        
        MatiereDao matDao = new MatiereDao ();
        Matiere mat1 = new Matiere (h,i);
        matDao.createMatiere(mat1);
        
        System.out.println(h+"\n"+i);
        
        JOptionPane.showMessageDialog(null, "Matiere enregistrée !!!");
        
        txtNomM.setText("");
        txtHeure.setText("");
    }
    
    //affichage des matieres dans le tableau...
    
    @FXML
    void btnAfficherMatiereAction(ActionEvent event) {
        ObservableList<Matiere> listeM = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from matiere";
            
            //ResultSet result = null;
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeM.add(new Matiere(result.getInt("idMatiere"),result.getString("NomMatiere"),result.getString("HeureInit")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idM.setCellValueFactory(new PropertyValueFactory<>("idMatiere"));
        col_nomM.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
        col_heureM.setCellValueFactory(new PropertyValueFactory<>("heureInit"));
        
        tableMatiere.setItems(listeM);
    }
    
    //suppression et recherche matiere...
    
    @FXML
    void btnOKdeleteMatAction(ActionEvent event) {
        System.out.println("Btn suppresionMat ok !");
        
        int j = Integer.parseInt(txtDeleteMat.getText());
        System.out.println(j);
        
        
        MatiereDao matDao2 = new MatiereDao();
        matDao2.deleteMatiereById(j);
        
        ObservableList<Matiere> listeM = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from matiere";
            
            //ResultSet result = null;
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeM.add(new Matiere(result.getInt("idMatiere"),result.getString("NomMatiere"),result.getString("HeureInit")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idM.setCellValueFactory(new PropertyValueFactory<>("idMatiere"));
        col_nomM.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
        col_heureM.setCellValueFactory(new PropertyValueFactory<>("heureInit"));
        
        tableMatiere.setItems(listeM);
        
        txtDeleteMat.setText("");
    }

    @FXML
    void btnOKresearchMatAction(ActionEvent event) {
        
        System.out.println("Btn reschercheEns ok !");
        
        String g = txtResearchMat.getText();
        System.out.println(g);
        
        ObservableList<Matiere> listSearchMat = FXCollections.observableArrayList();
        
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from matiere where NomMatiere = ?";
            
            PreparedStatement statement = con.prepareStatement(query); 
            statement.setString (1, g);
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listSearchMat.add(new Matiere(result.getInt("idMatiere"),result.getString("NomMatiere"),result.getString("HeureInit")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idM.setCellValueFactory(new PropertyValueFactory<>("idMatiere"));
        col_nomM.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
        col_heureM.setCellValueFactory(new PropertyValueFactory<>("heureInit"));
        
        tableMatiere.setItems(listSearchMat);
        
        txtResearchMat.setText("");
    }
    
    
    // parcours...
    @FXML
    void btnParcoursAction(ActionEvent event) throws Exception {
        System.out.println("Btn parcours ok !");
        
        Parent root = FXMLLoader.load(getClass().getResource("pageParcours.fxml"));
        Stage scene = (Stage) btnParcours.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnValiderParcoursAction(ActionEvent event) {
        String n = txtParcours.getText();
        
        ParcoursDao parDao = new ParcoursDao ();
        Parcours par1 = new Parcours (n);
        parDao.createParcours(par1);
        
        System.out.println(n);
        
        JOptionPane.showMessageDialog(null, "Parcours enregistrée !!!");
        
        txtParcours.setText("");
    }
    
    @FXML
    void btnAfficherParcoursAction(ActionEvent event) {
        ObservableList<Parcours> listeP = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from parcours";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeP.add(new Parcours(result.getInt("idParcours"),result.getString("NomParcours"),result.getDouble("cout")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParcoursDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idParcours.setCellValueFactory(new PropertyValueFactory<>("idParcours"));
        col_nomParcours.setCellValueFactory(new PropertyValueFactory<>("nomParcours"));
        
        tableParcours.setItems(listeP);
    }
    
    @FXML
    void btnOKdeleteParAction(ActionEvent event) {
        System.out.println("Btn suppresionPar ok !");
        
        int w = Integer.parseInt(txtDeletePar.getText());
        System.out.println(w);
        
        
        ParcoursDao parDao2 = new ParcoursDao();
        parDao2.deleteParcoursById(w);
        
        ObservableList<Parcours> listeP = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from parcours";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeP.add(new Parcours(result.getInt("idParcours"),result.getString("NomParcours"),result.getDouble("cout")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParcoursDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idParcours.setCellValueFactory(new PropertyValueFactory<>("idParcours"));
        col_nomParcours.setCellValueFactory(new PropertyValueFactory<>("nomParcours"));
        
        tableParcours.setItems(listeP);
        
        txtDeletePar.setText("");
    }

    @FXML
    void btnOKresearchParAction(ActionEvent event) {
        System.out.println("Btn rescherchePar ok !");
        
        String x = txtResearchPar.getText();
        System.out.println(x);
        
        ObservableList<Parcours> listSearchPar = FXCollections.observableArrayList();
        
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from parcours where NomParcours = ?";
            
            PreparedStatement statement = con.prepareStatement(query); 
            statement.setString (1, x);
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listSearchPar.add(new Parcours(result.getInt("idParcours"),result.getString("NomParcours"),result.getDouble("cout")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParcoursDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idParcours.setCellValueFactory(new PropertyValueFactory<>("idParcours"));
        col_nomParcours.setCellValueFactory(new PropertyValueFactory<>("nomParcours"));
        
        tableParcours.setItems(listSearchPar);
        
        txtResearchPar.setText("");
    }
    

    // semestre...
    @FXML
    void btnSemestreAction(ActionEvent event) throws Exception {
        System.out.println("Btn semestre ok !");
        
        Parent root = FXMLLoader.load(getClass().getResource("pageSemestre.fxml"));
        Stage scene = (Stage) btnSemestre.getScene().getWindow();
        scene.setScene(new Scene(root)); 
    } 
    
    @FXML
    void btnAfficherSemestreAction(ActionEvent event) {
        ObservableList<Semestre> listeSem = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from semestre";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeSem.add(new Semestre(result.getInt("idSemestre"),result.getString("NomSemestre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParcoursDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idSem.setCellValueFactory(new PropertyValueFactory<>("idSemestre"));
        col_nomSem.setCellValueFactory(new PropertyValueFactory<>("nomSemestre"));
        
        tableSemestre.setItems(listeSem);
    }
    
    @FXML
    void btnValiderSemestreAction(ActionEvent event) {

    }
    
    
    // comptable...
    
    @FXML
    void btnBackCompAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dashboardComptable.fxml"));
        Stage scene = (Stage) btnBackComp.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnEnseignantCompAction(ActionEvent event) throws Exception {
        System.out.println("Btn enseignant dans comptable ok !");
        
        Parent root = FXMLLoader.load(getClass().getResource("pageComptableEns.fxml"));
        Stage scene = (Stage) btnEnseignantComp.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnAfficherEnseignantCompAction(ActionEvent event) {
        ObservableList<Enseignant> listeComp = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from enseignant";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeComp.add(new Enseignant(result.getInt("idEnseignant"),result.getString("NomEnseignant"),result.getString("PrenomE"),
                        result.getInt("Tel"),result.getString("Email"),result.getString("Adresse")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idEComp.setCellValueFactory(new PropertyValueFactory<>("idEnseignant"));
        col_nomEComp.setCellValueFactory(new PropertyValueFactory<>("nomEnseignant"));
        col_prenomEComp.setCellValueFactory(new PropertyValueFactory<>("prenomEnseignant"));
        col_telEComp.setCellValueFactory(new PropertyValueFactory<>("telEnseignant"));
        
        tableEnseignantComp.setItems(listeComp);
    }
    
    @FXML
    void btnCoutAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pageComptableCout.fxml"));
        Stage scene = (Stage) btnCout.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    //creation cout...
    
    @FXML
    void btnAfficherCoutCompAction(ActionEvent event) {
        ObservableList<Parcours> listeCoutComp = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from parcours";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                //listeCoutComp.add( new Parcours )
                listeCoutComp.add(new Parcours(result.getInt("idParcours"),result.getString("NomParcours"),result.getDouble("cout")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idCoutComp.setCellValueFactory(new PropertyValueFactory<>("idParcours"));
        col_nomCoutComp.setCellValueFactory(new PropertyValueFactory<>("nomParcours"));
        col_coutComp.setCellValueFactory(new PropertyValueFactory<>("cout"));
        
        tableCoutComp.setItems(listeCoutComp);
    }
    
    @FXML
    void btnValiderCoutPAction(ActionEvent event) {
        String o = txtParc.getText();
        double p = Double.parseDouble(txtCout.getText());
        
        //BigDecimal bigDecimal = BigDecimal.valueOf(p);
        
        ParcoursDao parDao = new ParcoursDao ();
        Parcours par2 = new Parcours (o,p);
        parDao.createCoutParcours(par2);
        
        System.out.println(0+"\n"+p);
        
        JOptionPane.showMessageDialog(null, "Cout du parcours enregistrée !!!");
        
        txtParc.setText("");
        txtCout.setText("");
    }
    
    @FXML
    void btnComptablePayAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pageComptablePayement.fxml"));
        Stage scene = (Stage) btnComptablePay.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnAfficherInfosEnsCompAction(ActionEvent event) {
        ObservableList<CompEnsei> listeCompEns = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            //String query = "select * from enseignant";
            String query = "select NomEnseignant,NomMatiere,NomAnnee,NomSemestre,HeureEcouler from enseignant e1 join enseigner e2 on e1.idEnseignant = e2.idEnseignant join matiere m on e2.idMatiere = m.idMatiere join anneeacademique ann on e2.idAnnee = ann.idAnnee join semestre sem on e2.idSemestre = sem.idSemestre";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeCompEns.add(new CompEnsei(result.getString("NomEnseignant"),result.getString("NomMatiere"),result.getString("NomAnnee"),
                        result.getString("NomSemestre"),result.getString("HeureEcouler")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Enseigner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_IDEnseignantComp.setCellValueFactory(new PropertyValueFactory<>("nomEnsi"));
        col_IDMatiereComp.setCellValueFactory(new PropertyValueFactory<>("nomMat"));
        col_IDAnneeComp.setCellValueFactory(new PropertyValueFactory<>("nomAnn"));
        col_IDSemestreComp.setCellValueFactory(new PropertyValueFactory<>("nomSem"));
        col_IDHeurComp.setCellValueFactory(new PropertyValueFactory<>("nomHeu"));
        
        
        tableInfosEnseiComp.setItems(listeCompEns);
    }
    
    @FXML
    void btnPayerAction(ActionEvent event) throws ParseException {
        System.out.println("Btn Payer ok !");

        String parComp = txtParcoursComp.getText();System.out.println(parComp);
        
        String nomEns = txtNomEComp.getText();
        System.out.println(nomEns);
        
        try {
            
            
            
            
            Connection con = Connexion.getConnexion();
            
            String query= "SELECT cout from parcours where NomParcours like ?";
            String query2 = "SELECT HeureEcouler from enseigner e1 join enseignant e2 on e1.idEnseignant = e2.idEnseignant where NomEnseignant = ?";
            
            PreparedStatement statement = con.prepareStatement(query);
            PreparedStatement statement2 = con.prepareStatement(query2);
            
            statement.setString (1, parComp);
            statement2.setString (1, nomEns);
           
            ResultSet result = statement.executeQuery();
            ResultSet result2 = statement2.executeQuery();
            
      while(result.next()&&result2.next()){
          
        double cout = result.getDouble("cout");
        String heureEcoulee = result2.getString("HeureEcouler");
        
        System.out.println(cout);
        System.out.println(heureEcoulee);  
        
//        SimpleDateFormat formatHeure = new SimpleDateFormat ("hh");
//        String heure = formatHeure.format(heureEcoulee);

        SimpleDateFormat formatHeure = new SimpleDateFormat ("hh");
        Date d = formatHeure.parse(heureEcoulee);
        
        //d.getHours();
        
        System.out.println(d);
      } 
      
      
                
        } catch (SQLException ex) {
            Logger.getLogger(Enseigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // secretaire...
    
    @FXML
    void btnSecreFichAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pageSecreFiche.fxml"));
        Stage scene = (Stage) btnSecreFich.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
     @FXML
    void btnAffEnseiInfosAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pageSecreAffichInfo.fxml"));
        Stage scene = (Stage) btnAffEnseiInfos.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnValiderSecreAction(ActionEvent event) {
        System.out.println("Btn valider infos secretaire ok !");
        
        int q = Integer.parseInt(txtSecreIdEns.getText());
        int r = Integer.parseInt(txtSecreIdMat.getText());
        int s = Integer.parseInt(txtSecreIdAnn.getText());
        int t = Integer.parseInt(txtSecreIdSem.getText());
        String u = txtSecreHeu.getText();
        
        EnseignerDao enseiDao = new EnseignerDao ();
        Enseigner ensei1 = new Enseigner(q,r,s,t,u);
        enseiDao.createEnseignerInfos(ensei1);
        
        System.out.println(q+"\n"+r+"\n"+s+"\n"+t+"\n"+u+"\n");
        
        JOptionPane.showMessageDialog(null, "Heure ecoulée enrégistrer !!!");
    }
    
    @FXML
    void btnAffiInfoEnsAction(ActionEvent event) {
        System.out.println("Btn infos ens ds secre ok !");
        
        ObservableList<Enseignant> liste = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from enseignant";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                liste.add(new Enseignant(result.getInt("idEnseignant"),result.getString("NomEnseignant")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idSe.setCellValueFactory(new PropertyValueFactory<>("idEnseignant"));
        col_nomSe.setCellValueFactory(new PropertyValueFactory<>("nomEnseignant"));
        
        
        tableInfos.setItems(liste);
    }

    @FXML
    void btnAffiInfoMatAction(ActionEvent event) {
        System.out.println("Btn infos mat ds secre ok !");
        
        ObservableList<Matiere> listeM = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from matiere";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeM.add(new Matiere(result.getInt("idMatiere"),result.getString("NomMatiere"),result.getString("HeureInit")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idSe2.setCellValueFactory(new PropertyValueFactory<>("idMatiere"));
        col_nomSe2.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
        
        tableInfos2.setItems(listeM);
    }
    
    @FXML
    void btnAffiInfoAnnAction(ActionEvent event) {
        System.out.println("Btn infos ann ds secre ok !");
        
        ObservableList<Annee> listeAnn = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from  anneeacademique";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeAnn.add(new Annee(result.getInt("idAnnee"),result.getString("NomAnnee")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idSe3.setCellValueFactory(new PropertyValueFactory<>("idAnnee"));
        col_nomSe3.setCellValueFactory(new PropertyValueFactory<>("nomAnnee"));
        
        tableInfos3.setItems(listeAnn);
    }
    
    @FXML
    void btnAffiInfoSemAction(ActionEvent event) {
        System.out.println("Btn infos sem ds secre ok !");
        
        ObservableList<Semestre> listeSem = FXCollections.observableArrayList();
        try {
            
            Connection con = Connexion.getConnexion();
           
            String query = "select * from  semestre";
            
            PreparedStatement statement = con.prepareStatement(query); 
           
            ResultSet result = statement.executeQuery();
           
            while(result.next())
            {
                listeSem.add(new Semestre(result.getInt("idSemestre"),result.getString("NomSemestre")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_idSe4.setCellValueFactory(new PropertyValueFactory<>("idSemestre"));
        col_nomSe4.setCellValueFactory(new PropertyValueFactory<>("nomSemestre"));
        
        tableInfos4.setItems(listeSem);
    }
    
     
    
    
   // bouton retour...
    
    @FXML
    void btnBackAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dashboardAdmin.fxml"));
        Stage scene = (Stage) btnBack.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnDeconnexionAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Stage scene = (Stage) btnDeconnexion.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnBackSecreAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dashboardSecre.fxml"));
        Stage scene = (Stage) btnBackSecre.getScene().getWindow();
        scene.setScene(new Scene(root));
    }
    
    @FXML
    void btnBackSecre2Action(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("pageSecreFiche.fxml"));
        Stage scene = (Stage) btnBackSecre2.getScene().getWindow();
        scene.setScene(new Scene(root));
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label = progress ;
        statProgressBar = progressGH;
    }     
}
