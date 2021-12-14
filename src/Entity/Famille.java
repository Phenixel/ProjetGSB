/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author pheni
 */
public class Famille {
    
    private int fam_code;
    private String fam_libelle;
    
    public Famille(int unCode, String unLibelle){
        fam_code = unCode;
        fam_libelle = unLibelle;
    }

    /**
     * @return the fam_code
     */
    public int getFam_code() {
        return fam_code;
    }

    /**
     * @return the fam_libelle
     */
    public String getFam_libelle() {
        return fam_libelle;
    }

    /**
     * @param fam_libelle the fam_libelle to set
     */
    public void setFam_libelle(String fam_libelle) {
        this.fam_libelle = fam_libelle;
    }
    
    
    
}
