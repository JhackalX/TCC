/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacka
 */
public class AuxEs {
    //pesos e coeficiente
    private double coefSp;
    //lista de dados
    private List<Float> dados;

    //listas de dados auto-regressivo
    private List<Float> autoSmoot;
    //lista de erros
    private List<Float> erroEs;
    //lista de MAPEs
    private List<Float> mapeEs;
    //dados de discarte para o mape

    private List<Integer> discartEs;
    //vetor que acumula as posições que houve a substituição
    //seu erro será nulo, e isso tendencia o mape
    private List<Integer> subsEs;
    //soma
    private Float madES;
    private Float maeES;
    private Float mapeES;
    
    //construtor
    public AuxEs(List<Float> dados, double coef) {
        
        this.coefSp =coef;
                
        this.dados = dados;
        //listas auxiliares
        this.autoSmoot = new ArrayList<Float>();
        this.erroEs = new ArrayList<Float>();
        this.mapeEs = new ArrayList<Float>();
        this.discartEs = new ArrayList<Integer>();
        this.subsEs = new ArrayList<Integer>();
        //valores acumulados      
        this.madES = Float.parseFloat("0");               
        this.maeES = Float.parseFloat("0");                
        this.mapeES = Float.parseFloat("0");        
        
    }
    
    //Getter e Setter
    public List<Float> getDados() {
        return dados;
    }

    public void setDados(List<Float> dados) {
        this.dados = dados;
    }

    public List<Float> getAutoSmoot() {
        return autoSmoot;
    }

    public void setAutoSmoot(List<Float> autoSmoot) {
        this.autoSmoot = autoSmoot;
    }

    public List<Float> getErroEs() {
        return erroEs;
    }

    public void setErroEs(List<Float> erroEs) {
        this.erroEs = erroEs;
    }

    public List<Float> getMapeEs() {
        return mapeEs;
    }

    public void setMapeEs(List<Float> mapeEs) {
        this.mapeEs = mapeEs;
    }

    public Float getMadES() {
        return madES;
    }

    public void setMadES(Float madES) {
        this.madES = madES;
    }

    public Float getMaeES() {
        return maeES;
    }

    public void setMaeES(Float maeES) {
        this.maeES = maeES;
    }

    public Float getMapeES() {
        return mapeES;
    }

    public void setMapeES(Float mapeES) {
        this.mapeES = mapeES;
    }
    
    public void calculaErro(int index){
        if(this.autoSmoot.isEmpty() || this.dados.isEmpty()){
            //mensagem para erro de listagem
            System.out.println("(AuxEs-void calculoErro):lista de dados ou lista de predicao vazias...");
        }else{
            this.erroEs.add(Math.abs(this.dados.get(index)-this.autoSmoot.get(index)));
        }
    }
    
    //Equação Exponetial Smooth obs: add null no erro para a logica fazer sentido
    public void formulaES(int index){
        this.autoSmoot.add(this.autoSmoot.get(index-1) + Float.parseFloat
                          ("" + this.coefSp * (this.dados.get(index-1)-
                                               this.autoSmoot.get(index-1))));
    }
    
    //preenche meu vetor de predicao
    public void preencherAutoSmooth(){
        for(int index = 0; index < this.dados.size(); index++){
            if(this.autoSmoot.isEmpty()){
                this.autoSmoot.add(this.dados.get(index));
            }else{
                if(this.autoSmoot.get(this.autoSmoot.size()-1) == null){
                    this.autoSmoot.add(this.dados.get(index));
                }else{//erro, sem checagem da quantidade de preenchimento antes da formula 
                    ////maquina de estados
                    if(this.dados.get(index) == null){
                        if(this.trocaValorNull(index) == true){
                            this.formulaES(index);
                            this.troca(index);
                            this.subsEs.add(index);
                        }else{
                            this.autoSmoot.add(this.dados.get(index));
                        }
                    }else{
                        this.formulaES(index);
                    }
                }
            }   
        }
    }
    
    //Função de recursão--obs: tem algo errado aqui resolver parcialmente
    public void dividirConquistar(int index){

        int cont = 0;

        if ((this.dados.get(index) == null) && (index < this.dados.size())){
            
            this.autoSmoot.add(this.dados.get(index));
            index++;
            this.dividirConquistar(index);
                
        }else{
            if((this.dados.get(index) != null) && (index < this.dados.size())){
            
                this.autoSmoot.add(this.dados.get(index));
                index++;
                
                while((this.dados.get(index) != null) && (index < this.dados.size())){
                    this.formulaES(index-1);
                    index++;
                }
                
                while((this.dados.get(index) == null) && (cont < 3) && (index < this.dados.size())){
                    this.formulaES(index-1);
                    this.trocaValorNull(index);
                    index++;
                    cont++;
                }
                cont = 0;
                this.dividirConquistar(index);
            }else{
                if(index == this.dados.size()){
                    System.out.println("Acabou");
                }
            }
        }
    }
    
    //Problemas na area nula do vetor
    public void gerarARSE(){

        int index = 0;
        if(this.autoSmoot.isEmpty() == true){

        }else{
            for(int i = 1; i < this.dados.size(); i++){

            }
        }
    }
    //------Funções Administrativas entre vetores--------
    //Predição-troca o valor nulo pelo valor predito
    public void troca(int index){
        this.dados.remove(index);
        this.dados.add(index, this.autoSmoot.get(index));
        this.subsEs.add(index);
    }
    
    //verifica se eh possivel trocar valor nulo
    //obedece as regras das 3 substituições
    public boolean trocaValorNull(int index){
        if(this.subsEs.isEmpty()){
            return true;
        }else{
            //---------------------------------------------------//
            if(this.subsEs.get(this.subsEs.size()-1) != (index-1)){
                return true;
            }else{
                if(this.subsEs.size()-2 < 0){
                    return true;
                }else{
                    if(this.subsEs.get(this.subsEs.size()-2) != (index-2)){
                        return true;
                    }else{
                        if(this.subsEs.size()-3 < 0){
                            return true;
                        }else{
                            //checa os ultimos 3 valores------------//
                            if(this.subsEs.get(this.subsEs.size()-3) != (index-3)){
                                return true;
                            }else{
                                return false;
                            } 
                        }
                    }
                }
            }
        }
    }
    
    //------Funções para calculo-------
    //soma do erro
    public float somaErroABS(){
        float soma;
        soma = 0; 
            for(int i = 0; i < this.erroEs.size(); i++){
                soma += Math.abs(this.erroEs.get(i));
            }        
        return soma;    
    }
    
    //soma do erro normalizado
    public float somaErroABSNormalizada(){
        float soma;
        soma = 0; 
            for(int i = 0; i < this.erroEs.size(); i++){
                soma += Math.abs(this.erroEs.get(i)/this.dados.get(i));
            }        
        return soma;    
    }
    
    //Desvio Absoluto Médio
    public String esMAD(){
        this.madES = (1/this.dados.size())*(this.somaErroABS());    
        return ""+this.madES;    
    }
    
    //Erro Médio Absoluto
    public String esMAE(){
        this.maeES = (1/this.dados.size())*(this.somaErroABSNormalizada());    
        return ""+this.maeES;    
    }
    
    //Erro Absoluto Médio Percentual
    public String esMAPE(){
        this.mapeES = (1/this.dados.size())*(this.somaErroABSNormalizada())*100;    
        return ""+this.mapeES+"%";    
    }
    
}
