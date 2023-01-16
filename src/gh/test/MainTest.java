/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gh.test;

import gh.bean.Enseignant;
import gh.bean.Matiere;
import gh.dao.EnseignantDao;
import gh.dao.MatiereDao;

/**
 *
 * @author IDA(damessis)
 */
public class MainTest {
    public  static void main(String [] args){
        EnseignantDao ensDao = new EnseignantDao ();
        System.out.println("**********Création d'enseignant**********");
        Enseignant ens1 = new Enseignant ("DADA", "Ad", 90992909,"DADA@gmail.com","Tork");
        
        //ensDao.createEnseignant(ens1);
        
        /*String a = "DODO";
        String b = "Od";
        int c = 90100121;
        String d = "DODO@yahoo.fr";
        String e = "Taro";
        
        Enseignant ens2 = new Enseignant (a,b,c,d,e);
        
        //ensDao.createEnseignant(ens2);
        
        ensDao.findEnseignantByNom("DODO");
        ensDao.deleteEnseignantById(4);*/
        
        MatiereDao matDao = new MatiereDao ();
        Matiere mat1 = new Matiere ("JAVA", "02:00");
        //matDao.createMatiere(mat1);
        
       //ensDao.deleteEnseignantById(5);
       
       matDao.deleteMatiereById(4);
}
}
