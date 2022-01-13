/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Janela.Layout;


//import org.rosuda.JRI.REXP;
//import org.rosuda.JRI.Rengine;





/**
 *
 * @author jacka
 */
public class TesteTcc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Layout novo = new Layout();
        novo.show();
        /*if (!Rengine.versionCheck()) {
            System.err.println("Java version mismatch.");
            System.exit(1);
        }
        String my[] = { "–vanilla" };
        Rengine re=new Rengine(my,false,new TextConsole());
        if (!re.waitForR()) {
            System.out.println("Cannot load R");
            System.exit(1);
        }
        REXP result = re.eval("mean(1:6)");
        System.out.println("rexp: " + result.asDouble());
    */}
    
}
