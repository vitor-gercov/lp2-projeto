/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.api.daos;

import java.util.List;
import java.util.UUID;
import lp2.api.entities.Produto;

/**
 *
 * @author chseki
 */
public interface DAO<T> {
    
    List<T> listar();
    
    void salvar(T t);
    
    T pesquisar(UUID codigo);
    
    void deletar(UUID codigo);
    
    void editar(Produto produto);
}
