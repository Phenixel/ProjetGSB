/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Etat;
import Entity.Ticket;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbuffeteau
 */
public class FonctionsMetier implements IMetier
{
    @Override
    public User GetUnUser(String login, String mdp)
    {
        User unUser = null;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idUser, nomUser,prenomUser, statutUser from users where loginUser = '"+login+"' and pwdUser = '"+mdp+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                unUser = new User(rs.getInt("idUser"), rs.getString("nomUser"),rs.getString("prenomUser"),rs.getString("statutUser"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unUser;
    }

    @Override
    public ArrayList<Ticket> GetAllTickets()
    {
        ArrayList<Ticket> lesTickets = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idTicket, nomTicket,dateTicket, nomEtat from tickets inner join etats on numEtat = idEtat");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Ticket tic = new Ticket(rs.getInt("idTicket"),rs.getString("nomTicket"),rs.getString("dateTicket"),rs.getString("nomEtat"));
                lesTickets.add(tic);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTickets;
    }

    @Override
    public ArrayList<Ticket> GetAllTicketsByIdUser(int idUser)
    {
        ArrayList<Ticket> lesTickets = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idTicket, nomTicket,dateTicket, nomEtat from tickets inner join etats on numEtat = idEtat and numUser = "+idUser);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Ticket tic = new Ticket(rs.getInt("idTicket"),rs.getString("nomTicket"),rs.getString("dateTicket"),rs.getString("nomEtat"));
                lesTickets.add(tic);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesTickets;
    }

    @Override
    public void InsererTicket(int idTicket, String nomTicket, String dateTicket, int idUser, int idEtat) 
    {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("insert into tickets values("+idTicket+",'"+nomTicket+"','"+dateTicket+"',"+idUser+","+idEtat+")");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ModifierEtatTicket(int idTicket, int idEtat) 
    {
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update tickets set numEtat = "+idEtat + " where idTicket = "+idTicket);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<User> GetAllUsers()
    {
        ArrayList<User> lesUsers = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idUser, nomUser,prenomUser,statutUser from users");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                User unUser = new User(rs.getInt("idUser"), rs.getString("nomUser"),rs.getString("prenomUser"),rs.getString("statutUser"));
                lesUsers.add(unUser);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesUsers;    
    }

    @Override
    public int GetLastIdTicket()
    {
        int numTicket = 0;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select max(idTicket) as num from tickets");
            ResultSet rs = ps.executeQuery();
            rs.next();
            numTicket = rs.getInt("num") + 1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numTicket;
    }

    @Override
    public int GetIdEtat(String nomEtat)
    {
        int numEtat = 0;
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idEtat from etats where nomEtat = '"+nomEtat+"'");
            ResultSet rs = ps.executeQuery();
            rs.next();
            numEtat = rs.getInt("idEtat");
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numEtat;
    }

    @Override
    public ArrayList<Etat> GetAllEtats()
    {
        ArrayList<Etat> lesEtats = new ArrayList<>();
        try {
            Connection cnx = ConnexionBDD.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idEtat, nomEtat from etats");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Etat unEtat = new Etat(rs.getInt("idEtat"), rs.getString("nomEtat"));
                lesEtats.add(unEtat);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionsMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesEtats;    
    }
}
