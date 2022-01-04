/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Medicament;
import Entity.Prescrire;
import Entity.TypeIndividu;
import Entity.utilisateur;
import java.util.ArrayList;

public interface IMetier 
{
    
    public ArrayList<Medicament> GetAllMedicament();
    public utilisateur VerifierIdentifiants(String login, String mdp);
    public ArrayList<TypeIndividu> GetAllTypeIndividu();
    public Medicament AddMedicament(String nomMedicament, String famCode, String medComposition, String medEffets, String medContreIndic, float prix);
    public TypeIndividu addTypeIndividu();
    public Prescrire addPrescription();
    public Medicament GetUnMedic(int idMedic);
    public Medicament GetNomMedic(String nomMedic);
}