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
public enum EnumTamanhos {

    P("P"),

    M("M"),

    G("G"),

    GG("GG");
    

    private String tamanho;

    EnumTamanhos(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

}
