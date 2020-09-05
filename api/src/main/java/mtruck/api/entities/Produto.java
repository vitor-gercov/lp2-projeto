/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.entities;

import java.util.Date;

/**
 *
 * @author chseki
 */

public class Produto {

    private int id;
    private String categoria;
    private String marca;
    private String tamanho;
    private String descricao;
    private String cor;
    private double valorPago;
    private double valorEtiqueta;
    private double valorMargem;
    private double valorSugerido;
    private String localCompra;
    private Date dataEntrada;

    public Produto(int id, String categoria, String marca, String tamanho, String descricao, String cor, double valorPago, double valorEtiqueta, double valorSugerido, String localCompra, Date dataEntrada) {
        this.id = id;
        this.categoria = categoria;
        this.marca = marca;
        this.tamanho = tamanho;
        this.descricao = descricao;
        this.cor = cor;
        this.valorPago = valorPago;
        this.valorEtiqueta = valorEtiqueta;
        this.valorMargem = this.valorPago * 2;
        this.valorSugerido = valorSugerido;
        this.localCompra = localCompra;
        this.dataEntrada = dataEntrada;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCor() {
        return cor;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getValorEtiqueta() {
        return valorEtiqueta;
    }

    public double getValorMargem() {
        return this.valorMargem;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double getValorSugerido() {
        return valorSugerido;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setValorEtiqueta(double valorEtiqueta) {
        this.valorEtiqueta = valorEtiqueta;
    }

    public void setValorMargem(double valorMargem) {
        this.valorMargem = valorMargem;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setValorSugerido(double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }

    @Override
    public String toString() {
        return Integer.toString(this.id) + ',' + this.categoria + ',' + this.tamanho + ',' + this.descricao + ',' + this.cor + ','
                + this.marca + ',' + this.localCompra + ',' + this.valorPago + ',' + this.valorEtiqueta + ','
                + this.valorSugerido + ',' + this.valorMargem + ',' + this.dataEntrada.toString();
        
    }
}
