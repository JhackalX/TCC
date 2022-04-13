/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import static Funcoes.Funcionalidades.addObjdoArq;
import Janela.Layout;
import ObjDao.Cidades;
import ObjDao.Medicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;








/**
 *
 * @author jacka
 */
public class TesteTcc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Layout novo = new Layout();
        //novo.show();
        
        //Bloco de teste
        
        SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yy");
        Cidades cidade = new Cidades();
        try{
                        
            Medicao med1 = new Medicao(dateFormate.parse("02/05/2020"), (int)2300, (float) 16.3);
            //System.out.println(med1.toString());
        
            Medicao med2 = new Medicao(dateFormate.parse("02/05/2020"), (int)1300, (float) 10.4);
            //System.out.println(med2.toString());
            
            Medicao med3 = new Medicao(dateFormate.parse("17/10/2005"), (int)2100, (float) 14.4);
            //System.out.println(med2.toString());
            
            Medicao med4 = new Medicao(dateFormate.parse("02/05/2020"), (int)100, (float) 24.4);
            //System.out.println(med2.toString());
            
            addObjdoArq("2017-03-21;0800;null;",cidade);
            //System.out.println(med2.toString());            
            
            Medicao med6 = new Medicao(dateFormate.parse("24/05/2009"), (int)1500, (float) 18.4);
            //System.out.println(med2.toString());
                      
            Medicao med7 = new Medicao(dateFormate.parse("02/05/2020"), (int)2300, (float) 16.3);
            //System.out.println(med2.toString());
                      
            Medicao med8 = new Medicao(dateFormate.parse("02/07/2015"), (int)2000, (float) 21.4);
            //System.out.println(med2.toString());
                     
            Medicao med9 = new Medicao(dateFormate.parse("29/05/2017"), (int)1800, (float) 09.4);
            //System.out.println(med2.toString());
            
            //System.out.println(med1.compareTo(med2));
            cidade.adicionarMedicao(med1);
            cidade.adicionarMedicao(med2);
            cidade.adicionarMedicao(med3);
            cidade.adicionarMedicao(med4);
            
            cidade.adicionarMedicao(med6);
            cidade.adicionarMedicao(med7);
            cidade.adicionarMedicao(med8);
            cidade.adicionarMedicao(med9);
            cidade.excluirMedicaoInvalida();
            cidade.listarMedicao();
        }catch (ParseException ex){
            System.out.println("DEU  RUIM");
        }
        
        
        System.exit(0);
        
        
        

    }
    
}
