/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Interragis;
import Entity.Medicament;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pheni
 */
public class ModelInterragir extends AbstractTableModel{
    
    private String[] colonnes = {"Nom"};
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
    
    public void loadDatas(ArrayList<Medicament> lesInterractions)
    {
        rows = new Vector<>();
        for(Medicament inte : lesInterractions)
        {
            rows.add(new String[]{String.valueOf(inte.getMed_nomcommercial())});
        }
        fireTableChanged(null);
    
    }
}
