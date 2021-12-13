/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Etat;
import Entity.Ticket;
import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author jbuffeteau
 */
public interface IMetier 
{
    public User GetUnUser(String login, String mdp);
    public ArrayList<User> GetAllUsers();
    public ArrayList<Ticket> GetAllTickets();
    public ArrayList<Ticket> GetAllTicketsByIdUser(int idUser);
    public ArrayList<Etat> GetAllEtats();
    public int GetIdEtat(String nomEtat);
    public void InsererTicket(int idTicket, String nomTicket,String dateTicket, int idUser, int idEtat);
    public int GetLastIdTicket();
    public void ModifierEtatTicket(int idTicket, int idEtat);
}
