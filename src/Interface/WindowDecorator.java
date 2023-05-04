/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author jacka
 */
public class WindowDecorator {
    
    private JPanel face;
    private JTabbedPane painelTab;
    
    private JPanel inicio;
    private JPanel recuperar;
    private JPanel importar;
    private JPanel visaoGeral;
    private JPanel metodologias;
    private JPanel visaoAuxiliar;
    private JPanel resultados;

    private JScrollPane jScrollPaneInicio;
    private JScrollPane jScrollPaneRecuperar;
    private JScrollPane jScrollPaneImportar;
    private JScrollPane jScrollPaneVisaoGeral;
    private JScrollPane jScrollPaneMetodologias;
    private JScrollPane jScrollPaneVisaoAuxiliar;
    private JScrollPane jScrollPaneResultados;
    
    private JFrame janela;
    
    private WindowDecorator(JFrame janela) {
        this.initComponets();
        
        this.janela = janela;
        this.painelTab.setBounds(50, 50, 250, 200);
        this.painelTab.setSize(this.janela.getSize());
        this.painelTab.setVisible(true);
        
        this.montarTabPanel();
        this.montarFace();

    }
    
    public static WindowDecorator decorator (JFrame janela) {
        
        WindowDecorator decorate = new WindowDecorator(janela);
        
        return decorate;
    }  
    
    
    private void initAbas(){

        this.montarInicio();
        this.montarRecuperar();
        this.montarImportar();
        this.montarVisaoGeral();
        this.montarMetodologias();
        this.montarVisaoAuxiliar();
        this.montarResultados();
              
    }
    
    private void initComponets(){

        this.face = new JPanel(new BorderLayout());
        
        this.inicio = new JPanel(new BorderLayout());
        this.recuperar = new JPanel(new BorderLayout());
        this.importar = new JPanel(new BorderLayout());
        this.visaoGeral = new JPanel(new BorderLayout());
        this.metodologias = new JPanel(new BorderLayout());
        this.visaoAuxiliar = new JPanel(new BorderLayout());
        this.resultados = new JPanel(new BorderLayout());
        
        this.jScrollPaneInicio = new JScrollPane();
        this.jScrollPaneRecuperar = new JScrollPane();
        this.jScrollPaneImportar = new JScrollPane();
        this.jScrollPaneVisaoGeral = new JScrollPane();
        this.jScrollPaneMetodologias = new JScrollPane();
        this.jScrollPaneVisaoAuxiliar = new JScrollPane();
        this.jScrollPaneResultados = new JScrollPane();
        
        this.painelTab = new JTabbedPane();
              
    }

    //configuração do componete de abas
    private void montarTabPanel(){
        this.painelTab.setTabPlacement(JTabbedPane.LEFT);
        this.painelTab.setFont(new Font("Tahoma", 1, 12)); // NOI18N 
        
        this.painelTab.add("Inicio", this.jScrollPaneInicio);
        this.painelTab.add("Recuperar", this.jScrollPaneRecuperar);
        this.painelTab.add("Importar", this.jScrollPaneImportar);
        this.painelTab.add("Visão Geral", this.jScrollPaneVisaoGeral);
        this.painelTab.add("Metodologias", this.jScrollPaneMetodologias);
        this.painelTab.add("Visão Auxiliar", this.jScrollPaneVisaoAuxiliar);
        this.painelTab.add("Resultados", this.jScrollPaneResultados);
        
        this.painelTab.setEnabledAt(0, true);       
        this.painelTab.setEnabledAt(1, false);       
        this.painelTab.setEnabledAt(2, false);       
        this.painelTab.setEnabledAt(3, false);       
        this.painelTab.setEnabledAt(4, false);       
        this.painelTab.setEnabledAt(5, false);       
        this.painelTab.setEnabledAt(6, false);
        
        this.initAbas();
    }

    //configuração do painele sub aba    
    private void montarFace(){
        
        this.face.setBackground(new java.awt.Color(34, 41, 50));
        this.face.setLayout(new BorderLayout());
        this.face.add(this.painelTab, BorderLayout.CENTER);

        this.janela.add(this.face, BorderLayout.CENTER);
        
    }

    //construção de cada aba----------------------------------------------------    
    private void montarInicio() {
        InicioDecorator inicio = new InicioDecorator(this.janela, this.painelTab);
        JPanel jPanelInicio = inicio.InicioReady();

        GroupLayout inicioLayout = new GroupLayout(this.inicio);
        this.inicio.setLayout(inicioLayout);
        this.jScrollPaneInicio.setViewportView(this.inicio);        
        
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInicio, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInicio, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );        
    }

    private void montarRecuperar() {
        RecuperarDecorator recuperar = new RecuperarDecorator(this.painelTab);
        JPanel jPanelRecuperar = recuperar.RecuperarReady();

        GroupLayout recuperarLayout = new GroupLayout(this.recuperar);
        this.recuperar.setLayout(recuperarLayout);
        this.jScrollPaneRecuperar.setViewportView(this.recuperar);
        
        recuperarLayout.setHorizontalGroup(
            recuperarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRecuperar, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
        recuperarLayout.setVerticalGroup(
            recuperarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRecuperar, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );         
    }
    
    private void montarImportar(){
        ImportarDecorator importar = new ImportarDecorator(this.painelTab);
        JPanel jPanelImportar = importar.ImportarReady();

        GroupLayout importarLayout = new GroupLayout(this.importar);
        this.importar.setLayout(importarLayout);
        this.jScrollPaneImportar.setViewportView(this.importar);        
        
        importarLayout.setHorizontalGroup(
            importarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelImportar, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
        importarLayout.setVerticalGroup(
            importarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelImportar, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );        
    }
    
    private void montarVisaoGeral(){
        VisaoGeralDecorator visaoGeral = new VisaoGeralDecorator(this.painelTab);
        JPanel jPanelVisaoGeral = visaoGeral.visaoGeralReady();        

        GroupLayout visaoGeralLayout = new GroupLayout(this.visaoGeral);
        this.visaoGeral.setLayout(visaoGeralLayout);
        this.jScrollPaneVisaoGeral.setViewportView(this.visaoGeral);
        
        visaoGeralLayout.setHorizontalGroup(
            visaoGeralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVisaoGeral, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
        visaoGeralLayout.setVerticalGroup(
            visaoGeralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVisaoGeral, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );   
    }
    
    private void montarMetodologias(){ 
        MetodologiaDecorator metodologia = new MetodologiaDecorator(this.painelTab);
        JPanel jPanelMetodologia = metodologia.metodologiaReady();
        
        GroupLayout metodologialLayout = new GroupLayout(this.metodologias);
        this.metodologias.setLayout(metodologialLayout);
        this.jScrollPaneMetodologias.setViewportView(this.metodologias);
        
        metodologialLayout.setHorizontalGroup(
            metodologialLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMetodologia, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
        metodologialLayout.setVerticalGroup(
            metodologialLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMetodologia, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        ); 
    }
    
    private void montarVisaoAuxiliar(){
        
        VisaoAuxiliarDecorator visaoAuxiliar = new VisaoAuxiliarDecorator(this.painelTab);
        JPanel jPanelVisaoAuxiliar = visaoAuxiliar.visaoAuxiliarReady();
        
        GroupLayout visaoAuxiliarLayout = new GroupLayout(this.visaoAuxiliar);
        this.visaoAuxiliar.setLayout(visaoAuxiliarLayout);
        this.jScrollPaneVisaoAuxiliar.setViewportView(this.visaoAuxiliar);
        
        visaoAuxiliarLayout.setHorizontalGroup(
            visaoAuxiliarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVisaoAuxiliar, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
        visaoAuxiliarLayout.setVerticalGroup(
            visaoAuxiliarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVisaoAuxiliar, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
    }
    
    private void montarResultados(){
        
        ResultadosDecorator resultados = new ResultadosDecorator(this.janela);
        JPanel jPanelResultados = resultados.ResultadoReady();
        
        GroupLayout resultadoLayout = new GroupLayout(this.resultados);
        this.resultados.setLayout(resultadoLayout);
        this.jScrollPaneResultados.setViewportView(this.resultados);
        
        resultadoLayout.setHorizontalGroup(
            resultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelResultados, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
        resultadoLayout.setVerticalGroup(
            resultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanelResultados, 
                              GroupLayout.DEFAULT_SIZE, 
                              GroupLayout.DEFAULT_SIZE, 
                              Short.MAX_VALUE)
        );
    }
}
