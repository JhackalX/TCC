/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jacka
 */
public abstract class ObjectTableModel<T> extends AbstractTableModel {

    private List<T> objectRows = new ArrayList<>();

    public List<T> getObjectRows() {
        return objectRows;
    }

    public void setObjectRows(List<T> objectRows) {
        this.objectRows = objectRows;
    }

    @Override
    public int getRowCount() {
        return objectRows.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T t = objectRows.get(rowIndex);
        return getValueAt(t, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (objectRows.isEmpty()) {
            return Object.class;
        }
        Object valueAt = getValueAt(0, columnIndex);
        return valueAt != null ? valueAt.getClass() : Object.class;
    }

    public abstract Object getValueAt(T t, int columnIndex);

    @Override
    public abstract String getColumnName(int column);
    
}
