/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import mtruck.api.entities.Produto;

/**
 *
 * @author GERU\christian.seki
 */
public class ProdutoDAO implements DAO<Produto> {
    
    private String colunasTxt;
    
    public ProdutoDAO(){
        this.colunasTxt = "id,categoria,tamanho,descricao,cor,marca,localCompra,valorPago,valorEtiquta,valorSugerido,"
                + "valorMargem,dataEntrada";
    }

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
