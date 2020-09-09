/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaEstado;

/**
 *
 * @author oseas
 */
public enum EnumEstado{
 
    EDITA_PRODUTO(new EstadoEditaProduto()),
    
    EXCLUI_PRODUTO(new EstadoExcluiProduto()),
    
    MENU(new EstadoMenu()),
    
    REGISTRA_PRODUTO(new EstadoRegistroProduto()),
    
    SELECIONA_PRODUTO(new EstadoSelecionaProduto()),

    LISTA_PRODUTO(new EstadoListaProduto());
 
    private final MaquinaEstado estado;
    
    EnumEstado(MaquinaEstado estado) {
        this.estado = estado;
    }
 
    public MaquinaEstado getEstadoMaquina() {
        return estado;
    }
}
