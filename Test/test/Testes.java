package test;

import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.dao.IProdutoDAO;
import main.dao.ProdutoDAO;
import main.domain.Cliente;
import main.domain.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Testes {
      @Test
      public void cadastrarClienteTest() throws Exception {
          IClienteDAO dao = new ClienteDAO();

          Cliente cliente = new Cliente();
          cliente.setNome("Sdney Fernandes");
          cliente.setTelefone("71 992032184");
          cliente.setEmail("fsidney987@gmail.com");

          Integer qtd = dao.cadastrar(cliente);
          assertTrue(qtd == 1);

          Cliente clienteBD = dao.consultar(cliente.getId());
          assertNotNull(clienteBD);
          assertEquals(cliente.getNome(), clienteBD.getNome());
          assertEquals(cliente.getEmail(), clienteBD.getEmail());
          assertEquals(cliente.getTelefone(), clienteBD.getTelefone());
          
          Integer qtdDel = dao.excluir(clienteBD);
          assertNotNull(qtdDel);
      }

      @Test
      public void excluirClienteTest() throws Exception {

          IClienteDAO dao = new ClienteDAO();

          Cliente cliente = new Cliente();
          cliente.setNome("Maria Jango");
          cliente.setEmail("mariajango98@gmail.com");
          cliente.setTelefone("71998956481");

          Integer qtd = dao.cadastrar(cliente);
          assertTrue(qtd == 1);

          Cliente clienteBD = dao.consultar(cliente.getId());
          assertNotNull(clienteBD);
          assertEquals(cliente.getNome(), clienteBD.getNome());
          assertEquals(cliente.getEmail(), clienteBD.getEmail());
          assertEquals(cliente.getTelefone(), clienteBD.getTelefone());

          Integer qtdDel = dao.excluir(clienteBD);
          assertNotNull(qtdDel);
          assertTrue(qtdDel == 1);

          Cliente clienteDel = dao.consultar(clienteBD.getId());
          assertNull(clienteDel);
      }

    @Test
    public void consultarClienteTest() throws Exception {

        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setNome("Maria Jango");
        cliente.setEmail("mariajango98@gmail.com");
        cliente.setTelefone("71998956481");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getId());
        assertNotNull(clienteBD);
        assertEquals(cliente.getNome(), clienteBD.getNome());
        assertEquals(cliente.getEmail(), clienteBD.getEmail());
        assertEquals(cliente.getTelefone(), clienteBD.getTelefone());

    }

    @Test
    public void cadastrarProdutoTest() throws Exception {

        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Cadeira");
        produto.setPreco(99.99);
        produto.setQuantidade(10);
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getId());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getPreco(), produtoBD.getPreco());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);

    }

    @Test
    public void excluirProdutoTest() throws Exception {

        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Caderno");
        produto.setPreco(40.50);
        produto.setQuantidade(10);

        Integer qtdCadastro = dao.cadastrar(produto);
        assertTrue(qtdCadastro == 1);

        Produto produtoBD = dao.consultar(produto.getId());
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
        assertTrue(qtdDel == 1);

        Produto produtoDel = dao.consultar(produtoBD.getId());
        assertNull(produtoDel);
    }

    @Test
    public void consultarProdutoTest() throws Exception {

        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Caderno");
        produto.setPreco(40.50);
        produto.setQuantidade(10);

        Integer qtdCadastro = dao.cadastrar(produto);
        assertTrue(qtdCadastro == 1);

        Produto produtoBD = dao.consultar(produto.getId());
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());
    }
}