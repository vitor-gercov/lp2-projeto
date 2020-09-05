/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mtruck.api.entities.Produto;

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
        List<Produto> produtos = new ArrayList<Produto>();
        File file = new File("estoque.txt");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] campos = line.split(",");
                    
                    if(campos[0].contains("id")) continue;
                    
                    int id = Integer.parseInt(campos[0]);
                    String categoria = campos[1];
                    String tamanho = campos[2];
                    String descricao = campos[3];
                    String cor = campos[4];
                    String marca = campos[5];
                    String localCompra = campos[6];
                    double valorPago = Double.parseDouble(campos[7]);
                    double valorEtiqueta = Double.parseDouble(campos[8]);
                    double valorSugerido = Double.parseDouble(campos[9]);
                    
                    SimpleDateFormat formataData=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
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
    public Produto salvar(Produto produto) {
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
            return produto;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
