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
        List<Produto> produtos = new ArrayList<>();

        produtos = dao.listar();

        return produtos;
    }

    public void editar(UUID id, Produto p) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = this.pesquisar(id);

            if (produto.getId().toString() == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe!");
            }
            if (p.getCategoria() != null) {
                produto.setCategoria(p.getCategoria());
            }
            if (p.getMarca() != null) {
                produto.setMarca(p.getMarca());
            }
            if (p.getTamanho() != null) {
                produto.setTamanho(p.getTamanho());
            }
            if (p.getDescricao() != null) {
                produto.setDescricao(p.getDescricao());
            }
            if (p.getCor() != null) {
                produto.setCor(p.getCor());
            }
            if (p.getLocalCompra() != null) {
                produto.setLocalCompra(p.getLocalCompra());
            }
            if (p.getDataEntrada() != null) {
                produto.setDataEntrada(p.getDataEntrada());
            }
            if (p.getValorPago() != 0) {
                produto.setValorPago(p.getValorPago());
            }
            if (p.getValorEtiqueta() != 0) {
                produto.setValorEtiqueta(p.getValorEtiqueta());
            }
            if (p.getValorSugerido() != 0) {
                produto.setValorSugerido(p.getValorSugerido());
            }
            if (p.getValorMargem() != 0) {
                produto.setValorMargem(p.getValorMargem());
            }

            dao.editar(produto);
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
