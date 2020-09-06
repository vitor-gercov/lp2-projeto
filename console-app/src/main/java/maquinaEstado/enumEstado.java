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
public enum enumEstado{
 
    EDITA_PRODUTO(new estadoEditaProduto()),
    
    EXCLUI_PRODUTO(new estadoExcluiProduto()),
    
    MENU(new estadoMenu()),
    
    REGISTRA_PRODUTO(new estadoRegistroProduto()),
    
    SELECIONA_PRODUTO(new estadoSelecionaProduto()),

    LISTA_PRODUTO(new estadoListaProduto());
 
    private final maquinaEstado estado;
    
    enumEstado(maquinaEstado estado) {
        this.estado = estado;
    }
 
    public maquinaEstado getEstadoMaquina() {
        return estado;
    }
}
