/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import mtruck.api.daos.ProdutoDAO;
import mtruck.api.entities.Produto;

/**
 *
 * @author GERU\christian.seki
 */
public class CadastraProdutoService {

    public Produto executa(Produto p) {
            ProdutoDAO dao = new ProdutoDAO();
            Produto produtoSalvo = dao.salvar(p);
            
            return produtoSalvo;
    }
}
