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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 *
 * @author oseas
 */
public class estadoEditaProduto extends maquinaEstado {

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
                Menu.estadoConsole = enumEstado.MENU.getEstadoMaquina();

                return false;
            }

            List<Produto> lista = Arrays.asList(converted);

            lista.forEach(item -> this.exibeDadosDoProduto(item));

            System.out.println("Digite o ID do produto que deseja editar");

            Scanner scan = new Scanner(System.in);
            String productId = scan.nextLine();

            String produtoSelecionadoJSON = api.findProduct(productId);
            Produto produto = g.fromJson(produtoSelecionadoJSON, Produto.class);

            System.out.println("Dados do produto selecionado");
            this.exibeDadosDoProdutoCompleto(produto);

            Produto produtoEditado = new Produto();

            System.out.println("Digite 1 para editar a Categoria ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                produtoEditado.setCategoria(scan.nextLine());
            }

            System.out.println("Digite 1 para editar a Marca ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                produtoEditado.setMarca(scan.nextLine());
            }

            System.out.println("Digite 1 para editar o Tamanho ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor do tamanho(P, M, G, GG):");
                String tamanhoEntrada = scan.nextLine().toUpperCase();
                EnumTamanhos tamanho = Enum.valueOf(EnumTamanhos.class, tamanhoEntrada);
                produtoEditado.setTamanho(tamanho.getTamanho());
            }

            System.out.println("Digite 1 para editar a Descrição ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                produtoEditado.setDesc(scan.nextLine());
            }

            System.out.println("Digite 1 para editar a Cor ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor da cor(LARANJA,VERMELHO,ROSA,AMARELO,PRETO,BRANCO,VERDE):");
                String corEntrada = scan.nextLine().toUpperCase();
                EnumCores cor = Enum.valueOf(EnumCores.class, corEntrada);
                produtoEditado.setCor(cor.getCor());
            }

            System.out.println("Digite 1 para editar o Valor Pago ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                produtoEditado.setValorPago(scan.nextDouble());
                scan.nextLine();
            }

            System.out.println("Digite 1 para editar o Valor Sugerido ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                produtoEditado.setValorSugerido(scan.nextDouble());
                scan.nextLine();
            }

            System.out.println("Digite 1 para editar o Valor da Etiqueta ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                produtoEditado.setValorEtiqueta(scan.nextDouble());
                scan.nextLine();
            }

            System.out.println("Digite 1 para editar o Local da Compra ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                produtoEditado.setLocalCompra(scan.nextLine());
            }
            produtoEditado.setLocalCompra(scan.nextLine());
            System.out.println("Digite 1 para editar a Data Entrega(dd/MM/yyyy) ou qualquer outra coisa para ir para o próximo dado:");
            if ("1".equals(scan.nextLine())) {
                System.out.println("Digite o valor");
                Date dataDt = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());

                produtoEditado.setDataEntrega(dataDt);
            }

            api.updateProduct(productId, produtoEditado);

            System.out.println("Produto Editado com sucesso");
            Menu.estadoConsole = enumEstado.MENU.getEstadoMaquina();

            return false;
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro: " + ex.getMessage());
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
