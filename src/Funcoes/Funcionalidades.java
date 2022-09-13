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
import java.util.Date;

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
           
            //System.out.println("entrou aqui!!!");
            String line = ler.readLine();
            Info topo = new Info();
            //System.out.println("entrou aqui!!!");
            addCabecalho(line, topo);
            line = ler.readLine();
            //System.out.println("entrou aqui!!!");

            while(line != null){
                addDados(line, topo);
                line = ler.readLine();

                //System.out.println(line);
                
                
            }
            //System.out.println(relatorio(topo));
            Validacao o = new Validacao(topo.dadosPValidar());
            JOptionPane.showMessageDialog(null, "Leitura Completa!");
            //System.out.println(topo.toString());
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
    
}
