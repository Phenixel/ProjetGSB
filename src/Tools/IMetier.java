/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Medicament;
import Entity.TypeIndividu;
import Entity.utilisateur;
import java.util.ArrayList;

public interface IMetier 
{
    
    public ArrayList<Medicament> GetAllMedicament();
    public utilisateur VerifierIdentifiants(String login, String mdp);
    public ArrayList<TypeIndividu> GetAllTypeIndividu();
}
