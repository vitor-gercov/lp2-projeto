/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mtruck.api.daos.ProdutoDAO;
import mtruck.api.entities.Produto;

/**
 *
 * @author chseki
 */
public class ProdutoService {

    public void cadastrar(Produto p) {
        ProdutoDAO dao = new ProdutoDAO();

        p.setId(UUID.randomUUID().toString());

        dao.salvar(p);
    }

    public List<Produto> listar() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = new ArrayList<Produto>();

        produtos = dao.listar();

        return produtos;
    }

    public void editar(String id) {

    }

    public void deletar(String id) {

    }

    public Produto pesquisar(String id) {
        return null;
    }
}
