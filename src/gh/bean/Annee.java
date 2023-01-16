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
public class Annee {
    int idAnnee;
    String nomAnnee;

    public int getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(int idAnnee) {
        this.idAnnee = idAnnee;
    }

    public String getNomAnnee() {
        return nomAnnee;
    }

    public void setNomAnnee(String nomAnnee) {
        this.nomAnnee = nomAnnee;
    }

    public Annee(int idAnnee, String nomAnnee) {
        this.idAnnee = idAnnee;
        this.nomAnnee = nomAnnee;
    }

    public Annee(String nomAnnee) {
        this.nomAnnee = nomAnnee;
    }
}
