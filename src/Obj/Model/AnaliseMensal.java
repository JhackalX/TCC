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
public class AnaliseMensal {
    
    private int mes;
    private int ano;
    
    private String coluna;
    private String coefSperman;
    private String tendencia;
    private String estacionariedade;

    public AnaliseMensal() {
    }

    public AnaliseMensal(String coluna,
                         int ano,
                         int mes,  
                         String coefSperman, 
                         String tendencia, 
                         String estacionariedade) {
        this.mes = mes;
        this.ano = ano;
        this.coluna = coluna;
        this.coefSperman = coefSperman;
        this.tendencia = tendencia;
        this.estacionariedade = estacionariedade;
    }

    public String getMes() {
        return "" + mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getAno() {
        return "" + ano;
    }

    public int getIntMes() {
        return mes;
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

    public String getCoefSperman() {
        return coefSperman;
    }

    public void setCoefSperman(String coefSperman) {
        this.coefSperman = coefSperman;
    }

    public String getTendencia() {
        return tendencia;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public String getEstacionariedade() {
        return estacionariedade;
    }

    public void setEstacionariedade(String estacionariedade) {
        this.estacionariedade = estacionariedade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.mes;
        hash = 31 * hash + this.ano;
        hash = 31 * hash + Objects.hashCode(this.coluna);
        hash = 31 * hash + Objects.hashCode(this.coefSperman);
        hash = 31 * hash + Objects.hashCode(this.tendencia);
        hash = 31 * hash + Objects.hashCode(this.estacionariedade);
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
        final AnaliseMensal other = (AnaliseMensal) obj;
        if (this.mes != other.mes) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.coluna, other.coluna)) {
            return false;
        }
        if (!Objects.equals(this.coefSperman, other.coefSperman)) {
            return false;
        }
        if (!Objects.equals(this.tendencia, other.tendencia)) {
            return false;
        }
        return Objects.equals(this.estacionariedade, other.estacionariedade);
    }
    
    public String impprimir(){
        return"------------------------------------------------------" 
             + "\n Coluna: "+ this.getColuna()
             + "\n Ano: "+ this.getAno()
             + "\n Mes: "+ this.getMes()
             + "\n Coeficiente de Sperman: "+ this.getCoefSperman()
             + "\n Tendencia: "+ this.getTendencia()
             + "\n Estacionariedade: "+ this.getTendencia();
    }
    
}
