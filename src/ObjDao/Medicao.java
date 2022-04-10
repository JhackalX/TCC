/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjDao;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jacka
 */


public class Medicao implements Comparable<Medicao> {
    private Date data;
    private int hora;
    private float temperatura;

    public Medicao() {
    }

    public Medicao(Date data, int hora, float temperatura) {
        this.data = data;
        this.hora = hora;
        this.temperatura = temperatura;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.data);
        hash = 83 * hash + this.hora;
        hash = 83 * hash + Float.floatToIntBits(this.temperatura);
        return hash;
    }


    //equals para comparação de objeto

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicao other = (Medicao) obj;
        if (this.hora != other.hora) {
            return false;
        }
        if (Float.floatToIntBits(this.temperatura) != Float.floatToIntBits(other.temperatura)) {
            return false;
        }
        if (this.data.compareTo(other.data) != 0 ) {
            return false;
        }
        return true;
    }
 
    //to string
    @Override
    public String toString() {
        return "Medicao{" + "data: " + data + 
                        ", hora: " + hora + 
                        ", temperatura: " + temperatura + '}';
    }
    
    //funções práticas de lista
    
    public void adicionarMedicao(List<Medicao> Lista, Medicao Obj){
        if(!Lista.contains(Obj)){
            Lista.add(Obj);
            Obj.ordenarLista(Lista);
        }
    }
    
    public void editarMedicao(List<Medicao> Lista, Medicao Obj, int i){
        Lista.get(i).setData(Obj.getData());
        Lista.get(i).setHora(Obj.getHora());
        Lista.get(i).setTemperatura(Obj.getTemperatura());   
    }
    
    public void excluirMedicao(List<Medicao> Lista, Medicao Obj){
        Lista.remove(Obj);
    }
    
    public void limparGeral(List<Medicao> Lista){
        Lista.removeAll(Lista);
    }
    public void ordenarLista(List<Medicao> Lista){
       boolean troca = true;
       Medicao aux = new Medicao();
       while (troca){
           troca = false;
           for(int i = 0; i < Lista.size()-1; i++){
               if(Lista.get(i).compareTo(Lista.get(i+1)) > 0){
                   aux.setData(Lista.get(i).getData());
                   aux.setHora(Lista.get(i).getHora());
                   aux.setTemperatura(Lista.get(i).getTemperatura());
                   aux.editarMedicao(Lista, Lista.get(i+1), i);
                   aux.editarMedicao(Lista, aux, i+1);
                   troca = true;                   
               }          
           }
       }      
    }
    
    public void listarMedicao(List<Medicao> Lista){
        for (int i = 0; i<Lista.size(); i++){
            System.out.println(Lista.get(i).toString());
        }
        
    }
    //funções práticas de objeto
    
    public void limpar(){
        limparData();
        limparHora();
        limparTemperatura();
    }
    public void limparData(){
        this.data = null;
    }    
    public void limparHora(){
        this.hora = 0;
    }    
    public void limparTemperatura(){
        this.temperatura = 0;
    }

    @Override
    public int compareTo(Medicao outroObj) {
        if (this.data == null){
            System.out.println("Data sem valor gravado!!!");
            return -2;
        }else {
            if (this.data.compareTo(outroObj.getData())<0) { 
                return -1;
                //se this.data < outroObj.data
            }else {
                if (this.data.compareTo(outroObj.getData())>0) { 
                    return 1;
                    //se this.data > outroObj.data
                } else {
                    if(this.hora < outroObj.getHora()){
                        return -1;
                    }else{
                        if(this.hora > outroObj.getHora()){
                            return 1;
                        }else{
                            return 0;
                            //se todas os atributos dos objetos são iguais
                        }                         
                    }
                }
            }
        }           
    } 
    
}
