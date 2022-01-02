/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Medicament;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pheni
 */
public class ModelMedicament extends AbstractTableModel{
    
    private String[] colonnes = {"Numéro","Nom"};
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
    public String getColumnName(int column)
    {
        return colonnes[column];
    }
    
    public void loadDatas(ArrayList<Medicament> lesMedicaments)
    {
        rows = new Vector<>();
        for(Medicament med : lesMedicaments)
        {
            rows.add(new String[]{String.valueOf(med.getMed_depotlegal()),med.getMed_nomcommercial()});
        }
        fireTableChanged(null);
    }
}
