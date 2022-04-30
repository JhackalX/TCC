/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jacka
 */
public class Cidades {
    private String nome;
    private String estacao;
    private String latitude;
    private String longitude;
    private String altitude;
    private String situacao;
    private Date dataInicial;
    private Date dataFinal;
    private String tipoDeMedicao;
    
    private List<Medicao> lista;

    public Cidades() {
        this.lista = new ArrayList<Medicao>();
    }

    public Cidades(String nome, 
                   String estacao, 
                   String latitude, 
                   String longitude, 
                   String altitude,
                   String situacao,
                   Date dataInicial, 
                   Date dataFinal, 
                   String tipoDeMedicao) {
        this.nome = nome;
        this.estacao = estacao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.situacao = situacao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.tipoDeMedicao = tipoDeMedicao;
        this.lista = new ArrayList<Medicao>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getTipoDeMedicao() {
        return tipoDeMedicao;
    }

    public void setTipoDeMedicao(String tipoDeMedicao) {
        this.tipoDeMedicao = tipoDeMedicao;
    }

    public List<Medicao> getLista() {
        return lista;
    }

    public void setLista(List<Medicao> lista) {
        this.lista = lista;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.estacao);
        hash = 23 * hash + Objects.hashCode(this.latitude);
        hash = 23 * hash + Objects.hashCode(this.longitude);
        hash = 23 * hash + Objects.hashCode(this.altitude);
        hash = 23 * hash + Objects.hashCode(this.situacao);
        hash = 23 * hash + Objects.hashCode(this.dataInicial);
        hash = 23 * hash + Objects.hashCode(this.dataFinal);
        hash = 23 * hash + Objects.hashCode(this.tipoDeMedicao);
        hash = 23 * hash + Objects.hashCode(this.lista);
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
        final Cidades other = (Cidades) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.estacao, other.estacao)) {
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)) {
            return false;
        }
        if (!Objects.equals(this.longitude, other.longitude)) {
            return false;
        }
        if (!Objects.equals(this.altitude, other.altitude)) {
            return false;
        }
        if (!Objects.equals(this.situacao, other.situacao)) {
            return false;
        }
        if (!Objects.equals(this.tipoDeMedicao, other.tipoDeMedicao)) {
            return false;
        }
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cidades{" + "Nome: " + nome + ", "
                          + "Estacao: " + estacao + ", "
                          + "Latitude: " + latitude + ", "
                          + "Longitude: " + longitude + ", "
                          + "Altitude: " + altitude + ", "
                          + "Situacao: " + situacao + ", "
                          + "Data Inicial:" + dataInicial + ", "
                          + "Data Final:" + dataFinal + ", "
                          + "Tipo De Medicao:" + tipoDeMedicao + ", "
                          + "Lista:";
    }


    public void adicionarMedicao(Medicao Obj){
        if(!this.lista.contains(Obj)){
            this.lista.add(Obj);
            this.ordenarLista();
        }else{
            System.out.println("elemento ja existe na lista...");
        }
    }
    
    public void adicionarListaMedicao(List<Medicao> lista){
        for(int i=0; i < lista.size(); i++){
            if(!this.lista.contains(lista.get(i))){
                this.lista.add(lista.get(i));
                this.ordenarLista();
            }else{
                System.out.println("elemento ja existe na lista...");
            } 
        }
    }
    
    public void editarMedicao(Medicao Obj, int i){
        this.lista.get(i).setData(Obj.getData());
        this.lista.get(i).setHora(Obj.getHora());
        this.lista.get(i).setTemperatura(Obj.getTemperatura());   
    }
    
    public void excluirMedicao(Medicao Obj){
        this.lista.remove(Obj);
    }
    //exclui todas as medicoes de valor null/99999.0
    public void excluirMedicaoInvalida(){
        for(int i = 0; i < this.lista.size(); i++){
            if(this.lista.get(i).getTemperatura() == 99999.0){
                this.lista.remove(i);
            }
        }
    }
    
    
    public void limparGeral(){
        this.lista.removeAll(this.lista);
    }
    //ordenação de lista
    public void ordenarLista(){
       boolean troca = true;
       Medicao aux = new Medicao();
       while (troca){
           troca = false;
           for(int i = 0; i < this.lista.size()-1; i++){
               if(this.lista.get(i).compareTo(this.lista.get(i+1)) > 0){
                   aux.setData(this.lista.get(i).getData());
                   aux.setHora(this.lista.get(i).getHora());
                   aux.setTemperatura(this.lista.get(i).getTemperatura());
                   this.editarMedicao(this.lista.get(i+1), i);
                   this.editarMedicao(aux, i+1);
                   troca = true;                   
               }          
           }
       }      
    }
    
    public void listarMedicao(){
        System.out.println(this.toString());
        for (int i = 0; i<this.lista.size(); i++){
            System.out.println(this.lista.get(i).toString());
        }       
    }
    
}
