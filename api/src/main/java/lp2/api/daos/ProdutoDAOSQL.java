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
    
    private ResultSet executaSql(String comando) throws SQLException{
        try (Connection conn = DriverManager.getConnection(STRING_CONEXAO, USUARIO, SENHA)) {
            System.out.println("Banco conectado!");
            String SQL = comando;
            try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    return rs;
                    }
                }
            }
        } 

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
    public void salvar(Produto t) {
        
        throw new UnsupportedOperationException("Not supported yet.");
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
    public void editar(Produto t) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

}
