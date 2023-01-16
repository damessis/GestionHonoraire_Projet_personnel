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
public class Users {
    private int idUser;
    private String dbUserNam;
    private String dbPassw;

    public Users(String dbUserNam, String dbPassw) {
        this.dbUserNam = dbUserNam;
        this.dbPassw = dbPassw;
    }

    public Users(int idUser, String dbUserNam, String dbPassw) {
        this.idUser = idUser;
        this.dbUserNam = dbUserNam;
        this.dbPassw = dbPassw;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDbUserNam() {
        return dbUserNam;
    }

    public void setDbUserNam(String dbUserNam) {
        this.dbUserNam = dbUserNam;
    }

    public String getDbPassw() {
        return dbPassw;
    }

    public void setDbPassw(String dbPassw) {
        this.dbPassw = dbPassw;
    }

    
}
