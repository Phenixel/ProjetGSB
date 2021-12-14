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
    
    private int med_perturbateur;
    private int med_perturbe;
    
    public Prescrire(int unPerturbateur, int unPerturbe){
        med_perturbateur = unPerturbateur;
        med_perturbe = unPerturbe;
    }

    /**
     * @return the med_perturbateur
     */
    public int getMed_perturbateur() {
        return med_perturbateur;
    }

    /**
     * @return the med_perturbe
     */
    public int getMed_perturbe() {
        return med_perturbe;
    }
    
    
    
}
