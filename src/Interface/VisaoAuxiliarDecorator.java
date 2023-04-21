/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Obj.Model.AnaliseErro;
import Obj.Model.Funcionalidades;
import Tabela.Employee;
import static Tabela.Funcionalidades.createDataProvider;
import static Tabela.Funcionalidades.createObjectDataModel;
import Tabela.PaginatedTableDecorator;
import Tabela.PaginationDataProvider;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jacka
 */
public class VisaoAuxiliarDecorator {
    
    private JPanel fundo;
    private JPanel jPanelTable;
    private JPanel jPanelDetalhes;
    private JPanel jPanelBtn;
    private JPanel jPanelInfo;
    private JPanel jPanelStatus;
    
    private JScrollPane jScrollPaneInfo1;
    private JScrollPane jScrollPaneInfo2;
    private JScrollPane jScrollPaneInfo3;
    private JScrollPane jScrollPaneSaibaMais;
    private JScrollPane jScrollPaneStatus;
    
    private JTextArea jTextAreaInfo1;
    private JTextArea jTextAreaInfo2;
    private JTextArea jTextAreaInfo3;
    private JTextArea jTextAreaSaibaMais;
    
    private JTabbedPane jTabbedPaneColunas;
    
    private JButton avancarBtn;
    private JButton salvarBtn;
    
    private JTable tabela;
    private final String meses[] = {"Janeiro", "Fervereiro", "Março", "Abril", 
                                    "Maio", "Junho", "Julho", "Agosto", 
                                    "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    public VisaoAuxiliarDecorator(){
        this.initComponents();
    }
    
    public void initComponents(){

        this.fundo = new JPanel(new BorderLayout());
        this.jPanelTable = new JPanel();
        this.jPanelDetalhes = new JPanel(new BorderLayout());
        this.jPanelInfo = new JPanel();
        this.jPanelBtn = new JPanel();
        this.jPanelStatus = new JPanel();

        this.jScrollPaneInfo1 = new JScrollPane();
        this.jScrollPaneInfo2 = new JScrollPane();
        this.jScrollPaneInfo3 = new JScrollPane();
        this.jScrollPaneSaibaMais = new JScrollPane();
        this.jScrollPaneStatus = new JScrollPane();

        this.jTextAreaInfo1 = new JTextArea();
        this.jTextAreaInfo2 = new JTextArea();
        this.jTextAreaInfo3 = new JTextArea();
        this.jTextAreaSaibaMais = new JTextArea();
        
        this.jTabbedPaneColunas = new JTabbedPane();
        
        this.avancarBtn = new JButton();
        this.salvarBtn = new JButton();
        
        this.tabela = new JTable(createObjectDataModel());    
    }

    public JPanel visaoAuxiliarReady(){
        //this.panelStatus();
        this.panelTable();
        this.panelDetalhes();
        
        this.panelFundo();
        
        return this.fundo;
    }

    private void configureBtns(){
        this.avancarBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        this.avancarBtn.setText("Avançar");

        this.salvarBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        this.salvarBtn.setText("Salvar");        
    }

    private void configureAjuda(){
        
        this.jTextAreaInfo1.setEditable(false);
        this.jTextAreaInfo1.setColumns(20);
        this.jTextAreaInfo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        this.jTextAreaInfo1.setRows(5);
        this.jTextAreaInfo1.setText("\n Fórmula:"
                         + "\n MAD = ( 1 / n ) x ( ∑| Y - Ȳ | )"
                         + "\n Ȳ = Valor predito"
                         + "\n Y = Valor original"
                         + "\n ∑ = Somatória"
                         + "\n n = Numero de elementos"
                         + "\n | | = Módulo (valor absoluto)");
        this.jTextAreaInfo1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desvio Absoluto Médio:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        this.jScrollPaneInfo1.setViewportView(this.jTextAreaInfo1);

        this.jTextAreaInfo2.setEditable(false);
        this.jTextAreaInfo2.setColumns(20);
        this.jTextAreaInfo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        this.jTextAreaInfo2.setRows(5);
        this.jTextAreaInfo2.setText("\n Fórmula:"
                         + "\n MAE = ( 1 / n ) x ( ∑( | Y - Ȳ | / Y ) )"
                         + "\n Ȳ = Valor predito"
                         + "\n Y = Valor original"
                         + "\n ∑ = Somatoria"
                         + "\n n = Numero de elementos"
                         + "\n | | = Módulo (valor absoluto)");
        this.jTextAreaInfo2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Erro Médio Absoluto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        this.jScrollPaneInfo2.setViewportView(this.jTextAreaInfo2);

        this.jTextAreaInfo3.setEditable(false);
        this.jTextAreaInfo3.setColumns(20);
        this.jTextAreaInfo3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        this.jTextAreaInfo3.setRows(5);
        this.jTextAreaInfo3.setText("\n Fórmula:"
                         + "\n MAPE = [ MAE ] x 100"
                         + "\n MAE = Erro Médio Absoluto");
        this.jTextAreaInfo3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Erro Absoluto Médio Percentual: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        this.jScrollPaneInfo3.setViewportView(this.jTextAreaInfo3);

        this.jTextAreaSaibaMais.setColumns(20);
        this.jTextAreaSaibaMais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        this.jTextAreaSaibaMais.setRows(5);
        this.jTextAreaSaibaMais.setText("\n Os resultados apresentados na  área \"STATUS\" foram"
                          + "\n desconsiderados os valores preditos onde ouve a"
                          + "\n substituição das lacunas, pois seus valores se anulariam"
                          + "\n recorrente a formula do cálculo do erro e tendênciariam"
                          + "\n os  valores finais.");
        this.jTextAreaSaibaMais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saiba mais:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        this.jScrollPaneSaibaMais.setViewportView(this.jTextAreaSaibaMais);        
    }
    
    private void StatusTab(List<AnaliseErro> list){
        List<AnaliseErro> lista = list;

        this.jTabbedPaneColunas = this.AddColunasTab(lista);
        this.jScrollPaneStatus.setViewportView(this.jTabbedPaneColunas);
        this.jPanelStatus.add(this.jScrollPaneStatus);
    }
    
    private int calcPivorAno(List<AnaliseErro> lista, int inicio){
        
        int pivor = inicio;
        
        while((pivor + 1 < lista.size()) && 
            (lista.get(pivor).getAno().compareTo(lista.get(pivor + 1).getAno()) == 0)){
            //System.out.println(lista.get(pivor).impprimir());
            pivor++;
        }
        
        return pivor;
    }
    
    private int calcPivorColuna(List<AnaliseErro> lista, int inicio){
        
        int pivor = inicio;

        while((pivor + 1 < lista.size()) && 
             lista.get(pivor).getColuna().compareTo(lista.get(pivor + 1).getColuna()) == 0){
            pivor++;
        }
        
        return pivor;
    }
    
    private JTabbedPane AddMesesTab(List<AnaliseErro> list, int inicio, int fim){
        
        JTabbedPane mesTabs = new JTabbedPane();
        List<AnaliseErro> lista = list;
        
        for(int index = inicio; index <= fim; index++){
            mesTabs.addTab(this.meses[lista.get(index).getIntMes()-1],
                        new JScrollPane(this.panelStatus(lista.get(index).getMad(),
                                                            lista.get(index).getMae(),
                                                           lista.get(index).getMape())));
        }
        
        return mesTabs;
    }    

    private JTabbedPane AddAnosTab(List<AnaliseErro> list, int inicio, int fim){
        
        JTabbedPane anoTabs = new JTabbedPane();
        List<AnaliseErro> lista = list;
        int comeco = inicio;
        int finish = fim;
        int pivor = this.calcPivorAno(lista, comeco);
   
        for(int ano = comeco; pivor <= finish;){
            anoTabs.addTab(lista.get(ano).getAno(), this.AddMesesTab(lista, ano, pivor));
            ano = pivor + 1;
            pivor = this.calcPivorAno(lista, ano);                
        }
       
        return anoTabs;
    }    
    
    private JTabbedPane AddColunasTab(List<AnaliseErro> list){
        
        JTabbedPane colunaTabs = new JTabbedPane();
        List<AnaliseErro> lista = list;
        int comeco = 0;
        int finish = lista.size();
        int pivor = this.calcPivorColuna(lista, comeco);
        
        for(int coluna = comeco; coluna < lista.size();){            
            colunaTabs.addTab(lista.get(coluna).getColuna(), this.AddAnosTab(lista, coluna, pivor));
            coluna = pivor + 1;
            if(coluna < lista.size()-1){
                pivor = this.calcPivorColuna(lista, coluna);               
            }
//            System.out.println("Pivor: " + pivor);
        }
       
        return colunaTabs;
    }    
    
    private JPanel panelStatus(String mad, 
                             String mae, 
                             String mape){
        
        JPanel jPanelStatus = new JPanel();
        
        JLabel jlabelMAPE = new JLabel();
        JLabel jlabelMAE = new JLabel();
        JLabel jlabelMAD = new JLabel();
        
        JTextField jTextFieldMAD = new JTextField();
        JTextField jTextFieldMAE = new JTextField();
        JTextField jTextFieldMAPE = new JTextField();        
        
        jlabelMAPE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabelMAPE.setText("Erro Absoluto Médio Percentual (MAPE):");

        jlabelMAE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabelMAE.setText("Erro Médio Absoluto (MAE):");

        jlabelMAD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabelMAD.setText("Desvio Absoluto Médio (MAD):");

        jTextFieldMAD.setEditable(false);
        jTextFieldMAD.setText(mad);
        jTextFieldMAE.setEditable(false);
        jTextFieldMAE.setText(mae);
        jTextFieldMAPE.setEditable(false);
        jTextFieldMAPE.setText(mape);

        jPanelStatus.setBorder(BorderFactory.createTitledBorder(
                                                  null,
                                                   "Status:",
                                          javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                              javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                                                        new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanelStatus.setForeground(new java.awt.Color(204, 204, 204));
        //jPanelStatus.setBackground(Color.red);
        GroupLayout statusLayout = new GroupLayout(jPanelStatus);
        jPanelStatus.setLayout(statusLayout);
        statusLayout.setHorizontalGroup(
            statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(statusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jlabelMAPE)
                        .addComponent(jlabelMAE,
                                      GroupLayout.Alignment.TRAILING))
                    .addComponent(jlabelMAD))
                .addGap(10, 10, 10)
                .addGroup(statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMAE,
                                      GroupLayout.PREFERRED_SIZE,
                                     200,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMAD,
                                      GroupLayout.PREFERRED_SIZE,
                                     200,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMAPE,
                                      GroupLayout.PREFERRED_SIZE,
                                     200,
                                     GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                 Short.MAX_VALUE))
        );
        statusLayout.setVerticalGroup(
            statusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(statusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMAD,
                                      GroupLayout.PREFERRED_SIZE,
                                     GroupLayout.DEFAULT_SIZE,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelMAD))
                .addGap(10, 10, 10)
                .addGroup(statusLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelMAE,
                                      GroupLayout.PREFERRED_SIZE,
                                     15,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMAE,
                                      GroupLayout.PREFERRED_SIZE,
                                     GroupLayout.DEFAULT_SIZE,
                                     GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(statusLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMAPE,
                                      GroupLayout.PREFERRED_SIZE,
                                     GroupLayout.DEFAULT_SIZE,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelMAPE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                 Short.MAX_VALUE))
        );
        return jPanelStatus;
    }
    
    private void panelTable(){
        //introduz o layout a tabela a variavel
        this.tabela.setAutoCreateRowSorter(true);
        PaginationDataProvider<Employee> dataProvider = createDataProvider();
        PaginatedTableDecorator<Employee> paginatedDecorator = PaginatedTableDecorator.decorate(this.tabela,
              dataProvider, new int[]{29, 30, 31}, 30);
               
        //configura o painel onde a tabela é inserida
        this.jPanelTable.setBackground(new java.awt.Color(54, 63, 73));
        GroupLayout jPanelTableLayout = new GroupLayout(this.jPanelTable);
        this.jPanelTable.setLayout(jPanelTableLayout);

        //organiza o layout com a tabela
        jPanelTableLayout.setHorizontalGroup(
            jPanelTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paginatedDecorator.getContentPanel(),
//                .addComponent(this.tabela,
                              GroupLayout.PREFERRED_SIZE,
                              1200,
                              (GroupLayout.PREFERRED_SIZE))
                .addContainerGap()
                .addGap(1))
        );
        jPanelTableLayout.setVerticalGroup(
            jPanelTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paginatedDecorator.getContentPanel(),
//                .addComponent(this.tabela,
                              GroupLayout.PREFERRED_SIZE,
                              300,
                              GroupLayout.PREFERRED_SIZE)
                .addContainerGap()
                .addGap(1))
        );        
    }
 
    private void panelBtn(){
        this.configureBtns();
        this.jPanelBtn.setBackground(new java.awt.Color(255, 255, 255));
        this.jPanelBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
 
        GroupLayout BtnLayout = new GroupLayout(this.jPanelBtn);
        this.jPanelBtn.setLayout(BtnLayout);
        BtnLayout.setHorizontalGroup(
            BtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(BtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.salvarBtn,
                                      GroupLayout.PREFERRED_SIZE,
                                     79,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.avancarBtn))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BtnLayout.setVerticalGroup(
            BtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(BtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.salvarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.avancarBtn)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );        
    } 

    private void panelInfo(){
        this.configureAjuda();

        this.jPanelInfo.setBackground(new java.awt.Color(255, 255, 255));
        this.jPanelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        
        GroupLayout infoLayout = new GroupLayout(this.jPanelInfo);
        this.jPanelInfo.setLayout(infoLayout);
        infoLayout.setHorizontalGroup(
            infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(infoLayout.createSequentialGroup()
                        .addComponent(this.jScrollPaneInfo1,
                                          GroupLayout.PREFERRED_SIZE,
                                         GroupLayout.DEFAULT_SIZE,
                                         GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jScrollPaneSaibaMais,
                                          GroupLayout.PREFERRED_SIZE,
                                         336,
                                         GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoLayout.createSequentialGroup()
                        .addComponent(this.jScrollPaneInfo2,
                                          GroupLayout.PREFERRED_SIZE,
                                         GroupLayout.DEFAULT_SIZE,
                                         GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jScrollPaneInfo3,
                                          GroupLayout.PREFERRED_SIZE,
                                         GroupLayout.DEFAULT_SIZE,
                                         GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoLayout.setVerticalGroup(
            infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.jScrollPaneInfo1,
                                      GroupLayout.PREFERRED_SIZE,
                                     146,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.jScrollPaneSaibaMais,
                                      GroupLayout.PREFERRED_SIZE,
                                     136, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.jScrollPaneInfo2,
                                      GroupLayout.PREFERRED_SIZE,
                                     146,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.jScrollPaneInfo3,
                                      GroupLayout.PREFERRED_SIZE,
                                     146,
                                     GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    
    private void panelDetalhes(){
        this.panelBtn();
        this.panelInfo();
        this.StatusTab(Funcionalidades.gerarListaAnaliseErro());
        
        this.jPanelDetalhes.setBackground(new java.awt.Color(255, 255, 255));
        
        GroupLayout DetalhesLayout = new GroupLayout(this.jPanelDetalhes);
        this.jPanelDetalhes.setLayout(DetalhesLayout);
        DetalhesLayout.setHorizontalGroup(
            DetalhesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(DetalhesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                  Short.MAX_VALUE)
                .addComponent(this.jTabbedPaneColunas,
                                  GroupLayout.PREFERRED_SIZE,
                                 510,
                                 GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                 javax.swing.GroupLayout.DEFAULT_SIZE,
                                      Short.MAX_VALUE)
                .addGroup(DetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(this.jPanelBtn,
                                      GroupLayout.PREFERRED_SIZE,
                                     GroupLayout.DEFAULT_SIZE,
                                     GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.jPanelInfo,
                                      GroupLayout.PREFERRED_SIZE,
                                     GroupLayout.DEFAULT_SIZE,
                                     GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                 Short.MAX_VALUE))
        );
        DetalhesLayout.setVerticalGroup(
            DetalhesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(DetalhesLayout.createSequentialGroup()
                .addGap(0,7,9)
                .addComponent(this.jTabbedPaneColunas,
                                  GroupLayout.PREFERRED_SIZE,
                                 GroupLayout.DEFAULT_SIZE,
                                 GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                 Short.MAX_VALUE))
            .addGroup(DetalhesLayout.createSequentialGroup()
                    .addComponent(this.jPanelInfo,
                                      GroupLayout.PREFERRED_SIZE,
                                     GroupLayout.DEFAULT_SIZE,
                                     GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(this.jPanelBtn,
                                      GroupLayout.PREFERRED_SIZE,
                                     GroupLayout.DEFAULT_SIZE,
                                     GroupLayout.PREFERRED_SIZE)
                    .addGap(0,41, Short.MAX_VALUE))
        ); 
    }

    private void panelFundo(){
        this.fundo.add(this.jPanelTable, BorderLayout.NORTH);
        this.fundo.add(this.jPanelDetalhes, BorderLayout.CENTER);        
    }
}
