/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl.Interface;

import Interface.WindowDecorator;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author jacka
 */
public class CtrlInterface {
    private JFrame janela;
    private CtrlInterface ctrl;
    
    private WindowDecorator windowDeorator;    

    public CtrlInterface() {
        this.initComponets();
      
    }
    public static CtrlInterface ctrlInterface () {
        
        CtrlInterface ctrl = new CtrlInterface();
        
        return ctrl;
    }    
    public void ExibirJanela(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.janela.setVisible(true);
    }
    
   private void initComponets(){

        this.janela = new JFrame();
        this.janela.setSize(1200, 600);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.janela.setVisible(true);
        this.janela.setLayout(new BorderLayout());
        //this.face.setBackground(Color.red);        
        this.windowDeorator = WindowDecorator.decorator(this.janela);
        
        this.janela.repaint();        
    }

    public void InterfaceReady(){
        this.janela.setVisible(true);
    }

    public JFrame getJanela(){
        return this.janela;
    }
    
    public void DescricaoArVisible(boolean entrada){
//        tela.mostrarDescricaoAr(entrada);
    }
    
    public void DescricaoESVisible(boolean entrada){
//        tela.mostrarDescricaoEs(entrada);
    }
    
    
}
