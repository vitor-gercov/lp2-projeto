/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Produto {
    
    //Variaveis
    private int id;
    private String categoria;
    private String marca;
    private char tamanho;
    private String desc;
    private String cor;
    
    private double valorPago;
    private double valorSugerido;
    private double valorEtiqueta;
    private String localCompra;
    private Date dataEntrega;

    
    
    //Gets
    public int getId() {
        return id;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public char getTamanho() {
        return tamanho;
    }
    
    public String getDesc() {
        return desc;
    }

    public String getCor() {
        return cor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double getValorSugerido() {
        return valorSugerido;
    }

    public double getValorEtiqueta() {
        return valorEtiqueta;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    
    
    //Sets
    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setValorSugerido(double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }

    public void setValorEtiqueta(double valorEtiqueta) {
        this.valorEtiqueta = valorEtiqueta;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
