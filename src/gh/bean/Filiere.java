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
public class Filiere {
    int idFiliere;
    String nomFiliere;
    String sigleFiliere;

    @Override
    public String toString() {
        return "Filiere{" + "idFiliere=" + idFiliere + ", nomFiliere=" + nomFiliere + ", sigleFiliere=" + sigleFiliere + '}';
    }

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public String getSigleFiliere() {
        return sigleFiliere;
    }

    public void setSigleFiliere(String sigleFiliere) {
        this.sigleFiliere = sigleFiliere;
    }

    public Filiere(int idFiliere, String nomFiliere, String sigleFiliere) {
        this.idFiliere = idFiliere;
        this.nomFiliere = nomFiliere;
        this.sigleFiliere = sigleFiliere;
    }

    public Filiere(String nomFiliere, String sigleFiliere) {
        this.nomFiliere = nomFiliere;
        this.sigleFiliere = sigleFiliere;
    }
}
