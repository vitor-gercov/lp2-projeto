/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaEstado;

/**
 *
 * @author chseki
 */
public enum EnumCores {
    LARANJA("laranja"),

    VERMELHO("vermelho"),

    ROSA("rosa"),

    AMARELO("amarelo"),
    
    PRETO("preto"),
    
    BRANCO("branco"),
    
    VERDE("verde");

    private String cor;

    EnumCores(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }
}
