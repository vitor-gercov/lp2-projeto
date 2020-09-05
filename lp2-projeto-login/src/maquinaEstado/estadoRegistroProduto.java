/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaEstado;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Produto;

/**
 *
 * @author oseas
 */
public class estadoRegistroProduto extends maquinaEstado{
     @Override
    public boolean
    executa(){
         try {
             Scanner entrada = new Scanner(System.in);
             Produto novoProduto = new Produto();
             
             System.out.println("\n---Registro de Produto---\n");
             System.out.println("Categoria:");
             novoProduto.setCategoria(entrada.nextLine());
             System.out.println("Marca:");
             novoProduto.setMarca(entrada.nextLine());
             System.out.println("Tamanho(P, M, G, GG):");
             novoProduto.setTamanho(entrada.nextLine().charAt(0));
             System.out.println("Descrição:");
             novoProduto.setDesc(entrada.nextLine());
             System.out.println("Cor:");
             novoProduto.setCor(entrada.nextLine());
             
             System.out.println("Valor pago:");
             novoProduto.setValorPago(entrada.nextDouble());
             System.out.println("Valor sugerido:");
             novoProduto.setValorSugerido(entrada.nextDouble());
             System.out.println("Valor da etiqueta:");
             novoProduto.setValorEtiqueta(entrada.nextDouble());
             System.out.println("Local da compra:");
             novoProduto.setLocalCompra(entrada.nextLine());
             
             System.out.println("Data de entrega(dd/MM/yyyy):");
             SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
             Date dataDt = data.parse(entrada.nextLine());
             novoProduto.setDataEntrega(dataDt);
             
             return false;
         } catch (ParseException ex) {
             Logger.getLogger(estadoRegistroProduto.class.getName()).log(Level.SEVERE, null, ex);
             
             return false;
         }
    }
}
