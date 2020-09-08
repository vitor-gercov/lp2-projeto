/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Usuario
 */
public class Produto implements Serializable {
    
    //Variaveis
    private UUID id;
    private String categoria;
    private String marca;
    private String tamanho;
    private String descricao;
    private String cor;
    
    private double valorPago;
    private double valorSugerido;
    private double valorEtiqueta;
    private String localCompra;
    private Date dataEntrada;

    
    
    //Gets
    public UUID getId() {
        return id;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getTamanho() {
        return tamanho;
    }
    
    public String getDescricao() {
        return descricao;
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    
    
    //Sets
    public void setId(UUID id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setDesc(String desc) {
        this.descricao = desc;
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
        this.dataEntrada = dataEntrega;
    }
}
