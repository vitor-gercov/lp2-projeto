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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 *
 * @author oseas
 */
public class EstadoExcluiProduto extends MaquinaEstado {

    @Override
    public boolean
            executa() {
        try {
            Gson g = new Gson();

            RestService api = new RestService(new RestTemplateBuilder());
            String listaProdutos = api.getProducts();

            Produto[] converted = g.fromJson(listaProdutos, Produto[].class);

            if (converted.length == 0) {
                System.out.println("Não existe nenhum produto cadastrado");
                Menu.estadoConsole = EnumEstado.MENU.getEstadoMaquina();

                return false;
            }

            List<Produto> lista = Arrays.asList(converted);

            lista.forEach(item -> this.exibeDadosDoProduto(item));

            System.out.println("Digite o ID do produto que quer excluir");

            Scanner scan = new Scanner(System.in);
            String productId = scan.nextLine();

            api.deleteProduct(productId);
            System.out.println("Produto deletado com sucesso");

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        } finally {
            Menu.estadoConsole = EnumEstado.MENU.getEstadoMaquina();
            return false;
        }

    }

    public void exibeDadosDoProduto(Produto p) {
        System.out.println("///////////////////////////////");
        System.out.println("ID:");
        System.out.println(p.getId());
        System.out.println("Descrição:");
        System.out.println(p.getDescricao());
        System.out.println("///////////////////////////////");
    }
}
