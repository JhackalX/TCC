/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl.Interface;

import Ctrl.Geral.CtrlGeral;
import Interface.Layout;
import javax.swing.JFrame;

/**
 *
 * @author jacka
 */
public class CtrlInterface {
    
    private Layout tela;
    private CtrlGeral principal;
    private CtrlGeral gerDominio;

    public CtrlInterface() {
        gerDominio = new CtrlGeral();
        
    }
    
    public void ExibirJanela(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        tela = new Layout();
        tela.setVisible(true);
    }
    
    public void InicializarComponente(){
        tela.iniciarVariaveis();
    }

    public void DescricaoArVisible(boolean entrada){
        tela.mostrarDescricaoAr(entrada);
    }
    
    public void DescricaoESVisible(boolean entrada){
        tela.mostrarDescricaoEs(entrada);
    }
    
    
}
