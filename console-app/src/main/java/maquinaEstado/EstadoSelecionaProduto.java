/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaEstado;

import business.RestService;
import com.google.gson.Gson;
import dtos.Produto;
import frontend.Menu;
import java.util.Scanner;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 *
 * @author oseas
 */
public class EstadoSelecionaProduto extends MaquinaEstado{
     @Override
    public boolean
    executa(){
        try{
            
            RestService api = new RestService(new RestTemplateBuilder());
             Gson g = new Gson();
         System.out.println("Digite o ID do produto que deseja pesquisar");

            Scanner scan = new Scanner(System.in);
            String productId = scan.nextLine();

            String produtoSelecionadoJSON = api.findProduct(productId);
            Produto produto = g.fromJson(produtoSelecionadoJSON, Produto.class);

            System.out.println("Dados do produto selecionado");
            this.exibeDadosDoProdutoCompleto(produto);
       
             } catch (Exception ex) {
            System.out.println("Ocorreu um erro: " + ex.getMessage());
        } finally {
            Menu.estadoConsole = EnumEstado.MENU.getEstadoMaquina();
            return false;
        }
    }
    
    public void exibeDadosDoProdutoCompleto(Produto p) {
        System.out.println("///////////////////////////////");
        System.out.println("ID:");
        System.out.println(p.getId());
        System.out.println("Categoria:");
        System.out.println(p.getCategoria());
        System.out.println("Marca:");
        System.out.println(p.getMarca());
        System.out.println("Tamanho:");
        System.out.println(p.getTamanho());
        System.out.println("Descrição:");
        System.out.println(p.getDescricao());
        System.out.println("Cor:");
        System.out.println(p.getCor());
        System.out.println("Valor Pago:");
        System.out.println(p.getValorPago());
        System.out.println("Valor Sugerido:");
        System.out.println(p.getValorSugerido());
        System.out.println("Valor Sugerido:");
        System.out.println(p.getValorSugerido());
        System.out.println("Valor Etiqueta:");
        System.out.println(p.getValorEtiqueta());
        System.out.println("Local Compra:");
        System.out.println(p.getLocalCompra());
        System.out.println("Data entrada:");
        System.out.println(p.getDataEntrada());

        System.out.println("///////////////////////////////");
    }
}
