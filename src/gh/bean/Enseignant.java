/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.bean;

/**
 *
 * @author IDA(damessis)
 */
public class Enseignant {
    private int idEnseignant;
    private String nomEnseignant;
    private String prenomEnseignant;
    private int telEnseignant;
    private String emailEnseignant;
    private String adresseEnseignant;

    public Enseignant(int idEnseignant, String nomEnseignant) {
        this.idEnseignant = idEnseignant;
        this.nomEnseignant = nomEnseignant;
    }

    public Enseignant(String nomEnseignant, String prenomEnseignant, int telEnseignant, String emailEnseignant, String adresseEnseignant) {
        this.nomEnseignant = nomEnseignant;
        this.prenomEnseignant = prenomEnseignant;
        this.telEnseignant = telEnseignant;
        this.emailEnseignant = emailEnseignant;
        this.adresseEnseignant = adresseEnseignant;
    }

    public Enseignant(int idEnseignant, String nomEnseignant, String prenomEnseignant, int telEnseignant, String emailEnseignant, String adresseEnseignant) {
        this.idEnseignant = idEnseignant;
        this.nomEnseignant = nomEnseignant;
        this.prenomEnseignant = prenomEnseignant;
        this.telEnseignant = telEnseignant;
        this.emailEnseignant = emailEnseignant;
        this.adresseEnseignant = adresseEnseignant;
    }

    public Enseignant(int aInt, String string, String string0, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*public Enseignant (String a, String b, int c, String d, String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
   
    public int getIdEnseignant() {
        return idEnseignant;
    }

    @Override
    public String toString() {
        return "Enseignant{" + "idEnseignant=" + idEnseignant + ", nomEnseignant=" + nomEnseignant + ", prenomEnseignant=" + prenomEnseignant + ", telEnseignant=" + telEnseignant + ", emailEnseignant=" + emailEnseignant + ", adresseEnseignant=" + adresseEnseignant + '}';
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    public int getTelEnseignant() {
        return telEnseignant;
    }

    public void setTelEnseignant(int telEnseignant) {
        this.telEnseignant = telEnseignant;
    }

    public String getEmailEnseignant() {
        return emailEnseignant;
    }

    public void setEmailEnseignant(String emailEnseignant) {
        this.emailEnseignant = emailEnseignant;
    }

    public String getAdresseEnseignant() {
        return adresseEnseignant;
    }

    public void setAdresseEnseignant(String adresseEnseignant) {
        this.adresseEnseignant = adresseEnseignant;
    }

    
}
