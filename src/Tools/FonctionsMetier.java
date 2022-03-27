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
import Entity.Utilisateur;
import Entity.Dosage;
import Entity.Interragis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public Utilisateur VerifierIdentifiants(String login, String mdp) {
        Utilisateur user = null;
        try {
            
            maCnx = ConnexionBDD.getCnx();
            
            ps = maCnx.prepareStatement("SELECT idUser, login, mdp from utilisateur where login = ? and mdp = ? ");
            ps.setString(1, login);
            ps.setString(2, mdp);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new Utilisateur(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3));
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
            
            
            ps = maCnx.prepareStatement("INSERT INTO medicament (MED_NOMCOMMERCIAL, FAM_CODE, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON) VALUES (?,?,?,?,?,?);");
            ps.setString(1, nomMedicament);
            ps.setInt(2, numFam);
            ps.setString(3, medComposition);
            ps.setString(4, medEffets);
            ps.setString(5, medContreIndic);
            ps.setFloat(6, prix);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unMedicament;
    }

    @Override
    public Medicament GetUnMedic(int idMedic) {
        Medicament leMedicament = null;
        
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT m.MED_DEPOTLEGAL, m.MED_NOMCOMMERCIAL, f.FAM_libelle, M.MED_COMPOSITION, m.MED_EFFETS, m.MED_CONTREINDIC, m.MED_PRIXECHANTILLON from medicament as m INNER join famille as f on m.FAM_CODE = f.FAM_CODE WHERE m.MED_DEPOTLEGAL = ?");
            ps.setInt(1, idMedic);
            rs = ps.executeQuery();
            
            if(rs.next()){
                leMedicament = new Medicament(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
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
            ps = maCnx.prepareStatement("SELECT MED_NOMCOMMERCIAL FROM medicament WHERE MED_NOMCOMMERCIAL = ?;");
            ps.setString(1, nomMedic);
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
            
            ps = maCnx.prepareStatement("SELECT fam_code FROM famille WHERE fam_libelle = '"+famCode+"';");
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

    @Override
    public Prescrire addAjoutPres(String medDepotLegal, String tinCode, String dosCode, String prePosologie) {
    Prescrire unePres = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT MED_DEPOTLEGAL FROM medicament WHERE MED_NOMCOMMERCIAL = ?;");
            ps.setString(1, medDepotLegal);
            rs = ps.executeQuery();
            rs.next();
            int depotLegal = rs.getInt(1);
            rs.close();

            ps = maCnx.prepareStatement("SELECT TIN_CODE FROM type_individu WHERE TIN_LIBELLE = ?;");
            ps.setString(1, tinCode);
            rs = ps.executeQuery();
            rs.next();
            int typeCode = rs.getInt(1);
            rs.close(); 

            ps = maCnx.prepareStatement("SELECT DOS_CODE FROM dosage WHERE CONCAT(DOS_QUANTITE,' ',DOS_UNITE) = ?;");
            ps.setString(1, dosCode);
            rs = ps.executeQuery();
            rs.next();
            int dosageCode = rs.getInt(1);
            rs.close(); 
        
            ps = maCnx.prepareStatement("INSERT INTO prescrire (MED_DEPOTLEGAL, TIN_CODE, DOS_CODE, PRE_POSOLOGIE) VALUES (?,?,?,?)");
            ps.setInt(1, depotLegal);
            ps.setInt(2, typeCode);
            ps.setInt(3, dosageCode);
            ps.setString(4, prePosologie);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unePres;
    }
    
    @Override
    public ArrayList<Dosage> GetAllDosage() {
        ArrayList<Dosage> lesDosages = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT DOS_CODE, DOS_QUANTITE, DOS_UNITE FROM dosage");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Dosage dos = new Dosage(rs.getInt("DOS_CODE"),rs.getString("DOS_QUANTITE"),rs.getString("DOS_UNITE"));
                lesDosages.add(dos);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesDosages;
    }

    @Override
    public boolean checkLimitText(String text) {
        
        boolean longTextOk = true;
        int txtLen = text.length();
        
        if(txtLen > 255){
            longTextOk = false;
        }
        
        return longTextOk;
    }
    
    @Override
    public Prescrire getPrescription(String nomMedoc, String nomType, String dosCode) {
        Prescrire laPres = null;
        
        try {
            
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT MED_DEPOTLEGAL FROM medicament WHERE MED_NOMCOMMERCIAL = '"+nomMedoc+"'");
            rs = ps.executeQuery();
            rs.next();
            int depotLegal = rs.getInt(1);
            rs.close();
            
            ps = maCnx.prepareStatement("SELECT TIN_CODE FROM type_individu WHERE TIN_LIBELLE = '"+nomType+"'");
            rs = ps.executeQuery();
            rs.next();
            int typeCode = rs.getInt(1);
            rs.close();
            
            ps = maCnx.prepareStatement("SELECT DOS_CODE FROM dosage WHERE CONCAT(DOS_QUANTITE,' ',DOS_UNITE) = '"+dosCode+"'");
            rs = ps.executeQuery();
            rs.next();
            int dosageCode = rs.getInt(1);
            rs.close(); 
            
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT MED_DEPOTLEGAL, TIN_CODE, DOS_CODE FROM prescrire WHERE CONCAT(MED_DEPOTLEGAL, TIN_CODE, DOS_CODE) = CONCAT(?,?,?)");
            ps.setInt(1, depotLegal);
            ps.setInt(2, typeCode);
            ps.setInt(3, dosageCode);
            rs = ps.executeQuery();
            
            if(rs.next()){
                laPres = new Prescrire(rs.getInt(1),rs.getInt(2),rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return laPres;
    }
    
    @Override
    public boolean isNumeric(String str)
    {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }

    @Override
    public Medicament deleteMedic(int idMedic) {
        Medicament unMedicament = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("DELETE FROM medicament WHERE MED_DEPOTLEGAL = ?;");
            ps.setInt(1, idMedic);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unMedicament;
    }

    @Override
    public TypeIndividu addTypeIndividu(String unNom) {
        TypeIndividu unType = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("INSERT INTO type_individu (TIN_LIBELLE) VALUE (?);");
            ps.setString(1, unNom);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unType;
    }

    @Override
    public TypeIndividu GetNomTypeModif(int nomType){
        TypeIndividu leType = null;
        
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT TIN_CODE, TIN_LIBELLE FROM type_individu WHERE TIN_CODE = ?;");
            ps.setInt(1, nomType);
            rs = ps.executeQuery();
            
            if(rs.next()){
                leType = new TypeIndividu(rs.getInt(1),rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return leType;
    }

    @Override
    public TypeIndividu GetNomType(String nomType){
        TypeIndividu leType = null;
        
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT TIN_CODE, TIN_LIBELLE FROM type_individu WHERE TIN_LIBELLE = ?;");
            ps.setString(1, nomType);
            rs = ps.executeQuery();
            
            if(rs.next()){
                leType = new TypeIndividu(rs.getInt(1),rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return leType;
    }

    @Override
    public TypeIndividu SetModifType(int idType, String nomType) {
        TypeIndividu unType = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            
            ps = maCnx.prepareStatement("UPDATE type_individu SET TIN_LIBELLE = ? WHERE TIN_CODE = ?");
            ps.setString(1, nomType);
            ps.setInt(2, idType);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unType;
    }

    @Override
    public Interragis addInterraction(int medPerturbateur, int medPerturbe) {
        Interragis uneInterraction = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("INSERT INTO interagis (MED_PERTURBATEUR, MED_MED_PERTURBE) VALUES (?,?);");
            ps.setInt(1, medPerturbe);
            ps.setInt(2, medPerturbateur);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uneInterraction;
    }

    @Override
    public int getNextId() {
        int leMaxId = 0;
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT max(MED_DEPOTLEGAL)+1 FROM medicament;");
            rs = ps.executeQuery();
            
            while(rs.next()){
                leMaxId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leMaxId;
    }

    @Override
    public ArrayList<Medicament> getAllInterraction(int leMedic) {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT medicament.MED_NOMCOMMERCIAL FROM medicament INNER JOIN interagis on medicament.MED_DEPOTLEGAL = interagis.MED_PERTURBATEUR WHERE interagis.MED_MED_PERTURBE = ?");
            ps.setInt(1, leMedic);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament med = new Medicament(rs.getString("medicament.MED_NOMCOMMERCIAL"));
                lesMedicaments.add(med);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }
    
    @Override
    public ArrayList<Medicament> getLesInterraction(int leMedic) {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT medicament.MED_DEPOTLEGAL, medicament.MED_NOMCOMMERCIAL from medicament\n" +
                "WHERE medicament.MED_DEPOTLEGAL not in (\n" +
                "SELECT interagis.MED_PERTURBATEUR from interagis WHERE interagis.MED_MED_PERTURBE = ?)\n" +
                "and medicament.MED_DEPOTLEGAL <> ?");
            ps.setInt(1, leMedic);
            ps.setInt(2, leMedic);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament med = new Medicament(rs.getInt("medicament.MED_DEPOTLEGAL") ,rs.getString("medicament.MED_NOMCOMMERCIAL"));
                lesMedicaments.add(med);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }

    @Override
    public Interragis verifierInterraction(int medPerturbateur, int medPerturbe) {
        Interragis inte = null;
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT MED_PERTURBATEUR, MED_MED_PERTURBE FROM interagis WHERE MED_PERTURBATEUR = ? and MED_MED_PERTURBE = ?;");
            ps.setInt(1, medPerturbateur);
            ps.setInt(2, medPerturbe);
            rs = ps.executeQuery();
            
            if(rs.next()){
                inte = new Interragis(rs.getInt("MED_PERTURBATEUR"),rs.getInt("MED_MED_PERTURBE"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inte;
    }
    
    @Override
    public HashMap<String,Integer> GetDatasPieChart()
    {
        HashMap<String,Integer> lesDatas = new HashMap<>();
        try {

            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT type_individu.TIN_LIBELLE ,COUNT(*) FROM `prescrire` INNER JOIN type_individu on prescrire.TIN_CODE = type_individu.TIN_CODE GROUP BY prescrire.TIN_CODE");
            rs = ps.executeQuery();
            while(rs.next())
            {
                lesDatas.put(rs.getString(1),rs.getInt(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesDatas;
    }
    
    @Override
    public ArrayList<Medicament> GetPlusPrescrit() {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT medicament.MED_NOMCOMMERCIAL\n" +
"FROM medicament\n" +
"INNER JOIN prescrire ON medicament.MED_DEPOTLEGAL=prescrire.MED_DEPOTLEGAL\n" +
"GROUP BY medicament.MED_NOMCOMMERCIAL\n" +
"HAVING COUNT(*) = ( SELECT MAX(nb) FROM (SELECT MED_DEPOTLEGAL,COUNT(MED_DEPOTLEGAL) as nb FROM prescrire GROUP BY MED_DEPOTLEGAL) as temp)");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament med = new Medicament(rs.getString(1));
                lesMedicaments.add(med);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }
    
    @Override
    public ArrayList<Medicament> GetMoinsPrescrit() {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT medicament.MED_NOMCOMMERCIAL\n" +
"FROM medicament\n" +
"INNER JOIN prescrire ON medicament.MED_DEPOTLEGAL=prescrire.MED_DEPOTLEGAL\n" +
"GROUP BY medicament.MED_NOMCOMMERCIAL\n" +
"HAVING COUNT(*) = ( SELECT MIN(nb) FROM (SELECT MED_DEPOTLEGAL,COUNT(MED_DEPOTLEGAL) as nb FROM prescrire GROUP BY MED_DEPOTLEGAL) as temp)");
            rs = ps.executeQuery();
            while(rs.next())
            {
                Medicament med = new Medicament(rs.getString(1));
                lesMedicaments.add(med);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }

    @Override
    public HashMap<String,Integer> GetDatasBarChart() {
        HashMap<String, Integer> lesDatas = new HashMap<>();
        try {

            maCnx = ConnexionBDD.getCnx();
            ps = maCnx.prepareStatement("SELECT famille.FAM_LIBELLE, COUNT(*) FROM medicament INNER JOIN famille on medicament.FAM_CODE = famille.FAM_CODE GROUP BY famille.FAM_LIBELLE");
            rs = ps.executeQuery();
            while(rs.next())
            {
                lesDatas.put(rs.getString(1), rs.getInt(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesDatas;
    }
}