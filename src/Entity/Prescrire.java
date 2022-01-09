/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author pheni
 */
public class Prescrire {
    
    private int med_depotlegal;
    private int tin_code;
    private int dos_code;
    private String pre_posologie;
    
    public Prescrire(int unMedDepotLegal, int unTinCode, int unDosCode, String unePrePosologie){
        med_depotlegal = unMedDepotLegal;
        tin_code = unTinCode;
        dos_code = unDosCode;
        pre_posologie = unePrePosologie;
    }
    
    public Prescrire(int unMedDepotLegal, int unTinCode, int unDosCode) {
        med_depotlegal = unMedDepotLegal;
        tin_code = unTinCode;
        dos_code = unDosCode;
    }

    /**
     * @return the med_depotlegal
     */
    public int getMed_depotlegal() {
        return med_depotlegal;
    }

    /**
     * @return the tin_code
     */
    public int getTin_code() {
        return tin_code;
    }

    /**
     * @return the dos_code
     */
    public int getDos_code() {
        return dos_code;
    }

    /**
     * @return the pre_posologie
     */
    public String getPre_posologie() {
        return pre_posologie;
    }

    /**
     * @param pre_posologie the pre_posologie to set
     */
    public void setPre_posologie(String pre_posologie) {
        this.pre_posologie = pre_posologie;
    }
    
    
    
}
