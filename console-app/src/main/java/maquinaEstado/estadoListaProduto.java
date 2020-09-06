/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maquinaEstado;

import dtos.Produto;
import business.RestService;
import frontend.Menu;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 *
 * @author Usuario
 */
public class estadoListaProduto extends maquinaEstado{
     @Override
    public boolean
    executa(){
        
        RestService api = new RestService(new RestTemplateBuilder());
        String listaProdutos = api.getProducts();
        System.out.println(listaProdutos);
        
        return false;
    }
}
