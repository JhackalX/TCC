/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import Interface.WindowDecorator;
import javax.swing.JFrame;

/**
 *
 * @author jacka
 */
public class TesteTcc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        JFrame janela = new JFrame();     
        WindowDecorator teste = Interface.WindowDecorator.decorator(janela);
        janela.show();        

    }
    
}
