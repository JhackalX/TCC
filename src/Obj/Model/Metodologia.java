/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obj.Model;

import java.util.List;

/**
 *
 * @author jacka
 */

public class Metodologia {
    //opcao de escolha de metodologia
    private int opcao;
    //coeficiente exponencial
    private Float coef;
    //lista de pesos
    private List<Float> pesos;
    
    //construtor
    public Metodologia() {
    }

    public Metodologia(String opcao, String coef, List<Float> pesos) {
        this.opcao = Integer.parseInt(opcao);
        this.coef = Float.parseFloat(coef.replace(',', '.'));
        this.pesos = pesos;
    }

    public Metodologia(String opcao, String coef) {
        this.opcao = Integer.parseInt(opcao);
        this.coef = Float.parseFloat(coef.replace(',', '.'));
    }

    public Metodologia(String opcao, List<Float> pesos) {
        this.opcao = Integer.parseInt(opcao);
        this.pesos = pesos;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public Float getCoef() {
        return coef;
    }
    
    public String getCoefBR() {
        return coef.toString().replace('.', ',');
    }

    public void setCoef(String coef) {
        this.coef = Float.parseFloat(coef.replace(',', '.'));
    }

    public List<Float> getPesos() {
        return pesos;
    }

    public Float getValor(int index) {
        return pesos.get(index);
    }
    
    public String getValorBr(int index) {
        return pesos.get(index).toString().replace('.', ',');
    }
    
    public int getQtdPesos(){
        return pesos.size();
    }
    
    //soma a lista de peso
    public Float getSoma(){
        if(!this.pesos.isEmpty() && 
            this.pesos != null){
            Float cont = Float.parseFloat("0");
            for (int i = 0; i < this.pesos.size(); i++){
                cont += this.getValor(i);
            }
            return cont;
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        return "{" + "\n opcao = " + this.opcao + 
                     "\n coef = " + this.coef + 
                     "\n lista = " + this.pesos + '}';
    }

    public void setLista(List<Float> lista) {
        this.pesos = lista;
    }

    public void addPeso(String peso) {
        this.pesos.add(Float.parseFloat(peso.replace(',', '.')));
    }
    
    public void editPeso(String peso, int index) {
        this.removePeso(index);
        this.pesos.add(index, Float.parseFloat(peso.replace(',', '.')));
    }
    
    public void removePeso(int index) {
        this.pesos.remove(index);
    }
    
    //"0"-> tudo certo, "1"-> deu errado, "-1"-> deu merda
    public int verifiar(int opcao){
        
        if(opcao == 1){
            if (this.getSoma() != Float.parseFloat("1") ||  
                this.getSoma() == null){
                return 1;
            }else{
                return 0;
            }
        }else{
            if(opcao == 2){
                if(this.coef > Float.parseFloat("1") || 
                   this.coef < Float.parseFloat("0")){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                return -1;
            }
        }
    }
    
}
