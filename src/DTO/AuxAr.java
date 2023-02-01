/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import static DTO.CalculoErro.calculaMAD;
import static DTO.CalculoErro.calculaMAE;
import static DTO.CalculoErro.calculaMAPE;
import static DTO.CalculoErro.somaErroABS;
import static DTO.CalculoErro.somaErroABSNormalizada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacka
 */
public class AuxAr {
    //pesos e coeficiente
    private List<Float> pesos;
    //lista de dados
    private List<Float> dados;
    
    //listas de dados auto-regressivo
    private List<Float> autoAr;
    //lista de erros
    private List<Float> erroAr;
    //vetor que acumula as posições que houve a substituição
    //seu erro será nulo, e isso tendencia o mape
    private List<Integer> subsAr; 
    private List<Integer> copiaAr;
    //soma
    private Float madAR;
    private Float maeAR;
    private Float mapeAR;

    public AuxAr(List<Float> pesos, List<Float> dados) {
        this.pesos = pesos;
        this.dados = dados;
        //listas auxiliares
        this.autoAr =  new ArrayList<Float>();
        this.erroAr =  new ArrayList<Float>();
        this.subsAr = new ArrayList<Integer>();
        this.copiaAr = new ArrayList<Integer>();
        //valores acumulados  
        this.madAR = Float.parseFloat("0");
        this.maeAR = Float.parseFloat("0");
        this.mapeAR = Float.parseFloat("0");
        this.preencherAutoAR();
        this.calculaErro();
        //teste-----------------------------------------------------------------
        System.out.println("-----------------------------------------------");
        System.out.println(this.autoAr);
        System.out.println("-----------------------------------------------");
        System.out.println(this.dados);
        //----------------------------------------------------------------------
        //teste-----------------------------------------------------------------
        this.relatAnalise();
        System.out.println("-----------------------------------------------");
        System.out.println(this.erroAr);
        System.out.println("-----------------------------------------------");
        System.out.println("Vetor de substituições: "+this.subsAr);
        System.out.println("-----------------------------------------------");
        System.out.println("vetor de copias de valores: "+this.copiaAr);
        //----------------------------------------------------------------------
        this.arMAD();
        //System.out.println(this.madAR);
        this.arMAE();
        //System.out.println(this.maeAR);
        this.arMAPE();
        //System.out.println(this.arMAPE());
        this.relatorio();

    }
    //Getter e Setter
    public List<Float> getDados() {
        return dados;
    }

    public void setDados(List<Float> dados) {
        this.dados = dados;
    }

    public List<Float> getAutoAr() {
        return autoAr;
    }

    public void setAutoAr(List<Float> autoAr) {
        this.autoAr = autoAr;
    }

    public List<Float> getErroAr() {
        return erroAr;
    }

    public void setErroAr(List<Float> erroAr) {
        this.erroAr = erroAr;
    }

    public List<Integer> getSubsAr() {
        return subsAr;
    }

    public void setSubsAr(List<Integer> subsAr) {
        this.subsAr = subsAr;
    }

    public String getMadAR() {
        return ""+madAR;
    }

    public void setMadAR(String madAR) {
        this.madAR = Float.parseFloat(madAR);
    }

    public String getMaeAR() {
        return ""+maeAR;
    }

    public void setMaeAR(String maeAR) {
        this.maeAR = Float.parseFloat(maeAR);
    }

    public String getMapeAR() {
        return ""+mapeAR;
    }

    public void setMapeAR(String mapeAR) {
        this.mapeAR = Float.parseFloat(mapeAR);
    }

    //------Funções Administrativas entre vetores--------
    private void relatorio() {
        System.out.println("-----------------------------------------------");
        System.out.println("Desvio Absoluto Medio: " + this.getMadAR());
        System.out.println("Erro Absoluto Medio: " + this.getMaeAR());
        System.out.println("Erro Absoluto Medio percentual: " + this.getMapeAR() + "%");
        System.out.println("QTD substituida: " + this.subsAr.size());
        System.out.println("QTD copiada: " + this.copiaAr.size());
        System.out.println("Numero de elementos (n): " + (this.erroAr.size()-
                                                          this.copiaAr.size()-
                                                          this.subsAr.size()));
    }
    
    //função para teste
    private void relatAnalise(){
        System.out.println("-----------------------------------------------");
        System.out.println("lista de Dados:");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < this.dados.size(); i++) {
            if(//(this.dados.get(i).compareTo(Float.parseFloat("0")) == 0) || 
                this.dados.get(i) == null){
                System.out.println("index: "+(i+2)+"|--| valor: "+this.dados.get(i));
            }
        }
        System.out.println("-----------------------------------------------");
        System.out.println("lista de AR:");
        System.out.println("-----------------------------------------------");
        for (int o = 0; o < this.autoAr.size(); o++) {
            if(//(this.autoAr.get(o).compareTo(Float.parseFloat("0")) == 0) || 
               this.autoAr.get(o) == null){
                System.out.println("index: "+(o+2)+"|--| valor: "+this.autoAr.get(o));
            }
        }
        System.out.println("-----------------------------------------------");
        System.out.println("lista de Erro:");
        System.out.println("-----------------------------------------------");
        for (int u = 0; u < this.erroAr.size(); u++) {
            if(//(this.erroAr.get(u).compareTo(Float.parseFloat("0")) == 0) || 
               this.erroAr.get(u) == null){
                System.out.println("index: "+(u+2)+"|--| valor: "+this.erroAr.get(u));
            }
        }
        System.out.println("-----------------------------------------------");
    }
    
    private void preencherAutoAR() {
        for(int index = 0; index < this.dados.size(); index++){
            if(this.autoAr.isEmpty() || 
               !this.checkCadeia(index-1)){
                this.autoAr.add(this.dados.get(index));
                this.copiaAr.add(index);
            }else{
                if(this.checkCadeia(index-1) &&
         //          this.trocaValorNull(index) &&
                   (this.dados.get(index) != null)){
                    this.formulaAR(index-1);                    
                }else{
                    if((this.dados.get(index) == null) &&
                        this.checkCadeia(index-1) &&
                        this.trocaValorNull(index)){
                        this.formulaAR(index-1);
                        this.troca(index);                        
                    }else{
                        this.autoAr.add(this.dados.get(index));
                        this.copiaAr.add(index);
                    }
                }
            }  
        }
    }

    //Predição-troca o valor null pelo valor predito    
    private void troca(int index) {
        this.dados.remove(index);
        this.dados.add(index, this.autoAr.get(index));
        this.subsAr.add(index);
    }
    
    //verifica se eh possivel trocar valor null
    //obedece as regras das 3 substituições    
    private boolean trocaValorNull(int index) {
        //---------------------------------------------------//
        return !(this.subsAr.contains(index-1) && 
                this.subsAr.contains(index-2) &&
                this.subsAr.contains(index-3));
    }

    //verifica se existe valor null na cadeia de valores 
    //na formula arima de pesos
    private boolean checkCadeia(int inicial) {
        if((this.autoAr.size() - this.pesos.size()) < 0){
            return false;
        }
        for (int index = 0; index < this.pesos.size(); index++ ){
            if(this.dados.get(inicial - index) == null){
                return false;
            }
        }
        return true;
    }
    
    //------Funções para calculo-------
    //calcula o vetor erroAR   
    private void calculaErro() {
        for(int index = 0; index < this.dados.size(); index++){        
            if(this.autoAr.isEmpty() || this.dados.isEmpty()){
                //mensagem para erro de listagem
                System.out.println("(AuxAr-void calculoErro):lista de dados ou lista de predicao vazias...");
            }else{
                if((this.autoAr.get(index) == null || 
                    this.dados.get(index) == null) || 
                    (this.copiaAr.contains(index) ||
                     this.subsAr.contains(index))){
                    this.erroAr.add(null);
                }else{
                    this.erroAr.add((this.dados.get(index)-
                                     this.autoAr.get(index)));
                }
            }
        }    
    }

    //Equação arima de pesos obs: add null no erro para a logica fazer sentido
    private void formulaAR(int index) {
        float soma = 0;
        for(int pos = 0; pos < this.pesos.size(); pos++){
            soma += this.dados.get(index - pos)*this.pesos.get(pos);
        }
        this.autoAr.add(soma);
    }
    
    //contador de valores nulls
    private int contNull(List<Float> lista) {
        int qtd = 0;
        for(int index = 0; index < lista.size(); index++){
            if(lista.get(index) == null){
                qtd++;
            }
        }
        return qtd;    
    }
    
    //Desvio Absoluto Médio
    private void arMAD() {
        float abs = somaErroABS(this.erroAr, this.subsAr);
        //int cont = this.contNull(this.autoAr);
        float mad = calculaMAD(abs, 
                            this.erroAr.size(), 
                             this.subsAr.size(), 
                            this.copiaAr.size());
        this.setMadAR(""+mad);    
    }

    //Erro Médio Absoluto
    private void arMAE() {
       float absn = somaErroABSNormalizada(this.dados, 
                                            this.erroAr,
                                            this.subsAr);
        //int cont = this.contNull(this.autoAr);
        float mae = calculaMAE(absn, 
                            this.erroAr.size(), 
                             this.subsAr.size(), 
                            this.copiaAr.size());
        this.setMaeAR(""+mae);
    }

    //Erro Absoluto Médio Percentual
    private void arMAPE() {
       this.setMapeAR(calculaMAPE(this.getMaeAR()).toString());        
    }
}
