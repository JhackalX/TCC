/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjDao;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
        if(temperatura == 99999.0){
            return "Medicao{" + "data: " + dateFormate.format(data) + 
                                ", hora: " + hora + 
                                ", temperatura: null" +'}';
        }else{
            return "Medicao{" + "data: " + dateFormate.format(data) + 
                        ", hora: " + hora + 
                        ", temperatura: " + temperatura + '}';
        }
        
    }
    
    //funções práticas de lista
    
    
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
