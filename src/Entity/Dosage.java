/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author pheni
 */
public class Dosage {
    
    private int dos_code;
    private String dos_quantite;
    private String dos_unite;
    
    public Dosage(int unDosCode, String uneQuantite, String uneUnite){
        dos_code = unDosCode;
        dos_quantite = uneQuantite;
        dos_unite = uneUnite;
    }

    /**
     * @return the dos_code
     */
    public int getDos_code() {
        return dos_code;
    }

    /**
     * @return the dos_quantite
     */
    public String getDos_quantite() {
        return dos_quantite;
    }

    /**
     * @param dos_quantite the dos_quantite to set
     */
    public void setDos_quantite(String dos_quantite) {
        this.dos_quantite = dos_quantite;
    }

    /**
     * @return the dos_unite
     */
    public String getDos_unite() {
        return dos_unite;
    }

    /**
     * @param dos_unite the dos_unite to set
     */
    public void setDos_unite(String dos_unite) {
        this.dos_unite = dos_unite;
    }
    
    
    
}
