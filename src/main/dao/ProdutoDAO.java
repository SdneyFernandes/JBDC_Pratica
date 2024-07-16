package main.dao;

import main.dao.jdbc.ConnectionFactory;
import main.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (ID_PRODUTO, NOME, PRECO, QUANTIDADE) VALUES (nextval('produto_id_produto_seq'),?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getPreco());
            stm.setInt(3, produto.getQuantidade());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(int id) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT ID_PRODUTO, NOME, PRECO, QUANTIDADE FROM TB_PRODUTO WHERE ID_PRODUTO = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID_PRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setPreco(rs.getDouble("PRECO"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                return produto;
            }
            return null;
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE ID_PRODUTO = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, produto.getId());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
