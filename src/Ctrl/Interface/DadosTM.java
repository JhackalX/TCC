/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl.Interface;
import DTO.AuxAr;
import Funcoes.Funcionalidades;
import Obj.Model.Info;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import DTO.AuxEs;
/**
 *
 * @author jacka
 */
public class DadosTM extends AbstractTableModel {
    
    //private Info info;
    private String[] colunas;
    //private List<Dados> linhas;
    private List<Object> linhas;

    public DadosTM() {
        //this.info = new Info();
        this.linhas = new ArrayList<Object>();
    }

    public DadosTM(List<Object> linhas, String[] colunas) {
        this.colunas = colunas;
        this.linhas = linhas;
    }

    public DadosTM(Object obj) {
        //this.info = info;
        this.colunas = Funcionalidades.geraColuna(obj);
        this.linhas = Funcionalidades.geraListaD(obj);
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
        
        //Dados dado = this.linhas.get(rowIndex);
        List<String> dado = Funcionalidades.getObject(this.linhas, rowIndex);
                
        switch(columnIndex) {
            case 0:
                return dado.get(0);
            case 1:
                return dado.get(1);
            case 2:
                return dado.get(2).replace('.', ',');
            default :
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");
        }  
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){

        //Dados dado = this.linhas.get(rowIndex);
        List<String> dado = Funcionalidades.getObject(this.linhas, rowIndex);
        
        switch(columnIndex) {
            case 0:
                dado.get(0).replaceAll(dado.get(0), aValue.toString());
                break;
            case 1:
                dado.get(1).replaceAll(dado.get(1), aValue.toString());
                //dado.setPeriodo(aValue.toString());
                break;
            case 2:
                dado.get(2).replaceAll(dado.get(2), aValue.toString());
                //dado.setValor(aValue.toString());//observar as passagens de '.' e ','
                break;
            default :
                throw new IndexOutOfBoundsException("columnIndex out of bounds!");  
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void setValueAt(Object aValue, int rowIndex){

        //Dados dado = this.linhas.get(rowIndex);
        List<String> dado = Funcionalidades.getObject(this.linhas, rowIndex);
        dado.get(0).replaceAll(dado.get(0), aValue.toString());
        dado.get(1).replaceAll(dado.get(1), aValue.toString());
        dado.get(2).replaceAll(dado.get(2), aValue.toString());
        //dado.setData(aValue.toString());
        //dado.setPeriodo(aValue.toString());
        //dado.setValor(aValue.toString());
  
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public Object getDados(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    //mudar pois os dados são adicionados e ordenados automaticamente
    public void addObj(Object obj){
        Object novo = obj;
        this.linhas.add(novo);

        int ultimoIndice = getRowCount() -1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        //fireTableDataChanged();
        //System.out.println(novo.toString());
    }

    //mudar pois os dados são adicionados e ordenados automaticamente
//    public void addDados(Info obj){
//        Info info = obj;
//        this.colunas = (info.getColuna());
//        //System.out.println(linhas.toString());
//        //obj.listarMedicao();
//        for(int i = 0; i < info.getLista().size(); i++){
//            //obj.getLista().get(i).toString();
//            this.addObj(info.getLista().get(i));
//            fireTableDataChanged();
//        }
//        //info.listarMedicao();
//    }
    
    public void remove(int indiceLinha){
        this.linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    //ainda a testar
    public void addLista(List<Object> obj){
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
  //=========================================================================//
    //função para teste
    public List<Float> getLista(){
        List<Float> dados = new ArrayList<Float>();
        dados = Funcionalidades.geraLista(linhas);
        /*for(int index = 0; index < this.linhas.size(); index++){
            if(this.linhas.get(index).equals("null")){
                dados.add(null);
            }else{
                dados.add(Float.parseFloat(this.linhas.get(index).getValor()));
            }
        }*/
        List<Float> pesos = new ArrayList<Float>();
        pesos.add(Float.parseFloat("0.5")); 
        pesos.add(Float.parseFloat("0.3"));
        pesos.add(Float.parseFloat("0.2"));
        AuxAr met = new AuxAr(pesos, dados);
        return dados;
    }
    
}
