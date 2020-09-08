/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maquinaEstado;

import dtos.Produto;
import business.RestService;
import com.google.gson.Gson;
import frontend.Menu;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 *
 * @author Usuario
 */
public class estadoListaProduto extends maquinaEstado{
     @Override
    public boolean
    executa(){
        
        Gson g = new Gson();

        RestService api = new RestService(new RestTemplateBuilder());
        String listaProdutos = api.getProducts();  
        
        Produto[] converted = g.fromJson(listaProdutos, Produto[].class);
        List<Produto> lista= Arrays.asList(converted);
        
        lista.forEach(item -> this.exibeDadosDoProduto(item));
        
        Menu.estadoConsole = enumEstado.MENU.getEstadoMaquina();
        return false;
    }
    
    public void exibeDadosDoProduto(Produto p){
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
