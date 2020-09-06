/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaEstado;

import business.RestService;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import dtos.Produto;
import frontend.Menu;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 *
 * @author oseas
 */
public class estadoRegistroProduto extends maquinaEstado {

    @Override
    public boolean
            executa() {
        try {

            Scanner entrada = new Scanner(System.in);
            Produto novoProduto = new Produto();

            System.out.println("\n---Registro de Produto---\n");
            System.out.println("Categoria:");
            novoProduto.setCategoria(entrada.nextLine());
            System.out.println("Marca:");
            novoProduto.setMarca(entrada.nextLine());
            System.out.println("Tamanho(P, M, G, GG):");
            novoProduto.setTamanho(entrada.nextLine());
            System.out.println("Descrição:");
            novoProduto.setDesc(entrada.nextLine());
            System.out.println("Cor:");
            novoProduto.setCor(entrada.nextLine());
            System.out.println("Valor pago:");
            novoProduto.setValorPago(entrada.nextDouble());
            entrada.nextLine();
            System.out.println("Valor sugerido:");
            novoProduto.setValorSugerido(entrada.nextDouble());
            entrada.nextLine();
            System.out.println("Valor da etiqueta:");
            novoProduto.setValorEtiqueta(entrada.nextDouble());
            entrada.nextLine();

            System.out.println("Local da compra:");
            novoProduto.setLocalCompra(entrada.nextLine());
            System.out.println("Data de entrega(dd/MM/yyyy):");

            Date dataDt = new SimpleDateFormat("dd/MM/yyyy").parse(entrada.nextLine());

            System.out.println(dataDt);
            novoProduto.setDataEntrega(dataDt);

            RestService api = new RestService(new RestTemplateBuilder());
            api.postProduct(novoProduto);
            
            System.out.println("Produto cadastrado com sucesso");

            System.out.println("Deseja cadastrar um novo produto");

            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            Scanner scan = new Scanner(System.in);
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    Menu.estadoConsole = enumEstado.REGISTRA_PRODUTO.getEstadoMaquina();
                    break;
                case 2:
                    Menu.estadoConsole = enumEstado.MENU.getEstadoMaquina();
                    break;
            }

            return false;
        } catch (ParseException ex) {
            System.out.println("Ocorreu um erro");

            
            System.out.println("Deseja tentar novamente");

            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            Scanner scan = new Scanner(System.in);
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    Menu.estadoConsole = enumEstado.REGISTRA_PRODUTO.getEstadoMaquina();
                    break;
                case 2:
                    Menu.estadoConsole = enumEstado.MENU.getEstadoMaquina();
                    break;
            }

            return false;
            
        }
    }
}
