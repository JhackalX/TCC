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
public class AuxAr {
    //pesos e coeficiente
    private List<Float> pesos;
    //lista de dados
    private List<Float> dados;
    
    //listas de dados auto-regressivo
    private List<Float> autoAR;
    //lista de erros
    private List<Float> erroAr;
    //lista de MAPEs
    private List<Float> mapeAr;
    //dados de discarte para o mape
    private List<Integer> discartAs;

    //soma
    private Float madAR;
    private Float maeAR;
    private Float mapeAR;

    public AuxAr(List<Float> pesos, List<Float> dados) {
        this.pesos = pesos;
        this.dados = dados;
        //listas auxiliares
        this.autoAR =  new ArrayList<Float>();
        this.erroAr =  new ArrayList<Float>();
        this.mapeAr =  new ArrayList<Float>();
        //valores acumulados  
        this.madAR = Float.parseFloat("0");
        this.maeAR = Float.parseFloat("0");
        this.mapeAR = Float.parseFloat("0");
    }

    public AuxAr() {
    }

}
