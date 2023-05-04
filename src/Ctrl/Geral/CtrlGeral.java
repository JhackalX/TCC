/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl.Geral;

import Ctrl.Interface.CtrlInterface;
import Obj.Model.AnaliseErro;
import Obj.Model.AnaliseMensal;

/**
 *
 * @author jacka
 */
public class CtrlGeral {
    
    
    private AnaliseErro vetorAnaliseErro;
    private AnaliseMensal vetorAnaliseMensal;
    
    public CtrlGeral() {
        this.initComponets();        
    }
    
//    public static CtrlGeral ctrlReady(){
//        this.instancia = new CtrlGeral();
//        return this.instancia;
//    }
    public void ctrlReady(){

    }
    
    
    public void fecharJanela(){
//        this.janela.dispose();
    }

    public void runnigJanela(){
//        this.janela.setVisible(true);
    }

    private void initComponets() {

    }

}
