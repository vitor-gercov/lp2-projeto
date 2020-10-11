/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.api.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import lp2.api.entities.Produto;

/**
 *
 * @author GERU\christian.seki
 */
public class ProdutoDAOSQL implements DAO<Produto> {

    private final String STRING_CONEXAO = "jdbc:postgresql://localhost/lp2";
    private final String USUARIO = "postgres";
    private final String SENHA = "admin";
    private final String TABELA = "produtos"; 

    private Produto preencheProduto(ResultSet rs) {
        Produto p = new Produto();
        try {
            p.setId(UUID.fromString(rs.getString("id")));
            p.setCategoria(rs.getString("categoria"));
            p.setCor(rs.getString("cor"));
            p.setDescricao(rs.getString("descricao"));
            p.setDataEntrada(rs.getDate("data_entrada"));
            p.setLocalCompra(rs.getString("local_compra"));
            p.setMarca(rs.getString("marca"));
            p.setTamanho(rs.getString("tamanho"));
            p.setValorEtiqueta(rs.getDouble("valor_etiqueta"));
            p.setValorMargem(rs.getDouble("valor_margem"));
            p.setValorPago(rs.getDouble("valor_pago"));
            p.setValorSugerido(rs.getDouble("valor_sugerido"));
        } catch (SQLException ex) {
            System.out.println("Banco conectado!");
        }
        return p;
    }

    @Override
    public List<Produto> listar() {
        ArrayList<Produto> produtos = new ArrayList();

        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA;
            System.out.println("[Listar] - SQL: "+ SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Produto p = this.preencheProduto(rs);
                        produtos.add(p);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    @Override
    public void salvar(Produto p) {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "INSERT INTO produtos (categoria,cor,descricao,marca,tamanho,valor_etiqueta, valor_margem, valor_pago, valor_sugerido,local_compra)"
                    + " VALUES('"+ p.getCategoria()+"','"+p.getCor()+"','"+p.getDescricao()+"','"+p.getMarca()+"','"+p.getTamanho()+"','"+p.getValorEtiqueta()+"','"+
                    p.getValorMargem()+"','"+p.getValorPago()+"','"+p.getValorSugerido()+"','"+p.getLocalCompra()+"')";
            
            System.out.println("[Salvar] - SQL: "+ SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Produto pesquisar(UUID codigo) {
        
        Produto p = new Produto();
        
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "SELECT * FROM " + TABELA + " WHERE ID='"+codigo+"'";
            
            System.out.println("[Pesquisar] - SQL: "+ SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        p = this.preencheProduto(rs);
                    }   
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }

    @Override
    public void deletar(UUID codigo) {
            try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "DELETE FROM " + TABELA + " WHERE ID='"+codigo+"'";
            
            System.out.println("[Deletar] - SQL: "+ SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
               stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Produto p) {
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            String SQL = "UPDATE produtos set categoria='"+p.getCategoria()+"',cor='"+p.getCor()+"',tamanho='"+ p.getTamanho()+
            "',descricao='"+p.getDescricao()+"',marca='"+p.getMarca()+"',valor_etiqueta='"+p.getValorEtiqueta()+"',valor_margem='"
            + p.getValorMargem() + "',valor_pago='" + p.getValorPago() + "',valor_sugerido='" + p.getValorSugerido() + "',local_compra='" 
            + p.getLocalCompra() + "',data_entrada='" + p.getDataEntrada().toString() + "' WHERE id='" + p.getId().toString()+"'";
            
            System.out.println("[Editar] - SQL: "+ SQL);
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
