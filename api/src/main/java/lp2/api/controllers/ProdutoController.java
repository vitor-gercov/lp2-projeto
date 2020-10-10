/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lp2.api.daos.ProdutoDAOSQL;
import lp2.api.daos.ProdutoDAOtxt;
import lp2.api.entities.Produto;
import lp2.api.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GERU\christian.seki
 */
@RequestMapping("/produtos")
@RestController
public class ProdutoController {

    @GetMapping
    List<Produto> listar() {
     //   ProdutoDAOtxt daoTxt = new ProdutoDAOtxt();
        ProdutoDAOSQL daoSql = new ProdutoDAOSQL();
        
        ProdutoService produtoService = new ProdutoService(daoSql);
        List<Produto> produtos = new ArrayList<>();

        produtos = produtoService.listar();

        return produtos;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    void cadastrar(@RequestBody Produto newProduto) {
        ProdutoDAOtxt daoTxt = new ProdutoDAOtxt();
        ProdutoService produtoService = new ProdutoService(daoTxt);

        produtoService.cadastrar(newProduto);
    }
    
    @GetMapping("/{id}")
    Produto pesquisar(@PathVariable UUID id) {
      //  ProdutoDAOtxt daoTxt = new ProdutoDAOtxt();  
        ProdutoDAOSQL daoSql = new ProdutoDAOSQL();
            
        ProdutoService produtoService = new ProdutoService(daoSql);
        
        Produto produto = produtoService.pesquisar(id);
        return produto;
    }
    
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void editar(@RequestBody Produto newProduto, @PathVariable UUID id) {
        ProdutoDAOtxt daoTxt = new ProdutoDAOtxt();
        ProdutoService produtoService = new ProdutoService(daoTxt);
        
        produtoService.editar(id,newProduto);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletar(@PathVariable UUID id) {
        ProdutoDAOtxt daoTxt = new ProdutoDAOtxt();
        ProdutoService produtoService = new ProdutoService(daoTxt);
        
        produtoService.deletar(id);
    }
}
