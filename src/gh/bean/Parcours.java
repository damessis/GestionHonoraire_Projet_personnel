/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.bean;

import java.math.BigDecimal;

/**
 *
 * @author IDA(damessis)
 */
public class Parcours {
    private int idParcours;
    private String nomParcours;
    private Double cout;

    public Parcours(String nomParcours, Double cout) {
        this.nomParcours = nomParcours;
        this.cout = cout;
    }

    public Parcours(int idParcours, String nomParcours, Double cout) {
        this.idParcours = idParcours;
        this.nomParcours = nomParcours;
        this.cout = cout;
    }

    public Parcours(Double cout) {
        this.cout = cout;
    }

    public Parcours(String nomParcours) {
        this.nomParcours = nomParcours;
    }

    public int getIdParcours() {
        return idParcours;
    }

    public void setIdParcours(int idParcours) {
        this.idParcours = idParcours;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public void setNomParcours(String nomParcours) {
        this.nomParcours = nomParcours;
    }

    public Double getCout() {
        return cout;
    }

    public void setCout(Double cout) {
        this.cout = cout;
    }

    
}
