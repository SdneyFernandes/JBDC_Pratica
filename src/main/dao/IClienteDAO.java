package main.dao;

import main.domain.Cliente;

// A diferença de tipos provem do retorno dos metodos
//cadastrar é integer porque retorna uma linha que sera adicionada
//excluir retorna linha excluida
//Cliente retorna o codigo do ciente por isso String

public interface IClienteDAO {
    public Integer cadastrar(Cliente cliente) throws Exception;
    public Cliente consultar(Long id) throws Exception;
    public Integer excluir(Cliente clienteBD) throws Exception;
}
