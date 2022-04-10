/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Janela.Layout;
import ObjDao.Medicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;








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
        List<Medicao> lista = new ArrayList<Medicao>();
        try{
            
            
            
            Medicao med1 = new Medicao(dateFormate.parse("02/05/2020"), (int)2300, (float) 16.3);
            //System.out.println(med1.toString());
        
            Medicao med2 = new Medicao(dateFormate.parse("02/05/2020"), (int)1300, (float) 10.4);
            //System.out.println(med2.toString());
            
            Medicao med3 = new Medicao(dateFormate.parse("17/10/2005"), (int)2100, (float) 14.4);
            //System.out.println(med2.toString());
            
            Medicao med4 = new Medicao(dateFormate.parse("02/05/2020"), (int)100, (float) 24.4);
            //System.out.println(med2.toString());
            
            Medicao med5 = new Medicao(dateFormate.parse("01/01/2022"), (int)400, (float) 34.4);
            //System.out.println(med2.toString());
            
            
            Medicao med6 = new Medicao(dateFormate.parse("24/05/2009"), (int)1500, (float) 18.4);
            //System.out.println(med2.toString());
            
            
            Medicao med7 = new Medicao(dateFormate.parse("02/05/2010"), (int)1000, (float) 23.4);
            //System.out.println(med2.toString());
            
            
            Medicao med8 = new Medicao(dateFormate.parse("02/07/2015"), (int)2000, (float) 21.4);
            //System.out.println(med2.toString());
            
            
            Medicao med9 = new Medicao(dateFormate.parse("29/05/2017"), (int)1800, (float) 09.4);
            //System.out.println(med2.toString());
            
            //System.out.println(med1.compareTo(med2));
            med1.adicionarMedicao(lista, med1);
            med1.adicionarMedicao(lista, med2);
            med1.adicionarMedicao(lista, med3);
            med1.adicionarMedicao(lista, med4);
            med1.adicionarMedicao(lista, med5);
            med1.adicionarMedicao(lista, med6);
            med1.adicionarMedicao(lista, med7);
            med1.adicionarMedicao(lista, med8);
            med1.adicionarMedicao(lista, med9);
            
            lista.get(0).listarMedicao(lista);
        }catch (ParseException ex){
            System.out.println("DEU  RUIM");
        }
        
        
        System.exit(0);
        
        
        

    }
    
}
