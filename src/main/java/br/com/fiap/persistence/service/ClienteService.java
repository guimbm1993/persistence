package br.com.fiap.persistence.service;

import br.com.fiap.persistence.entity.Cliente;

import java.util.Optional;

public interface ClienteService {

    Cliente saveCliente(Cliente cliente);
    Iterable<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    String deleteCliente(Long id);
    Cliente findByCPF(String cpf);

}
