/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package frontend;

import maquinaEstado.maquinaEstado;
import maquinaEstado.enumEstado;
/**
 *
 * @author Usuario
 */
public class Menu {

     public static maquinaEstado estadoConsole;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        estadoConsole = enumEstado.MENU.getEstadoMaquina();;
        Boolean saida = false;
        while (!saida) {
            saida = estadoConsole.executa();
        }
    }
    
}
