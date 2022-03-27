/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.TypeIndividu;
import Entity.Utilisateur;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maxim
 */
public class ModelUtilisateur extends AbstractTableModel {
    
    private String[] colonnes = {"N°","Login","Mot de passe"};
    private Vector<String[]> rows;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }
    
    @Override
    public String getColumnName(int column) {
        return colonnes[column]; 
    }
    
    public void loadDatas(ArrayList<Utilisateur> lesUtilisateurs)
    {
        rows = new Vector<>();
        for(Utilisateur user : lesUtilisateurs)
        {
            rows.add(new String[]{String.valueOf(user.getIdUser()), user.getLogin(),user.getMdp()});
        }
        fireTableChanged(null);
    
    }
}
