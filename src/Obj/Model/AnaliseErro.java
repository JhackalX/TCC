/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Obj.Model;

import java.util.Objects;

/**
 *
 * @author jacka
 */
public class AnaliseErro {
    private int mes;
    private int ano;
    
    private String coluna;
    
    private String mad;
    private String mae;
    private String mape;

    public AnaliseErro() {
    }

    public AnaliseErro(String coluna, 
                       int ano, 
                       int mes, 
                       String mad, 
                       String mae, 
                       String mape) {
        this.mes = mes;
        this.ano = ano;
        this.coluna = coluna;
        this.mad = mad;
        this.mae = mae;
        this.mape = mape;
    }

    public String getMes() {
        return "" + mes;
    }

    public int getIntMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getAno() {
        return "" + ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getMad() {
        return mad;
    }

    public void setMad(String mad) {
        this.mad = mad;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getMape() {
        return mape;
    }

    public void setMape(String mape) {
        this.mape = mape;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.mes;
        hash = 29 * hash + this.ano;
        hash = 29 * hash + Objects.hashCode(this.coluna);
        hash = 29 * hash + Objects.hashCode(this.mad);
        hash = 29 * hash + Objects.hashCode(this.mae);
        hash = 29 * hash + Objects.hashCode(this.mape);
        return hash;
    }

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
        final AnaliseErro other = (AnaliseErro) obj;
        if (this.mes != other.mes) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.coluna, other.coluna)) {
            return false;
        }
        if (!Objects.equals(this.mad, other.mad)) {
            return false;
        }
        if (!Objects.equals(this.mae, other.mae)) {
            return false;
        }
        return Objects.equals(this.mape, other.mape);
    }
    
    public String impprimir(){
        return"------------------------------------------------------" 
             + "\n Coluna: "+ this.getColuna()
             + "\n Ano: "+ this.getAno()
             + "\n Mes: "+ this.getMes()
             + "\n Desvio Absoluto Médio: "+ this.getMad()
             + "\n Erro Médio Absoluto: "+ this.getMae()
             + "\n Erro Absoluto Médio Percentual: "+ this.getMape();
    }
  
}
