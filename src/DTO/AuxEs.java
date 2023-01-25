/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;
import static DTO.CalculoErro.calculaMAPE;
import static DTO.CalculoErro.calculaMAD;
import static DTO.CalculoErro.calculaMAE;
import static DTO.CalculoErro.somaErroABS;
import static DTO.CalculoErro.somaErroABSNormalizada;
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
        this.subsEs = new ArrayList<Integer>();
        //valores acumulados      
        this.madES = Float.parseFloat("0");               
        this.maeES = Float.parseFloat("0");                
        this.mapeES = Float.parseFloat("0");
        this.preencherAutoSmooth();
        this.calculaErro();
        //teste-----------------------------------------------------------------
        System.out.println("-----------------------------------------------");
        System.out.println(this.autoSmoot);
        //----------------------------------------------------------------------
        //teste-----------------------------------------------------------------
        System.out.println("-----------------------------------------------");
        System.out.println(this.erroEs);
        System.out.println("-----------------------------------------------");
        System.out.println(this.subsEs);
        //----------------------------------------------------------------------
        this.esMAD();
        //System.out.println(this.madES);
        this.esMAE();
        //System.out.println(this.maeES);
        this.esMAPE();
        //System.out.println(this.esMAPE());
        this.relatorio();
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

    public String getMadES() {
        return ""+madES;
    }

    public void setMadES(String madES) {
        this.madES = Float.parseFloat(madES);
    }

    public String getMaeES() {
        return ""+maeES;
    }

    public void setMaeES(String maeES) {
        this.maeES = Float.parseFloat(maeES);
    }

    public String getMapeES() {
        return ""+mapeES;
    }

    public void setMapeES(String mapeES) {
        this.mapeES = Float.parseFloat(mapeES);
    }
    
    //------Funções Administrativas entre vetores--------
    public void relatorio(){
        System.out.println("-----------------------------------------------");
        System.out.println("Desvio Absoluto Medio: " + this.getMadES());
        System.out.println("Erro Absoluto Medio: " + this.getMaeES());
        System.out.println("Erro Absoluto Medio percentual: " + this.getMapeES() + "%");
        System.out.println("QTD substituida: " + this.subsEs.size());
        System.out.println("Numero de elementos (n): " + (this.autoSmoot.size()-
                                                          this.subsEs.size()-
                                                          this.contNull(this.autoSmoot)));
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
    
    //Predição-troca o valor null pelo valor predito
    public void troca(int index){
        this.dados.remove(index);
        this.dados.add(index, this.autoSmoot.get(index));
        this.subsEs.add(index);
    }
    
    //verifica se eh possivel trocar valor null
    //obedece as regras das 3 substituições
    public boolean trocaValorNull(int index){
        //---------------------------------------------------//
        return !(this.subsEs.contains(index-1) && 
                this.subsEs.contains(index-2) &&
                this.subsEs.contains(index-3));
    }
    
    //------Funções para calculo-------
    //calcula o vetor erroES
    public void calculaErro(){
        for(int index = 0; index < this.dados.size(); index++){        
            if(this.autoSmoot.isEmpty() || this.dados.isEmpty()){
                //mensagem para erro de listagem
                System.out.println("(AuxEs-void calculoErro):lista de dados ou lista de predicao vazias...");
            }else{
                if(this.autoSmoot.get(index) == null && this.dados.get(index) == null){
                    this.erroEs.add(null);
                }else{
                    this.erroEs.add((this.dados.get(index)-this.autoSmoot.get(index)));
                }
            }
        }
    }
    
    //Equação Exponetial Smooth obs: add null no erro para a logica fazer sentido
    public void formulaES(int index){
        this.autoSmoot.add(this.autoSmoot.get(index-1) + Float.parseFloat
                          ("" + this.coefSp * (this.dados.get(index-1)-
                                               this.autoSmoot.get(index-1))));
    }
    
    //contador de valores nulls
    public int contNull(List<Float> lista){
        int qtd = 0;
        for(int index = 0; index < lista.size(); index++){
            if(lista.get(index) == null){
                qtd++;
            }
        }
        return qtd;
    }
    
    //Desvio Absoluto Médio
    public void esMAD(){
        float abs = somaErroABS(this.erroEs, this.subsEs);
        int cont = this.contNull(this.autoSmoot);
        float mad = calculaMAD(abs, 
                            this.erroEs.size(), 
                            this.subsEs.size(), 
                            cont);
        this.setMadES(""+mad);
    }
    
    //Erro Médio Absoluto
    public void esMAE(){
        float absn = somaErroABSNormalizada(this.dados, this.erroEs, this.subsEs);
        int cont = this.contNull(this.autoSmoot);
        float mae = calculaMAE(absn, 
                            this.erroEs.size(), 
                            this.subsEs.size(), 
                            cont);
        this.setMaeES(""+mae);
    }
    
    //Erro Absoluto Médio Percentual
    public void esMAPE(){
        this.setMapeES(calculaMAPE(this.getMaeES()).toString());        
    }
    
}
