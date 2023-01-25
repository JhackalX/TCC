/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import DTO.Validacao;
import Obj.Model.Info;
import Obj.Model.Dados;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author jacka
 */
public class Funcionalidades {


    
    public static String relatorio(Info obj){
        Info novo;
        novo = obj;
        int qtDados = novo.getLista().size();
        int qtNull = contNull(novo);
        String relat = mesNull(novo);
        return "Quantidade de dados: " + qtDados + 
               "\nQuantidade de lacunas: " + qtNull +
                relat;
    }

    public static int contNull(Info obj){
        Info novo = obj;
        int cont = 0;
        for(int i = 0; i < novo.getLista().size(); i++){
            if(novo.getLista().get(i).getValor().equalsIgnoreCase("null")){
                cont++;
            }
        }
        return cont;
    }
    
    public static String contNull(Info obj, int mes, int ano){
        Info novo = obj;
        int cont = 0;
        for(int i = 0; i < novo.getLista().size(); i++){
            if(novo.getLista().get(i).getValor().equalsIgnoreCase("null") && 
               novo.getLista().get(i).getMonth() == mes && 
               novo.getLista().get(i).getYear() == ano){
                cont++;
            }
        }
        return "Mês: "+ mes + 
               "/" + ano + 
               "....... Quantidade: " + cont;
    }
    
    public static String mesNull(Info obj){
        Info novo = obj;
        String relat;
        int ano = 0;
        int mes = 0;
        for(int i = 0; i < novo.getLista().size(); i++){
            
            if(novo.getLista().get(i).getValor().equalsIgnoreCase("null")){
                mes = novo.getLista().get(i).getData().getMonth()+1;
                ano = novo.getLista().get(i).getData().getYear()+1900;
                //System.out.println(contNull(novo, mes, ano));
            }    
            while((novo.getLista().get(i+1).getData().getMonth()+1 == mes) && ((i + 3) < novo.getLista().size())){
                i = i+1;        
            }
        }
        return contNull(novo, mes, ano);
    }
    
    public static Info lerArquivo(String path) throws FileNotFoundException, ParseException, IOException{
        try(BufferedReader ler = new BufferedReader(new FileReader(path))){
           
            String line = ler.readLine();
            Info topo = new Info();
            addCabecalho(line, topo);
            line = ler.readLine();
            while(line != null){
                addDados(line, topo);
                line = ler.readLine();    
            }
            Validacao o = new Validacao(topo.dadosPValidar());
            JOptionPane.showMessageDialog(null, "Leitura Completa!");
            return topo;
        }catch(IOException e){
            System.out.println("Funcoes.Funcionalidades.lerArquivo()");
            System.err.println("Error: " + e.getMessage());
            return null;
        }
        
    }
    
    public static void addCabecalho (String linha, Info cidade) throws ParseException{
        
        String[] campos = linha.split(";");

        cidade.setColuna(campos);

        //System.out.println("periodicidade de medicao");        
    }
    
    public static void addDados (String linha, Info cidade) throws ParseException{
        //System.out.println(linha);
        String[] campos = linha.trim().split(";");
        SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
        Dados dado = new Dados();
        dado.setData(dateFormate.parse(campos[0].trim()));
        dado.setPeriodo(Integer.parseInt(campos[1].trim()));
        //dado.setValor(Float.parseFloat(campos[2].replace(',', '.')));

        dado.setValor(campos[2]);
   
        //System.out.println(dado.toString());
        //System.out.println(dado.getData()+","+dado.getPeriodo()+","+dado.getValor());

        cidade.adicionarMedicao(dado);
        //System.out.println("periodicidade de medicao");
    }
    
//Dados-------------------------------------------------------------------------
    public static List<Float> geraLista(List<Object> lista){
        List<Float> valores = new ArrayList<Float>();
        for(int index = 0; index < lista.size(); index++){
            if(((Dados)lista.get(index)).getValor().equals("null")){
                valores.add(null);
            }else{
                valores.add(Float.parseFloat(((Dados)lista.get(index)).getValor()));
            }
        }
        return valores;
    }    
    
    public static void atualizaDados(List<Object> lista, List<Float> valores){
        for(int index = 0; index < lista.size(); index++){
            if(!((Dados)lista.get(index)).getValor().equals(""+valores.get(index))){
                ((Dados)lista.get(index)).setValor(valores.get(index));
            }
        }
    }

    public static List<String> getObject(List<Object> lista, int index){
        
        List<String> obj = new ArrayList<String>();
        obj.add(((Dados)lista.get(index)).getDataBr());
        obj.add(""+((Dados)lista.get(index)).getPeriodo());
        obj.add(((Dados)lista.get(index)).getValor().replace('.', ','));        
        return obj;
    }
    
//INFO--------------------------------------------------------------------------    
    public static List<Object> geraListaD(Object objeto){
        List<Object> valores = new ArrayList<Object>();
        valores.addAll(((Info)(objeto)).getLista());
        return valores;
    }
    
    public static String[] geraColuna(Object objeto){
        String[] coluna;
        coluna = ((Info)(objeto)).getColuna();
        return coluna;
    }
    
}
