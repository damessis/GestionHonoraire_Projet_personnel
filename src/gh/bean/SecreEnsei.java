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
public class SecreEnsei {
    private String nomEnsi;
    private String nomMat;
    private String nomAnn;
    private String nomSem;
    private String nomHeu;

    public String getNomEnsi() {
        return nomEnsi;
    }

    public void setNomEnsi(String nomEnsi) {
        this.nomEnsi = nomEnsi;
    }

    public String getNomMat() {
        return nomMat;
    }

    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }

    public String getNomAnn() {
        return nomAnn;
    }

    public void setNomAnn(String nomAnn) {
        this.nomAnn = nomAnn;
    }

    public String getNomSem() {
        return nomSem;
    }

    public void setNomSem(String nomSem) {
        this.nomSem = nomSem;
    }

    public String getNomHeu() {
        return nomHeu;
    }

    public void setNomHeu(String nomHeu) {
        this.nomHeu = nomHeu;
    }

    public SecreEnsei(String nomEnsi, String nomMat, String nomAnn, String nomSem, String nomHeu) {
        this.nomEnsi = nomEnsi;
        this.nomMat = nomMat;
        this.nomAnn = nomAnn;
        this.nomSem = nomSem;
        this.nomHeu = nomHeu;
    }
}
