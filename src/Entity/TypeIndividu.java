/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author pheni
 */
public class TypeIndividu {
    
    private int tin_code;
    private String tin_libelle;
    
    public TypeIndividu(int unCode, String unLibelle){
        tin_code = unCode;
        tin_libelle = unLibelle;
    }
    public TypeIndividu (String unType) {
        tin_libelle = unType;
    }
    public TypeIndividu(int idType) {
        tin_code = idType;
    }

    /**
     * @return the tin_code
     */
    public int getTin_code() {
        return tin_code;
    }

    /**
     * @return the tin_libelle
     */
    public String getTin_libelle() {
        return tin_libelle;
    }

    /**
     * @param tin_libelle the tin_libelle to set
     */
    public void setTin_libelle(String tin_libelle) {
        this.tin_libelle = tin_libelle;
    }
    
    
    
}
