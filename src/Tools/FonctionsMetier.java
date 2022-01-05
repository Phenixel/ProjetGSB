/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Famille;
import Entity.Medicament;
import Entity.Prescrire;
import Entity.TypeIndividu;
import Entity.utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phen
 */
public class FonctionsMetier implements IMetier
{
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection maCnx;

    @Override
    public utilisateur VerifierIdentifiants(String login, String mdp) {
        utilisateur user = null;
        try {
            
            maCnx = ConnexionBDD.getCnx();
            
            ps = maCnx.prepareStatement("SELECT idUser, login, mdp from utilisateur where login = '"+ login +"' and mdp = '"+ mdp +"' ");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new utilisateur(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public ArrayList<TypeIndividu> GetAllTypeIndividu()
    {
        ArrayList<TypeIndividu> lesIndividus = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT TIN_CODE, TIN_LIBELLE FROM type_individu");
            rs = ps.executeQuery();
            while(rs.next())
            {
                TypeIndividu tic = new TypeIndividu(rs.getInt("TIN_CODE"),rs.getString("TIN_LIBELLE"));
                lesIndividus.add(tic);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesIndividus;
    }
    
    @Override
    public ArrayList<Medicament> GetAllMedicament() {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT MED_DEPOTLEGAL, MED_NOMCOMMERCIAL, FAM_CODE, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON FROM medicament");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament med = new Medicament(rs.getInt("MED_DEPOTLEGAL"),rs.getString("MED_NOMCOMMERCIAL"), rs.getInt("FAM_CODE"), rs.getString("MED_COMPOSITION"), rs.getString("MED_EFFETS"), rs.getString("MED_CONTREINDIC"), rs.getFloat("MED_PRIXECHANTILLON"));
                lesMedicaments.add(med);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }

    @Override
    public Medicament AddMedicament(String nomMedicament, String famCode, String medComposition, String medEffets, String medContreIndic, float prix) {
        Medicament unMedicament = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            
            ps = maCnx.prepareStatement("SELECT fam_code FROM famille WHERE fam_libelle = '"+famCode+"'");
            rs = ps.executeQuery();
            rs.next();
            
            int numFam = rs.getInt(1);
            rs.close();
            
            
            ps = maCnx.prepareStatement("INSERT INTO medicament "
                    + "(MED_NOMCOMMERCIAL, FAM_CODE, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON) "
                    + "VALUES ('"+ nomMedicament +"',"
                    + numFam+ ","
                    + "'"+ medComposition + "',"
                    + "'"+ medEffets + "',"
                    + "'"+ medContreIndic + "',"
                    + prix +");");
            ps.executeUpdate();
                    
//            if(rs.next()){
//                unMedicament = new Medicament(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
//            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unMedicament;
    }

    @Override
    public TypeIndividu addTypeIndividu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prescrire addPrescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medicament GetUnMedic(int idMedic) {
        Medicament leMedicament = null;
        
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT MED_DEPOTLEGAL, MED_NOMCOMMERCIAL, FAM_CODE, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON from medicament WHERE MED_DEPOTLEGAL = "+ idMedic);
            rs = ps.executeQuery();
            
            if(rs.next()){
                leMedicament = new Medicament(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return leMedicament;
    }

    @Override
    public Medicament GetNomMedic(String nomMedic) {
        Medicament leMedicament = null;
        
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT MED_NOMCOMMERCIAL FROM medicament WHERE MED_NOMCOMMERCIAL = '" +nomMedic+ "'");
            rs = ps.executeQuery();
            
            if(rs.next()){
                leMedicament = new Medicament(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return leMedicament;
    }

    @Override
    public ArrayList<Famille> GetAllFamille() {
        ArrayList<Famille> lesFamille = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT fam_code, fam_LIBELLE FROM famille");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Famille fam = new Famille(rs.getInt("fam_code"),rs.getString("fam_LIBELLE"));
                lesFamille.add(fam);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesFamille;
    }

    @Override
    public Medicament SetModifMedic(int medId, String nomMedicament, String famCode, String medComposition, String medEffets, String medContreIndic, float prix) {
        Medicament unMedicament = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            
            ps = maCnx.prepareStatement("SELECT fam_code FROM famille WHERE fam_libelle = '"+famCode+"'");
            rs = ps.executeQuery();
            rs.next();
            
            int numFam = rs.getInt(1);
            rs.close();

            ps = maCnx.prepareStatement("UPDATE medicament SET MED_NOMCOMMERCIAL = ? ,FAM_CODE = ?,MED_COMPOSITION = ?,MED_EFFETS = ?,MED_CONTREINDIC = ?,MED_PRIXECHANTILLON = ? WHERE MED_DEPOTLEGAL = ?;");
            ps.setString(1, nomMedicament);
            ps.setInt(2, numFam);
            ps.setString(3, medComposition);
            ps.setString(4, medEffets);
            ps.setString(5, medContreIndic);
            ps.setFloat(6, prix);
            ps.setInt(7, medId);
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unMedicament;
    }
}