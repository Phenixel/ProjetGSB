/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Dosage;
import Entity.Famille;
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
    public ArrayList<Famille> GetAllFamille();
    public Medicament AddMedicament(String nomMedicament, String famCode, String medComposition, String medEffets, String medContreIndic, float prix);
    public TypeIndividu addTypeIndividu();
    public Prescrire addPrescription();
    public Prescrire addAjoutPres(String medDepotLegal, String tinCode, String dosCode, String prePosologie);
    public Medicament GetUnMedic(int idMedic);
    public Medicament GetNomMedic(String nomMedic);
    public Medicament SetModifMedic(int medId, String nomMedicament, String famCode, String medComposition, String medEffets, String medContreIndic, float prix);
    public ArrayList<Dosage> GetAllDosage();
    public boolean checkLimitText(String text);
    public boolean isNumeric(String str);
}