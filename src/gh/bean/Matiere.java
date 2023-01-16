/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.bean;

import java.sql.Time;

/**
 *
 * @author IDA(damessis)
 */
public class Matiere {
    int idMatiere;
    String nomMatiere;
    String heureInit;

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getHeureInit() {
        return heureInit;
    }

    public void setHeureInit(String heureInit) {
        this.heureInit = heureInit;
    }

    public Matiere(int idMatiere, String nomMatiere, String heureInit) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.heureInit = heureInit;
    }

    public Matiere(String nomMatiere, String heureInit) {
        this.nomMatiere = nomMatiere;
        this.heureInit = heureInit;
    }
}
