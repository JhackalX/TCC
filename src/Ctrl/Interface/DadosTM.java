/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl.Interface;

import Obj.Model.Dados;
import Obj.Model.Info;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jacka
 */
public class DadosTM extends AbstractTableModel {
    
    private Info info;
    private String[] colunas;
    private List<Dados> linhas;


    public DadosTM() {
        this.info = new Info();
        this.linhas = new ArrayList<Dados>();
    }

    public DadosTM(List<Dados> linhas, String[] colunas) {
        this.colunas = colunas;
        this.linhas = linhas;
    }

    public DadosTM(Info info) {
        this.info = info;
        this.colunas = info.getColuna();
        this.linhas = info.getLista();
    }
          
    @Override
    public int getRowCount() {
        if(this.linhas == null){
            return 0;
        }else{      
            return this.linhas.size();
        }
    }

    @Override
    public int getColumnCount() {
        if(this.colunas == null){
            return 0;
        }else{
            return this.colunas.length;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
    
    public void setColumnName(String[] colunas){
        this.colunas = colunas;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Dados dado = this.linhas.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return dado.getDataBr();
            case 1:
                return dado.getPeriodo();
            case 2:
                return dado.getValor().replace('.', ',');
            default :
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");
        }  
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){

        Dados dado = this.linhas.get(rowIndex);
            
        switch(columnIndex) {
            case 0:
                dado.setData(aValue.toString());
                break;
            case 1:
                dado.setPeriodo(aValue.toString());
                break;
            case 2:
                dado.setValor(aValue.toString());//observar as passagens de '.' e ','
                break;
            default :
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");  
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void setValueAt(Object aValue, int rowIndex){

        Dados dado = this.linhas.get(rowIndex);
                
        dado.setData(aValue.toString());
        dado.setPeriodo(aValue.toString());
        dado.setValor(aValue.toString());
  
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public Dados getDados(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    //mudar pois os dados são adicionados e ordenados automaticamente
    public void addObj(Dados obj){
        Dados novo = obj;
        this.linhas.add(novo);

        int ultimoIndice = getRowCount() -1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        //fireTableDataChanged();
        //System.out.println(novo.toString());
    }

    //mudar pois os dados são adicionados e ordenados automaticamente
    public void addDados(Info obj){
        Info info = obj;
        this.colunas = (info.getColuna());
        //System.out.println(linhas.toString());
        //obj.listarMedicao();
        for(int i = 0; i < info.getLista().size(); i++){
            //obj.getLista().get(i).toString();
            this.addObj(info.getLista().get(i));
            fireTableDataChanged();
        }
        //info.listarMedicao();
    }
    
    public void remove(int indiceLinha){
        this.linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    //ainda a testar
    public void addLista(List<Dados> obj){
        int tamanhoAntigo = getRowCount();
        
        this.linhas.addAll(obj);
        fireTableRowsInserted(tamanhoAntigo, getRowCount()-1);
    }
    
    public void limpar(){
        this.linhas.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty(){
        return linhas.isEmpty();
    }
    
}
