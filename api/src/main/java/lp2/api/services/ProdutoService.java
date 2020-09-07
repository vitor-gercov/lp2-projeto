/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lp2.api.daos.ProdutoDAO;
import lp2.api.entities.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author chseki
 */
public class ProdutoService {

    public void cadastrar(Produto p) throws ResponseStatusException {

        try {
            ProdutoDAO dao = new ProdutoDAO();

            if (p.getCategoria().isEmpty() || p.getCategoria() == null) {
                throw new Exception("Valor de Categoria inválido!");
            }
            if (p.getMarca().isEmpty() || p.getMarca() == null) {
                throw new Exception("Valor de Marca inválido!");
            }
            if (p.getTamanho().isEmpty() || p.getTamanho() == null) {
                throw new Exception("Valor de Tamanho inválido!");
            }
            if (p.getDescricao().isEmpty() || p.getDescricao() == null) {
                throw new Exception("Valor de Descrição inválido!");
            }
            if (p.getCor().isEmpty() || p.getCor() == null) {
                throw new Exception("Valor de Cor inválido!");
            }
            if (p.getLocalCompra().isEmpty() || p.getLocalCompra() == null) {
                throw new Exception("Valor de Local de compra inválido!");
            }
            if (p.getDataEntrada() == null) {
                throw new Exception("Valor de Data de Entrada inválido!");
            }
            if (p.getValorPago() == 0) {
                throw new Exception("Valor de Valor Pago inválido!");
            }
            if (p.getValorEtiqueta() == 0) {
                throw new Exception("Valor de Valor de Etiqueta inválido!");
            }
            if (p.getValorSugerido() == 0) {
                throw new Exception("Valor de Valor Sugerido inválido!");
            }

            dao.salvar(p);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    public List<Produto> listar() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = new ArrayList<Produto>();

        produtos = dao.listar();

        return produtos;
    }

    public void editar(UUID id,Produto p) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = this.pesquisar(id);
                
            if (produto.getId().toString() == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe!");
            }
            if (p.getCategoria() == null) {
                p.setCategoria(produto.getCategoria());
            }
            if (p.getMarca() == null) {
                p.setMarca(produto.getMarca());
            }
            if (p.getTamanho()== null) {
                p.setTamanho(produto.getTamanho());
            }
            if (p.getDescricao()== null) {
                p.setDescricao(produto.getDescricao());
            }
            if (p.getCor()== null) {
                p.setCor(produto.getCor());
            }
            if (p.getLocalCompra()== null) {
                p.setLocalCompra(produto.getLocalCompra());
            }
            if (p.getDataEntrada()== null) {
                p.setDataEntrada(produto.getDataEntrada());
            }
            if (p.getValorPago()== 0) {
                p.setValorPago(produto.getValorPago());
            }
            if (p.getValorEtiqueta()== 0) {
                p.setValorEtiqueta(produto.getValorEtiqueta());
            }
            if (p.getValorSugerido()== 0) {
                p.setValorSugerido(produto.getValorSugerido());
            }
            if (p.getValorMargem()== 0) {
                p.setValorMargem(produto.getValorMargem());
            }
            
            p.setId(id);
            dao.editar(p);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

    public void deletar(UUID id) throws ResponseStatusException {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.deletar(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

    public Produto pesquisar(UUID id) throws ResponseStatusException {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = dao.pesquisar(id);

            if (produto.getId() == null) {
                throw new Exception("Produto não encontrado");
            }

            return produto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }
}
