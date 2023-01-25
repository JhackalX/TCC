/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;



/**
 *
 * @author jacka
 */
public class CalculoErro {

    //soma do erro
    public static float somaErroABS(List<Float> erro, List<Integer> sub){
        float soma;
        soma = 0; 
            for(int i = 0; i < erro.size(); i++){
                if(erro.get(i) != null && 
                   !sub.contains(i)){
                    soma += Float.parseFloat(""+Math.abs(erro.get(i)));                
                }
            }        
        return soma;    
    }
    
    //soma do erro normalizado
    public static float somaErroABSNormalizada(List<Float> dados, 
                                        List<Float> erro, 
                                        List<Integer> sub){
        float soma;
        soma = 0; 
            for(int i = 0; i < erro.size(); i++){
                if(erro.get(i) != null && 
                   !sub.contains(i)){
                    soma += Float.parseFloat(""+Math.abs(Float.parseFloat(""+erro.get(i))/
                                     Float.parseFloat(""+dados.get(i))));
                }
            }        
        return soma;    
    }
//------------------------------------------------------------------------------
    //Desvio Absoluto Médio
    public static Float calculaMAD(float somaErroABS, 
                            int erroQTD, 
                            int subQTD, 
                            int nullQTD){
        return ((float)((somaErroABS)/(erroQTD - subQTD - nullQTD)));        
    }
    
    //Erro Médio Absoluto
    public static Float calculaMAE(float somaErroABSNormalizada, 
                            int erroQTD, 
                            int subQTD, 
                            int nullQTD){
        return ((float)((somaErroABSNormalizada)/(erroQTD - subQTD - nullQTD)));        
    }
    
    //Erro Absoluto Médio Percentual
    public static Float calculaMAPE(String mae){
        return (((float)(Float.parseFloat(""+mae)))*100);       
    }
    
}
