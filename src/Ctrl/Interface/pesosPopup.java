/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrl.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jacka
 */
public class pesosPopup extends JFrame {
    
    private int qtd;
    private List<Float> pesos;
    private Box caixaVertical;
    private List<JLabel> titulo;
    private List<JTextField> campo;
    private JButton avancar, limpar, cancelar;
    
    public pesosPopup(int qtd) {

        this.desenharLayout();
        this.avancar = this.desenharBotoes("avancar");
        this.limpar = this.desenharBotoes("Limpar");
        this.cancelar = this.desenharBotoes("cancelar");
        this.caixaVertical = Box.createVerticalBox();
        this.titulo = new ArrayList<JLabel>();
        this.campo = new ArrayList<JTextField>();
        this.pesos = new ArrayList<Float>();
        
        this.desenharCorpo(qtd);
        this.addCaixa();
        
    }
    private void btLimparActionPerformed(ActionEvent evt){
        System.out.println("limpa");
    }
    private JButton desenharBotoes(String titulo){
        JButton btnNovo = new JButton(titulo);
	btnNovo.setBounds(10, 280, 80, 30);
	btnNovo.setMnemonic('O');
	btnNovo.setToolTipText(titulo);
	//btnNovo.setForeground(Color.BLACK);
	//btnNovo.setBackground(Color.lightGray);
	//add(btnNovo);
        return btnNovo;
    }
    
    private void addCaixa(){
        this.add(this.caixaVertical);
        this.setVisible(true);
    }
    
    public final void desenharLayout(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Entrada de Pesos");
        this.setSize(250, 200);
        this.setLocationRelativeTo(null); 
    }
    
    public final void desenharCorpo(int qtd){
        for(int i=0; i < qtd; i++){
            
            
            
            this.titulo.add(this.tituloLabel(i));
            this.campo.add(this.inputTextField());

            this.caixaVertical.add(this.denharCaixaHorizontal(this.tituloLabel(i), 
                                                              this.inputTextField()));
        }
        this.caixaVertical.add(this.denharCaixaHorizontal(this.avancar, 
                                                          this.limpar, 
                                                          this.cancelar));
        //JLabel  = new JLabel("Peso (t-" + (i+1) + ") : ");
        //JTextField input = new JTextField(10);

    }
    public Box denharCaixaHorizontal(JLabel label, JTextArea textArea){
        Box caixaHorizontal = Box.createHorizontalBox();
        caixaHorizontal.add(label);
        caixaHorizontal.add(textArea);
        return caixaHorizontal;
    }
    
    public Box denharCaixaHorizontal(JLabel label, JTextField textField){
        Box caixaHorizontal = Box.createHorizontalBox();
        caixaHorizontal.add(label);
        caixaHorizontal.add(textField);
        return caixaHorizontal;
    }
    
    public Box denharCaixaHorizontal(JButton avancar, 
                                     JButton limpar, 
                                     JButton cancelar){
        Box caixaHorizontal = Box.createHorizontalBox();
        caixaHorizontal.add(avancar);
        caixaHorizontal.add(limpar);
        caixaHorizontal.add(cancelar);
        return caixaHorizontal;
    }
    
    public JLabel tituloLabel(int valor){
        JLabel label = new JLabel("Peso (t-" + (valor+1) + ") : ");
        return label;
    }
    
    public JTextField inputTextField(){
        JTextField input = new JTextField(10);
        return input;
    }
    
    
}
