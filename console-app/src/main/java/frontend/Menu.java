/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package frontend;

import maquinaEstado.MaquinaEstado;
import maquinaEstado.EnumEstado;
/**
 *
 * @author Usuario
 */
public class Menu {

     public static MaquinaEstado estadoConsole;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        estadoConsole = EnumEstado.MENU.getEstadoMaquina();;
        Boolean saida = false;
        while (!saida) {
            saida = estadoConsole.executa();
        }
    }
    
}
