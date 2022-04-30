/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import Exception.CabecalhoInvalido;
import ObjDao.Cidades;
import ObjDao.Medicao;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jacka
 */
public class Funcionalidades {
    private static final String cabecalho = "Data Medicao;Hora Medicao;TEMPERATURA DO PONTO DE ORVALHO(°C);";
    //lê o arquivo e retorna uma lista de objetos do arquivo
    private static Cidades lerArquivo(InputStream arquivoMed) throws CabecalhoInvalido, ParseException{
        
        Cidades cidade = new Cidades();
        
        try(Scanner scan = new Scanner(arquivoMed)){
            scan.useDelimiter("/n");
            String linha = scan.next();
            while(scan.hasNext()){
                addObjdoArq(linha, cidade);
            }
        };             
        return cidade;  
    }
    
    //recebe a linha, divide onde houver ";" e insere no objeto e depois insere na lista
    public static void addObjdoArq (String linha, Cidades cidade) throws ParseException{
        
        String[] campos = linha.split(";");
        SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");

        if (campos[2].equals("null")){
            campos[2] = "99999,0";
        }
        Medicao obj = new Medicao(dateFormate.parse(campos[0]),
                                  Integer.parseInt(campos[1]),
                                  Float.parseFloat(campos[2].replace(',', '.')));
        
        cidade.adicionarMedicao(obj);    
    }
    
    public static void addCabecalho (String linha, Cidades cidade) throws ParseException{
        
        String[] campos = linha.split(":");
        SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(campos[0]);
        System.out.println("periodicidade de medicao");
        if (campos[0].toLowerCase().equals("nome")){
            cidade.setNome(campos[1]);
        }else{
            if(campos[0].toLowerCase().equals("codigo estacao")){
                cidade.setEstacao(campos[1]);
            }else{
                if (campos[0].toLowerCase().equals("latitude")){
                    cidade.setLatitude(campos[1]);
                }else{
                    if(campos[0].toLowerCase().equals("logitude")){
                        cidade.setLongitude(campos[1]);
                    }else{
                       if (campos[0].toLowerCase().equals("altitude")){
                            cidade.setAltitude(campos[1]);
                        }else{
                            if(campos[0].toLowerCase().equals("situacao")){
                                cidade.setSituacao(campos[1]);
                            }else{
                                if (campos[0].toLowerCase().equals("data inicial")){
                                    cidade.setDataInicial(dateFormate.parse(campos[1]));
                                }else{
                                    if(campos[0].toLowerCase().equals("data final")){
                                        cidade.setDataFinal(dateFormate.parse(campos[1]));
                                    }else{
                                        if(campos[0].trim().equalsIgnoreCase("periodicidade de medicao")){
                                            cidade.setTipoDeMedicao(campos[1]);
                                        }else{
                                            System.out.println("Linha não condiz com a especificação do documento...");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }            
        }    
    }    
    
    //procura o cabecalho no arquivo para saber se o arquivo é valido
    //tem que testar....
    public static Boolean validarCabecalho(InputStream arq){
        try(Scanner scan = new Scanner(arq)){
            scan.useDelimiter("/n");
            Boolean validador = false;
            String linha = scan.next();
            while(scan.hasNext()){
                if(linha.equals(cabecalho)){
                    validador = true;
                    return validador;
                }else {
                    linha = scan.next();
                }
            }
            return validador;
        }
    }
    
}
