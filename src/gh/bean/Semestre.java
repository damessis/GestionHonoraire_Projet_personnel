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
public class Semestre {
    int idSemestre;
    String nomSemestre;

    public Semestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Semestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    public Semestre(int idSemestre, String nomSemestre) {
        this.idSemestre = idSemestre;
        this.nomSemestre = nomSemestre;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    
}
