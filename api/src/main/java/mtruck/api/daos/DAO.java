/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.daos;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author chseki
 */
public interface DAO<T> {
    
    List<T> listar();
    
    void salvar(T t);
    
    T pesquisar(UUID codigo);
    
    void deletar(String codigo);
    
    void editar(String codigo);
}
