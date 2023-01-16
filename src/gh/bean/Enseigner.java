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
public class Enseigner {
    private int idEnseignan;
    private int idMatier;
    private int idAnne;
    private int idSemestr;
    private String heureEcoulee;

    public Enseigner(int idEnseignan, int idMatier, int idAnne, int idSemestr, String heureEcoulee) {
        this.idEnseignan = idEnseignan;
        this.idMatier = idMatier;
        this.idAnne = idAnne;
        this.idSemestr = idSemestr;
        this.heureEcoulee = heureEcoulee;
    }

    public int getIdEnseignan() {
        return idEnseignan;
    }

    public void setIdEnseignan(int idEnseignan) {
        this.idEnseignan = idEnseignan;
    }

    public int getIdMatier() {
        return idMatier;
    }

    public void setIdMatier(int idMatier) {
        this.idMatier = idMatier;
    }

    public int getIdAnne() {
        return idAnne;
    }

    public void setIdAnne(int idAnne) {
        this.idAnne = idAnne;
    }

    public int getIdSemestr() {
        return idSemestr;
    }

    public void setIdSemestr(int idSemestr) {
        this.idSemestr = idSemestr;
    }

    public String getHeureEcoulee() {
        return heureEcoulee;
    }

    public void setHeureEcoulee(String heureEcoulee) {
        this.heureEcoulee = heureEcoulee;
    }

    
}
