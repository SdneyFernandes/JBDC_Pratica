package main.dao;

import main.dao.jdbc.ConnectionFactory;
import main.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO cliente (id_cliente, nome, email, telefone) VALUES (nextval('cliente_id_cliente_seq)'),?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getEmail());
            stm.setString(3, cliente.getTelefone());
            return stm.executeUpdate();
        } catch(Exception e) {
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
    public Cliente consultar(Long id) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT id_cliente, nome, telefone, email FROM cliente WHERE id_cliente = ?";
            stm = connection.prepareStatement(sql);
            stm.setLong(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
            }
            return cliente;
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }

        }
    }

    @Override
    public Integer excluir(Cliente clienteBD) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELET FROM cliente WHERE id_cliente = ?";
            stm = connection.prepareStatement(sql);
            stm.setLong(1, clienteBD.getId());
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
