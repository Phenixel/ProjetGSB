/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Famille;
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
    public Famille GetAllFamille(Integer FAM_CODE, String FAM_LIBELLE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
