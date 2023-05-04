/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 *
 * @author jacka
 */
public class InicioDecorator {
    
    private JPanel fundo;
    private JPanel panelBTNs;
    
    private JButton btCSV;
    private JButton btBD;
    private JButton btSair;
    
    private JLabel jLabelOpcaoCSV;
    private JLabel jLabelOpcaoBD;
    
    private JTabbedPane painelTab;
    private JFrame janela;
    
    public InicioDecorator(JFrame janela, JTabbedPane tab) {
       
        this.initComponets(janela, tab);

    }

    private void initComponets(JFrame janela, JTabbedPane tab) {
        
        this.fundo = new JPanel(new BorderLayout());
        this.panelBTNs = new JPanel();
        this.btCSV = new JButton();
        this.btBD = new JButton();
        this.btSair = new JButton();
        this.jLabelOpcaoBD = new JLabel();
        this.jLabelOpcaoCSV = new JLabel();
        this.janela = janela;
        this.painelTab = tab;
    }
    
    public JPanel InicioReady() {
        
        this.configureFundo();
        
        return this.fundo;        
    }

    private void configureFundo() {
        this.panelBtn();
        
        this.fundo.setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(this.fundo);
        this.fundo.setLayout(fundoLayout);
        
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, 
                                 fundoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 
                                         GroupLayout.DEFAULT_SIZE, 
                                          Short.MAX_VALUE)
                        .addComponent(this.btSair))
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addComponent(this.panelBTNs, 
                                          GroupLayout.PREFERRED_SIZE, 
                                         GroupLayout.DEFAULT_SIZE, 
                                          GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );        
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, 
                                                               false)
                    .addComponent(this.panelBTNs, 
                                      GroupLayout.PREFERRED_SIZE, 
                                     GroupLayout.DEFAULT_SIZE, 
                                      GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 
                                 0, 
                                 Short.MAX_VALUE)
                .addGroup(fundoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.btSair))
                .addContainerGap())
        );
    }

    private void configureBtn() {
        this.btBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sqlite-database-thumbmail.png")));
        this.btBD.setBackground(Color.WHITE);
        this.btBD.setBorderPainted(false);
        
        this.btBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBDActionPerformed(evt);
            }
        });
        
        this.btCSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Filecsv-thumbnail.png")));
        this.btCSV.setBackground(Color.WHITE);
        this.btCSV.setBorderPainted(false);
        
        this.btCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCSVActionPerformed(evt);
            }
        }); 
        
        this.btSair.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.btSair.setText("Sair");
        
        this.btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
    }

    private void configureLabel() {
        this.jLabelOpcaoBD.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        this.jLabelOpcaoBD.setText("Entrar com dados do Banco de Dados:");
        
        this.jLabelOpcaoCSV.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        this.jLabelOpcaoCSV.setText("Entrar com dados de um Arquivo CSV:");
    }

    private void panelBtn() {
        this.configureBtn();
        this.configureLabel();
        
        this.panelBTNs.setBackground(new java.awt.Color(255, 255, 255));

        this.panelBTNs.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
                                                                                    "Escolha a Opção:",
                                                                           javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                                                              javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                                                                        new java.awt.Font("Segoe UI", 1, 18)));       
        javax.swing.GroupLayout btnLayout = new javax.swing.GroupLayout(this.panelBTNs);
        
        this.panelBTNs.setLayout(btnLayout);
        btnLayout.setHorizontalGroup(
            btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(this.jLabelOpcaoCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btCSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(this.btBD)
                    .addComponent(this.jLabelOpcaoBD, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        btnLayout.setVerticalGroup(
            btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(this.jLabelOpcaoBD)
                    .addComponent(this.jLabelOpcaoCSV))
                .addGap(18, 18, 18)
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.btCSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(this.btBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    private void btCSVActionPerformed(ActionEvent evt) {
        this.focusPainel(2);        
        this.habilitarPainel(2, true);
        this.habilitarPainel(1, false);
        this.habilitarPainel(0, false);
    } 
    
    private void btBDActionPerformed(ActionEvent evt) {
        this.focusPainel(1);
        this.habilitarPainel(1, true);
        this.habilitarPainel(2, false);
        this.habilitarPainel(0, false);
    }    

    private void habilitarPainel(int tabIndex, boolean enable) {
        //deve ser assim que funfa...
        this.painelTab.setEnabledAt(tabIndex, enable);                            
    }
    
    private void focusPainel(int tabIndex) {
        //deve ser assim que funfa...
        this.painelTab.setSelectedIndex(tabIndex);                            
    }
    
    private void btnSairActionPerformed(ActionEvent evt) {
        this.janela.dispose();
    }
}
