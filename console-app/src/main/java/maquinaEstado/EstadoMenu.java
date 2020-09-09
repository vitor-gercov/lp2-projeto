/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaEstado;

import java.util.Scanner;
import frontend.Menu;

/**
 *
 * @author oseas
 */
public class EstadoMenu extends MaquinaEstado{
     @Override
    public boolean
    executa(){
         boolean sair = false;
        System.out.println("Bem-vindo!");
        System.out.println("Indique a opção desejada!");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Editar produto");
        System.out.println("3 - Seleciona Produto");
        System.out.println("4 - Excluir produto");
        System.out.println("5 - Listar produto");
        System.out.println("0 - Sair");
        Scanner scan = new Scanner(System.in);
        int opcao = scan.nextInt();
        switch (opcao)
        {
            case 0:
                sair = true;
                break;
            case 1:
                Menu.estadoConsole = EnumEstado.REGISTRA_PRODUTO.getEstadoMaquina();
                break;
            case 2:
                Menu.estadoConsole = EnumEstado.EDITA_PRODUTO.getEstadoMaquina();
                break;
            case 3:
                Menu.estadoConsole = EnumEstado.SELECIONA_PRODUTO.getEstadoMaquina();
                break;
            case 4:
                Menu.estadoConsole = EnumEstado.EXCLUI_PRODUTO.getEstadoMaquina();
                break;
            case 5:
                Menu.estadoConsole = EnumEstado.LISTA_PRODUTO.getEstadoMaquina();
                break;
        }
        return sair;
    }
}
