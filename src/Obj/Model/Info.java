/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obj.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jacka
 */
public class Info {
    private String titulo;//titulo de indentificação
    private String[] coluna;//Nome da colunas
    private String descricao;//breve descrição sobre o conteudo...
    private String tipoDeDado;//tipo de dado, ºc, m², cm, R$, etc...
    private Metodologia metodologiaAplicada;//formula aplicada (indice 1 ou 2)
    private Date dataInicial;//data inicial da medição
    private Date dataFinal;//data final da medição
    private String tipoDeMedicao; //formato de periodo da medição (hora, dia, mês, trimestre)
    private Date dataCriacao;//data gravada da dos dados atual
    
    private List<Dados> lista;

    public Info() {
        Date data = new Date();
        this.dataCriacao = data;
        this.lista = new ArrayList<Dados>();
        this.metodologiaAplicada = new Metodologia();
    }

    public Info(String titulo,String[] coluna,  
                String descricao, 
                String tipoDeDado, 
                Metodologia metodologiaAplicada,                                  
                String tipoDeMedicao,                  
                List<Dados> lista) {
        this.titulo = titulo;
        this.coluna[0] = coluna[0];
        this.coluna[1] = coluna[1];
        this.coluna[2] = coluna[2];
        this.descricao = descricao;
        this.tipoDeDado = tipoDeDado;
        this.metodologiaAplicada = metodologiaAplicada;
        this.tipoDeMedicao = tipoDeMedicao;
        this.lista = lista;
        
        this.atualizarIntervaloData();
        this.setDataCriacao();
    }

/*    public Info(Info obj) {
        this.coluna = obj.getColuna();
        this.descricao = obj.getDescricao();
        this.tipoDeDado = obj.getTipoDeDado();
        this.metodologiaAplicada = obj.getMetodologiaAplicada();
        this.tipoDeMedicao = obj.getTipoDeMedicao();
        this.lista = obj.getLista();
        
        this.setDataInicial();
        this.setDataFinal();
        this.setDataCriacao();
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getColunaCount() {
        if (this.coluna == null){
            return 0;
        }else{
            return coluna.length;
        }
    }
    
    public String[] getColuna() {
        return coluna;
    }
    
    public String getColuna(int index) {
        return coluna[index];
    }

    public void setColuna(String[] coluna) {
        this.coluna = coluna;
    }
    
    public void setColuna(String coluna, int index) {
        this.coluna[index] = coluna;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoDeDado() {
        return tipoDeDado;
    }

    public void setTipoDeDado(String tipoDeDado) {
        this.tipoDeDado = tipoDeDado;
    }

    public Metodologia getMetodologiaAplicada() {
        return metodologiaAplicada;
    }

    public void setMetodologiaAplicada(Metodologia metodologiaAplicada) {
        this.metodologiaAplicada = metodologiaAplicada;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    
    public String getDataInicialBR() {
        SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormate.format(dataInicial).toString();
    }

    public void setDataInicial(){
        if((!lista.isEmpty()) || (lista != null)){
            this.dataInicial = lista.get(0).getData();
        }else{
            this.dataInicial = null;
        }
    }

    public Date getDataFinal() {
        return dataFinal;
    }
    
    public String getDataFinalBR() {
        SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormate.format(dataFinal).toString();
    }
    
    public void setDataFinal() {
        if((!lista.isEmpty()) || (lista != null)){
            this.dataFinal = lista.get(lista.size()-1).getData();
        }else{
            this.dataFinal = null;
        }
    }

    public String getTipoDeMedicao() {
        return tipoDeMedicao;
    }

    public void setTipoDeMedicao(String tipoDeMedicao) {
        this.tipoDeMedicao = tipoDeMedicao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
    
    public String getDataCriacaoBR(){
        SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormate.format(dataCriacao).toString();
    }

    public void setDataCriacao() {
        //DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        this.dataCriacao = data;
    }

    public List<Dados> getLista() {
        return lista;
    }
    
    public Dados getDado(int index) {
        return lista.get(index);
    }

    public void setLista(List<Dados> lista) {
        this.lista = lista;
 
        this.atualizarIntervaloData();
    }
    
    public void atualizarIntervaloData(){
        this.setDataInicial();
        this.setDataFinal();   
    }

    @Override
    public String toString() {
        return "Info{" + "\n titulo = " + this.titulo
                       + "\n coluna 1 = " + this.coluna[0] 
                       + "\n coluna 2 = " + this.coluna[1] 
                       + "\n coluna 3 = " + this.coluna[2] 
                       + "\n descricao = " + this.descricao 
                       + "\n tipo de dado = " + this.tipoDeDado 
                       + "\n metodologia aplicada = " + this.metodologiaAplicada.toString()
                       + "\n data inicial = " + this.getDataInicialBR()
                       + "\n data final = " + this.getDataFinalBR()
                       + "\n tipo de medicao = " + this.tipoDeMedicao//obs 
                       + "\n data criacao = " + this.getDataCriacaoBR() + '}'; 
    }//obs: ajeitar o toString da lista

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.titulo);
        hash = 89 * hash + Arrays.deepHashCode(this.coluna);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.tipoDeDado);
        hash = 89 * hash + Objects.hashCode(this.metodologiaAplicada);
        hash = 89 * hash + Objects.hashCode(this.dataInicial);
        hash = 89 * hash + Objects.hashCode(this.dataFinal);
        hash = 89 * hash + Objects.hashCode(this.tipoDeMedicao);
        hash = 89 * hash + Objects.hashCode(this.dataCriacao);
        hash = 89 * hash + Objects.hashCode(this.lista);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Info other = (Info) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.tipoDeDado, other.tipoDeDado)) {
            return false;
        }
        if (!Objects.equals(this.tipoDeMedicao, other.tipoDeMedicao)) {
            return false;
        }
        if (!Arrays.deepEquals(this.coluna, other.coluna)) {
            return false;
        }
        if (!Objects.equals(this.metodologiaAplicada, other.metodologiaAplicada)) {
            return false;
        }
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }

    public void adicionarMedicao(Dados Obj){
        //System.out.println(Obj.getData()+","+Obj.getPeriodo()+","+Obj.getValor());
        Dados dado = new Dados();
        dado.setData(Obj.getData());
        dado.setPeriodo(Obj.getPeriodo());
        dado.setValor(Obj.getValor());
        
        //System.out.println(dado.getData()+","+dado.getPeriodo()+","+dado.getValor());
        if(this.isEmpty()){
                this.lista.add(dado);

                this.atualizarIntervaloData();
        }else{
            //System.out.println("entrou aqui");
            if(!lista.contains(dado)){
                this.lista.add(dado);
                //this.ordenarLista();

                this.atualizarIntervaloData();
            }else{
                System.out.println("elemento ja existe na lista...");
            }    
        }
        //this.listarMedicao();
    }
    
    public void adicionarListaMedicao(List<Dados> objList){
        List<Dados> lista = objList;
        for(int i=0; i < lista.size(); i++){
            if(!this.lista.contains(lista.get(i))){
                this.lista.add(lista.get(i));
                //this.ordenarLista();
                
                //this.atualizarIntervaloData();
                
            }else{
                System.out.println("elemento ja existe na lista...");
            }
        }
        
        this.atualizarIntervaloData();
    }
    
    public void editarMedicao(Dados Obj, int index){
        this.getDado(index).setData(Obj.getData());
        this.getDado(index).setPeriodo(Obj.getPeriodo());
        this.getDado(index).setValor(Obj.getValor());

        this.atualizarIntervaloData();
    }
    
    public void excluirMedicao(Dados Obj){
        this.lista.remove(Obj);

        this.atualizarIntervaloData();
    }

    public void excluirMedicao(int index){
        this.lista.remove(index);

        this.atualizarIntervaloData();
    }
    
    //exclui todas as medicoes de valor null
    public void excluirMedicaoInvalida(){
        for(int i = 0; i < this.lista.size(); i++){
            if(this.getDado(i).getValor().equals("null")){
                this.lista.remove(i);
            }
        }
        
        this.atualizarIntervaloData();
    }

    //gera uma lista sem nulls de dados
    public List<Float> dadosPValidar(){
        List<Float> dados = new ArrayList<Float>();
        for(int i = 0; i < this.lista.size(); i++){
            if(!this.getDado(i).getValor().equals("null")){
                dados.add(Float.parseFloat(lista.get(i).getValor()));
            }
        }
        
        return dados;
    }
    
    //validada pelo controlador
    //exclui todas as medicoes no dia especifico
    public void excluirDia(int dia, int mes,  int ano){
        for(int i = 0; i < this.lista.size(); i++){
            if((this.getDado(i).getDay() == dia) && 
               (this.getDado(i).getYear() == ano) &&
               (this.getDado(i).getMonth() == mes)){
                this.lista.remove(i);
            }
        }
        
        this.atualizarIntervaloData();
    }
    
    //validada pelo controlador
    //exclui todas as medicoes no mes especifico
    public void excluirMes(int mes, int ano){
        for(int i = 0; i < this.lista.size(); i++){
            if((this.getDado(i).getMonth() == mes) && 
               (this.getDado(i).getYear() == ano)){
                this.lista.remove(i);
            }
        }

        this.atualizarIntervaloData();
    }

    public void excluirAno(int ano){
        for(int i = 0; i < this.lista.size(); i++){
            if((this.getDado(i).getYear()) == ano){
                this.lista.remove(i);
            }
        }

        this.atualizarIntervaloData();
    }
    
    public void limparGeral(){
        this.lista.removeAll(this.lista);
        
        this.dataInicial = null;
        this.dataFinal = null;
    }
    
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    
    //ordenação de lista
    public void ordenarLista(){
       boolean troca = true;
       Dados aux = new Dados();
       while (troca){
           troca = false;
           for(int i = 0; i < this.lista.size()-1; i++){
               if(this.getDado(i).compareTo(this.getDado(i+1)) > 0){
                   //auxiliar recebe o valor maior
                   aux.setData(this.getDado(i).getData());
                   aux.setPeriodo(this.getDado(i).getPeriodo());
                   aux.setValor(this.getDado(i).getValor());
                   //troca
                   this.editarMedicao(this.getDado(i+1), i);
                   this.editarMedicao(aux, i+1);
                   
                   troca = true;                   
               }          
           }
       }      
    }
    
    public void listarMedicao(){
        System.out.println(this.toString());
        for (int i = 0; i<lista.size(); i++){
            System.out.println(this.getDado(i).toString());
        }       
    }
    
}
