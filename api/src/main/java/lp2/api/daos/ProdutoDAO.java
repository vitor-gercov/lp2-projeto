/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.api.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import lp2.api.entities.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author GERU\christian.seki
 */
public class ProdutoDAO implements DAO<Produto> {

    private String colunasTxt;

    public ProdutoDAO() {
        this.colunasTxt = "id,categoria,tamanho,descricao,cor,marca,localCompra,valorPago,valorEtiqueta,valorSugerido,"
                + "valorMargem,dataEntrada";
    }

    @Override
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        File file = new File("estoque.txt");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] campos = line.split(",");

                    if (campos[0].contains("id")) {
                        continue;
                    }

                    UUID id = UUID.fromString(campos[0]);
                    String categoria = campos[1];
                    String tamanho = campos[2];
                    String descricao = campos[3];
                    String cor = campos[4];
                    String marca = campos[5];
                    String localCompra = campos[6];
                    double valorPago = Double.parseDouble(campos[7]);
                    double valorEtiqueta = Double.parseDouble(campos[8]);
                    double valorSugerido = Double.parseDouble(campos[9]);

                    SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    Date dataEntrada = formataData.parse(campos[11]);

                    Produto produto = new Produto(id, categoria, marca, tamanho, descricao, cor, valorPago, valorEtiqueta, valorSugerido, localCompra, dataEntrada);

                    produtos.add(produto);
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                return null;
            } catch (ParseException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produtos;
    }

    @Override
    public void salvar(Produto produto) {
        try {
            File file = new File("estoque.txt");

            if (file.exists()) {

                FileWriter fw = new FileWriter(file.getName(), true);
                BufferedWriter buffer = new BufferedWriter(fw);

                PrintWriter pw = new PrintWriter(buffer);
                pw.println(produto.toString());
                pw.close();
            } else {
                PrintWriter pw = new PrintWriter(new File("estoque.txt"));
                pw.println(this.colunasTxt);
                pw.println(produto.toString());
                pw.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(UUID codigo) {
        List<String> produtos = new ArrayList<>();
        File file = new File("estoque.txt");
        boolean existe = false;
        
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] campos = line.split(",");

                    if (campos[0].contains(codigo.toString())) {
                        existe = true;
                        continue;
                    }

                    produtos.add(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
            if (!existe) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe no estoque !");
            }
            try {
                Iterator i = produtos.iterator();
                PrintWriter pw = new PrintWriter(new File("estoque.txt"));
                
                while (i.hasNext()) {
                    pw.println(i.next().toString());
                }

                pw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe no estoque !");
        }
    }

    @Override
    public Produto pesquisar(UUID codigo) {

        File file = new File("estoque.txt");
        Produto produto = new Produto();
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] campos = line.split(",");
                    //campo[] possui o Id do produto na posição 0
                    if (campos[0].contains(codigo.toString())) {
                        String categoria = campos[1];
                        String tamanho = campos[2];
                        String descricao = campos[3];
                        String cor = campos[4];
                        String marca = campos[5];
                        String localCompra = campos[6];
                        double valorPago = Double.parseDouble(campos[7]);
                        double valorEtiqueta = Double.parseDouble(campos[8]);
                        double valorSugerido = Double.parseDouble(campos[9]);
                        double valorMargem = Double.parseDouble(campos[10]);
                        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                        Date dataEntrada = formataData.parse(campos[11]);

                        //Seta os valores em produtos
                        produto.setId(codigo);
                        produto.setCategoria(categoria);
                        produto.setTamanho(tamanho);
                        produto.setDescricao(descricao);
                        produto.setCor(cor);
                        produto.setMarca(marca);
                        produto.setLocalCompra(localCompra);
                        produto.setValorPago(valorPago);
                        produto.setValorEtiqueta(valorEtiqueta);
                        produto.setValorSugerido(valorSugerido);
                        produto.setDataEntrada(dataEntrada);
                        produto.setValorMargem(valorMargem);

                        break;
                    }
                }

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                return null;
            } catch (ParseException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return produto;
    }

    @Override
    public void editar(Produto produto) {
        List<String> produtos = new ArrayList<>();
        File file = new File("estoque.txt");
        boolean existe = false;
        
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] campos = line.split(",");

                    if (campos[0].contains(produto.getId().toString())) {
                        produtos.add(produto.toString());
                        existe = true;
                        continue;
                    }

                    produtos.add(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
            if (!existe) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe no estoque !");
            }
            try {
                Iterator i = produtos.iterator();
                PrintWriter pw = new PrintWriter(new File("estoque.txt"));
                
                while (i.hasNext()) {
                    pw.println(i.next().toString());
                }

                pw.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe no estoque !");
        }
    }

}
