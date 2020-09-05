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
import mtruck.api.entities.Produto;

/**
 *
 * @author GERU\christian.seki
 */
public class ProdutoDAO {

    public void criaTxt(Produto produto) {
        try {
            File file = new File("estoque.txt");

            if (file.exists()) {

                FileWriter fw = new FileWriter(file.getName(), true);
                BufferedWriter buffer = new BufferedWriter(fw);

                PrintWriter pw = new PrintWriter(buffer);
                pw.println(produto.getCategoria());
                pw.close();
            } else {
                PrintWriter pw = new PrintWriter(new File("estoque.txt"));
                pw.println(produto.getCategoria());
                pw.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
