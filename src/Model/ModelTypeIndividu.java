/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.TypeIndividu;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maxim
 */
public class ModelTypeIndividu extends AbstractTableModel {
    
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
    public String getColumnName(int column) {
        return colonnes[column]; 
    }
    
    public void loadDatas(ArrayList<TypeIndividu> lesIndividus)
    {
        rows = new Vector<>();
        for(TypeIndividu tic : lesIndividus)
        {
            rows.add(new String[]{String.valueOf(tic.getTin_code()),tic.getTin_libelle()});
        }
        fireTableChanged(null);
    
    }
}
