/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author jacqu
 */
public class Etat
{
    private int idEtat;
    private String nomEtat;
    
    public Etat(int unId, String unNom)
    {
        idEtat =unId;
        nomEtat = unNom;
    }

    public int getIdEtat() {
        return idEtat;
    }

    public String getNomEtat() {
        return nomEtat;
    }
}
