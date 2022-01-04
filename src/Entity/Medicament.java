/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author pheni
 */
public class Medicament {
    
    private int med_depotlegal;
    private String med_nomcommercial;
    private int fam_code;
    private String med_composition;
    private String med_effets;
    private String med_contreindic;
    private float med_prixechantillon;
    
    public Medicament (int unDepotLegal, String unNom, int unFamCode, String uneComposition, String unEffet, String uneContreindic, float unPrix){
        med_depotlegal = unDepotLegal;
        med_nomcommercial = unNom;
        fam_code = unFamCode;
        med_composition = uneComposition;
        med_effets = unEffet;
        med_contreindic = uneContreindic;
        med_prixechantillon = unPrix;
    }
     public Medicament (String unNom){
        med_nomcommercial = unNom;
    }

    /**
     * @return the med_depotlegal
     */
    public int getMed_depotlegal() {
        return med_depotlegal;
    }

    /**
     * @return the med_nomcommercial
     */
    public String getMed_nomcommercial() {
        return med_nomcommercial;
    }

    /**
     * @param med_nomcommercial the med_nomcommercial to set
     */
    public void setMed_nomcommercial(String med_nomcommercial) {
        this.med_nomcommercial = med_nomcommercial;
    }

    /**
     * @return the fam_code
     */
    public int getFam_code() {
        return fam_code;
    }

    /**
     * @param fam_code the fam_code to set
     */
    public void setFam_code(int fam_code) {
        this.fam_code = fam_code;
    }

    /**
     * @return the med_composition
     */
    public String getMed_composition() {
        return med_composition;
    }

    /**
     * @param med_composition the med_composition to set
     */
    public void setMed_composition(String med_composition) {
        this.med_composition = med_composition;
    }

    /**
     * @return the med_effets
     */
    public String getMed_effets() {
        return med_effets;
    }

    /**
     * @param med_effets the med_effets to set
     */
    public void setMed_effets(String med_effets) {
        this.med_effets = med_effets;
    }

    /**
     * @return the med_contreindic
     */
    public String getMed_contreindic() {
        return med_contreindic;
    }

    /**
     * @param med_contreindic the med_contreindic to set
     */
    public void setMed_contreindic(String med_contreindic) {
        this.med_contreindic = med_contreindic;
    }

    /**
     * @return the med_prixechantillon
     */
    public float getMed_prixechantillon() {
        return med_prixechantillon;
    }

    /**
     * @param med_prixechantillon the med_prixechantillon to set
     */
    public void setMed_prixechantillon(float med_prixechantillon) {
        this.med_prixechantillon = med_prixechantillon;
    }
    
    
    
}
