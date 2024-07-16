package main.dao;

import main.domain.Produto;

public interface IProdutoDAO {
    Integer cadastrar(Produto produto) throws Exception;
    Produto consultar(int id) throws Exception;
    Integer excluir(Produto produto) throws Exception;
}
